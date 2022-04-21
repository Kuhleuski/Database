package program;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity

@DiscriminatorValue("E")
public class Employee1 extends Person{
    @Column
    private String company;

    @Column
    private Double salary;

}
