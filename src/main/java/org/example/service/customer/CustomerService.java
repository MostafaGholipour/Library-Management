package org.example.service.customer;

import org.example.base.service.BaseService;
import org.example.entity.Customer;

public interface CustomerService extends BaseService<Customer> {
    public Customer login(long customerCode,long nationalCode);
    public void requestToExtend(Customer customer,Long  idBookInlistCustomer);
}
