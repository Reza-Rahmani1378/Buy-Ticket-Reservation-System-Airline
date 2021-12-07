package ir.maktab.btrs.btrsa.repository;

import ir.maktab.btrs.btrsa.base.repository.BaseRepository;
import ir.maktab.btrs.btrsa.domain.Wallet;

public interface WalletRepository extends BaseRepository<Wallet, Long> {


    Wallet findFirstByCustomerId(Long customerId);
}
