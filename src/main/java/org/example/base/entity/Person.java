package org.example.base.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.MappedSuperclass;

@Setter
@Getter
@NoArgsConstructor
@MappedSuperclass
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Person extends BaseEntity{
    String name;
    long NationalCode;

}
