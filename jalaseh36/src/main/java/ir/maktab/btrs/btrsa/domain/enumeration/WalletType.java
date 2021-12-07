package ir.maktab.btrs.btrsa.domain.enumeration;

public enum WalletType {
    INCOME, OUTCOME;

    @Override
    public String toString() {
        return switch (this) {
            case INCOME -> "درآمد";
            case OUTCOME -> "خروجی";
        };
    }
}
