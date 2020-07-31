package com.neuedu.myoffice.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UploadController {
	private static String UPLOADED_FOLDER = "C:\\Users\\姚季\\Desktop\\xx\\框架\\resources\\";
	
	@RequestMapping(value = "upload")
    public String index()
    {
        return "ud/upload";
    }
    
    @RequestMapping(value={"multi"},method=RequestMethod.GET)
    public String uploadMore()
    {
        return "ud/multiupload";
    }
    
    @RequestMapping(value={"uploadResult"},method=RequestMethod.GET)
    public String uploadStatus()
    {
        return "ud/uploadresult";
    }
    
    @RequestMapping(value={"file_upload"},method=RequestMethod.POST)
    public String singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes)
    {
        if (file.isEmpty())
        {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadResult";
        }
        try
        {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            
            redirectAttributes.addFlashAttribute("message", "Successfully uploaded '" + file.getOriginalFilename() + "'");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return "redirect:uploadResult";
    }
    
    @RequestMapping(value={"multi_file_upload"}, method=RequestMethod.POST)
    public String moreFileUpload(@RequestParam("file") MultipartFile[] files, RedirectAttributes redirectAttributes)
    {
        if (files.length == 0)
        {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadResult";
        }
        for (MultipartFile file : files)
        {
            try
            {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
                Files.write(path, bytes);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        redirectAttributes.addFlashAttribute("message", "Successfully uploaded all");
        return "redirect:uploadResult";
    }
    
}
