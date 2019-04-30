package learn_jpa.init;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "sky_gen", sequenceName = "sky_db_gen",
        initialValue = 1, allocationSize = 1)
public class Sky {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sky_gen")
    @Column(name = "sky_id")
    private int id;

    private String name;

    public Sky(String name) {
        this.name = name;
    }

    public Sky() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class TestTableSql {
    public static void main(String[] args) {

        EntityManager em = JPAUtil.geEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        Sky sky = new Sky("Blue");
        em.persist(sky);

        transaction.commit();

        em.close();
    }
}
