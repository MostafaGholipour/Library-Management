package org.example.service.admin;

import org.example.base.service.BaseServiceImpl;
import org.example.entity.Admin;
import org.example.entity.Customer;
import org.example.entity.StatusTrust;
import org.example.entity.Trust;
import org.example.repository.admin.AdminRepositoryImpl;

import java.util.List;

public class AdminServiceImpl extends BaseServiceImpl<Admin, AdminRepositoryImpl> implements AdminService {
    AdminRepositoryImpl repository1;
    public AdminServiceImpl(AdminRepositoryImpl repository) {
        super(repository);
        repository1=repository;
    }

    @Override
    public void requestBorrow() {
        repository1.requestBorrow();
    }

    @Override
    public void requestToExtend() {
        repository1.requestToExtend();
    }

    @Override
    public void confirmBorrow(Admin admin, long trustId, int i) {
        StatusTrust statusTrust = null;
        if (i == 0) {
            statusTrust=StatusTrust.accept;
        } else if (i==1) {
            statusTrust=StatusTrust.Refuse;
        }else if (i>=2) {
            System.out.println("The entered number is not correct");
        }
        repository1.confirmBorrow(admin, trustId, statusTrust);
    }

    @Override
    public void confirmToExtend(Admin admin, long trustId, int i) {
        StatusTrust statusTrust = null;
        if (i == 0) {
            statusTrust=StatusTrust.accept;
        } else if (i==1) {
            statusTrust=StatusTrust.Refuse;
        } else if (i>=2) {
            System.out.println("The entered number is not correct");
        }
        repository1.confirmToExtend(admin, trustId, statusTrust);
    }

    @Override
    public Admin login(long adminCode, String password) {
        return repository1.login(adminCode, password);
    }

    public List<Trust> searchTrust(long customerId, long bookId){
        return repository1.searchTrust(customerId, bookId);

    }

}
