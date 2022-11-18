package com.n10.webbook.controller.book;


import com.n10.webbook.common.util.response.ResponseHander;
import com.n10.webbook.dto.QueryUserDto;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@SecurityRequirement(name = "webbook")
public class BookController {

    @GetMapping("")
    public ResponseHander listBooks(@ParameterObject QueryUserDto queryDto){

        return  ResponseHander.response();
    }
}
