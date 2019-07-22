package secondModule.repository;

import org.springframework.stereotype.Repository;
import secondModule.model.Shop;

import java.util.List;

@Repository
public interface ShopRepositoryCriteria {

    List<Shop> testCriteria(String shopTitle);
}
