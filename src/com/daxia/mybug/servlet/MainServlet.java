package com.daxia.mybug.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daxia.mybug.model.User;
import com.daxia.mybug.service.UserService;

public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	        doService(request);
        } catch (Exception e) {
	        e.printStackTrace();
	        // 跳转到 显示 错误信息的页面
        }
	}

	private void doService(HttpServletRequest request) throws Exception {
	    // 接收到请求，从request里间接得到请求的路径是什么，如 /user/add, /user/delete等
		String path = extractRequestPath(request);
		
		// 这是根据不同的请求进行不同的处理，可以避免写多个servlet，struts, spring mvc的基本原理也是这样的
		if ("/user/add".equals(path)) {
			User user = new User();
			// user.setXXX
			
			UserService userService = new UserService();
			userService.add(user);
			// 转到指定的页面
		} else if ("/user/xxx".equals(path)) {
			//
		} else {
			// 
		}
    }

	/**
	 * 从request里间接得到请求的路径是什么，如 /user/add, /user/delete等,
	 * 是去掉应用名后的路径，如应用是mybugs，完整的url可能是http://localhost:8080/mybugs/user/add,
	 * 截取之后得到的路径就是/user/add
	 * @param request
	 * @return
	 */
	private String extractRequestPath(HttpServletRequest request) {
	    return null;
    }
}
