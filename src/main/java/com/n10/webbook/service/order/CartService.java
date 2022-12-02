package com.n10.webbook.service.order;


import com.n10.webbook.entity.Book;
import com.n10.webbook.entity.Cart;
import com.n10.webbook.entity.Item;
import com.n10.webbook.service.GennericService;

import java.util.List;

public interface CartService extends GennericService<Cart> {

    Cart getCartByUsername(String username);
    List<Item> getItemsInCart(String username);
    void addItemInCart(Book book,Cart cart);
}
