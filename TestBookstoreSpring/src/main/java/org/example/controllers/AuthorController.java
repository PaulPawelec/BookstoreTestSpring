package org.example.controllers;

import org.example.model.Authors;
import org.example.services.AuthorService;
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
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping("/list")
    public String listAuthor(Model model) {
        List<Authors> authors = authorService.getAuthors();

        model.addAttribute("authors", authors);
        return "authorsList";
    }

    @GetMapping("/authorAdd")
    @Secured("ROLE_ADMIN")
    public String addForm(Model model){
        Authors author = new Authors();
        model.addAttribute("author", author);

        return "addAuthorForm";
    }

    @PostMapping("/saveAuthor")
    @Secured("ROLE_ADMIN")
    public String saveAuthor(@ModelAttribute("author") Authors author){
        authorService.saveAuthor(author);

        return "redirect:/authors/list";
    }
}
