package br.com.alosilla.automanager.util;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public abstract class AbstractService<T extends AbstractEntityId> {

    @Inject
    protected EntityManager em;

    protected Class<T> entityClass;

    public AbstractService(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public T persist(T t) {
        return em.merge(t);
    }

    public void remove(Long id) {
        em.remove(em.getReference(entityClass, id));
    }
}
