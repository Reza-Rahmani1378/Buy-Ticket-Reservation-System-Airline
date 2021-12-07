package ir.maktab.btrs.btrsa.repository;

import ir.maktab.btrs.btrsa.base.repository.BaseRepository;
import ir.maktab.btrs.btrsa.domain.User;

public interface UserRepository extends BaseRepository<User, Long> {


    User existByUsername(String username);
}
