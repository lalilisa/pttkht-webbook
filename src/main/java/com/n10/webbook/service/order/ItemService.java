package com.n10.webbook.service.order;

import com.n10.webbook.entity.Item;
import com.n10.webbook.service.GennericService;

import java.util.List;

public interface ItemService extends GennericService<Item> {

    List<Item> getListItemByIdCart(Long id);
}
