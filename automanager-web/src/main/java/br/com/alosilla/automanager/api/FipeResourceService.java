package br.com.alosilla.automanager.api;

import br.com.alosilla.automanager.model.Marca;
import br.com.alosilla.automanager.util.CollectionsBuilder;
import java.net.URI;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.ServiceUnavailableException;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;

public class FipeResourceService {

    @Inject
    private Logger log;

    private final String FIPE_MARCAS = "https://fipe-parallelum.rhcloud.com/api/v1/carros/marcas";

    List<Marca> findMarcas() {
            List<Marca> marcas = CollectionsBuilder.createDefaultArrayList();
        try {
            GenericType<List<Marca>> marcaType = new GenericType<List<Marca>>() {
            };
            marcas.addAll(ClientBuilder.newClient()
                    .target(URI.create(FIPE_MARCAS))
                    .request().get(marcaType));
        } catch (ProcessingException ex) {
            log.info("Você está sem conexção com a internet.");
            log.log(Level.SEVERE, ex.getMessage());
        } catch(ServiceUnavailableException ex){
            log.info("O serviço externo da FIPE está indisponível.");      
            log.log(Level.SEVERE, ex.getMessage());
        }
        return marcas;
    }

}
