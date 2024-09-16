package vn.iostar.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iostar.models.UserModel;
import vn.iostar.serives.IUserService;
import vn.iostar.serives.impl.UserService;


@WebServlet(urlPatterns = {"/forgotpwd"})
public class ForgotController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	IUserService service = new UserService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		
		String username = req.getParameter("uname");
		String password = req.getParameter("pwd");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		
		String alert = "";
		
		UserModel user = service.FindByUserName(username);
		
		if(email.equals(user.getEmail()) && phone.equals(user.getPhone())) {
			alert = "Update successfully.";
			service.UpdateByUserName(username, password);
			req.setAttribute("alert", alert);
			req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
		}
	}
}
