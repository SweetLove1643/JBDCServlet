package vn.iostar.serives.impl;

import java.util.List;

import vn.iostar.dao.ICategoryDao;
import vn.iostar.dao.impl.CategoryDaoImpl;
import vn.iostar.models.CategoryModel;
import vn.iostar.serives.ICategoryService;

public class CatagoryServiceImpl implements ICategoryService{

	
	public ICategoryDao cateDao = new CategoryDaoImpl();
	@Override
	public List<CategoryModel> findALL() {
		return cateDao.findALL();
	}

	@Override
	public CategoryModel findById(int id) {
		return cateDao.findById(id);
	}

	@Override
	public void insert(CategoryModel category) {
		cateDao.insert(category);
		
	}

	@Override
	public void update(CategoryModel category) {
		CategoryModel cate = new CategoryModel();
		cate = cateDao.findById(category.getCategoryid());
		if(cate != null) {
			cateDao.update(category);
		}
	}

	@Override
	public void delete(int id) {
		CategoryModel cate = new CategoryModel();
		cate = cateDao.findById(id);
		if(cate != null) {
			cateDao.delete(id);
		}
	}

	@Override
	public List<CategoryModel> findName(String keyword) {
		return cateDao.findName(keyword);
	}

}
