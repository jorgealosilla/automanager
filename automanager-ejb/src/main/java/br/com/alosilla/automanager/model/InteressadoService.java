package br.com.alosilla.automanager.model;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@Stateless
public class InteressadoService {

    @Inject
    private EntityManager em;

    public InteressadoService() {
    }

    public Interessado persist(final Interessado interessado) {
        return em.merge(interessado);
    }
}
