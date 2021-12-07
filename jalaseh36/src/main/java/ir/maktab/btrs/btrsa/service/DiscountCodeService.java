package ir.maktab.btrs.btrsa.service;

import ir.maktab.btrs.btrsa.base.service.BaseService;
import ir.maktab.btrs.btrsa.domain.DiscountCode;

public interface DiscountCodeService extends BaseService<DiscountCode, Long> {

    DiscountCode findDiscountCodeByCode(String code);

}
