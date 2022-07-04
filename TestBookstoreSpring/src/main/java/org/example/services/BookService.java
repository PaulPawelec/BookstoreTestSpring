package org.example.services;

import org.example.model.Books;

import java.util.List;
import java.util.Set;

public interface BookService {
    List<Books> getBooks();
    List<Books> getBooks(Set<Integer> bookIds);
    public void saveBook(Books book);
    public void deleteBook(int id);
}
