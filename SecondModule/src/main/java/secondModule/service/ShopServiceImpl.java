package secondModule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import secondModule.model.Shop;
import secondModule.repository.ShopRepository;
import secondModule.repository.ShopRepositoryCriteriaImpl;
import secondModule.specs.ShopSpecification;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;
    private final ShopSpecification shopSpecs;
    private final ShopRepositoryCriteriaImpl shopRepositoryCriteriaImpl;

    @Autowired
    public ShopServiceImpl(ShopRepository shopRepository, ShopSpecification shopSpecs, ShopRepositoryCriteriaImpl shopRepositoryCriteriaImpl) {
        this.shopRepository = shopRepository;
        this.shopSpecs = shopSpecs;
        this.shopRepositoryCriteriaImpl = shopRepositoryCriteriaImpl;
    }

    @Override
    public List<Shop> findShopByIdShop() {
        return shopRepository.findShopByIdShop();
    }

    @Override
    public List<Shop> findAll(String shopTitle, Long idRegion) { return shopRepository.findAll(Specification.where(shopSpecs.getShopsByShopTitle(shopTitle)
            .and(shopSpecs.getShopsByShopRegion(idRegion))
    )); }

    @Override
    @Transactional(isolation = Isolation.READ_UNCOMMITTED,
                   propagation = Propagation.REQUIRED,
                   rollbackFor = Exception.class)
    public void createShop(List<Shop> shop) throws Exception {

        List<Shop> newShop = null;

        newShop = shopRepository.saveAll(shop);

        for (Shop s : shop) {
            if (s.idRegion == null) {
                throw new Exception();
            }
        }
    }

    @Override
    public List<Shop> findAllShops(String shopTitle) {

        shopTitle = "%" + shopTitle + "%";

        return shopRepository.findAll(shopSpecs.findAllShops(shopTitle));
    }

    @Override
    public List<Shop> findAllShopsByTitleAndIdRegion(String shopTitle, Long idRegion) {

        shopTitle = "%" + shopTitle + "%";

       if (idRegion == null) {

            return shopRepositoryCriteriaImpl.testCriteria(shopTitle);
        } else {

            return shopRepository.findAll(shopSpecs.findAllShopsByIdRegion(idRegion));
       }
    }

    @Override
    public List<Shop> getShopsByIdShop(Integer idShop) {
        return shopRepository.getShopsByIdShop(idShop);
    }

    @Override
    public Shop findById(Integer idShop) throws Exception {

        return shopRepository.findById(idShop).orElseThrow(Exception::new);
    }
}
