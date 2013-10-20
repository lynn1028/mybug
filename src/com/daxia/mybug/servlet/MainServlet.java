package com.daxia.mybug.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        }
	}

	private void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    // 接收到请求，从request里间
		String path = extractRequestPath(request);
		// 这是根据不同的请求进行不同的处理，可以避免写多个servlet，struts, spring mvc的基本原理也是这样的
		if ("/user/add".equals(path)) {
			User user = new User();
			// user.setXXX
			
			UserService userService = new UserService();
			userService.add(user);
			// 转到指定的页面
		} else if ("/user/register".equals(path)) {
			//
			System.out.println("register...");
		} else if("/user/login".equals(path)){
			
			//用户登录
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			UserService u = new UserService();
			User user = u.login(username, password);
			if (user!=null) {
				HttpSession session=request.getSession(); //获取服务器创建的session
				session.setAttribute("user", user);
				request.getRequestDispatcher("/bug.jsp").forward(request,response);
			} else {
				response.sendRedirect("/fail.jsp");
			}
		}else if("/bug/add".equals(path)){
			//添加bug
			String title=request.getParameter("titile");
			String content=request.getParameter("content");
			int status=Integer.parseInt(request.getParameter("status"));
			int userId=Integer.parseInt(request.getParameter("user_id"));
			Bug bug=new Bug();
			bug.setTitle(title);
			bug.setContent(content);
			bug.setStatus(status);
			bug.setUser_id(userId);
			BugService bS=new BugService();	
			if(bS.addBug(bug)){
				List<Bug> list= bS.hostBugList();
				request.setAttribute("buglist", list);
				request.getRequestDispatcher("/bug.jsp").forward(request,response);
			}else{
				System.out.println("false...");
				response.sendRedirect("/fail.jsp");
			}
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
		System.out.println(request.getRequestURI());
		return request.getServletPath().replace(".do", "");
    }
}
