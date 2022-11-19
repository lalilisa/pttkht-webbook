package com.n10.webbook.controller.book;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.n10.webbook.common.util.ConvertDtoToEntity;
import com.n10.webbook.common.util.response.ResponseHander;
import com.n10.webbook.dto.author.AuthorDto;
import com.n10.webbook.dto.author.QueryAuthorDto;
import com.n10.webbook.entity.Author;
import com.n10.webbook.service.AuthorService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/author")
@SecurityRequirement(name = "webAuthor")
@Tag(name = "Author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;
    @GetMapping("")
    public ResponseEntity<?> listAuthors(@ParameterObject QueryAuthorDto queryDto) throws JsonProcessingException {
        return  ResponseHander.response(authorService.findAll(queryDto), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<?> getOneAuthor(@PathVariable Long id)  {

        return  ResponseHander.response(authorService.findOneById(id), HttpStatus.OK);
    }
    @PostMapping(value = "")
    public ResponseEntity<?> createAuthors(@RequestBody AuthorDto authorDto) {
        Author author= ConvertDtoToEntity.map(authorDto,Author.class);
        return  ResponseHander.response(authorService.create(author), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<?> upadateAuthors(@PathVariable Long id,@RequestBody AuthorDto authorDto) {
        Author author=authorService.findOneById(id);
        author.setNickName(authorDto.getNickName());
        author.setName(authorDto.getName());
        author.setDateOfBirth(authorDto.getDateOfBirth());
        return  ResponseHander.response(authorService.update(author), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteAuthors(@PathVariable Long id) {
        authorService.deleleById(id);
        return  ResponseHander.response("Success", HttpStatus.OK);
    }
}
