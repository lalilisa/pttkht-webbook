package com.n10.webbook.service.impl.book;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.n10.webbook.common.dto.QueryDto;
import com.n10.webbook.common.dto.ResponseListAll;
import com.n10.webbook.common.util.ConvertDtoToEntity;
import com.n10.webbook.dto.book.BookDto;
import com.n10.webbook.entity.Author;
import com.n10.webbook.entity.Book;
import com.n10.webbook.entity.Category;
import com.n10.webbook.entity.Publisher;
import com.n10.webbook.repository.book.BookRepository;
import com.n10.webbook.service.AuthorService;
import com.n10.webbook.service.BookService;
import com.n10.webbook.service.CategoryService;
import com.n10.webbook.service.PublisherService;
import com.n10.webbook.service.impl.base.AbstractJpaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BookImpl  extends AbstractJpaDAO<Book> implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PublisherService publisherService;
    public BookImpl() {
        super(Book.class);
    }

    @Override
    public ResponseListAll findAll(QueryDto queryDto) throws JsonProcessingException {
        return this.findsEntity(queryDto);
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
        return this.findOne(id);
    }

    @Override
    public void deleleById(long id) {
      bookRepository.deleteById(id);
    }

    @Override
    public Book createNewBook(BookDto bookDto) {
        try {
            Book book= ConvertDtoToEntity.map(bookDto,Book.class);
            Author author=authorService.findOneById(bookDto.getAuthorId());
            Publisher publisher=publisherService.findOneById(bookDto.getPublisherId());
            Set<Category> categories=new HashSet<>();
            bookDto.getCategoryId().forEach(v->{
                    Category category=new Category();
                    category.setId(v);
                    categories.add(category);
            });
            if(book.getCategories()==null)
                book.setCategories(new HashSet<>());
            book.setCategories(categories);
            book.setAuthor(author);
            book.setPublisher(publisher);
            return bookRepository.save(book);
        }
        catch (Exception e){
            System.out.println(e);
            return  null;
        }

    }

    @Override
    public Book upadteBook(BookDto bookDto) {
        try {
            Book book= this.findOne(bookDto.getId());
            book.setTitle(bookDto.getTitle());
            book.setPublishYear(bookDto.getPublishYear());
            book.setNumberOfPages(bookDto.getNumberOfPages());
            book.setLanguage(bookDto.getLanguage());
            Author author=authorService.findOneById(bookDto.getAuthorId());
            Publisher publisher=publisherService.findOneById(bookDto.getPublisherId());
            Set<Category> categories=new HashSet<>();
            bookDto.getCategoryId().forEach(v->{
                Category category=new Category();
                category.setId(v);
                categories.add(category);
            });
            System.out.println(categories);
            if(book.getCategories()==null)
                book.setCategories(new HashSet<>());
            book.setCategories(categories);
            book.setAuthor(author);
            book.setPublisher(publisher);
            return bookRepository.save(book);
        }
        catch (Exception e){
            System.out.println(e);
            return  null;
        }
    }
}
