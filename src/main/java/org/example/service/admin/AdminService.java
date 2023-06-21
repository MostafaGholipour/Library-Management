package org.example.service.admin;

import org.example.base.service.BaseService;
import org.example.entity.Admin;
import org.example.entity.Customer;
import org.example.entity.StatusTrust;

public interface AdminService extends BaseService<Admin> {
    public void requestBorrow();
    public void requestToExtend();
    public void confirmBorrow(Admin admin, long trustId, int i);
    public void confirmToExtend(Admin admin,long trustId,int i);
    public Admin login(long adminCode, String password);
}
