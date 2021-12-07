package ir.maktab.btrs.btrsa.service;

import ir.maktab.btrs.btrsa.base.service.BaseService;
import ir.maktab.btrs.btrsa.domain.AirLine;

public interface AirLineService extends BaseService<AirLine, Long> {

    AirLine findByName(String airlineName);
}
