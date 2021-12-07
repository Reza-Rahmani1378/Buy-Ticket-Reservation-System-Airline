package ir.maktab.btrs.btrsa.service;

import ir.maktab.btrs.btrsa.base.service.BaseService;
import ir.maktab.btrs.btrsa.domain.Customer;
import ir.maktab.btrs.btrsa.domain.Ticket;
import ir.maktab.btrs.btrsa.domain.Wallet;
import ir.maktab.btrs.btrsa.domain.dto.WalletChangeDTO;

public interface WalletService extends BaseService<Wallet, Long> {

    Boolean isIncreaseWalletAmount(WalletChangeDTO wct);

    Boolean isDecreaseWalletAmountWithBuyTicket(WalletChangeDTO wct, Ticket ticket, Customer customer);
}
