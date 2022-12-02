package com.n10.webbook.repository.order;

import com.n10.webbook.entity.Cart;
import com.n10.webbook.entity.Item;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
    @Query(value = "select * from cart where id= (select cartid from customer  where id=  (select customerid from account where username = :username))",nativeQuery = true)
    Cart getCartByUsername(@Param("username") String username);
}
