package org.example.dao;

import org.example.model.Categories;

import java.util.List;

public interface CategoryDAO {
    public List<Categories> getCategories();
    public void saveCategory(Categories category);
}
