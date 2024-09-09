package vn.iostar.models;

import java.io.Serializable;
import java.util.Objects;

public class UserModel implements Serializable {
	private int id;
	private String username;
	private String password;
	private String images;
	private String fullname;

	public UserModel(int id, String username, String password, String images, String fullname) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.images = images;
		this.fullname = fullname;
	}

	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

}
