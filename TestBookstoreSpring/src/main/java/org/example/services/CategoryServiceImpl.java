package org.example.services;

import org.example.dao.CategoryDAO;
import org.example.model.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
//    @Autowired
    private CategoryDAO categoryDAO;

    @Autowired
    public CategoryServiceImpl(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @Override
    @Transactional
    public List<Categories> getCategories() {
        List<Categories> categories = categoryDAO.getCategories();

        return categories;
    }

    @Override
    @Transactional
    public void saveCategory(Categories category) {
        categoryDAO.saveCategory(category);
    }
}
