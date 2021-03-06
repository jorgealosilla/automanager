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
import javax.ws.rs.OPTIONS;
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
    private VeiculoDto.Builder dtoBuilder;
    @Inject
    private FipeResourceService fipeResourceService;
    @Inject
    private AbastecimentoResource abastecimentoResource;

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
        if (veiculo == null) {
            return Response.status(Status.NO_CONTENT).build();
        }
        return Response.ok(representationBuilder.toRepresentation(veiculo)).build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("em-uso")
    public Response findEmUso() {
        Veiculo veiculo = repository.findEmUso();
        if (veiculo == null) {
            return Response.status(Status.NO_CONTENT).build();
        }
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
        Veiculo veiculo = repository.find(id);
        if (veiculo == null) {
            return Response.status(Status.BAD_REQUEST).build();
        }
        final Veiculo veiculoUpdated = representationBuilder.fromRepresentation(dto, Veiculo.Builder.from(veiculo));
        return Response.ok(representationBuilder.toRepresentation(service.persist(veiculoUpdated))).build();
    }

    @PUT
    @Path("{id}/uso")
    public Response setEmUso(@PathParam("id") final Long id) {
        Veiculo veiculo = repository.find(id);
        if (veiculo == null) {
            return Response.status(Status.BAD_REQUEST).build();
        }
        return Response.ok(representationBuilder.toRepresentation(service.definirUso(id))).build();
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

    @Path(value = "{idVeiculo}/abastecimentos")
    public AbastecimentoResource abastecimentos() {
        return abastecimentoResource;
    }

    @OPTIONS
    public Response options() {
//        Veiculo veiculoDefault = Veiculo.Builder.create().build();
        VeiculoDto veiculoDefault = dtoBuilder.build();

        return Response.ok(veiculoDefault).build();
    }
}
