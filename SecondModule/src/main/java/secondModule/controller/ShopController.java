package secondModule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;
import secondModule.dto.Shop;
import secondModule.repo.ShopRepo;
import secondModule.service.ShopService;
import secondModule.specs.ShopSpecs;

import java.util.ArrayList;
import java.util.List;

/**
 * Test controller for Shops table, which contains some methods
 */
@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    public ShopSpecs shopSpecs;

    @Autowired
    public ShopRepo shopRepo;

    @Autowired
    public ShopService shopService;

    /**
     * This method allows get all shops from database
     *
     * @return
     */
    @GetMapping
    public List<Shop> findAllShops() {
        return shopRepo.findAll();
    }

    /**
     * This method allows get and sort Shop(s) by shop title
     *
     * @param shopTitle
     * @param region
     * @return
     */
    @GetMapping(params = {"shop_title", "region"})
    public List<Shop> getShopsByShopTitle(@RequestParam("shop_title") String shopTitle,
                                          @RequestParam("region") int region) {

        return shopRepo.findAll(
                Specification.where(shopSpecs.getShopsByShopTitle(shopTitle)
                        .and(shopSpecs.getShopsByShopRegion(region))
                ));
    }

    /**
     * This method
     *
     * @return
     */
    @GetMapping("/query")
    public List<Shop> findShops() {
        return shopService.findAllShops();
    }

    /**
     * This method allows create Shop(s) in database
     *
     * @param shop
     * @throws Exception
     */
    @PostMapping("/transactional")
    public void createShops(@RequestBody ArrayList<Shop> shop) throws Exception {
        shopService.createShop(shop);
    }
/*
    @GetMapping(value = "/criteria", params = {"shop_title", "region"})
    public List<Shop> getShops(@RequestParam("shop_title") String shopTitle,
                               @RequestParam("region") int region) {
        return shopService.getShops(shopTitle, region);
    } */
}
