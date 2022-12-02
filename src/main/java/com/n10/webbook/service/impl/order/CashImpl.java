package com.n10.webbook.service.impl.order;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.n10.webbook.common.dto.QueryDto;
import com.n10.webbook.common.dto.ResponseListAll;
import com.n10.webbook.entity.Cash;
import com.n10.webbook.service.order.CashService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CashImpl implements CashService {
    @Override
    public ResponseListAll findAll(QueryDto queryDto) throws JsonProcessingException {
        return null;
    }

    @Override
    public List<Cash> findAll() {
        return null;
    }

    @Override
    public Cash findOneById(long id) {
        return null;
    }

    @Override
    public Cash create(Cash entity) {
        return null;
    }

    @Override
    public Cash update(Cash entity) {
        return null;
    }

    @Override
    public void deleleById(long id) {

    }
}
