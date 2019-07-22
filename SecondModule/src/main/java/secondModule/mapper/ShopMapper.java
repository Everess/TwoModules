package secondModule.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import secondModule.dto.ShopDto;
import secondModule.model.Shop;

import java.util.List;

@Mapper
public interface ShopMapper {

    ShopMapper INSTANCE = Mappers.getMapper(ShopMapper.class);

    /* @Mappings ({
            @Mapping (source = "idShop", target = "idShop"),
            @Mapping (source = "shopTitle", target = "shopTitle")
    })
    ShopDto shopToShopDto(Shop shop); */

    List<ShopDto> SHOP_DTO_LIST(List<Shop> shop);
}
