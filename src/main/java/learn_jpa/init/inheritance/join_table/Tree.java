package learn_jpa.init.inheritance.join_table;

import learn_jpa.init.JPAUtil;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TREE_TYPE")
@DiscriminatorValue(value = "SIMPLE_TREE")
public class Tree {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    public Tree(String name) {
        this.name = name;
    }

    public Tree() {
    }
}

@Entity
@DiscriminatorValue(value = "OAK")
class Oak extends Tree {
    private String oakName;

    public Oak(String name, String oakName) {
        super(name);
        this.oakName = oakName;
    }
    public Oak() {

    }
}

@Entity
@DiscriminatorValue(value = "TOPOL")
class Topol extends Tree {
    private String topolName;

    public Topol(String name, String topolName) {
        super(name);
        this.topolName = topolName;
    }

    public Topol() {

    }
}

class TestJoinedStrategy {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.geEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        Tree tree = new Tree("Simple tree");

        Oak oak  = new Oak("Big oak", "One");

        Topol topol  = new Topol("Big topol", "Two");

        em.persist(tree);
        em.persist(topol);
        em.persist(oak);

        transaction.commit();

        em.close();
    }
}
