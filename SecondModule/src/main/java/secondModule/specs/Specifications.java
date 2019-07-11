package secondModule.specs;

import org.hibernate.criterion.CriteriaQuery;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import java.util.function.Predicate;

public interface Specifications<T> {

    Predicate toPredicate(Root<T> root, CriteriaQuery query, CriteriaBuilder builder);
}
