package com.n10.webbook.repository.order;

import com.n10.webbook.entity.Cash;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashRepository extends JpaRepository<Cash,Long> {
}
