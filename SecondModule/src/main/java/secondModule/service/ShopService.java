package secondModule.service;

import org.springframework.stereotype.Service;
import secondModule.model.Shop;

import java.util.List;

@Service
public interface ShopService {

    /** Need for test filtration */
    /* List<Shop> findShopsByShopTitleAndIdRegion(String shopTitle, Long idRegion);

    List<Shop> findShopByShopTitleAndIdRegion(String shopTitle, Long idRegion); */

    List<Shop> getShopsByShopTitleAndIdRegion(String shopTitle, Long idRegion);

    List<Shop> findAll(String shopTitle, Long idRegion);

    List<Shop> findShopByIdShop();

    void createShop(List<Shop> shop) throws Exception;


}
