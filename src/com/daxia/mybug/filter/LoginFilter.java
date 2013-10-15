package com.daxia.mybug.filter;

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
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException,
            ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		String path = request.getServletPath();
		System.out.println("path = " + path);
		
		if (path.equals("/user/login.do")) {
			// do nothing
			arg2.doFilter(arg0, arg1);
		} else {
			Object user = request.getSession().getAttribute("user");
			if (user == null) {
				request.getRequestDispatcher("/user/login.jsp").forward(arg0, arg1);
			} else {
				// do nothing
				arg2.doFilter(arg0, arg1);
			}
					
		}
    }

	@Override
    public void init(FilterConfig arg0) throws ServletException {
	    
    }

}
