package program;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


/**
 * Тут мы создали просто таблицы из Entity
 * */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;

    @AttributeOverrides({
            @AttributeOverride(name="street", column = @Column(name = "home_street")),
            @AttributeOverride(name="city", column = @Column(name = "home_city")),
            @AttributeOverride(name="zipcode", column = @Column(name = "home_zipcode"))
    })
    @Embedded
    private Address homeAddress;
    @Embedded
    private Address buildAddress;
}
