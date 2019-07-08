package secondModule.specs;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import secondModule.dto.Shop;

/**
 * This class need for realize sorting
 */
@Repository
public class ShopSpecs {

    /**
     * Sorting by shop title
     * @param shopTitle
     * @return
     */
    public Specification<Shop> getShopsByShopTitle(String shopTitle) {

        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("shopTitle"), shopTitle);
        };
    }

    /**
     * Sorting by shop region
     * @param region
     * @return
     */
    public Specification<Shop> getShopsByShopRegion(int region) {

        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("region"), region);
    }
}
