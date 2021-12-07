package ir.maktab.btrs.btrsa.service;

import ir.maktab.btrs.btrsa.base.service.BaseService;
import ir.maktab.btrs.btrsa.domain.User;

public interface UserService extends BaseService<User, Long> {

    User login();

    void singUp();

    User existByUsername(String username);


}
