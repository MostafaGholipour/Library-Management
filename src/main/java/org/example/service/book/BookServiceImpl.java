package org.example.service.book;

import org.example.base.service.BaseServiceImpl;
import org.example.entity.Book;
import org.example.repository.book.BookRepositoryImpl;

public class BookServiceImpl extends BaseServiceImpl<Book, BookRepositoryImpl> implements BookService {
    BookRepositoryImpl repository1;
    public BookServiceImpl(BookRepositoryImpl repository) {
        super(repository);
        repository1=repository;
    }
}
