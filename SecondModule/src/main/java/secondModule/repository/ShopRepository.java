package secondModule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import secondModule.model.Shop;

import java.util.List;

/**
 * This repository realised method for work at Shop entity
 */
@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer>, JpaSpecificationExecutor<Shop> {

    /** Need for test filtration */
    /* List<Shop> findShopByIdShopAndShopTitle(Integer idShop, String shopTitle);

    List<Shop> findShopByShopTitleAndIdRegion(String shopTitle, Long idRegion); */

    /**
     * Method for test native query
     */
    @Query(value = "SELECT * FROM first_test_schema.shop s WHERE s.id_shop = 3", nativeQuery = true)
    List<Shop> findShopByIdShop();

    /**
     * Realize native query with param
     * @param idShop
     */
    @Query(value = "SELECT * FROM first_test_schema.shop s WHERE s.id_shop = :idShop", nativeQuery = true)
    List<Shop> getShopsByIdShop(@Param("idShop") Integer idShop);
}
