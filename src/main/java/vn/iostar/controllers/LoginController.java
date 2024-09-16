package vn.iostar.controllers;

import java.io.IOException;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iostar.models.UserModel;
import vn.iostar.serives.IUserService;
import vn.iostar.serives.impl.UserService;
import vn.iostar.utils.Constant;


@WebServlet(urlPatterns = { "/login" })
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	IUserService service = new UserService();


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String username = req.getParameter("uname");
		String password = req.getParameter("pwd");
		String remember = req.getParameter("remember");
		
		String action = req.getParameter("action");
		String alertMsg = "";
		
		if("register".equals(action)) {
			req.getRequestDispatcher("/view/register.jsp").forward(req, resp);
			return;
		}
		boolean isRememberMe = false;
		if("on".equals(remember)) {
			isRememberMe = true;
		}

		if (username.isEmpty() || password.isEmpty()) {
			alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
			return;
		}
		
		UserModel user = service.login(username, password);
		
		if(user!=null){
			 HttpSession session = req.getSession(true);
			 session.setAttribute("account", user);
			 if(isRememberMe){
				 saveRemeberMe(resp, username);
			 }
			 resp.sendRedirect(req.getContextPath()+"/waiting");
		}else{
			 alertMsg ="Tài khoản hoặc mật khẩu không đúng";
			 req.setAttribute("alert", alertMsg);
			 req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
			 }
	}

	private void saveRemeberMe(HttpServletResponse resp, String username) {
		Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER,
				username);
				 cookie.setMaxAge(30 * 60);
				 resp.addCookie(cookie);
		
	}
		
		

	
}
