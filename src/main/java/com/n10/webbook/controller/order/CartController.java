package com.n10.webbook.controller.order;

import com.n10.webbook.dto.order.IdItemDto;
import com.n10.webbook.entity.Book;
import com.n10.webbook.entity.Cart;
import com.n10.webbook.repository.order.ItemRepository;
import com.n10.webbook.service.book.BookService;
import com.n10.webbook.service.order.CartService;
import com.n10.webbook.service.order.ItemService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/cart")
@SecurityRequirement(name = "webbook")
@Tag(name = "CartController")
public class CartController {
    @Autowired
    CartService cartService;
    @Autowired
    BookService bookService;
    @Autowired
    ItemService itemService;
    @GetMapping()
    public ResponseEntity<?> getAllItemsIncart(){
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return ResponseEntity.ok(cartService.getItemsInCart(userDetails.getUsername()));
    }

    @PostMapping()
    public ResponseEntity<?> addtoCart(@RequestBody IdItemDto idItemDto){
        Book book=bookService.findOneById(idItemDto.getId());
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Cart cart = cartService.getCartByUsername(userDetails.getUsername());
        cartService.addItemInCart(book,cart);
        return ResponseEntity.ok(cartService.getItemsInCart(userDetails.getUsername()));
    }

    @DeleteMapping("/item/{id}")
    public ResponseEntity<?> deleteItemInCart(@PathVariable Long id){
        itemService.deleleById(id);
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return ResponseEntity.ok(cartService.getItemsInCart(userDetails.getUsername()));
    }
}
