package org.example.service.bookGroups;

import org.example.base.service.BaseServiceImpl;
import org.example.entity.BookGroups;
import org.example.repository.bookGroups.BookGroupsRepositoryImpl;

import java.util.List;

public class BookGroupsServiceImpl extends BaseServiceImpl<BookGroups, BookGroupsRepositoryImpl> implements BookGroupsService {
    BookGroupsRepositoryImpl repository1;
    public BookGroupsServiceImpl(BookGroupsRepositoryImpl repository) {
        super(repository);
        repository1=repository;
    }

    @Override
    public List<BookGroups> findAtLeast() {
        return repository1.findAtLeast();
    }
}
