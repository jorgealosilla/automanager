package br.com.alosilla.automanager.util;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public abstract class GenericService<T> {

    @Inject
    protected EntityManager em;
    
    private final Class<T> entityClass;

    public GenericService(Class<T> entity) {
        this.entityClass = entity;
    }
    
    public T persist(T t) {
        return em.merge(t);
    }

    public void delete(T id) {
        em.remove(em.getReference(entityClass, id));
    }
}
