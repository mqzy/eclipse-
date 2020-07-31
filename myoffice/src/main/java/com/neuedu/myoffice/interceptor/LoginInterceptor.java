package com.neuedu.myoffice.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.neuedu.myoffice.entity.Management;

@Component
public class LoginInterceptor implements HandlerInterceptor{
	private List<String> excludeUrls;
	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Management management = (Management) request.getSession().getAttribute("management");
		String realPath = request.getRequestURI().replaceFirst(request.getContextPath(),"");
//		if (realPath.startsWith("/login")) {
//			return true;
//		}
		for (String url : excludeUrls) {
			if(realPath.startsWith(url)) {
				return true;
			}
		}
		if (management == null) {
			if (!response.isCommitted()) {
				response.sendRedirect(request.getContextPath()+"/login");
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
