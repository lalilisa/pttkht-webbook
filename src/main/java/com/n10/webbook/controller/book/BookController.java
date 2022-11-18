package com.n10.webbook.controller.book;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.n10.webbook.common.util.ConvertDtoToEntity;
import com.n10.webbook.common.util.response.ResponseHander;
import com.n10.webbook.dto.QueryUserDto;
import com.n10.webbook.dto.book.BookDto;
import com.n10.webbook.entity.Book;
import com.n10.webbook.repository.book.BookRepository;
import com.n10.webbook.service.BookService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/book")
@SecurityRequirement(name = "webbook")
@Tag(name = "BookController")
public class BookController {

    @Autowired
    private BookRepository bookService;
    @GetMapping("")
    public ResponseEntity<?> listBooks(@ParameterObject QueryUserDto queryDto) throws JsonProcessingException {
        System.out.println(bookService.findAll());
        return  ResponseHander.response(bookService.findAll(), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<?> getOneBook(@PathVariable Long id)  {

        return  ResponseHander.response(bookService.findAll(), HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<?> createBooks(@RequestBody BookDto bookDto) {
        Book book= ConvertDtoToEntity.map(bookDto,Book.class);
        System.out.println(book);
        return  ResponseHander.response(bookService.findAll(), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> upadateBooks(@RequestBody BookDto bookDto) {
        Book book= ConvertDtoToEntity.map(bookDto,Book.class);
        System.out.println(book);
        return  ResponseHander.response(bookService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteBooks(@PathVariable Long id) {
        //bookService.deleleById(id);
        return  ResponseHander.response("Success", HttpStatus.OK);
    }
}
