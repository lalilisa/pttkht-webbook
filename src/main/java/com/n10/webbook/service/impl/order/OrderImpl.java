package com.n10.webbook.service.impl.order;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.n10.webbook.common.dto.QueryDto;
import com.n10.webbook.common.dto.ResponseListAll;
import com.n10.webbook.entity.Order;
import com.n10.webbook.service.order.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderImpl implements OrderService {
    @Override
    public ResponseListAll findAll(QueryDto queryDto) throws JsonProcessingException {
        return null;
    }

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public Order findOneById(long id) {
        return null;
    }

    @Override
    public Order create(Order entity) {
        return null;
    }

    @Override
    public Order update(Order entity) {
        return null;
    }

    @Override
    public void deleleById(long id) {

    }
}
