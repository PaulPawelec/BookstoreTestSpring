package org.example.services;

import org.example.model.Categories;

import java.util.List;

public interface CategoryService {
    List<Categories> getCategories();
    public void saveCategory(Categories category);
}
