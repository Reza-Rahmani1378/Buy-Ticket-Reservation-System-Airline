package ir.maktab.btrs.btrsa.domain;

import ir.maktab.btrs.btrsa.domain.enumeration.UserType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer extends User {

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "customer_ticket_join_table",
            joinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ticket_id", referencedColumnName = "id")
    )
    Set<Ticket> Tickets = new HashSet<>();
    private double balance;

    /*  @OneToMany(mappedBy = "customer" ,cascade = CascadeType.ALL)
      private List<Ticket> tickets;*/
    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private Wallet wallet;

    public Customer(String first_name, String last_name, String username, String national_code,
                    String password, Date birth_day, UserType userType, boolean airLinOperator) {
        super(first_name, last_name, username, national_code, password,
                birth_day, userType, airLinOperator);
    }


    public Customer(String username, String password, String nationalCode, UserType userType) {
        super(username, password, nationalCode, userType);
    }
}
