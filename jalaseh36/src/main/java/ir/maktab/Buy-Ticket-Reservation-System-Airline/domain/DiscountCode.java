package ir.maktab.home_work17.domain;

import ir.maktab.home_work17.base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiscountCode extends BaseEntity<Long> {

    private String code;

    private double discountPercent;

    private LocalDate expireDate;

    @ManyToMany
    private Set<Customer> customers = new HashSet<>();

    public DiscountCode(String discountCode, Double percentage, LocalDate expireDateCode) {
        this.code = discountCode;
        this.discountPercent = percentage;
        this.expireDate = expireDateCode;
    }
}
