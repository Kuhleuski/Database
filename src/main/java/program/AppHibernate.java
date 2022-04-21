package program;

import javax.persistence.EntityManager;

public class AppHibernate {
    public static void main(String[] args) {
        //addWheelToTable();
        //addEngineToTable();

        Student student = Student.builder().mark(23.3).faculty("jhb").build();

        EntityManager entityManager2 = HibernateUtil.getEntityManager();
        entityManager2.getTransaction().begin();
        entityManager2.persist(student);
        entityManager2.getTransaction().commit();
        HibernateUtil.close();


    }

    private static void addEngineToTable() {
        Engine engine = Engine.builder().volume(2500).build();

        EntityManager entityManager2 = HibernateUtil.getEntityManager();
        entityManager2.getTransaction().begin();
        entityManager2.persist(engine);
        entityManager2.getTransaction().commit();
        HibernateUtil.close();
    }

    private static void addWheelToTable() {
        Wheel wheel = Wheel.builder()
                .size(13)
                .type("литьё").build();

        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(wheel);
        entityManager.getTransaction().commit();
        HibernateUtil.close();
    }

}
