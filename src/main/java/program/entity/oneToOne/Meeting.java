package program.entity.oneToOne;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
@Builder
public class Meeting implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     *
     * */
    @Column(name = "meeting_date")
    private Date meetingDate;
    /**
     *
     * */
    @Column
    private String subject;
    /**
     *
     * */
    @ManyToMany(mappedBy = "meetings")  // ссылается именно на имя переменной а именно сэт митингс
    @ToString.Exclude
    private Set<Employee> employees = new HashSet<>();
}
