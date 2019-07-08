package secondModule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;
import secondModule.dto.Shop;
import secondModule.repo.ShopRepo;
import secondModule.specs.ShopSpecs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShopService /*implements PlatformTransactionManager, TransactionDefinition, TransactionStatus*/ {

    @Autowired
    public ShopRepo shopRepo;

    @Query(value = "SELECT * FROM shop", nativeQuery = true)
    public List<Shop> findAllShops() {
        return shopRepo.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    public void createShop(ArrayList<Shop> shop) throws Exception {

        ArrayList<Shop> newShop = null;

        newShop = (ArrayList<Shop>) shopRepo.saveAll(shop);

        for (Shop s : shop) {
            if (s.region == null) {
                throw new Exception();
            }
        }
    }


    @Autowired
    public ShopSpecs shopSpecs;

    /**
     * Method for test criteria builder
     * @param shopTitle
     * @param region
     * @return
     */
    public List<Shop> getShops(String shopTitle, int region) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ru.easyjava.data.jpa.hibernate");
        EntityManager em = emf.createEntityManager();

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Shop> criteria = builder.createQuery(Shop.class);
        Root<Shop> root = criteria.from(Shop.class);

        Iterable<? extends Shop> shop = null;
        for (Shop s : shop) {
            if (s.region != null) {
                criteria.select(root).where((Predicate) shopSpecs.getShopsByShopRegion(region));
            } else {
                criteria.select(root).where((Predicate) shopSpecs.getShopsByShopTitle(shopTitle));
            }
        }

        return shopRepo.getShopsByShopTitleAndRegion(shopTitle, region);
    }

    /**
     * Return current transaction or create new
     * @param definition
     * @return
     * @throws TransactionException
     *//*
    @Override
    public TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionException {
        return null;
    }

    /**
     * This method row transaction with status
     * @param status
     * @throws TransactionException
     */
   /* @Override
    public void commit(TransactionStatus status) throws TransactionException {

    }*/

    /**
     * Method make rollback transaction
     * @param status
     * @throws TransactionException
     *//*
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
