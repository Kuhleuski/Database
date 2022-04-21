package program;


import org.junit.Assert;
import org.junit.Test;
import program.entity.oneToOne.Department;
import program.entity.oneToOne.Employee;
import program.entity.oneToOne.EmployeeDetail;
import program.entity.oneToOne.Meeting;
import static program.MockConstants.*;

import javax.persistence.EntityManager;
import java.awt.*;

public class WheelTest {
//
//    @Test
//    public void saveTest(){
//        Wheel wheel =  Wheel.builder()
//                .size(16)
//                .type("Литьё")
//                .build();
//        EntityManager em = HibernateUtil.getEntityManager();
//        try {
//            em.getTransaction().begin();;
//            em.persist(wheel);
//            em.getTransaction().commit();
//        } catch (HeadlessException e){
//            em.getTransaction().rollback();
//
//        }
//        em.getTransaction().begin();
//        Wheel whellFromDb = em.find(Wheel.class, wheel.getId());
//        Assert.assertEquals(wheel,whellFromDb);
//        em.getTransaction().commit();
//        em.close();
//    }
//    public static void cleanUp(){
//        HibernateUtil.close();
//    }

    @Test
    public void jpql() {

        final Meeting meeting = MockUtils.getMeeting();
        final EmployeeDetail employeeDetail = MockUtils.createEmployeeDetail();
        final Department department = MockUtils.createDepartment();
        Employee employee = MockUtils.createEmployee(meeting, employeeDetail, department);
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(employee);

        // не заработало
//        javax.persistence.Query query = entityManager.createQuery("select  count(e.firstName), " +
//                "e.firstName from Employee e group by  e.firstName");
//        query.getFirstResult().forEach(employees -> {
//            Object[] emp = (Object[]) employees;
//            System.out.println("Имя: " + emp[1] + " количество:" + emp[0]);
//        });

        final Employee employeeEntity = entityManager.find(Employee.class, employee.getId());

        entityManager.getTransaction().commit();
        entityManager.close();
        Assert.assertNotNull(employeeEntity);
        Assert.assertNotNull(employeeEntity.getId());
        Assert.assertEquals("CELL PHONE not equals", CELLPHONE, employeeEntity.getCellphone());

        HibernateUtil.close();

    }
}