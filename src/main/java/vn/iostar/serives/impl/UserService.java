package vn.iostar.serives.impl;

import vn.iostar.dao.IUserDao;

import vn.iostar.dao.impl.UserDaoimpl;
import vn.iostar.models.UserModel;
import vn.iostar.serives.IUserService;

public class UserService implements IUserService {
	IUserDao userDao = new UserDaoimpl();

	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.FindByUserName(username);
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	@Override
	public UserModel FindByUserName(String Username) {
		// TODO Auto-generated method stub
		return userDao.findByUserName(Username);
	}

	@Override
	public UserModel register(String username, String password,String images, String fullname, String email, String phone) {
		if (userDao.findByUserName(username) != null) {
	        System.out.println("User đã tồn tại!");
	        return null;
	    }
		UserModel user = new UserModel(username, password,images,fullname,email,phone);
		userDao.insert(user);
		return user;
	}

}
