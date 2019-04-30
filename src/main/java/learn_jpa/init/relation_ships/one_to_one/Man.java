package learn_jpa.init.relation_ships.one_to_one;

import learn_jpa.init.JPAUtil;

import javax.persistence.*;

@Entity
public class  Man {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

//    @OneToOne(mappedBy = "man")
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    @JoinColumn(name = "man_fk_id")
    private Phone phone;

    public Man(String name, Phone phone) {
        this.name = name;
        this.phone = phone;
    }

    public Man() {
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}

class TestOneToOne {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.geEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        Phone phone = new Phone("067");

        Man man = new Man("John", phone);

        phone.setMan(man);

        Man man1 = em.find(Man.class, 2);

        man1.setPhone(null);

//        em.persist(phone);

//        em.persist(man);

        transaction.commit();



        em.close();

    }
}
