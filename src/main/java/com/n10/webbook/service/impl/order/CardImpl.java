package com.n10.webbook.service.impl.order;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.n10.webbook.common.dto.QueryDto;
import com.n10.webbook.common.dto.ResponseListAll;
import com.n10.webbook.entity.Card;
import com.n10.webbook.service.order.CardService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardImpl implements CardService {
    @Override
    public ResponseListAll findAll(QueryDto queryDto) throws JsonProcessingException {
        return null;
    }

    @Override
    public List<Card> findAll() {
        return null;
    }

    @Override
    public Card findOneById(long id) {
        return null;
    }

    @Override
    public Card create(Card entity) {
        return null;
    }

    @Override
    public Card update(Card entity) {
        return null;
    }

    @Override
    public void deleleById(long id) {

    }
}
