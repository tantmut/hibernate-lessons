package learn_jpa.init;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Objects;

public class JPAUtil {
    private static ThreadLocal<EntityManager> threadLocal;

    static {
        threadLocal = new ThreadLocal<>();
    }

    public static EntityManager geEntityManager() {
        if (Objects.isNull(threadLocal.get())) {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("nazar");

            EntityManager em = factory.createEntityManager();

            threadLocal.set(em);
        }

        return threadLocal.get();
    }
}
