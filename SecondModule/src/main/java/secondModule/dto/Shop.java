package secondModule.dto;


import javax.persistence.*;

/**
 * This class describe shop table in database
 */
@Entity
@Table(name = "shop", schema = "firstTestSchema")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_shop")
    public int idShop;

    @Column(name = "shop_title")
    public String shopTitle;

    @Column(name = "region")
    public Long region;

    public Shop() { }

    public Shop(int idShop, String shopTitle, Long region) {
        this.idShop = idShop;
        this.shopTitle = shopTitle;
        this.region = region;
    }

    public String getShopTitle() {
        return shopTitle;
    }

    public void setShopTitle(String shopTitle) {
        this.shopTitle = shopTitle;
    }

    public Long getRegion() {
        return region;
    }

    public void setRegion(Long region) {
        this.region = region;
    }
}
