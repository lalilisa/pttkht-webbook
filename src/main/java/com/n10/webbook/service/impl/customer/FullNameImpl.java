package com.n10.webbook.service.impl.customer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.n10.webbook.common.dto.QueryDto;
import com.n10.webbook.common.dto.ResponseListAll;
import com.n10.webbook.entity.Fullname;
import com.n10.webbook.repository.customer.FullNameRepository;
import com.n10.webbook.service.GennericService;
import com.n10.webbook.service.customer.FullNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FullNameImpl implements FullNameService {
    @Autowired
    FullNameRepository fullNameRepository;
    @Override
    public ResponseListAll findAll(QueryDto queryDto) throws JsonProcessingException {
        return null;
    }

    @Override
    public List<Fullname> findAll() {
        return null;
    }

    @Override
    public Fullname findOneById(long id) {
        return null;
    }

    @Override
    public Fullname create(Fullname entity) {
        return fullNameRepository.save(entity);
    }

    @Override
    public Fullname update(Fullname entity) {
        return null;
    }

    @Override
    public void deleleById(long id) {

    }
}
