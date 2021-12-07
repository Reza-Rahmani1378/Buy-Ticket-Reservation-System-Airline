package ir.maktab.btrs.btrsa.repository.impl;

import ir.maktab.btrs.btrsa.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.btrs.btrsa.domain.AirLine;
import ir.maktab.btrs.btrsa.repository.AirLineRepository;

import javax.persistence.EntityManager;

public class AirLineRepositoryImpl extends BaseRepositoryImpl<AirLine, Long> implements AirLineRepository {
    public AirLineRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<AirLine> getEntityClass() {
        return AirLine.class;
    }


    @Override
    public AirLine findByName(String airlineName) {
        return entityManager.createQuery(
                "select a from AirLine a where a.name = :airlineName", getEntityClass()
        ).setParameter("airlineName", airlineName).getSingleResult();
    }
}
