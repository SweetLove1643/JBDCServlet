package vn.iostar.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.mysql.cj.Session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import vn.iostar.utils.Constant;

@WebServlet(urlPatterns = { "/myaccount" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class MyaccountController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/view/myaccount.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String uploadPath = getServletContext().getRealPath("") + Constant.UPLOAD_DIRECTORY;
	    System.out.println("Upload Path: " + uploadPath); // In đường dẫn ra console
	    File uploadDir = new File(uploadPath);
	    
	    if (!uploadDir.exists()) {
	        if (uploadDir.mkdir()) // Kiểm tra nếu chưa có file chứa thì tạo 
	        {
	            System.out.println("Directory created");
	        } else {
	            System.out.println("Failed to create directory");
	        }
	    }

	    try {
	        String fileName = "";
	        for (Part part : req.getParts()) {
	            fileName = getFileName(part);
	            part.write(uploadPath + File.separator + fileName);
	            System.out.println("File saved as: " + fileName);
	        }

	        String fileURL = req.getContextPath() + File.separator + Constant.UPLOAD_DIRECTORY + File.separator + fileName;
	        
	        req.getSession().setAttribute("image", fileURL);
//	        req.getSession().setAttribute("account.images", fileURL);
//	        System.out.println(req.getSession().getAttribute("account.images"));
	        
	        req.setAttribute("message", "File " + fileName + " uploaded successfully");
	    } catch (FileNotFoundException fne) {
	        req.setAttribute("message", "There was an error: " + fne.getMessage());
	        fne.printStackTrace();
	    }
	    getServletContext().getRequestDispatcher("/view/myaccount.jsp").forward(req, resp);
	}



	private String getFileName(Part part) {
	    String header = part.getHeader("content-disposition");
	    if (header != null) {
	        for (String content : header.split(";")) {
	            if (content.trim().startsWith("filename")) {
	                return content.substring(content.indexOf("=") + 2, content.length() - 1);
	            }
	        }
	    }
	    return Constant.DEFAULT_FILENAME;
	}
}
