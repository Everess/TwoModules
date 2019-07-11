package secondModule.dto;

public class Shop {

    public Integer idShop;

    public String shopTitle;

    public Long idRegion;

    public Shop() { }

    public Shop(Integer idShop, String shopTitle, Long region) {
        this.idShop = idShop;
        this.shopTitle = shopTitle;
        this.idRegion = region;
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
