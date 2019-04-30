package learn_jpa.init.inheritance.mappedsuperclass;

import learn_jpa.init.JPAUtil;

import javax.persistence.*;

@MappedSuperclass
public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public Animal() {
    }
}

@Entity
class Dog extends Animal {

    @Id
    @GeneratedValue
    private int id;

    private String color;

    public Dog(String name, String color) {
        super(name);
        this.color = color;
    }

    public Dog() {

    }
}

class TestMappedSuperClass {
    public static void main(String[] args) {

        EntityManager em = JPAUtil.geEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        Dog dog = new Dog("Jack", "Black");

        em.persist(dog);

        transaction.commit();

        em.close();

    }
}
