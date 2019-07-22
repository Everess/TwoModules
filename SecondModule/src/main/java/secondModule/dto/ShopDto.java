package secondModule.dto;

public class ShopDto {

    public Integer idShop;

    public String shopTitle;

    public ShopDto() { }

    public ShopDto(Integer idShop, String shopTitle) {
        this.idShop = idShop;
        this.shopTitle = shopTitle;
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

}
