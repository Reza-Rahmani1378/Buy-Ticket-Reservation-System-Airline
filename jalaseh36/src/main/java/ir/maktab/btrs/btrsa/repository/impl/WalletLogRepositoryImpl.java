package ir.maktab.btrs.btrsa.repository.impl;

import ir.maktab.btrs.btrsa.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.btrs.btrsa.domain.WalletLog;
import ir.maktab.btrs.btrsa.repository.WalletLogRepository;

import javax.persistence.EntityManager;

public class WalletLogRepositoryImpl extends BaseRepositoryImpl<WalletLog, Long> implements WalletLogRepository {
    public WalletLogRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<WalletLog> getEntityClass() {
        return WalletLog.class;
    }


}
