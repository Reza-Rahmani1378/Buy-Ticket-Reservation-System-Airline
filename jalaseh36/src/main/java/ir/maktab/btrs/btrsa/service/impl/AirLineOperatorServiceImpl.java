package ir.maktab.btrs.btrsa.service.impl;


import ir.maktab.btrs.btrsa.base.service.impl.BaseServiceImpl;
import ir.maktab.btrs.btrsa.domain.AirLineOperator;
import ir.maktab.btrs.btrsa.repository.AirLineOperatorRepository;
import ir.maktab.btrs.btrsa.service.AirLineOperatorService;

public class AirLineOperatorServiceImpl extends BaseServiceImpl<AirLineOperator, Long, AirLineOperatorRepository> implements
        AirLineOperatorService {

    public AirLineOperatorServiceImpl(AirLineOperatorRepository repository) {
        super(repository);
    }

}
