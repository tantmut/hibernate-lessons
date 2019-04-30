package learn_jpa.init.relation_ships.one_to_many.uni;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Gun.class)
public abstract class Gun_ {

	public static volatile SingularAttribute<Gun, String> name;
	public static volatile SingularAttribute<Gun, Integer> id;
	public static volatile SetAttribute<Gun, Patron> patrons;

	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String PATRONS = "patrons";

}

