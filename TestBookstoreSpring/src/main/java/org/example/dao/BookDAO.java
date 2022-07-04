package org.example.dao;

import org.example.model.Books;

import java.util.List;
import java.util.Set;

public interface BookDAO {
    public List<Books> getBooks();
    public List<Books> getBooks(Set<Integer> bookIds);
    public void saveBook(Books book);
    public void deleteBook(int id);
}
