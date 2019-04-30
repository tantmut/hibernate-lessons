package learn_jpa.init.inheritance.join_table;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Tree.class)
public abstract class Tree_ {

	public static volatile SingularAttribute<Tree, String> name;
	public static volatile SingularAttribute<Tree, Integer> id;

	public static final String NAME = "name";
	public static final String ID = "id";

}

