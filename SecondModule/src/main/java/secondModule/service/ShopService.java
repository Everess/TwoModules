package secondModule.service;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import secondModule.model.Shop;

import java.util.List;

@Service
public interface ShopService {

    /** Need for test filtration */
    /* List<Shop> findShopsByShopTitleAndIdRegion(String shopTitle, Long idRegion);

    List<Shop> findShopByShopTitleAndIdRegion(String shopTitle, Long idRegion); */

    /**
     * Method allows find all shops with shop title and id region
     * @param shopTitle
     * @param idRegion
     */
    List<Shop> findAll(String shopTitle, Long idRegion);

    /**
     * Method realize native query and allows find shop by idShop
     */
    List<Shop> findShopByIdShop();

    /**
     * Method allows create shop(s)
     * @param shop
     * @throws Exception
     */
    void createShop(List<Shop> shop) throws Exception;

    /**
     * Search shops with shop title
     * @param shopTitle
     */
    List<Shop> findAllShops(String shopTitle);

    /**
     * Search shops with shop title and region
     * @param shopTitle
     * @param idRegion
     */
    List<Shop> findAllShopsByTitleAndIdRegion(String shopTitle, Long idRegion);

    /**
     * Realize native query with param
     * @param idShop
     */
    List<Shop> getShopsByIdShop(Integer idShop);
}
