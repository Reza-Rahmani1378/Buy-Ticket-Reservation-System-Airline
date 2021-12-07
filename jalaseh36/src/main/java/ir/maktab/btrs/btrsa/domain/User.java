package ir.maktab.btrs.btrsa.domain;

import ir.maktab.btrs.btrsa.base.domain.BaseEntity;
import ir.maktab.btrs.btrsa.domain.enumeration.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = User.TABLE_NAME)
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity<Long> {
    public static final String TABLE_NAME = "user_table";

    public static final String USER_TYPE = "user_type";

    private static final String AIR_LINE_OPERATOR = "air_line_operator";


    @Column
    private String first_name;

    @Column
    private String last_name;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String national_code;

    @Column
    private String password;

    @Column
    private Date birth_day;

    @Column(name = USER_TYPE)
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Column(name = AIR_LINE_OPERATOR, columnDefinition = "TINYINT(1) default 0")
    private boolean airLineOperator;

    public User(String firstName, String lastName, String national_code, String username, String password, UserType userType, boolean isAirLineOperator) {
        this.first_name = firstName;
        this.last_name = lastName;
        this.national_code = national_code;
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.airLineOperator = isAirLineOperator;
    }

    public User(String username, String password, String nationalCode, UserType userType) {
        this.username = username;
        this.password = password;
        this.national_code = nationalCode;
        this.userType = userType;
    }

    public User(String first_name, String last_name, String username, String national_code, String password, UserType userType) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.national_code = national_code;
        this.password = password;
        this.userType = userType;
    }


}
