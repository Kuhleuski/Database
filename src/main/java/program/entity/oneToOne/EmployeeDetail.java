package program.entity.oneToOne;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString(exclude = "employee")
@EqualsAndHashCode   // посмотреть как переопределить просто по id
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee_detail")
@Entity
@Builder

public class EmployeeDetail implements Serializable {
    /**
     *
     * */
    @GenericGenerator(name = "one-one",
                     strategy = "foreign",
                     parameters = @org.hibernate.annotations.Parameter(name = "property",
                     value = "employee"))
    @GeneratedValue(generator = "one-one")
    @Id
    @Column(name = "id_employee")
    private Integer id;
    /**
     *
     * */
    @Column(name = "city")
    private String city;
    /**
     *
     * */
    @Column(name = "country")
    private String country;
    /**
     *
     * */
    @Column(name = "street")
    private String street;
    /**
     *
     * */
    @Column(name = "state")
    private String state;
    /**
     *
     * */
    @OneToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private Employee employee;

}
