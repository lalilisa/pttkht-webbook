package com.n10.webbook.controller.book;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.n10.webbook.cloudinary.CloudinaryService;
import com.n10.webbook.common.util.response.ResponseHander;
import com.n10.webbook.dto.book.BookDto;
import com.n10.webbook.dto.book.QueryBookDto;
import com.n10.webbook.entity.Account;
import com.n10.webbook.entity.Book;
import com.n10.webbook.service.book.BookService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/book")
@SecurityRequirement(name = "webbook")
@Tag(name = "BookController")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private CloudinaryService cloudinaryService;

    @GetMapping("")
    public ResponseEntity<?> listBooks(@ParameterObject QueryBookDto queryDto) throws JsonProcessingException {
        return  ResponseHander.response(bookService.findAll(queryDto), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<?> getOneBook(@PathVariable Long id)  {
        UserDetails authentication = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(authentication);
        return  ResponseHander.response(bookService.findOneById(id), HttpStatus.OK);
    }
    @PostMapping(value = "",consumes = {"multipart/form-data"})
    public ResponseEntity<?> createBooks(@ModelAttribute BookDto bookDto) {
        Book book=bookService.createNewBook(bookDto);
        return  ResponseHander.response(bookService.findOneById(book.getId()), HttpStatus.OK);
    }

    @PutMapping(value = "{id}",consumes = {"multipart/form-data"})
    public ResponseEntity<?> upadateBooks(@PathVariable Long id,@ModelAttribute BookDto bookDto) {
        bookDto.setId(id);
        Book book=bookService.upadteBook(bookDto);
        return  ResponseHander.response(bookService.findOneById(book.getId()), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteBooks(@PathVariable Long id) {
        bookService.deleleById(id);
        return  ResponseHander.response("Success", HttpStatus.OK);
    }
}
