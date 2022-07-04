package org.example.services;

import org.example.model.Authors;

import java.util.List;

public interface AuthorService {
    List<Authors> getAuthors();
    public void saveAuthor(Authors author);
}
