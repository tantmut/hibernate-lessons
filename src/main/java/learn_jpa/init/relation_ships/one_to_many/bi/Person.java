package learn_jpa.init.relation_ships.one_to_many.bi;

import learn_jpa.init.JPAUtil;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "person", orphanRemoval = true)
    private List<Email> emails = new ArrayList<>();

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    public void addEmail(Email email) {
        emails.add(email);
    }

    public List<Email> getEmails() {
        return emails;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
//                ", emails=" + emails +
                '}';
    }
}

class TestOneToMany {
    public static void main(String[] args) {
        Person person = new Person("Nazar");

        Email email = new Email("ynazar@gmail.com");

        Email email1 = new Email("ynaz@gmail.com");

        email.setPerson(person);
        email1.setPerson(person);

        person.addEmail(email);
        person.addEmail(email1);

        EntityManager em = JPAUtil.geEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

//        em.persist(person);

        Person person1 = em.find(Person.class, 11);


//        List<Email> emails = person1.getEmails();

//        emails.remove(1);
//        emails.clear();

//        Query query = em.createQuery("FROM Person p JOIN FETCH p.emails");


        transaction.commit();

        em.close();

//        System.out.println(person1);


    }
}

/*
 * Person
 *
 * 1 John 1
 * 1 John 2
 *
 *
 * Email
 *
 * 1 1
 * 2 1
 * */
