package ir.maktab.btrs.btrsa.repository;

import ir.maktab.btrs.btrsa.base.repository.BaseRepository;
import ir.maktab.btrs.btrsa.domain.DiscountCode;

public interface DiscountCodeRepository extends BaseRepository<DiscountCode, Long> {

    DiscountCode findDiscountCodeByCode(String code);


}
