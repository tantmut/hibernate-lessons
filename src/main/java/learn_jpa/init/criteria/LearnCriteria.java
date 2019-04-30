package learn_jpa.init.criteria;

import learn_jpa.init.Country_;
import learn_jpa.init.JPAUtil;
import learn_jpa.init.relation_ships.one_to_many.bi.Person;
import learn_jpa.init.relation_ships.one_to_many.bi.Person_;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

public class LearnCriteria {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.geEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        CriteriaBuilder builder = em.getCriteriaBuilder();

        CriteriaQuery<Person> query = builder.createQuery(Person.class);

        Root<Person> root = query.from(Person.class);

        Path<Integer> pathId = root.get(Person_.id);

        query.where(builder.equal(pathId, 8));

        query.select(root);

        TypedQuery<Person> query1 = em.createQuery(query);

        query1.getResultStream().forEach(System.out::println);

        transaction.commit();
        em.close();
    }
}

class MultiSelectCriteria {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.geEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        CriteriaBuilder builder = em.getCriteriaBuilder();

        CriteriaQuery<Tuple> tupleQuery = builder.createTupleQuery();

        Root<Person> root = tupleQuery.from(Person.class);

        Path<Integer> pathId = root.get(Person_.id);

        Path<String> pathName = root.get(Person_.name);

        tupleQuery.where(builder.equal(pathId, 8));

        tupleQuery.multiselect(pathId, pathName);

        TypedQuery<Tuple> query = em.createQuery(tupleQuery);

        Tuple result = query.getSingleResult();

        System.out.println(result.get(pathId) + "\t" + result.get(pathName));

        transaction.commit();
        em.close();
    }
}
