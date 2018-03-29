package com.formation.infotel.services.interfaces;

import java.util.List;
import java.util.Set;

import com.formation.infotel.entity.Book;
import com.formation.infotel.entity.Category;

public interface CategoryService {

	void insertCategory(Category category) throws Exception;

	void deleteCategory(Category category) throws Exception;

	void updateCategory(Category category) throws Exception;

	Category getCategory(int categoryId) throws Exception;

	List<Category> getAllCategories() throws Exception;

	List<Category> getAllBookByCategory(String categoryname) throws Exception;
	
	Set<Book> getCategoriesPeriodique(String categoryName) throws Exception;

	Category getCategoryByName(String name) throws Exception;
}
