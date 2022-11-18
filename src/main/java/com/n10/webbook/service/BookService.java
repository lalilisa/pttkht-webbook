package com.n10.webbook.service;

import com.n10.webbook.dto.book.BookDto;
import com.n10.webbook.entity.Book;

public interface BookService extends GennericService<Book>{
    Book createNewBook(BookDto bookDto);
    Book upadteBook(BookDto bookDto);
}
