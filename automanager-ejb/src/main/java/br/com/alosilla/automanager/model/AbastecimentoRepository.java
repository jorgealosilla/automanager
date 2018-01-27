package br.com.alosilla.automanager.model;

import br.com.alosilla.automanager.util.AbstractRepository;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class AbastecimentoRepository extends AbstractRepository<Abastecimento> {

    public AbastecimentoRepository() {
        super(Abastecimento.class);
    }

    
    @Override
    @Deprecated
    public Abastecimento find(Object id) {
        throw new UnsupportedOperationException("Método não suportado.");
    }

    @Override
    @Deprecated
    public List<Abastecimento> findAll() {
        throw new UnsupportedOperationException("Método não suportado.");
    }

    public List<Abastecimento> findAll(final Long idVeiculo) {
        final CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Abastecimento> cq = criteriaBuilder.createQuery(Abastecimento.class);
        final Root<Abastecimento> qAbastecimento = cq.from(entityClass);
        cq.select(qAbastecimento).where(criteriaBuilder.equal(qAbastecimento.get("veiculo"), idVeiculo));
        return em.createQuery(cq).getResultList();
    }

    public Abastecimento findById(final Long idVeiculo, final Long idAbastecimento) {
        final CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Abastecimento> cq = criteriaBuilder.createQuery(Abastecimento.class);
        final Root<Abastecimento> qAbastecimento = cq.from(entityClass);

        cq.select(qAbastecimento).where(criteriaBuilder.and(
                criteriaBuilder.equal(qAbastecimento.get("veiculo"), idVeiculo)),
                criteriaBuilder.equal(qAbastecimento.get("id"), idAbastecimento));

        return em.createQuery(cq).getSingleResult();
    }
}
