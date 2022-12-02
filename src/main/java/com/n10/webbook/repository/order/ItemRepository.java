package com.n10.webbook.repository.order;

import com.n10.webbook.entity.Item;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
    @Query(value = "select * from item where cartid= :id",nativeQuery = true)
    List<Item> listItemByIdCart(@Param("id") Long id);
}
