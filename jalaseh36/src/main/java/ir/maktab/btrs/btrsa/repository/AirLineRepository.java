package ir.maktab.btrs.btrsa.repository;

import ir.maktab.btrs.btrsa.base.repository.BaseRepository;
import ir.maktab.btrs.btrsa.domain.AirLine;

public interface AirLineRepository extends BaseRepository<AirLine, Long> {


    AirLine findByName(String airlineName);
}
