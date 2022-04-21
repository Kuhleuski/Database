package program.entity.oneToOne;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode  // посмотреть как переопределить просто по id
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
@Builder

public class Department implements Serializable {
    /**
     *
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     *
     * */
    @Column(name = "department_name")
    private String departmentName;
    /**
     *
     * */
    @OneToMany(mappedBy = "department")
    @ToString.Exclude
    private Set<Employee> employees = new HashSet<>();
}
