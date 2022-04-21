package program;

import program.entity.oneToOne.Department;
import program.entity.oneToOne.Employee;
import program.entity.oneToOne.EmployeeDetail;
import program.entity.oneToOne.Meeting;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;
import static program.MockConstants.*;

public class MockUtils {




    public static Employee createEmployee(Meeting meeting, EmployeeDetail employeeDetail, Department department) {
        Employee employee =  Employee.builder()
                .birthDate(new Date(LocalDate.now().toEpochDay()))
                .cellphone(CELLPHONE)
                .firstName(FIRST_NME)
                .lastName(LAST_NAME)
                .employeeDetail(employeeDetail)
                .department(department)
                .meetings(Set.of(meeting))
                .build();
        employeeDetail.setEmployee(employee);
        return employee;
    }

    public static Department createDepartment() {
        return Department.builder().departmentName(DEPARTMENT_NAME).build();
    }

    public static EmployeeDetail createEmployeeDetail() {
        return EmployeeDetail.builder().city(CITY).country(COUNTRY)
                .state(STATE).street(STREET).build();
    }

    public static Meeting getMeeting() {
        return Meeting.builder().meetingDate(new Date(LocalDate.now()
                .toEpochDay())).subject(SUBJECT).build();
    }
}
