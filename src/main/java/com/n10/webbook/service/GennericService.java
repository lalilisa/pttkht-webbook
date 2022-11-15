package com.n10.webbook.service;

import com.n10.webbook.common.dto.QueryDto;
import com.n10.webbook.common.dto.ResponseListAll;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface GennericService<T>{
        ResponseListAll findAlls(QueryDto queryDto) throws JsonProcessingException;
        List<T> findAll(QueryDto queryDto) throws JsonProcessingException;
        T findOneById(long id);
        T create(T entity);
        T update(T entity);
        void deleleById(long id);
}
