package com.n10.webbook.service.impl.book;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.n10.webbook.common.dto.QueryDto;
import com.n10.webbook.common.dto.ResponseListAll;
import com.n10.webbook.entity.Author;
import com.n10.webbook.repository.book.AuthorRepository;
import com.n10.webbook.service.AuthorService;
import com.n10.webbook.service.impl.base.AbstractJpaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorImpl extends AbstractJpaDAO<Author> implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;


    public AuthorImpl() {
        super(Author.class);
    }

    @Override
    public ResponseListAll findAll(QueryDto queryDto) throws JsonProcessingException {
        return this.findsEntity(queryDto);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author create(Author entity) {
        return authorRepository.save(entity);
    }

    @Override
    public Author update(Author entity) {
        return authorRepository.save(entity);
    }

    @Override
    public Author findOneById(long id) {
        return this.findOne(id);
    }

    @Override
    public void deleleById(long id) {
        authorRepository.deleteById(id);
    }


}
