package co.trycore.galaxy.infrastructure.database.crud;

import co.trycore.galaxy.infrastructure.database.entity.Planeta;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class PlanetaJpaImplRepository implements PlanetaJpaRepository {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public List<Planeta> getPlanetasMasVisitados(int top) {
        final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Planeta> cq = cb.createQuery(Planeta.class);
        final Root<Planeta> root = cq.from(Planeta.class);
        cq.select(root).orderBy(cb.desc(root.get("contador")));
        final TypedQuery<Planeta> query = entityManager.createQuery(cq).setMaxResults(top);
        return query.getResultList();
    }

}
