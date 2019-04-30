package learn_jpa.init.relation_ships.one_to_many.uni;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Patron {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    public Patron(String name) {
        this.name = name;
    }
}
