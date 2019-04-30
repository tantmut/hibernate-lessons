package learn_jpa.init.inheritance.table_per_class;

import learn_jpa.init.JPAUtil;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class House {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    public House(String name) {
        this.name = name;
    }

    public House() {
    }
}

@Entity
class WoodHouse extends House {
    private String typeWood;

    public WoodHouse(String name, String typeWood) {
        super(name);
        this.typeWood = typeWood;
    }

    public WoodHouse() {

    }
}

@Entity
class GlassHouse extends House {
    private String typeGlass;

    public GlassHouse(String name, String typeGlass) {
        super(name);
        this.typeGlass = typeGlass;
    }

    public GlassHouse() {
    }
}

class TestTablePerClass {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.geEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        House house = new House("Simple house");

        WoodHouse woodHouse = new WoodHouse("Simple wood", "One");

        GlassHouse glassHouse = new GlassHouse("Simple glass", "Two");

        em.persist(house);
        em.persist(woodHouse);
        em.persist(glassHouse);

        transaction.commit();

        em.close();
    }

}
