package secondModule.model;

import javax.persistence.*;

/**
 * This class describe shop table in database
 */
@Entity
@Table(name = "shop", schema = "first_test_schema")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_shop")
    public Integer idShop;

    @Column(name = "shop_title")
    public String shopTitle;

    @Column(name = "region")
    public Long idRegion;

    public Shop() { }

    public Shop(Integer idShop, String shopTitle, Long region) {
        this.idShop = idShop;
        this.shopTitle = shopTitle;
        this.idRegion = region;
    }

    public Integer getIdShop() {
        return idShop;
    }

    public void setIdShop(Integer idShop) {
        this.idShop = idShop;
    }

    public String getShopTitle() {
        return shopTitle;
    }

    public void setShopTitle(String shopTitle) {
        this.shopTitle = shopTitle;
    }

    public Long getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Long idRegion) {
        this.idRegion = idRegion;
    }
}

