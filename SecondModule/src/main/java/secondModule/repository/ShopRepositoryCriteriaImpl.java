package secondModule.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import secondModule.model.Shop;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ShopRepositoryCriteriaImpl implements ShopRepositoryCriteria {

    private final SessionFactory hibernateFactory;

    @Autowired
    public ShopRepositoryCriteriaImpl(EntityManagerFactory factory) {
        if (factory.unwrap(SessionFactory.class) == null) {
            throw new NullPointerException("factory is not a hibernate factory");
        }
        this.hibernateFactory = factory.unwrap(SessionFactory.class);
    }

    /**
     * Test session factory
     */
    @Override
    public List<Shop> testCriteria(String shopTitle) {

        Session session = hibernateFactory.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Shop> criteriaQuery = criteriaBuilder.createQuery(Shop.class);
        Root<Shop> root = criteriaQuery.from(Shop.class);

        criteriaQuery
                .select(root)
                .where(criteriaBuilder.like(root.get("shopTitle"), "%" + shopTitle + "%"))
                .orderBy(criteriaBuilder.desc(root.get("shopTitle")));

        Query<Shop> articleQuery = session.createQuery(criteriaQuery);
        List<Shop> articleList = articleQuery.getResultList();
        return articleList;
    }
}
