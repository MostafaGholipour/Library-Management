package org.example.service.book;

import org.example.base.service.BaseServiceImpl;
import org.example.entity.Book;
import org.example.entity.BookGroups;
import org.example.repository.book.BookRepositoryImpl;
import org.example.repository.bookGroups.BookGroupsRepositoryImpl;
import org.example.service.bookGroups.BookGroupsServiceImpl;

public class BookServiceImpl extends BaseServiceImpl<Book, BookRepositoryImpl> implements BookService {
    BookRepositoryImpl repository1;
    public BookServiceImpl(BookRepositoryImpl repository) {
        super(repository);
        repository1=repository;
    }

    @Override
    public void changeBookGroups(Long idBook, Long idBookGroup) {
        BookGroupsServiceImpl bookGroupsService=new BookGroupsServiceImpl(new BookGroupsRepositoryImpl());
        Book book=repository1.loadById(idBook);
        BookGroups bookGroups = bookGroupsService.loadById(idBookGroup);
        book.setBookGroups(bookGroups);
        repository1.update(book);
    }
}
