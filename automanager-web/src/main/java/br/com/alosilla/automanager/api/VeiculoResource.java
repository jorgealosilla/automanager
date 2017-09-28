package br.com.alosilla.automanager.api;

import br.com.alosilla.automanager.dto.VeiculoDto;
import br.com.alosilla.automanager.model.Marca;
import br.com.alosilla.automanager.model.Veiculo;
import br.com.alosilla.automanager.model.VeiculoRepository;
import br.com.alosilla.automanager.model.VeiculoService;
import java.net.URI;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@RequestScoped
@Path("veiculos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VeiculoResource {

    @Inject
    private VeiculoService service;
    @Inject
    private VeiculoRepository repository;
    @Inject
    private VeiculoDto.RepresentationBuilder representationBuilder;
    @Inject
    private FipeResourceService fipeResourceService;

    @POST
    public Response save(VeiculoDto veiculoDto) {
        Veiculo veiculoCreated = service.persist(representationBuilder.fromRepresentation(veiculoDto, Veiculo.Builder.create()));
        VeiculoDto dto = representationBuilder.toRepresentation(veiculoCreated);
        return Response.created((URI) dto.getLinks().get("self")).entity(dto).build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<Veiculo> veiculos = repository.findAll();

        return Response.ok(representationBuilder.toRepresentation(veiculos)).build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response findById(@PathParam("id") Long id) {
        Veiculo veiculo = repository.find(id);
        return Response.ok(representationBuilder.toRepresentation(veiculo)).build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("marcas")
    public List<Marca> findMarcas() {
        return fipeResourceService.findMarcas();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") final Long id, final VeiculoDto dto) {
        final Veiculo veiculo = representationBuilder.fromRepresentation(dto, Veiculo.Builder.from(repository.find(id)));
        return Response.created(null).entity(representationBuilder.toRepresentation(service.persist(veiculo))).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        Veiculo veiculo = repository.find(id);
        if (veiculo == null) {
            return Response.status(Status.NOT_FOUND).build();
        }
        service.remove(id);
        return Response.noContent().build();
    }
}
