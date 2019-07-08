package secondModule.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import secondModule.dto.Shop;

import java.util.List;

/**
 * This repository realised method for work at Shop entity
 */
@Repository
public interface ShopRepo extends JpaRepository<Shop, Integer>, JpaSpecificationExecutor<Shop> {

    List<Shop> findShopByIdShopAndShopTitle(int idShop, String shopTitle);

    List<Shop> findShopByShopTitleAndRegion(String shopTitle, int region);

    List<Shop> getShopsByShopTitleAndRegion(String shopTitle, int region);
}
