package learn_jpa.init.inheritance;

import learn_jpa.init.inheritance.mappedsuperclass.Dog;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Dog.class)
public abstract class Dog_ extends Animal_ {

	public static volatile SingularAttribute<Dog, String> color;
	public static volatile SingularAttribute<Dog, Integer> id;

	public static final String COLOR = "color";
	public static final String ID = "id";

}

