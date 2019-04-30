package learn_jpa.init.relation_ships.one_to_many.uni;

import learn_jpa.init.JPAUtil;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Gun {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "gun_patron",
            joinColumns = @JoinColumn(name = "gun_fk_id"),
    inverseJoinColumns = @JoinColumn(name = "patron_fk_id"))
    private Set<Patron> patrons = new HashSet<>();

    public Gun(String name) {
        this.name = name;
    }

    public Gun() {
    }

    public void addPatron(Patron patron) {
        patrons.add(patron);
    }
}

class TestOneToManyUni {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.geEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        Gun gun = new Gun("Steeve");

        gun.addPatron(new Patron("One"));
        gun.addPatron(new Patron("Two"));

        em.persist(gun);

        transaction.commit();

        em.close();

    }
}
