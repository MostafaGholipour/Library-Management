package org.example.service.bookGroups;

import org.example.base.service.BaseService;
import org.example.entity.BookGroups;

import java.util.List;

public interface BookGroupsService extends BaseService<BookGroups> {
    public List<BookGroups> findAtLeast();
}
