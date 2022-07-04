package org.example.dao;

import org.example.model.Authors;

import java.util.List;

public interface AuthorDAO {
    public List<Authors> getAuthors();
    public void saveAuthor(Authors author);
}
