package learn_jpa.init.relation_ships.many_to_many;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Tree {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Leaf> leaves = new LinkedList<>();

    public Tree(String name) {
        this.name = name;
    }

    public Tree() {
    }

    public void addLeaf(Leaf leaf) {
        leaves.add(leaf);
    }
}
