package program;

import program.entity.oneToOne.Department;
import program.entity.oneToOne.Employee;
import program.entity.oneToOne.EmployeeDetail;
import program.entity.oneToOne.Meeting;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;


/**
 * Разобрали связь один к одному (employee -> employee_detail через primary key
 * а так же всязь один ко многогим  у одного employee может быть только один департамент,
 * у департамента может быть много employee я так это понял)
 * */

public class AppOneToOne {
    public static void main(String[] args) {


        Meeting meeting = Meeting.builder()
                .meetingDate(new Date(LocalDate.now().toEpochDay()))
                .subject("Event")
                .build();

        EmployeeDetail employeeDetail = EmployeeDetail.builder()
                .city("Minsk")
                .country("Belarus")
                .state("TYU")
                .street("Mstislavtsa")
                .build();

        Department department = Department.builder()
                .departmentName("Sales department")
                .build();

        Employee employee =  Employee.builder()
                .birthDate(new Date(LocalDate.now().toEpochDay()))
                .cellphone("45678")
                .firstName("Alex")
                .lastName("Smit")
                .employeeDetail(employeeDetail)
                .department(department)
                .meetings(Set.of(meeting))
                .build();
        employeeDetail.setEmployee(employee);

        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(employee);

        entityManager.getTransaction().commit();
        entityManager.close();
        HibernateUtil.close();
        System.out.println(employee);
    }
}
