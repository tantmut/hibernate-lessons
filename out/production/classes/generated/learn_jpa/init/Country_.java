package learn_jpa.init;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Country.class)
public abstract class Country_ {

	public static volatile SingularAttribute<Country, Address> address;
	public static volatile SingularAttribute<Country, String> name;
	public static volatile SingularAttribute<Country, Integer> id;
	public static volatile SingularAttribute<Country, Region> region;

	public static final String ADDRESS = "address";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String REGION = "region";

}

