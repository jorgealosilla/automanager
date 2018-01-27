package br.com.alosilla.automanager.model;

import br.com.alosilla.automanager.util.AbstractRepository;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class VeiculoRepository extends AbstractRepository<Veiculo> {

    public VeiculoRepository() {
        super(Veiculo.class);
    }

    public Veiculo findEmUso() {
        TypedQuery<Veiculo> query = em.createQuery("SELECT v FROM Veiculo v where v.emUso = TRUE", entityClass);
        try {
            return query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }
}
