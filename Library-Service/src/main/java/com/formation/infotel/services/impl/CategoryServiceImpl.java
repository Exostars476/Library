package com.formation.infotel.services.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.formation.infotel.interfaces.Dao;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;

import com.formation.infotel.entity.Author;
import com.formation.infotel.entity.Book;
import com.formation.infotel.entity.Category;
import com.formation.infotel.exception.ErrorConstants;
import com.formation.infotel.interfaces.CategoryDao;
import com.formation.infotel.services.interfaces.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private Dao dao;

	@Override
	public void insertCategory(Category category) throws Exception {
		dao.save(category);
	}

	@Override
	public void deleteCategory(Category category) throws Exception {
		dao.delete(category);
	}

	@Override
	public void updateCategory(Category category) throws Exception {
		dao.saveOrUpdate(category);
	}

	@Override
	public Category getCategory(int categoryId) throws Exception {
		return dao.get(Category.class, categoryId);
	}

	@Override
	public List<Category> getAllCategories() throws Exception {
		List<Category> category  = dao.getAll(Category.class);
		if (category.isEmpty())
			throw new ServiceException(ErrorConstants.CATEGORY_EMPTY);

		return category;
	}

	/* retourne la liste de tous les livre pas cat�gorie */
	@Override
	public List<Category> getAllBookByCategory(String categoryname) throws Exception {
		categoryname = "Manga d'Action"; /* uniquement pour le teste ne reste pas dans la version final */

		List<Category> AllBook = null;
		AllBook = categoryDao.getAllBookByCategory(categoryname);

		if (AllBook.isEmpty()) {
			throw new ServiceException(ErrorConstants.CATEGORY_EMPTY);
		}

		return AllBook;
	}

	/* retourne un objet catalogue contenant tout les p�riodique */
	@Override
	public Set<Book> getCategoriesPeriodique(String categoryName) throws Exception {
		Category Periodique = categoryDao.getCategoriesPeriodique(categoryName);
		Set<Book> list = new HashSet<>();
		/*Set<Book> list = Periodique.getBooks();
		if (list.isEmpty()) {
			throw new ServiceException(ErrorConstants.CATEGORY_EMPTY);
		}*/

		return list;
	}

	@Override
	public Category getCategoryByName(String name) throws Exception {
		return categoryDao.getCategoryByName(name);
	}
}
