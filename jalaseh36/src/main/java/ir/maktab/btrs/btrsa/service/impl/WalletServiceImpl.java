package ir.maktab.btrs.btrsa.service.impl;


import ir.maktab.btrs.btrsa.base.service.impl.BaseServiceImpl;
import ir.maktab.btrs.btrsa.domain.Customer;
import ir.maktab.btrs.btrsa.domain.Ticket;
import ir.maktab.btrs.btrsa.domain.Wallet;
import ir.maktab.btrs.btrsa.domain.WalletLog;
import ir.maktab.btrs.btrsa.domain.dto.WalletChangeDTO;
import ir.maktab.btrs.btrsa.domain.enumeration.UserType;
import ir.maktab.btrs.btrsa.domain.enumeration.WalletType;
import ir.maktab.btrs.btrsa.repository.WalletRepository;
import ir.maktab.btrs.btrsa.service.WalletLogService;
import ir.maktab.btrs.btrsa.service.WalletService;

import java.time.LocalDateTime;
import java.util.UUID;

public class WalletServiceImpl extends BaseServiceImpl<Wallet, Long, WalletRepository> implements
        WalletService {
    private final WalletLogService walletLogService;

    public WalletServiceImpl(WalletRepository repository, WalletLogService walletLogService) {
        super(repository);
        this.walletLogService = walletLogService;
    }

    @Override
    public Boolean isIncreaseWalletAmount(WalletChangeDTO wct) {
        Wallet wallet = repository.findFirstByCustomerId(wct.getCustomerId());
        Long beforeTotalAmount = wallet.getTotalAmount();
        wallet.setTotalAmount(beforeTotalAmount + wct.getAmount());
        Long creditAmountChange = 0L;
        Long cashAmountChange = 0L;
        Long beforeCreditAmount = wallet.getCreditAmount();
        Long beforeCashAmount = wallet.getCashAmount();
        if (wct.getCash()) {
            wallet.setCashAmount(beforeCashAmount + wct.getAmount());
            cashAmountChange = wct.getAmount();
        } else {
            wallet.setCreditAmount(beforeCreditAmount + wct.getAmount());
            creditAmountChange = wct.getAmount();
        }
        wallet = repository.save(wallet);

        WalletLog walletLog = new WalletLog();
        walletLog.setCreateDate(LocalDateTime.now());
        walletLog.setLogType(WalletType.INCOME);
        walletLog.setWallet(wallet);
//        walletLog.setCustomerId(wallet.getCustomer().getId());
        walletLog.setCustomer(wallet.getCustomer());
        walletLog.setUniqueCode(UUID.randomUUID().toString());
        walletLog.setUserType(UserType.ADMIN.name());

//        use static class to get current user
//        walletLog.setUser();

        return getLog(wct, wallet, creditAmountChange, cashAmountChange, walletLog);


    }

    @Override
    public Boolean isDecreaseWalletAmountWithBuyTicket(WalletChangeDTO wct, Ticket ticket, Customer customer) {
        Wallet wallet = customer.getWallet();
        Long beforeTotalAmount = wallet.getTotalAmount();
        wallet.setTotalAmount(beforeTotalAmount - wct.getAmount());
        Long creditAmountChange = 0L;
        Long cashAmountChange = 0L;
        Long beforeCreditAmount = wallet.getCreditAmount();
        Long beforeCashAmount = wallet.getCashAmount();
        if (wct.getCash()) {
            wallet.setCashAmount(beforeCashAmount - wct.getAmount());
            cashAmountChange = wct.getAmount();
        } else {
            wallet.setCreditAmount(beforeCreditAmount - wct.getAmount());
            creditAmountChange = wct.getAmount();
        }
        wallet = repository.save(wallet);

        WalletLog walletLog = new WalletLog();
        walletLog.setCreateDate(LocalDateTime.now());
        walletLog.setLogType(WalletType.OUTCOME);
        walletLog.setWallet(wallet);
//        walletLog.setCustomerId(wallet.getCustomer().getId());
        walletLog.setCustomer(wallet.getCustomer());
        walletLog.setUniqueCode(UUID.randomUUID().toString());
        walletLog.setUserType(UserType.CUSTOMER.name());

//        use static class to get current user
//        walletLog.setUser();

        return getLog(wct, wallet, creditAmountChange, cashAmountChange, walletLog);


    }

    private Boolean getLog(WalletChangeDTO wct, Wallet wallet, Long creditAmountChange, Long cashAmountChange, WalletLog walletLog) {
        walletLog.setAmount(wct.getAmount());
        walletLog.setTotalAmount(wallet.getTotalAmount());
        walletLog.setCreditAmount(wallet.getCreditAmount());
        walletLog.setCashAmount(wallet.getCashAmount());
        walletLog.setCreditAmountChange(creditAmountChange);
        walletLog.setCashAmountChange(cashAmountChange);

        walletLogService.save(walletLog);

        return true;
    }
}
