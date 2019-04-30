package learn_jpa.init;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private int streetNumber;

    public Address(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public Address() {
    }
}
