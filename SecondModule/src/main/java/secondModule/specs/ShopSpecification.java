package secondModule.specs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import secondModule.model.Shop;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * This class need for realize sorting
 */
@Component
public class ShopSpecification {

    /**
     * Sorting by shop title
     * @param shopTitle
     */
    public Specification<Shop> getShopsByShopTitle(String shopTitle) {

        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("shopTitle"), shopTitle);
    }

    /**
     * Sorting by shop region
     * @param idRegion
     */
    public Specification<Shop> getShopsByShopRegion(Long idRegion) {

        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("idRegion"), idRegion);
    }

    /**
     * Like query with one param
     * @param shopTitle
     */
    public Specification<Shop> findAllShops(String shopTitle) {

        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("shopTitle"), shopTitle);
    }

    /**
     * Method for search with id region
     * @param idRegion
     * @return
     */
    public Specification<Shop> findAllShopsByIdRegion(Long idRegion) {

        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("idRegion"), idRegion);
    }
}
