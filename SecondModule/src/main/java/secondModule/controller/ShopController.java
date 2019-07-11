package secondModule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import secondModule.model.Shop;
import secondModule.service.ShopServiceImpl;

import java.util.List;

/**
 * Test controller for Shops table, which contains some methods
 */
@RestController
@RequestMapping("/shop")
public class ShopController {

    private final ShopServiceImpl shopService;

    @Autowired
    private ShopController(ShopServiceImpl shopService) {
        this.shopService = shopService;
    }

    /** Need for test native query with params */
    /*
    @GetMapping(value = "/queryParam", params = "id_shop")
    public List<Shop> getShopsByIdShopCtrl(@RequestParam("id_shop") Integer idShop) {
        return shopService.getShopsByIdShop(idShop);
    } */

    /**
     * This method allows get and sort Shop(s) by shop title
     *
     * @param shopTitle
     * @param idRegion
     */
    @GetMapping(params = {"shop_title", "region"})
    public List<Shop> findAll(@RequestParam("shop_title") String shopTitle,
                                          @RequestParam("region") Long idRegion) {

        return shopService.findAll(shopTitle, idRegion);
    }

    /**
     * This method realize custom native query
     */
    @GetMapping("/query")
    public List<Shop> findShopByIdShop() {
        return shopService.findShopByIdShop();
    }

    /**
     * This method allows create Shop(s) in database
     *
     * @param shop
     * @throws Exception
     */
    @PostMapping("/transactional")
    public void createShops(@RequestBody List<Shop> shop) throws Exception {
        shopService.createShop(shop);
    }

    /**
     * Test method for criteria builder
     */
    @GetMapping(value = "/criteria", params = {"shop_title", "region"})
    public List<Shop> getShopsByShopTitleAndIdRegion(@RequestParam("shop_title") String shopTitle,
                               @RequestParam("region") Long idRegion) {
        return shopService.getShopsByShopTitleAndIdRegion(shopTitle, idRegion);
    }
}
