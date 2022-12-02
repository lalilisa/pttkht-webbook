package com.n10.webbook.service.book;

import com.n10.webbook.dto.book.BookDto;
import com.n10.webbook.entity.Book;
import com.n10.webbook.service.GennericService;

public interface BookService extends GennericService<Book> {
    Book createNewBook(BookDto bookDto);
    Book upadteBook(BookDto bookDto);
}
