package vn.iostar.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import vn.iostar.configs.DBConnectSQL;

import vn.iostar.dao.IUserDao;

import vn.iostar.models.UserModel;

public class UserDaoimpl extends DBConnectSQL implements IUserDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public List<UserModel> findAll() {
		String sql = "Select * from table1";

		List<UserModel> list = new ArrayList<>();

		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			

			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setFullname(rs.getString("fullname"));
				user.setPassword(rs.getString("password"));
				user.setImages(rs.getString("images"));
				user.setRoleid(Integer.parseInt(rs.getString("roleid")));
				user.setPhone(rs.getString("phone"));
				user.setCreateDate(rs.getDate("createdDate"));
				list.add(user);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public UserModel findById(int id) {
		String sql = "select * from table1 where id = ?";

		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				return new UserModel(rs.getInt("id"), 
						rs.getString("username"), 
						rs.getString("password"),
						rs.getString("images"), 
						rs.getString("fullname"), 
						rs.getString("email"), 
						rs.getString("phone"),
						rs.getInt("role"), 
						rs.getDate("createDate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void insert(UserModel user) {
	    String sql = "INSERT INTO table1 (username, password, images, fullname, email, phone, role, createDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

	    try {
	        conn = super.getConnection();
	        ps = conn.prepareStatement(sql);

	        ps.setString(1, user.getUsername());
	        ps.setString(2, user.getPassword());
	        ps.setString(3, user.getImages());
	        ps.setString(4, user.getFullname());
	        ps.setString(5, user.getEmail());
	        ps.setString(6, user.getPhone());
	        ps.setString(7, "2"); 
	        ps.setTimestamp(8, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));

	        int result = ps.executeUpdate(); 

	        if(result > 0) {
	            System.out.println("User registed successfully!");
	        }
	    } 
	    catch (SQLException e) {
	        e.printStackTrace();
	    } 
	    catch (Exception e) {
	        System.err.println("Error: " + e.getMessage());
	        e.printStackTrace();
	    } 
	    finally {
	        try {
	            if(ps != null) ps.close();
	            if(conn != null) conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	@Override
	public int updateByUserName(String Username, String pwd) {
		String sql = "UPDATE dbo.table1 SET password = ' ? ' WHERE username = ' ? '";
		
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			
			ps.setString(0, pwd);
			ps.setString(1, Username);
			
			int result = ps.executeUpdate();
			
			if(result > 0) {
				System.out.print("Update successfully.");
				return result;
			}
			return 0;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
	        try {
	            if(ps != null) ps.close();
	            if(conn != null) conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
		return 0;
		
	}

	public static void main(String[] args) {
//	    // Tạo đối tượng UserDaoImpl để thực hiện các thao tác với cơ sở dữ liệu
//	    UserDaoimpl userDao = new UserDaoimpl();
//	    
//	    // Tạo một đối tượng UserModel với các thông tin cần chèn
//	    UserModel user = new UserModel(2, "vaqunua", "1", "", "Nguyen Duy Hao");
//	    
//	    // Thực hiện chèn đối tượng này vào cơ sở dữ liệu
//	    userDao.insert(user);
//	    
//	    System.out.println("Đã chèn người dùng thành công.");

//		 UserDaoimpl userDao = new UserDaoimpl();
//
//		    // ID người dùng cần tìm
//		    int userId = 1; // Thay đổi ID này nếu muốn tìm người dùng khác
//
//		    // Gọi phương thức findById để tìm người dùng theo ID
//		    UserModel user = userDao.findById(userId);
//
//		    // Kiểm tra và in ra thông tin người dùng nếu tìm thấy
//		    if (user != null) {
//		        System.out.println("User found:");
//		        System.out.println("ID: " + user.getId());
//		        System.out.println("Username: " + user.getUsername());
//		        System.out.println("Password: " + user.getPassword());
//		        System.out.println("Images: " + user.getImages());
//		        System.out.println("Fullname: " + user.getFullname());
//		    } else {
//		        System.out.println("User with ID " + userId + " not found.");

		// }

		UserDaoimpl userDao = new UserDaoimpl();

		// Lấy danh sách tất cả người dùng từ bảng Table_1
		List<UserModel> users = userDao.findAll();

		// Kiểm tra nếu danh sách không rỗng, in thông tin từng người dùng
		if (users != null && !users.isEmpty()) {
			for (UserModel user : users) {
				System.out.println("ID: " + user.getId());
				System.out.println("Username: " + user.getUsername());
				System.out.println("Password: " + user.getPassword());
				System.out.println("Images: " + user.getImages());
				System.out.println("Fullname: " + user.getFullname());
				System.out.println("----------------------------");
			}
		} else {
			System.out.println("Không có người dùng nào trong bảng Table_1.");
		}

	}

	@Override
	public UserModel findByUserName(String username) {

		String sql = "SELECT * FROM table1 WHERE username = ? ";
		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setFullname(rs.getString("fullname"));
				user.setPassword(rs.getString("password"));
				user.setImages(rs.getString("images"));
				user.setRoleid(Integer.parseInt(rs.getString("role")));
				user.setPhone(rs.getString("phone"));
				user.setCreateDate(rs.getDate("createDate"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
