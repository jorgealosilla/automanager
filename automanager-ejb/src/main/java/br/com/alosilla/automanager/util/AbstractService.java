package br.com.alosilla.automanager.util;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractService<T extends AbstractEntityId> {

    @PersistenceContext
    protected EntityManager em;

    public T persist(T t) {
        return em.merge(t);
    }

    public void remove(T t) {
        em.remove(t);
    }
}
