package br.com.alosilla.automanager.api;

import br.com.alosilla.automanager.model.Interessado;
import br.com.alosilla.automanager.model.InteressadoRepository;
import br.com.alosilla.automanager.model.InteressadoService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@RequestScoped
@Path("interessados")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class InteressadoResource {

    @Inject
    private InteressadoService service;
    @Inject
    private InteressadoRepository repository;
//    @Inject
//    GenericRepository<Interessado> repository;

    @POST
    public Response save(Interessado interessado) {
        return Response.ok(service.persist(interessado)).build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Interessado> findAll() {
        return repository.findAll();
    }
    
    @GET
    @Path("uri")
    public Response uriDetails(@Context UriInfo uriInfo) {
        Map<String, String> dados = new HashMap();
        dados.put("host", uriInfo.getBaseUri().getHost());

        return Response.ok(dados).build();
    }

    @GET
    @Path("headers")
    public Response headerDetails(@Context HttpHeaders header) {
        Map<String, String> dados = new HashMap();
        dados.put("X-teste", header.getHeaderString("X-teste"));
        return Response.ok(dados).build();
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("text/X-a+json")
    public Response acceptA() {
        
        return Response.ok("Accept-A").link("http://localhost:8080/a", "http://localhost:8080/b").build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("text/X-b+json")
    public Response acceptB() {
        return Response.ok("Accept-B").build();
    }
}
