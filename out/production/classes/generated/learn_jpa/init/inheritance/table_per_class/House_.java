package learn_jpa.init.inheritance.table_per_class;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(House.class)
public abstract class House_ {

	public static volatile SingularAttribute<House, String> name;
	public static volatile SingularAttribute<House, Integer> id;

	public static final String NAME = "name";
	public static final String ID = "id";

}

