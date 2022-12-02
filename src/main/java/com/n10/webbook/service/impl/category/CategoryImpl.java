package com.n10.webbook.service.impl.category;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.n10.webbook.common.dto.QueryDto;
import com.n10.webbook.common.dto.ResponseListAll;
import com.n10.webbook.entity.Category;
import com.n10.webbook.repository.category.CategoryRepository;
import com.n10.webbook.service.category.CategoryService;
import com.n10.webbook.service.impl.base.AbstractJpaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryImpl extends AbstractJpaDAO<Category> implements CategoryService {
    @Autowired
    private CategoryRepository CategoryRepository;


    public CategoryImpl() {
        super(Category.class);
    }

    @Override
    public ResponseListAll findAll(QueryDto queryDto) throws JsonProcessingException {
        return this.findsEntity(queryDto);
    }

    @Override
    public List<Category> findAll() {
        return CategoryRepository.findAll();
    }

    @Override
    public Category create(Category entity) {
        return CategoryRepository.save(entity);
    }

    @Override
    public Category update(Category entity) {
        return CategoryRepository.save(entity);
    }

    @Override
    public Category findOneById(long id) {
        return this.findOne(id);
    }



    @Override
    public void deleleById(long id) {
        CategoryRepository.deleteById(id);
    }
}
