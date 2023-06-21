package org.example.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.base.entity.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookGroups extends BaseEntity {
    String title;
    @OneToMany(mappedBy = "bookGroups",cascade = CascadeType.ALL)
    List<Book> books=new ArrayList<>();

    public BookGroups(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "BookGroups{" +
                "title='" + title + '\'' +
                '}';
    }
}


