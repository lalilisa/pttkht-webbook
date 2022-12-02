package com.n10.webbook.service.impl.order;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.n10.webbook.common.dto.QueryDto;
import com.n10.webbook.common.dto.ResponseListAll;
import com.n10.webbook.entity.Item;
import com.n10.webbook.repository.order.ItemRepository;
import com.n10.webbook.service.order.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemImpl implements ItemService {
    @Autowired
    ItemRepository itemRepository;
    @Override
    public ResponseListAll findAll(QueryDto queryDto) throws JsonProcessingException {
        return null;
    }

    @Override
    public List<Item> findAll() {
        return null;
    }

    @Override
    public Item findOneById(long id) {
        return null;
    }

    @Override
    public Item create(Item entity) {
        return itemRepository.save(entity);
    }

    @Override
    public Item update(Item entity) {
        return null;
    }

    @Override
    public void deleleById(long id) {
            this.itemRepository.deleteById(id);
    }

    @Override
    public List<Item> getListItemByIdCart(Long id) {
       return itemRepository.listItemByIdCart(id);
    }
}
