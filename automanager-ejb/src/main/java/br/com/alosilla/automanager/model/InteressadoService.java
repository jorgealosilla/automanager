package br.com.alosilla.automanager.model;

import br.com.alosilla.automanager.util.AbstractService;
import javax.ejb.Stateless;

@Stateless
public class InteressadoService extends AbstractService<Interessado> {

    public InteressadoService() {
        super(Interessado.class);
    }

}
