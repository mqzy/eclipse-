package com.neuedu.myoffice.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.commons.io.FileUtils;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class DownloadController {
	
	@RequestMapping(value = "ud/down")
	public String down() {
		return "ud/download";
	}
	
//	@RequestMapping(value = "ud/download",method = RequestMethod.GET)
//	public ResponseEntity<byte[]> download(
//	        HttpServletRequest req,
//	        @RequestParam("filename") String filename, 
//	        Model model) throws Exception {
//
//	  System.out.println(filename);
//
//	  String path = req.getServletContext().getRealPath("static");
//	  File file = new File(path + File.separator + filename);
//
//	  HttpHeaders headers = new HttpHeaders();
//	  // 解决文件名乱码问题
//	  // String downloadFileName = new String(filename.getBytes("UTF-8"), "iso-8859-1");
//
//	  headers.setContentDispositionFormData("attachment", filename);
//	  headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//
//	  return new ResponseEntity<>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
//	}
//}
	
	  @RequestMapping("download") 
	  public void down(HttpServletRequest request,HttpServletResponse response) throws Exception{ 
	    //模拟文件，myfile.txt为需要下载的文件 
	    String fileName = request.getSession().getServletContext().getRealPath("static")+"/a.txt"; 
	    //获取输入流 
	    InputStream bis = new BufferedInputStream(new FileInputStream(new File(fileName))); 
	    //假如以中文名下载的话 
	    String filename = "下载文件.txt"; 
	    //转码，免得文件名中文乱码 
	    filename = URLEncoder.encode(filename,"UTF-8"); 
	    //设置文件下载头 
	    response.addHeader("Content-Disposition", "attachment;filename=" + filename);  
	    //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型  
	    response.setContentType("multipart/form-data");  
	    BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream()); 
	    int len = 0; 
	    while((len = bis.read()) != -1){ 
	      out.write(len); 
	      out.flush(); 
	    } 
	    out.close(); 
	  } 
}
