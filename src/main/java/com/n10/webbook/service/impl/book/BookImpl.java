package com.n10.webbook.service.impl.book;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.n10.webbook.common.dto.QueryDto;
import com.n10.webbook.common.dto.ResponseListAll;
import com.n10.webbook.entity.Book;
import com.n10.webbook.repository.book.BookRepository;
import com.n10.webbook.service.BookSevice;
import com.n10.webbook.service.impl.base.AbstractJpaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookImpl  extends AbstractJpaDAO<Book> implements BookSevice  {
    @Autowired
    private BookRepository bookRepository;
    public BookImpl(Class<Book> clazz) {
        super(clazz);
    }

    @Override
    public ResponseListAll findAlls(QueryDto queryDto) throws JsonProcessingException {
        return this.findsEntity(queryDto);
    }

    @Override
    public List<Book> findAll(QueryDto queryDto) throws JsonProcessingException {
        return null;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book update(Book entity) {
        return bookRepository.save(entity);
    }

    @Override
    public Book create(Book entity) {
        return bookRepository.save(entity);
    }

    @Override
    public Book findOneById(long id) {
        return this.findOneById(id);
    }

    @Override
    public void deleleById(long id) {
      bookRepository.deleteById(id);
    }



}
