package ir.maktab.btrs.btrsa.domain;

import ir.maktab.btrs.btrsa.base.domain.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = Ticket.TABLE_NAME)
@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
public class Ticket extends BaseEntity<Long> {
    public static final String TABLE_NAME = "ticket_table";

   /* public static final String FROM = "FROM";
    public static final String TO = "TO";*/

    @Column(length = 30)
    private String start_point;
    @Column(length = 30)
    private String end_point;


    @Column
    private Long price_ticket;

    @Column
    private Long valency;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "air_line_id")
    private AirLine air_line;

    @Column
    private LocalDate depart_time;

    @Column
    private LocalDate reture_time;

    @Column
    private LocalTime take_of_time;

    @Column
    private LocalTime landing_time;


    public Ticket(String start_point, String end_point, String depart_time, String take_off_time, String landing_time, Long price_ticket) {
        this.start_point = start_point;
        this.end_point = end_point;
        this.price_ticket = price_ticket;
    }


}
