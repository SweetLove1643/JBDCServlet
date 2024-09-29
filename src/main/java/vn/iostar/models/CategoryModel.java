package vn.iostar.models;

import java.io.Serializable;

public class CategoryModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int categoryid;
	private String categoryname;
	private int status;
	private String image;
	
	
	public CategoryModel() {
		super();
	}
	public CategoryModel(int categoryid, String categoryname, int status, String image) {
		super();
		this.categoryid = categoryid;
		this.categoryname = categoryname;
		this.status = status;
		this.image = image;
	}
	/**
	 * @return the categoryid
	 */
	public int getCategoryid() {
		return categoryid;
	}
	/**
	 * @param categoryid the categoryid to set
	 */
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	/**
	 * @return the categoryname
	 */
	public String getCategoryname() {
		return categoryname;
	}
	/**
	 * @param categoryname the categoryname to set
	 */
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

}
