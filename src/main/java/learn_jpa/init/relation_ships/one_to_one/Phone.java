package learn_jpa.init.relation_ships.one_to_one;

import javax.persistence.*;

@Entity
public class Phone {
    @Id
    @GeneratedValue
    private int id;

    private String number;

    @OneToOne(mappedBy = "phone")
//    @OneToOne
//    @JoinColumn(name = "man_fk_id")
    private Man man;

    public Phone(String number) {
        this.number = number;
    }

    public Phone() {
    }

    public void setMan(Man man) {
        this.man = man;
    }
}
