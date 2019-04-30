package learn_jpa.init.locking;

import learn_jpa.init.JPAUtil;

import javax.persistence.*;

@Entity
public class Person {

    @Id
    @GeneratedValue
    private int id;

    @Version
    private int version;

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    public void setName(String name) {
        this.name = name;
    }
}

class TestLocking {
    public static void main(String[] args) {
        Runnable runnable = () -> {

            EntityManager em = JPAUtil.geEntityManager();

            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            Person person = em.find(Person.class, 39);

            System.out.println();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            em.refresh(person);

            person.setName("From thread");

            transaction.commit();

            em.close();


        };

//        new Thread(runnable).start();


        EntityManager em = JPAUtil.geEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

//        Person person = new Person("John");

//        em.persist(person);

        Person person = em.find(Person.class, 39);

        person.setName("From main2 thread");

        transaction.commit();

        em.close();


    }
}
