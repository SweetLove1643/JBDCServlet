package vn.iostar.controllers.admin;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iostar.models.CategoryModel;
import vn.iostar.serives.ICategoryService;
import vn.iostar.serives.impl.CatagoryServiceImpl;

@WebServlet(urlPatterns = { "/admin/categories","/admin/category/add","/admin/category/insert","/admin/category/edit","/admin/category/update","/admin/category/delete","/admin/category/search" })
public class CategoryController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ICategoryService cateService = new CatagoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		if (url.contains("categories")) {
			List<CategoryModel> list = cateService.findALL();
			req.setAttribute("listcate", list);
			req.getRequestDispatcher("/view/admin/category-list.jsp").forward(req, resp);
		}
		else if(url.contains("add")){
			req.getRequestDispatcher("/view/admin/category-add.jsp").forward(req, resp);
		}else if(url.contains("edit")) {
			int id = Integer.parseInt(req.getParameter("id"));
			CategoryModel category = cateService.findById(id);
			req.setAttribute("cate", category);
			req.getRequestDispatcher("/view/admin/category-edit.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		if (url.contains("insert")) {
			String categoryName = req.getParameter("categoryName");
			String status = req.getParameter("status");
			int statuss = Integer.parseInt(status);
			String image = "";
			CategoryModel category = new CategoryModel();
			category.setCategoryname(categoryName);
			category.setImage(image);
			category.setStatus(statuss);
			cateService.insert(category);
			
			resp.sendRedirect(req.getContextPath() +"/admin/categories");
			
		}
		
	}

}
