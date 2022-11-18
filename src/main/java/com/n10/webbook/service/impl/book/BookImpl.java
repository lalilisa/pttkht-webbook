//package com.n10.webbook.service.impl.book;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.n10.webbook.common.dto.QueryDto;
//import com.n10.webbook.common.dto.ResponseListAll;
//import com.n10.webbook.dto.book.BookDto;
//import com.n10.webbook.entity.Book;
//import com.n10.webbook.repository.book.BookRepository;
//import com.n10.webbook.service.BookService;
//import com.n10.webbook.service.impl.base.AbstractJpaDAO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class BookImpl  extends AbstractJpaDAO<Book> implements BookService {
//    @Autowired
//    private BookRepository bookRepository;
//
//
//    public BookImpl() {
//        super(Book.class);
//    }
//
//    @Override
//    public ResponseListAll findAll(QueryDto queryDto) throws JsonProcessingException {
//        return this.findsEntity(queryDto);
//    }
//
//    @Override
//    public List<Book> findAll() {
//        return bookRepository.findAll();
//    }
//
//    @Override
//    public Book update(Book entity) {
//        return bookRepository.save(entity);
//    }
//
//    @Override
//    public Book create(Book entity) {
//        return bookRepository.save(entity);
//    }
//    @Override
//    public Book findOneById(long id) {
//        return this.findOneById(id);
//    }
//
//    @Override
//    public void deleleById(long id) {
//      bookRepository.deleteById(id);
//    }
//
//    @Override
//    public Book createNewBook(BookDto bookDto) {
//        return null;
//    }
//}
