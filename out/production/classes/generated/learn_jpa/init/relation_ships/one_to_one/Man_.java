package learn_jpa.init.relation_ships.one_to_one;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Man.class)
public abstract class Man_ {

	public static volatile SingularAttribute<Man, Phone> phone;
	public static volatile SingularAttribute<Man, String> name;
	public static volatile SingularAttribute<Man, Integer> id;

	public static final String PHONE = "phone";
	public static final String NAME = "name";
	public static final String ID = "id";

}

