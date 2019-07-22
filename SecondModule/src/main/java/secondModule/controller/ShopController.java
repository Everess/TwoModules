package secondModule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import secondModule.dto.ShopDto;
import secondModule.mapper.ShopMapper;
import secondModule.model.Shop;
import secondModule.repository.ShopRepository;
import secondModule.service.ShopServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Test controller for Shops table, which contains some methods
 */
@RestController
@RequestMapping("/shop")
public class ShopController {

    private final ShopServiceImpl shopService;
    private final ShopRepository shopRepository;

    @Autowired
    private ShopController(ShopServiceImpl shopService, ShopRepository shopRepository) {
        this.shopService = shopService;
        this.shopRepository = shopRepository;
    }

    /** Need for test native query with params */
    @GetMapping(value = "/queryParam", params = "id_shop")
    public List<Shop> getShopsByIdShopCtrl(@RequestParam("id_shop") Integer idShop) {
        return shopService.getShopsByIdShop(idShop);
    }

    /**
     * This method allows get and sort Shop(s) by shop title
     *
     * @param shopTitle
     * @param idRegion
     */
    @GetMapping(params = { "shop_title", "region" })
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
     * Method for test criteria query with one param
     * @param shopTitle
     */
    @GetMapping(value = "/criteriaParam", params = { "shop_title" })
    public List<Shop> findAllShops(@RequestParam("shop_title") String shopTitle) {

        return shopService.findAllShops(shopTitle);
    }

    /**
     * Method for test criteria query with two params
     * @param shopTitle
     */
    @GetMapping(value = "/criteriaParams", params = { "shop_title", "region" })
    public List<Shop> findAllShopsByTitleAndIdRegion(@RequestParam("shop_title") String shopTitle,
                                                     @RequestParam("region") Long idRegion) {

        return shopService.findAllShopsByTitleAndIdRegion(shopTitle, idRegion);
    }

    @GetMapping(value = "/optional", params = { "id_shop"})
    public Shop findAllShopsByTitleAndIdRegion(@RequestParam("id_shop") Integer idShop) throws Exception {

        return shopService.findById(idShop);
    }

    /**
     * This method realize mapper
     */
    /*
    @GetMapping(value = "/mapper")
    public ShopDto getMapper() {

        Integer idShop = 1;

        ShopMapper shopMapper = ShopMapper.INSTANCE;

        return shopMapper.shopToShopDto(shopRepo.findById(idShop).get());
    } */

    /**
     * This method realize mapper which convert List
     */
    @GetMapping(value = "/mapperList")
    public List<ShopDto> getMapperList() {
        
        List<Shop> s = new ArrayList<>();

        Iterable<Shop> i = shopRepository.findAll();
        i.forEach(s::add);

        ShopMapper shopMapper = ShopMapper.INSTANCE;

        return shopMapper.SHOP_DTO_LIST(s);
    }
}
