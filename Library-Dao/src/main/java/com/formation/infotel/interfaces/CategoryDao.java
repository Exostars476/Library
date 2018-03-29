package com.formation.infotel.interfaces;

import com.formation.infotel.entity.Category;

import java.util.List;

public interface CategoryDao {

    List<Category> getAllBookByCategory(String categoryname);
    
    Category getCategoriesPeriodique(String name);

    Category getCategoryByName(String name);

    List<Category> getAll();
}
