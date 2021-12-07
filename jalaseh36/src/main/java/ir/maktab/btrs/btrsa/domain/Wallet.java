package ir.maktab.btrs.btrsa.domain;

import ir.maktab.btrs.btrsa.base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = Wallet.TABLE_NAME)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Wallet extends BaseEntity<Long> {
    public static final String TABLE_NAME = "wallet_table";
    @OneToOne
    private Customer customer;

    @Column
    private Long totalAmount = 0L;

    @Column
    private Long creditAmount = 0L;

    @Column
    private Long cashAmount = 0L;

}

