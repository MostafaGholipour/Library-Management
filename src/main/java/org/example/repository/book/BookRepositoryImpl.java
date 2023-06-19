package org.example.repository.book;

import org.example.base.repository.BaseRepositoryImpl;
import org.example.entity.Book;

public class BookRepositoryImpl extends BaseRepositoryImpl<Book> implements BookRepository {
    @Override
    public Class getClassName() {
        return Book.class;
    }
}
