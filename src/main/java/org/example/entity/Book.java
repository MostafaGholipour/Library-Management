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
    @JoinColumn(name = "BookGroups", referencedColumnName = "title")
    BookGroups bookGroups;
    boolean ready;
}
