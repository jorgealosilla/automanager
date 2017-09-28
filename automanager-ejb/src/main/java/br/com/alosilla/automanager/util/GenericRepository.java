package br.com.alosilla.automanager.util;

import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

public class GenericRepository<T> {

    @Inject
    private EntityManager em;

    private final Class<T> entityClass;

    public GenericRepository(Class<T> entity) {
        this.entityClass = entity;
    }

    public List<T> findAll() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass.getClass()));
        return em.createQuery(cq).getResultList();
    }

    public T findById(Object id) {
        return em.find(entityClass, id);
    }
}
