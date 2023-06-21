package org.example.repository.customer;

import org.example.base.repository.BaseRepository;
import org.example.entity.Customer;

public interface CustomerRepository extends BaseRepository<Customer> {
    public Customer login(long customerCode,long nationalCode);

}
