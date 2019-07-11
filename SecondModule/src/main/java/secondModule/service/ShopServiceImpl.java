package secondModule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;
import secondModule.model.Shop;
import secondModule.repository.ShopRepository;
import secondModule.specs.ShopSpecification;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;
    private final ShopSpecification shopSpecs;

    @Autowired
    public ShopServiceImpl(ShopRepository shopRepository, ShopSpecification shopSpecs) {
        this.shopRepository = shopRepository;
        this.shopSpecs = shopSpecs;
    }

    @Override
    public List<Shop> findShopByIdShop() {
        return shopRepository.findShopByIdShop();
    }

    @Override
    public List<Shop> findAll(String shopTitle, Long idRegion) { return shopRepository.findAll(Specification.where(shopSpecs.getShopsByShopTitle(shopTitle)
            .and(shopSpecs.getShopsByShopRegion(idRegion))
    )); }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createShop(List<Shop> shop) throws Exception {

        List<Shop> newShop = null;

        newShop = shopRepository.saveAll(shop);

        for (Shop s : shop) {
            if (s.idRegion == null) {
                throw new Exception();
            }
        }
    }

    /**
     * TODO: Make this method work
     * Method for test criteria builder
     * @param shopTitle
     * @param idRegion
     */
    @Override
    public List<Shop> getShopsByShopTitleAndIdRegion(String shopTitle, Long idRegion) {

        // EntityManagerFactory emf = Persistence.createEntityManagerFactory("ru.easyjava.data.jpa.hibernate");
        // EntityManager em = emf.createEntityManager();
        Iterable<? extends Shop> shop = null;
        /*
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Shop> criteria = builder.createQuery(Shop.class);
        Root<Shop> root = criteria.from(Shop.class);

        for (Shop s : shop) {
            if (s.idRegion != null) {
                criteria.select(root).where(builder.equal(root.get("region"), 73));
                // criteria.select(root).where((Predicate) shopSpecs.getShopsByShopRegion(region));
            } else {
                criteria.select(root).where(builder.equal(root.get("shopTitle"), "Magaz"));
            }
        } */

        return shopRepository.getShopsByShopTitleAndIdRegion(shopTitle, idRegion);
    }

    /** Need for test native query with params */
    /*
    @Override
    public List<Shop> getShopsByIdShop(Integer idShop) {
        return shopRepository.getShopsByIdShopImpl(idShop);
    } */

    /** Need for test transactions via override methods*/
    /**
     * Return current transaction or create new
     * @param definition
     * @throws TransactionException
     */
    /*
    @Override
    public TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionException {
        return null;
    }

    /**
     * This method row transaction with status
     * @param status
     * @throws TransactionException
     */
    /*
    @Override
    public void commit(TransactionStatus status) throws TransactionException {

    }*/

    /**
     * Method make rollback transaction
     * @param status
     * @throws TransactionException
     */
    /*
    @Override
    public void rollback(TransactionStatus status) throws TransactionException {

    }

    @Override
    public int getPropagationBehavior() {
        return 0;
    }

    @Override
    public int getIsolationLevel() {
        return 0;
    }

    @Override
    public int getTimeout() {
        return 0;
    }

    @Override
    public boolean isReadOnly() {
        return false;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean isNewTransaction() {
        return false;
    }

    @Override
    public boolean hasSavepoint() {
        return false;
    }

    @Override
    public void setRollbackOnly() {

    }

    @Override
    public boolean isRollbackOnly() {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public boolean isCompleted() {
        return false;
    }

    @Override
    public Object createSavepoint() throws TransactionException {
        return null;
    }

    @Override
    public void rollbackToSavepoint(Object savepoint) throws TransactionException {

    }

    @Override
    public void releaseSavepoint(Object savepoint) throws TransactionException {

    }*/
}
