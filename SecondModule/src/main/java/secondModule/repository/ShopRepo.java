package secondModule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import secondModule.model.Shop;

@Repository
public interface ShopRepo extends JpaRepository<Shop, Integer> {

}
