package org.example.repository.admin;

import org.example.base.repository.BaseRepository;
import org.example.entity.Admin;
import org.example.entity.Customer;
import org.example.entity.StatusTrust;

public interface AdminRepository extends BaseRepository<Admin> {
    public void requestBorrow();
    public void requestToExtend();
    public void confirmBorrow(Admin admin, long trustId, StatusTrust statusTrust);
    public void confirmToExtend(Admin admin,long trustId,StatusTrust statusTrust);
    public Admin login(long adminCode, String password);
//    public Admin registerAdmin(Admin admin);

}
