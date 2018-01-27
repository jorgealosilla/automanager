package br.com.alosilla.automanager.model;

import br.com.alosilla.automanager.util.AbstractService;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class VeiculoService extends AbstractService<Veiculo> {

    @Inject
    private VeiculoRepository repository;

    public VeiculoService() {
        super(Veiculo.class);
    }

    public Veiculo definirUso(final long id) {
        Veiculo veiculoEmUso = repository.findEmUso();
        if (veiculoEmUso != null) {
            veiculoEmUso.setEmUso(false);
            em.merge(veiculoEmUso);
        }
        
        Veiculo veiculo = repository.find(id);
        veiculo.setEmUso(true);

        return em.merge(veiculo);
    }

}
