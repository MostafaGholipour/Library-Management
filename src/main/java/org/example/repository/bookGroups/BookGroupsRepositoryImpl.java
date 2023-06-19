package org.example.repository.bookGroups;

import org.example.base.repository.BaseRepositoryImpl;
import org.example.entity.BookGroups;

public class BookGroupsRepositoryImpl extends BaseRepositoryImpl<BookGroups> implements BookGroupsRepository {
    @Override
    public Class getClassName() {
        return BookGroups.class;
    }
}
