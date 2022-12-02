package com.n10.webbook.service.impl.order;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.n10.webbook.common.dto.QueryDto;
import com.n10.webbook.common.dto.ResponseListAll;
import com.n10.webbook.entity.Book;
import com.n10.webbook.entity.Cart;
import com.n10.webbook.entity.Item;
import com.n10.webbook.repository.order.CartRepository;
import com.n10.webbook.service.order.CartService;
import com.n10.webbook.service.order.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CartImpl implements CartService {

    @Autowired
    CartRepository cartRepository;
    @Override
    public ResponseListAll findAll(QueryDto queryDto) throws JsonProcessingException {
        return null;
    }

    @Override
    public List<Cart> findAll() {
        return this.cartRepository.findAll();
    }

    @Override
    public Cart findOneById(long id) {
        return this.cartRepository.getReferenceById(id);
    }

    @Override
    public Cart create(Cart entity) {
        return cartRepository.save(entity);
    }

    @Override
    public Cart update(Cart entity) {
        return null;
    }

    @Override
    public void deleleById(long id) {
        this.cartRepository.deleteById(id);
    }

    @Override
    public Cart getCartByUsername(String username) {
        return cartRepository.getCartByUsername(username);
    }
    @Autowired
    ItemService itemService;
    public List<Item> getItemsInCart(String username){
        try {
            Cart cart=getCartByUsername(username);
            System.out.println(cart);
            return itemService.getListItemByIdCart(cart.getId());
        }
        catch (Exception e){
            System.out.println(e);
            return  null;
        }

    }

    @Override
    public void addItemInCart(Book book,Cart cart) {
        Item item=new Item();
        UUID uuid = UUID.randomUUID();
        item.setBarcode(uuid.toString());
        item.setPrice(book.getPrice());
        item.setCart(cart);
        item.setBook(book);
        itemService.create(item);
    }


}
