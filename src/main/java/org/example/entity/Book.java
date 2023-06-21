package org.example.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.base.entity.BaseEntity;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.BooleanString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Book extends BaseEntity {
    String name;
    String writer;
    int numberPages;
    @ManyToOne
//    @JoinColumn(name = "BookGroups", referencedColumnName = "id")
    BookGroups bookGroups;
    boolean ready=true;

    public Book(String name, String writer, int numberPages, BookGroups bookGroups, boolean ready) {
        this.name = name;
        this.writer = writer;
        this.numberPages = numberPages;
        this.bookGroups = bookGroups;
    }
}
