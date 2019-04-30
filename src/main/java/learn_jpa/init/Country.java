package learn_jpa.init;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "getAllCountries", query = "FROM Country"),
        @NamedQuery(name = "getSpecificCountry", query = "FROM Country c WHERE c.id = :id")
})
public class Country {

    @Id
    @GeneratedValue
    @Column(name = "country_id")
    private int id;//country_id

    private String name;

    @Enumerated(EnumType.STRING)
    private Region region;

    @Embedded
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Country(String name) {
        this.name = name;
    }

    public Country() {

    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", region=" + region +
                ", address=" + address +
                '}';
    }


}

class TestCountry {
    public static void main(String[] args) {
        Country ukraine = new Country("UK");

        Address address = new Address(1);
        ukraine.setAddress(address);
        EntityManager em = JPAUtil.geEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        //add new value to DB
//        em.persist(ukraine);

        //Find by ID
//        Country country = em.find(Country.class, 1);

//        System.out.println( country.toString());

//        Country country = em.getReference(Country.class, 2);

        //Find by id using query
//        TypedQuery<Country> emQuery = em.createQuery("FROM Country c WHERE c.id = :countryID", Country.class);
//
//        emQuery.setParameter("countryID", 1);
//
//        Country country = emQuery.getSingleResult();
//
//        System.out.println(country);

        //Find by id using named query
//        TypedQuery<Country> countries = em.createNamedQuery("getAllCountries", Country.class);
//
//        System.out.println(countries.getResultList());

        TypedQuery<Country> country = em.createNamedQuery("getSpecificCountry", Country.class);

        country.setParameter("id", 2);

        Country country1 = country.getSingleResult();

        System.out.printf("", country1);

        //Remove from DB
//        em.remove(country);

        transaction.commit();

        em.close();


        //Add object to the persist context
        /*EntityManager manager = factory.createEntityManager();

        EntityTransaction tran = manager.getTransaction();

        tran.begin();

        Country country2 = manager.merge(country1);

        country2.setName("TTTT");

        manager.persist(country2);

        tran.commit();

        manager.close();

        factory.close();*/

    }
}


class TestCountry1 {
    public static void main(String[] args) {
        Country ukraine = new Country("UK");

        Address address = new Address(5);

        ukraine.setAddress(address);

        EntityManager em = JPAUtil.geEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        ukraine.setRegion(Region.KIEV);

//        em.persist(ukraine);

        Country country = em.find(Country.class, 3);

        country.setName("Refresh");

        em.refresh(country);

        transaction.commit();

        em.close();

    }
}
