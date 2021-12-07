package ir.maktab.btrs.btrsa.domain;

import ir.maktab.btrs.btrsa.domain.enumeration.UserType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.sql.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class AirLineOperator extends User {

    @OneToOne
    private AirLine airLine;

    public AirLineOperator(String firstName,
                           String lastName,
                           String username,
                           String national_code,
                           String password,
                           Date birth_day,
                           UserType userType,
                           boolean isAirLineOperator) {
        super(firstName, lastName, username, national_code, password, birth_day, userType, isAirLineOperator);

    }

    public AirLineOperator(
            String firstName,
            String lastName,
            String national_code,
            String username,
            String password,
            UserType userType,
            boolean isAirLineOperator) {
        super(firstName, lastName, national_code, username, password, userType, isAirLineOperator);
    }

}
