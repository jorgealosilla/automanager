package br.com.alosilla.automanager.model;

import br.com.alosilla.automanager.util.AbstractService;
import javax.ejb.Stateless;

@Stateless
public class AbastecimentoService extends AbstractService<Abastecimento> {

    public AbastecimentoService() {
        super(Abastecimento.class);
    }

}
