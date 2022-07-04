package org.example.controllers;

import org.example.model.Categories;
import org.example.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public String listBook(Model model) {
        List<Categories> categories = categoryService.getCategories();

        model.addAttribute("categories", categories);
        return "categoriesList";
    }

    @GetMapping("/categoryAdd")
    @Secured("ROLE_ADMIN")
    public String addForm(Model model){
        Categories category = new Categories();
        model.addAttribute("category", category);

        return "addCategoryForm";
    }

    @PostMapping("/saveCategory")
    @Secured("ROLE_ADMIN")
    public String saveCategory(@ModelAttribute("category") Categories category){
        categoryService.saveCategory(category);

        return "redirect:/categories/list";
    }
}
