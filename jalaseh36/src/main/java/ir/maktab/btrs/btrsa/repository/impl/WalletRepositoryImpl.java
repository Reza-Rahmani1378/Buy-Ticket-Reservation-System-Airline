package ir.maktab.btrs.btrsa.repository.impl;

import ir.maktab.btrs.btrsa.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.btrs.btrsa.domain.Wallet;
import ir.maktab.btrs.btrsa.repository.WalletRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class WalletRepositoryImpl extends BaseRepositoryImpl<Wallet, Long> implements WalletRepository {
    public WalletRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Wallet> getEntityClass() {
        return Wallet.class;
    }


    @Override
    public Wallet findFirstByCustomerId(Long customerId) {
        TypedQuery<Wallet> wallet = entityManager.createQuery("select w from Wallet w where w.customer.id = :customerId",
                getEntityClass()).setParameter("customerId", customerId);
        try {
            return wallet.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
