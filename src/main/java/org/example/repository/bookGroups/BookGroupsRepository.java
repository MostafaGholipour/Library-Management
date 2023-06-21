package org.example.repository.bookGroups;

import org.example.base.repository.BaseRepository;
import org.example.entity.Book;
import org.example.entity.BookGroups;

import java.util.List;

public interface BookGroupsRepository extends BaseRepository<BookGroups> {
    public List<BookGroups> findAtLeast();
}
