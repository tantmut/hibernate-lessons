package learn_jpa.init.relation_ships.one_to_many.bi;

import javax.persistence.*;

@Entity
public class Email {

    @Id
    @GeneratedValue
    private int id;

    private String email;

    public Email(String email) {
        this.email = email;
    }

    public Email() {
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_fk_id")
    private Person person;

    public void setPerson(Person person) {
        this.person = person;
    }

}
