package ir.maktab.btrs.btrsa.domain;

import ir.maktab.btrs.btrsa.base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = AirLine.TABLE_NAME)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AirLine extends BaseEntity<Long> {
    public static final String TABLE_NAME = "airline_table";

    @Column
    private String name;

    @Column
    private String concat_us;
    @OneToMany(mappedBy = "air_line", cascade = CascadeType.ALL)
    private List<Ticket> tickets;
    @OneToOne(mappedBy = "airLine", cascade = CascadeType.ALL)
    private AirLineOperator airLineOperator;

//    @OneToOne(cascade = CascadeType.ALL)
//    private Customer customer;

    public AirLine(String name, String concat_us, AirLineOperator airLineOperator) {
        this.name = name;
        this.concat_us = concat_us;
        this.airLineOperator = airLineOperator;
    }

}
