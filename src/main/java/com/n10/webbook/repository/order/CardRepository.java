package com.n10.webbook.repository.order;

import com.n10.webbook.entity.Card;
import com.n10.webbook.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card,Long> {
}
