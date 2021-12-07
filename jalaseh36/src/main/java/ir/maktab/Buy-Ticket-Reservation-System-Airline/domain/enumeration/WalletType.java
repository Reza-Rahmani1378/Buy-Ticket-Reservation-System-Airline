package ir.maktab.home_work17.domain.enumeration;

public enum WalletType {
    INCOME, OUTCOME;

    @Override
    public String toString() {
        switch (this) {
            case INCOME:
                return "درآمد";
            case OUTCOME:
                return "خروجی";
        }
        return super.toString();
    }
}
