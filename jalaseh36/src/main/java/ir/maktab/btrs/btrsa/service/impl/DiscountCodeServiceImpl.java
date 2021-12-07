package ir.maktab.btrs.btrsa.service.impl;


import ir.maktab.btrs.btrsa.base.service.impl.BaseServiceImpl;
import ir.maktab.btrs.btrsa.domain.DiscountCode;
import ir.maktab.btrs.btrsa.repository.DiscountCodeRepository;
import ir.maktab.btrs.btrsa.service.DiscountCodeService;

public class DiscountCodeServiceImpl extends BaseServiceImpl<DiscountCode, Long, DiscountCodeRepository> implements
        DiscountCodeService {

    public DiscountCodeServiceImpl(DiscountCodeRepository repository) {
        super(repository);
    }

    @Override
    public DiscountCode findDiscountCodeByCode(String code) {
        return repository.findDiscountCodeByCode(code);
    }
}
