package br.com.alosilla.automanager.model;

import br.com.alosilla.automanager.util.AbstractService;
import javax.ejb.Stateless;

@Stateless
public class VeiculoService extends AbstractService<Veiculo> {

    public VeiculoService() {
        super(Veiculo.class);
    }

}
