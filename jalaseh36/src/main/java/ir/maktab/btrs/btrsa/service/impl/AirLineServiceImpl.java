package ir.maktab.btrs.btrsa.service.impl;


import ir.maktab.btrs.btrsa.base.service.impl.BaseServiceImpl;
import ir.maktab.btrs.btrsa.domain.AirLine;
import ir.maktab.btrs.btrsa.repository.AirLineRepository;
import ir.maktab.btrs.btrsa.service.AirLineService;

public class AirLineServiceImpl extends BaseServiceImpl<AirLine, Long, AirLineRepository> implements
        AirLineService {

    public AirLineServiceImpl(AirLineRepository repository) {
        super(repository);
    }

    @Override
    public AirLine findByName(String airlineName) {
        return repository.findByName(airlineName);
    }
}
