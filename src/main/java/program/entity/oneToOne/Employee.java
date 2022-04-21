package program.entity.oneToOne;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode  // посмотреть как переопределить просто по id
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
@Entity
@Builder

public class Employee implements Serializable {
    /**
     *
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    /**
     *
     */
    @Column(name = "birth_date")
    private Date birthDate;
    /**
     *
     * */
    @Column(name = "cell_phone")
    private String cellphone;
    /**
     *
     * */
    @Column(name = "first_name")
    private String firstName;
    /**
     *
     * */
    @Column(name = "last_name")
    private String lastName;
    /**
     *
     * */
    @OneToOne(mappedBy = "employee", cascade = { CascadeType.PERSIST, CascadeType.MERGE },
              fetch = FetchType.LAZY)
    private EmployeeDetail employeeDetail;
    /**
     *
     * */
    @ManyToOne(cascade = CascadeType.ALL)
    private Department department;
    /**
     *
     * */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_meeting", joinColumns = {@JoinColumn(name = "employee_id")},
    inverseJoinColumns = {@JoinColumn(name = "meeting_id")})
    private Set<Meeting> meetings = new HashSet<>();
}
