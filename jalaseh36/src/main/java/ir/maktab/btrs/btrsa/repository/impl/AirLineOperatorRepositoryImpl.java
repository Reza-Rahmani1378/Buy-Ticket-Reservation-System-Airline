package ir.maktab.btrs.btrsa.repository.impl;

import ir.maktab.btrs.btrsa.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.btrs.btrsa.domain.AirLineOperator;
import ir.maktab.btrs.btrsa.repository.AirLineOperatorRepository;

import javax.persistence.EntityManager;

public class AirLineOperatorRepositoryImpl extends BaseRepositoryImpl<AirLineOperator, Long> implements AirLineOperatorRepository {
    public AirLineOperatorRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<AirLineOperator> getEntityClass() {
        return AirLineOperator.class;
    }


}
