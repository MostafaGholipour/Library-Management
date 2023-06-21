package org.example.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.base.entity.Person;
import org.example.repository.trust.TrustRepositoryImpl;
import org.example.service.trust.TrustServiceImpl;

import javax.persistence.Entity;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Admin extends Person {
    Long username;
    String password;

}
