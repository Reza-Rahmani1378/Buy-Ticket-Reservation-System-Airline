package ir.maktab.btrs.btrsa.repository.impl;

import ir.maktab.btrs.btrsa.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.btrs.btrsa.domain.DiscountCode;
import ir.maktab.btrs.btrsa.repository.DiscountCodeRepository;

import javax.persistence.EntityManager;

public class DiscountCodeRepositoryImpl extends BaseRepositoryImpl<DiscountCode, Long> implements DiscountCodeRepository {
    public DiscountCodeRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<DiscountCode> getEntityClass() {
        return DiscountCode.class;
    }


    @Override
    public DiscountCode findDiscountCodeByCode(String code) {
        return entityManager.createQuery("from Coupon where code = :code", DiscountCode.class)
                .setParameter("code", code).getSingleResult();
    }
}
