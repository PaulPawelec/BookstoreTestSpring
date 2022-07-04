package org.example.services;

import org.example.dao.AuthorDAO;
import org.example.model.Authors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService{

    private AuthorDAO authorDAO;

    @Autowired
    public AuthorServiceImpl(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    @Override
    @Transactional
    public List<Authors> getAuthors() {
        List<Authors> authors = authorDAO.getAuthors();

        return authors;
    }

    @Override
    @Transactional
    public void saveAuthor(Authors author) {
        authorDAO.saveAuthor(author);
    }
}
