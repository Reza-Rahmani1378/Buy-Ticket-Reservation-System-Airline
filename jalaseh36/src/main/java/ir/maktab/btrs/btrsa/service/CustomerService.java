package ir.maktab.btrs.btrsa.service;

import ir.maktab.btrs.btrsa.base.service.BaseService;
import ir.maktab.btrs.btrsa.domain.Customer;
import ir.maktab.btrs.btrsa.domain.Ticket;
import ir.maktab.btrs.btrsa.domain.dto.WalletChangeDTO;
import ir.maktab.btrs.btrsa.domain.enumeration.UserType;


public interface CustomerService extends BaseService<Customer, Long> {

    Boolean isIncreaseWalletAmount(WalletChangeDTO wct, UserType userType) throws Exception;

    Boolean isDecreaseWalletAmountWithBuyTicket(WalletChangeDTO wct, Ticket ticket);

}
