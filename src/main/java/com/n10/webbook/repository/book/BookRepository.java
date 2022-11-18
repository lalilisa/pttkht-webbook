package com.n10.webbook.repository.book;

import com.n10.webbook.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository  extends JpaRepository<Book,Long> {
}
