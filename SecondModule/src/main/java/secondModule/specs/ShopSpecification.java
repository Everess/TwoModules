package secondModule.specs;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import secondModule.model.Shop;

/**
 * This class need for realize sorting
 */
@Repository
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
