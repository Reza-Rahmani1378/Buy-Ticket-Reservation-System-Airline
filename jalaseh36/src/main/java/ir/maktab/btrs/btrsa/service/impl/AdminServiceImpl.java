package ir.maktab.btrs.btrsa.service.impl;


import ir.maktab.btrs.btrsa.base.service.impl.BaseServiceImpl;
import ir.maktab.btrs.btrsa.domain.Admin;
import ir.maktab.btrs.btrsa.repository.AdminRepository;
import ir.maktab.btrs.btrsa.service.AdminService;

public class AdminServiceImpl extends BaseServiceImpl<Admin, Long, AdminRepository> implements
        AdminService {

    public AdminServiceImpl(AdminRepository repository) {
        super(repository);
    }

}
