package com.daxia.mybug.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginFilter implements Filter
{
	public void init(FilterConfig config) throws ServletException{ //初始化过滤器

	}
	
	public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain) 
			throws IOException,ServletException{                   //执行过滤
		System.out.println("登录验证过滤...");
		chain.doFilter(request, response);                         //交给下一个过滤器,如果无 将进入servlet方法
	}
	
	public void destroy(){
		System.out.println("过滤器销毁..");
	}
}
