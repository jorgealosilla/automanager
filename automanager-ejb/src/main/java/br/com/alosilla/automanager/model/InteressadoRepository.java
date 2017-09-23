package br.com.alosilla.automanager.model;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

@Stateless
public class InteressadoRepository {

    @Inject
    private EntityManager em;

    public List<Interessado> find() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Interessado.class));
        return em.createQuery(cq).getResultList();
    }
}
