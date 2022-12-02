package com.n10.webbook.controller.book;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.n10.webbook.common.util.ConvertDtoToEntity;
import com.n10.webbook.common.util.response.ResponseHander;
import com.n10.webbook.dto.category.CategoryDto;
import com.n10.webbook.dto.category.QueryCategoryDto;
import com.n10.webbook.entity.Category;
import com.n10.webbook.service.category.CategoryService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/category")
@SecurityRequirement(name = "webbook")
@Tag(name = "Categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("")
    public ResponseEntity<?> listCategorys(@ParameterObject QueryCategoryDto queryDto) throws JsonProcessingException {
        return  ResponseHander.response(categoryService.findAll(queryDto), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<?> getOneCategory(@PathVariable Long id)  {

        return  ResponseHander.response(categoryService.findOneById(id), HttpStatus.OK);
    }
    @PostMapping(value = "")
    public ResponseEntity<?> createCategorys(@RequestBody CategoryDto CategoryDto) {
        Category Category= ConvertDtoToEntity.map(CategoryDto,Category.class);
        return  ResponseHander.response(categoryService.create(Category), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<?> upadateCategorys(@PathVariable Long id,@RequestBody CategoryDto categoryDto) {
        Category category=categoryService.findOneById(id);
        category.setType(categoryDto.getType());
        return  ResponseHander.response(categoryService.update(category), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCategorys(@PathVariable Long id) {
        categoryService.deleleById(id);
        return  ResponseHander.response("Success", HttpStatus.OK);
    }
}
