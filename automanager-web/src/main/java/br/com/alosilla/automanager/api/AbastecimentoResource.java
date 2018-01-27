package br.com.alosilla.automanager.api;

import br.com.alosilla.automanager.dto.AbastecimentoDto;
import br.com.alosilla.automanager.model.Abastecimento;
import br.com.alosilla.automanager.model.AbastecimentoRepository;
import br.com.alosilla.automanager.model.AbastecimentoService;
import br.com.alosilla.automanager.model.Veiculo;
import br.com.alosilla.automanager.model.VeiculoRepository;
import java.net.URI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
@Path("abastecimentos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AbastecimentoResource {

    @Inject
    private AbastecimentoService abastecimentoService;
    @Inject
    private AbastecimentoRepository abastecimentoRepository;
    @Inject
    private AbastecimentoDto.RepresentationBuilder representationBuilder;
    @Inject
    private AbastecimentoDto.Builder dtoBuilder;

    @PathParam("idVeiculo")
    private Long idVeiculo;

//    @Inject
//    private VeiculoService veiculoService;
    @Inject
    private VeiculoRepository veiculoRepository;

    @POST
    public Response save(AbastecimentoDto abastecimentoDto) {
        Veiculo veiculo = getVeiculo();
        Abastecimento abastecimentoCreated = abastecimentoService.persist(representationBuilder
                .fromRepresentation(abastecimentoDto, Abastecimento.Builder.create(veiculo)));
        AbastecimentoDto dto = representationBuilder.toRepresentation(abastecimentoCreated);
        return Response.created((URI) dto.getLinks().get("self")).entity(dto).build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<Abastecimento> abastecimentos = abastecimentoRepository.findAll(idVeiculo);

        return Response.ok(representationBuilder.toRepresentation(abastecimentos)).build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response findById(@PathParam("id") Long id) {
        Abastecimento abastecimento = abastecimentoRepository.findById(idVeiculo, id);
        if (abastecimento == null) {
            return Response.status(Status.NOT_FOUND).build();
        }
        return Response.ok(representationBuilder.toRepresentation(abastecimento)).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") final Long id, final AbastecimentoDto dto) {
        Abastecimento abastecimento = abastecimentoRepository.findById(idVeiculo, id);
        if (abastecimento == null) {
            return Response.status(Status.NOT_FOUND).build();
        }
        final Abastecimento abastecimentoUpdated = representationBuilder.fromRepresentation(dto, Abastecimento.Builder.from(abastecimento));
        return Response.ok(representationBuilder.toRepresentation(abastecimentoService.persist(abastecimentoUpdated))).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        Abastecimento abastecimento = abastecimentoRepository.findById(idVeiculo, id);
        if (abastecimento == null) {
            return Response.status(Status.NOT_FOUND).build();
        }
        abastecimentoService.remove(id);
        return Response.noContent().build();
    }

    @OPTIONS
    public Response options() {
//        Veiculo veiculoDefault = Veiculo.Builder.create().build();
        AbastecimentoDto abastecimentoDefault = dtoBuilder.data(LocalDate.now().format(DateTimeFormatter.ISO_DATE)).build();

        return Response.ok(abastecimentoDefault).build();
    }

    private Veiculo getVeiculo() {
        return veiculoRepository.find(idVeiculo);
    }
}
