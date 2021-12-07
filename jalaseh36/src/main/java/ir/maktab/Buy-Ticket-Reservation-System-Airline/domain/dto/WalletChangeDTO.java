package ir.maktab.home_work17.domain.dto;

public class WalletChangeDTO {
    private Long customerId;

    private Long amount;

    private Boolean isCash;

    public WalletChangeDTO() {
        System.out.println("Yes i am ok in this case...");
    }

    public WalletChangeDTO(Long customerId, Long amount, Boolean isCash) {
        this.customerId = customerId;
        this.amount = amount;
        this.isCash = isCash;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Boolean getCash() {
        return isCash;
    }

    public void setCash(Boolean cash) {
        isCash = cash;
    }
}
