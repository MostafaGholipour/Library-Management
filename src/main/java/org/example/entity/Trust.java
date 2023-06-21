package org.example.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.base.entity.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

@Setter
@Getter
@NoArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Trust extends BaseEntity {
    @ManyToOne

    Book book;
    @ManyToOne
    Customer customer;
    @ManyToOne
    Admin admin;
    @Enumerated(EnumType.STRING)
    Status status;
    @Enumerated(EnumType.STRING)
    StatusTrust statusTrust=StatusTrust.waiting;
    LocalDate startTime;
    LocalDate endTime;

    public Trust(Book book, Customer customer, Admin admin) {
        this.book = book;
        this.customer = customer;
        this.admin = admin;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
        endTime=startTime.plusDays(7L);

//        int i=startTime.getDayOfMonth()+7;
//        if(i>23){
//            i=i-30;
//            this.endTime=LocalDate.of(startTime.getYear(),startTime.getMonth().plus(1L),i);
//        }
//        this.endTime=LocalDate.of(startTime.getYear(),startTime.getMonth(),startTime.getDayOfMonth()+7);
    }

    @Override
    public String toString() {
        return "Trust{" +
                "id :"+ getId() +
                ",   book=" + book.getName() +
                ", customer=" + customer.getName() +
                ",   status   : "+status+
                ",  statusTrust : "+statusTrust+
                '}'+"\n";
    }
}
