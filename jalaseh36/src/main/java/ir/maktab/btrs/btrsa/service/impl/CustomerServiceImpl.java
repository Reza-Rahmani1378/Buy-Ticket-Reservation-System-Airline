package ir.maktab.btrs.btrsa.service.impl;


import ir.maktab.btrs.btrsa.base.service.impl.BaseServiceImpl;
import ir.maktab.btrs.btrsa.domain.Customer;
import ir.maktab.btrs.btrsa.domain.Ticket;
import ir.maktab.btrs.btrsa.domain.dto.WalletChangeDTO;
import ir.maktab.btrs.btrsa.domain.enumeration.UserType;
import ir.maktab.btrs.btrsa.repository.CustomerRepository;
import ir.maktab.btrs.btrsa.service.CustomerService;
import ir.maktab.btrs.btrsa.service.WalletService;
import ir.maktab.btrs.btrsa.utility.SecurityContext;

public class CustomerServiceImpl extends BaseServiceImpl<Customer, Long, CustomerRepository> implements
        CustomerService {
    private final WalletService walletService;

    public CustomerServiceImpl(CustomerRepository repository, WalletService walletService) {
        super(repository);
        this.walletService = walletService;
    }

    @Override
    public Boolean isIncreaseWalletAmount(WalletChangeDTO wct, UserType userType) throws Exception {
        if (SecurityContext.getActiveUser().getUserType().equals(userType)) {
            if (repository.existById(wct.getCustomerId()))
                return walletService.isIncreaseWalletAmount(wct);
            else
                return false;
        }
        throw new Exception();
    }

    @Override
    public Boolean isDecreaseWalletAmountWithBuyTicket(WalletChangeDTO wct, Ticket ticket) {
        Customer customer = repository.findById(wct.getCustomerId());
        if (customer.getWallet().getTotalAmount() >= wct.getAmount())
            return walletService.isDecreaseWalletAmountWithBuyTicket(wct, ticket, customer);
        else
            return false;
    }
}
