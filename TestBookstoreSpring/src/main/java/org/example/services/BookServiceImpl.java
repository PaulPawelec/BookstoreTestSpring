package org.example.services;

import org.example.dao.BookDAO;
import org.example.model.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService{
    private BookDAO bookDAO;

    @Autowired
    public BookServiceImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    @Transactional
    public List<Books> getBooks(Set<Integer> bookIds) {
        List<Books> books = bookDAO.getBooks(bookIds);

        return books;
    }

    @Override
    @Transactional
    public List<Books> getBooks() {
        List<Books> books = bookDAO.getBooks();

        return books;
    }

    @Override
    @Transactional
    public void saveBook(Books book) {
        bookDAO.saveBook(book);
    }

    @Override
    @Transactional
    public void deleteBook(int id) {
        bookDAO.deleteBook(id);
    }
}
