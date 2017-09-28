package br.com.alosilla.automanager.model;

import br.com.alosilla.automanager.util.AbstractRepository;
import javax.ejb.Stateless;

@Stateless
public class InteressadoRepository extends AbstractRepository<Interessado> {

    public InteressadoRepository() {
        super(Interessado.class);
    }

}
