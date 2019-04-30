package learn_jpa.init.inheritance.single_table;

import learn_jpa.init.JPAUtil;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "CAR_TYPE")
@DiscriminatorValue(value = "SIMPLE_CAR")
public class Car {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    public Car(String name) {
        this.name = name;
    }

    public Car() {
    }
}

@Entity
@DiscriminatorValue(value = "SMALL_CAR")
class SmallCar extends Car {
    private String smallCarName;

    public SmallCar(String name, String smallCarName) {
        super(name);
        this.smallCarName = smallCarName;
    }

    public SmallCar() {

    }
}

@Entity
@DiscriminatorValue(value = "BIG_CAR")
class BigCar extends Car {
    private String bigCarName;

    public BigCar(String name, String bigCarName) {
        super(name);
        this.bigCarName = bigCarName;
    }

    public BigCar() {

    }
}

class TestJoinedTable {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.geEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        Car car = new Car("OldCar");

        SmallCar smallCar = new SmallCar("NewSmallCar", "One");

        BigCar bigCar = new BigCar("NewBigCar", "Two");

        em.persist(car);
        em.persist(smallCar);
        em.persist(bigCar);

        Car car1 = em.find(Car.class, 27);

        transaction.commit();

        em.close();
    }
}
