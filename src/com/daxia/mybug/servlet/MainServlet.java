package com.daxia.mybug.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daxia.mybug.common.BugPriority;
import com.daxia.mybug.common.BugStatus;
import com.daxia.mybug.model.Bug;
import com.daxia.mybug.model.User;
import com.daxia.mybug.service.BugService;
import com.daxia.mybug.service.UserService;

public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	        doService(request, response);
        } catch (Exception e) {
        	e.printStackTrace();
	        // 跳转到 显示 错误信息的页面
        	request.setAttribute("msg", e.getMessage());
        	request.getRequestDispatcher("/common/fail.jsp").forward(request, response);
        }
	}

	private void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    // 接收到请求，从request里间接得到请求的路径是什么，如 /user/add, /user/delete等
		String path = extractRequestPath(request);
		
		// 这是根据不同的请求进行不同的处理，可以避免写多个servlet，struts, spring mvc的基本原理也是这样的
		if ("/user/add".equals(path)) {
			User user = new User();
			// user.setXXX
			
			UserService userService = new UserService();
			userService.add(user);
			// 转到指定的页面
		} else if ("/user/main".equals(path)) {
			//
			request.getRequestDispatcher("/user/main.jsp").forward(request, response);
		} else if ("/user/login".equals(path)){
			UserService userService = new UserService();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			User user = userService.login(username, password);
			if (user != null) {
				String message = "ok..........";
				request.setAttribute("msg", message);
				request.getSession().setAttribute("user", user);
				request.getRequestDispatcher("/user/main.jsp").forward(request, response);
			} else {
				String message = "用户名或密码错误";
				request.setAttribute("msg", message);
				request.getRequestDispatcher("/user/login.jsp").forward(request, response);
			}
		} else if ("/bug/bug".equals(path)) {
			request.getRequestDispatcher("/bug/bug.jsp").forward(request, response);
		} else if ("/bug/pageAdd".equals(path)) {
			UserService userService = new UserService();
			List<User> users = userService.findAll();
			request.setAttribute("users", users);
			request.setAttribute("priorities", BugPriority.values());
			request.getRequestDispatcher("/bug/add.jsp").forward(request, response);
		} else if ("/bug/add".equals(path)) {
			Bug bug = new Bug();
			bug.setTitle(request.getParameter("title"));
			bug.setContent(request.getParameter("content"));
			bug.setStatus(BugStatus.Active.getValue());
			bug.setPriority(Integer.parseInt(request.getParameter("priority")));
			bug.setUserId(Long.parseLong(request.getParameter("userId")));
			BugService bugService = new BugService();
			bugService.add(bug);
		} else if ("/bug/bug".equals(path)) {
			BugService bugService = new BugService();
			User user = (User) request.getSession().getAttribute("user");
			
			bugService.findByUserId(user.getId());
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
		return request.getServletPath().replace(".do", "");
    }
}
