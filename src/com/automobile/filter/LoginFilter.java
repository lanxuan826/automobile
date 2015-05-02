package com.automobile.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		String path = ((HttpServletRequest)request).getContextPath();
		String allPath = ((HttpServletRequest)request).getRequestURI();
		String serPath = ((HttpServletRequest)request).getServletPath();
//		int index = allPath.indexOf(path);
//		path = allPath.substring(index+path.length()+6);
//		if(!path.equals("") &&!path.equals("login") && path.equals("login.html")) {
//			request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
//			return;
//		}
		
		if((serPath.indexOf("login.html"))>=0 && !serPath.equals("")&&(serPath.indexOf("login.htm"))>=0)  {
			request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
			return;
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
