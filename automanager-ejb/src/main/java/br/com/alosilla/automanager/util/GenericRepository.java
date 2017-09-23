package br.com.alosilla.automanager.util;

import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

public class GenericRepository<T> {

    @Inject
    private EntityManager em;

    private final T entity;

    public GenericRepository(T entity) {
        this.entity = entity;
    }

    public List<T> find() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entity.getClass()));
        return em.createQuery(cq).getResultList();
    }

}
