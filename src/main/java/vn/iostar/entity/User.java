package vn.iostar.entity;

import java.io.Serializable;

import javax.persistence.*;



@Entity
@Table(name="Userss")
@NamedQuery(name="User.findAll", query = "Select u FROM User u")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="Username")
	private String username;

	@Column(name="Active")
	private boolean active;

	@Column(name="Admin")
	private boolean admin;

	@Column(name="Email")
	private String email;
	
	@Column(name="Phone")
	private String phone;


	@Column(name="Fullname")
	private String fullname;

	@Column(name="Password")
	private String password;
	
	@Column(name="Images")
	private String images;
	
	
	
	public User() {
		super();
	}


	public User(String username, boolean active, boolean admin, String email, String phone, String fullname,
			String password, String images) {
		super();
		this.username = username;
		this.active = active;
		this.admin = admin;
		this.email = email;
		this.phone = phone;
		this.fullname = fullname;
		this.password = password;
		this.images = images;
	}
	


	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}


	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}


	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}


	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}


	/**
	 * @return the admin
	 */
	public boolean isAdmin() {
		return admin;
	}


	/**
	 * @param admin the admin to set
	 */
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}


	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}


	/**
	 * @return the fullname
	 */
	public String getFullname() {
		return fullname;
	}


	/**
	 * @param fullname the fullname to set
	 */
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @return the images
	 */
	public String getImages() {
		return images;
	}


	/**
	 * @param images the images to set
	 */
	public void setImages(String images) {
		this.images = images;
	}
	
	
	
	
	
}
