package org.example.controllers;

import org.example.model.Authors;
import org.example.model.Books;
import org.example.model.Categories;
import org.example.services.AuthorService;
import org.example.services.BookService;
import org.example.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    private final AuthorService authorService;

    private final CategoryService categoryService;

    @Autowired
    public BookController(BookService bookService, AuthorService authorService, CategoryService categoryService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @GetMapping("/list")
    public String listBook(Model model) {
        List<Books> books = bookService.getBooks();

        model.addAttribute("books", books);
        return "bookslist";
    }

    @GetMapping("/bookAdd")
    public String addForm(Model model) {
        Books book = new Books();
        model.addAttribute("book", book);

        List<Categories> categories = categoryService.getCategories();
        model.addAttribute("categoryList", categories);

        List<Authors> authors = authorService.getAuthors();
        model.addAttribute("authorsList", authors);

        return "addBookForm";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Books book) {
        bookService.saveBook(book);

        return "redirect:/books/list";
    }

    @PostMapping("/deleteBook")
    @Secured("ROLE_ADMIN")
    public String deleteBook(@RequestParam(name = "bookId") int id) {
        bookService.deleteBook(id);

        return "redirect:/books/list";
    }
}
