package org.example.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.example.base.entity.Person;
import org.example.repository.book.BookRepositoryImpl;
import org.example.repository.trust.TrustRepositoryImpl;
import org.example.service.book.BookServiceImpl;
import org.example.service.trust.TrustServiceImpl;

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
public class Customer extends Person {
    long customerCode;
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    Set<Trust> list=new HashSet<>();

    public Customer(long customerCode) {
        this.customerCode = customerCode;
    }
    public void requestBook(Long bookId){
        BookServiceImpl bookService=new BookServiceImpl(new BookRepositoryImpl());
        TrustServiceImpl trustService=new TrustServiceImpl(new TrustRepositoryImpl());
        Book book = bookService.loadById(bookId);
        if (book.isReady()==false){
            System.out.println("Sorry     Not available now");
        }
        else {
            Trust trust=new Trust();
            trust.setCustomer(this);
            trust.setBook(book);
            trust.setStatus(Status.Borrow);
            trustService.save(trust);
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id   : "+ getId()+
                "   name  : "+getName()+
                "   getNationalCode : "+getNationalCode()+
                "    customerCode :  " + customerCode + +
                '}';
    }
}
