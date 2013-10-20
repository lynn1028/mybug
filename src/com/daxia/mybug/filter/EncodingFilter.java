package com.daxia.mybug.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter
{
	private String charset;
	public void init(FilterConfig config) throws ServletException{ //初始化过滤器
		charset=config.getInitParameter("charSet");           //取得初始化参数
		System.out.println("***过滤器初始化,初始化参数="+charset);
	}
	
	public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain) 
			throws IOException,ServletException{                   //执行过滤
		System.out.println("**编码验证"+charset);
		
		request.setCharacterEncoding(charset);
		response.setCharacterEncoding(charset);
		chain.doFilter(request, response);                         //交给下一个过滤器,如果无 将进入servlet方法
		
		System.out.println("执行doFilter()方法之后.");
	}
	
	public void destroy(){
		System.out.println("过滤器销毁..");
	}
}
