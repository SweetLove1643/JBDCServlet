package vn.iostar.serives;

import vn.iostar.models.UserModel;

public interface IUserService {
	
	UserModel login(String username, String password);
	
	UserModel FindByUserName(String Username);
	
	UserModel register(String username, String password,String images, String fullname, String email, String phone);
	
	int UpdateByUserName(String username, String password);
}
