package com.n10.webbook.controller.book;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.n10.webbook.common.util.ConvertDtoToEntity;
import com.n10.webbook.common.util.response.ResponseHander;
import com.n10.webbook.dto.book.BookDto;
import com.n10.webbook.dto.book.QueryBookDto;
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
    private BookService bookService;
    @GetMapping("")
    public ResponseEntity<?> listBooks(@ParameterObject QueryBookDto queryDto) throws JsonProcessingException {
        return  ResponseHander.response(bookService.findAll(queryDto), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<?> getOneBook(@PathVariable Long id)  {

        return  ResponseHander.response(bookService.findOneById(id), HttpStatus.OK);
    }
    @PostMapping(value = "",consumes = {"multipart/form-data"})
    public ResponseEntity<?> createBooks(@ModelAttribute BookDto bookDto) {
        return  ResponseHander.response(bookService.createNewBook(bookDto), HttpStatus.OK);
    }

    @PutMapping(value = "{id}",consumes = {"multipart/form-data"})
    public ResponseEntity<?> upadateBooks(@PathVariable Long id,@ModelAttribute BookDto bookDto) {
        bookDto.setId(id);
        return  ResponseHander.response(bookService.upadteBook(bookDto), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteBooks(@PathVariable Long id) {
        bookService.deleleById(id);
        return  ResponseHander.response("Success", HttpStatus.OK);
    }
}
