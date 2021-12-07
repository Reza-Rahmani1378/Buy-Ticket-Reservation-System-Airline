package ir.maktab.btrs.btrsa.service.impl;


import ir.maktab.btrs.btrsa.base.service.impl.BaseServiceImpl;
import ir.maktab.btrs.btrsa.domain.WalletLog;
import ir.maktab.btrs.btrsa.repository.WalletLogRepository;
import ir.maktab.btrs.btrsa.service.WalletLogService;

public class WalletLogServiceImpl extends BaseServiceImpl<WalletLog, Long, WalletLogRepository> implements
        WalletLogService {

    public WalletLogServiceImpl(WalletLogRepository repository) {
        super(repository);
    }

}
