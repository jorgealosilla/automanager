package br.com.alosilla.automanager.dto;

import br.com.alosilla.automanager.api.Api;
import br.com.alosilla.automanager.model.Veiculo;
import br.com.alosilla.automanager.model.Veiculo.TipoAbastecimento;
import br.com.alosilla.automanager.model.Veiculo.UnidadeCombustivel;
import br.com.alosilla.automanager.model.Veiculo.UnidadeDistancia;
import br.com.alosilla.automanager.util.AbstractRepresentationBuilder;
import br.com.alosilla.automanager.util.CollectionsBuilder;
import java.net.URI;
import java.time.Year;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class VeiculoDto {

    private Long id;
    private String nome;
    private String marca;
    private String modelo;
    private int ano;
    private boolean emUso;
    private TipoAbastecimento tipoAbastecimento;
    private UnidadeCombustivel unidadeCombustivel;
    private UnidadeDistancia unidadeDistancia;
    private String placa;
    private String apolice;
    private Map<String, URI> links;

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    private void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    private void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    private void setAno(int ano) {
        this.ano = ano;
    }

    public boolean isEmUso() {
        return emUso;
    }

    private void setEmUso(boolean emUso) {
        this.emUso = emUso;
    }

    public TipoAbastecimento getTipoAbastecimento() {
        return tipoAbastecimento;
    }

    private void setTipoAbastecimento(TipoAbastecimento tipoAbastecimento) {
        this.tipoAbastecimento = tipoAbastecimento;
    }

    public UnidadeCombustivel getUnidadeCombustivel() {
        return unidadeCombustivel;
    }

    private void setUnidadeCombustivel(UnidadeCombustivel unidadeCombustivel) {
        this.unidadeCombustivel = unidadeCombustivel;
    }

    public UnidadeDistancia getUnidadeDistancia() {
        return unidadeDistancia;
    }

    private void setUnidadeDistancia(UnidadeDistancia unidadeDistancia) {
        this.unidadeDistancia = unidadeDistancia;
    }

    public String getPlaca() {
        return placa;
    }

    private void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getApolice() {
        return apolice;
    }

    private void setApolice(String apolice) {
        this.apolice = apolice;
    }

    public Map<String, URI> getLinks() {
        return links;
    }

    private void setLinks(Map<String, URI> links) {
        this.links = links;
    }

    public static class Builder {

        private VeiculoDto entityDto;

        private Builder() {
            entityDto = new VeiculoDto();
        }

        public Builder id(Long id) {
            entityDto.setId(id);
            return this;
        }

        public Builder nome(String nome) {
            entityDto.setNome(nome);
            return this;
        }

        public Builder marca(String marca) {
            entityDto.setMarca(marca);
            return this;
        }

        public Builder modelo(String modelo) {
            entityDto.setModelo(modelo);
            return this;
        }

        public Builder ano(int ano) {
            entityDto.setAno(ano);
            return this;
        }

        public Builder emUso(boolean emUso) {
            entityDto.setEmUso(emUso);
            return this;
        }

        public Builder tipoAbastecimento(TipoAbastecimento tipoAbastecimento) {
            entityDto.setTipoAbastecimento(tipoAbastecimento);
            return this;
        }

        public Builder unidadeCombustivel(UnidadeCombustivel unidadeCombustivel) {
            entityDto.setUnidadeCombustivel(unidadeCombustivel);
            return this;
        }

        public Builder unidadeDistancia(Veiculo.UnidadeDistancia unidadeDistancia) {
            entityDto.setUnidadeDistancia(unidadeDistancia);
            return this;
        }

        public Builder placa(String placa) {
            entityDto.setPlaca(placa);
            return this;
        }

        public Builder apolice(String apolice) {
            entityDto.setApolice(apolice);
            return this;
        }

        public Builder links(Map<String, URI> links) {
            entityDto.setLinks(links);
            return this;
        }

        public VeiculoDto build() {
            return entityDto;
        }

    }

    public static class RepresentationBuilder
            extends AbstractRepresentationBuilder<Veiculo, VeiculoDto, Veiculo.Builder> {

        @Context
        private UriInfo uriInfo;

        public static Builder builder() {
            return new Builder();
        }

        @Override
        public Veiculo fromRepresentation(VeiculoDto dto, Veiculo.Builder builder) {
            return builder.nome(dto.getNome())
                    .marca(dto.getMarca())
                    .modelo(dto.getModelo())
                    .ano(Year.of(dto.getAno()))
                    .emUso(dto.isEmUso())
                    .tipoAbastecimento(dto.getTipoAbastecimento())
                    .placa(dto.getPlaca())
                    .apolice(dto.getApolice())
                    .build();
        }

        public List<Veiculo> fromRepresentation(List<VeiculoDto> dtos) {
            List<Veiculo> veiculos = CollectionsBuilder.createDefaultArrayList();
            dtos.forEach(dto -> veiculos.add(fromRepresentation(dto, Veiculo.Builder.create())));
            return veiculos;
        }

        @Override
        public VeiculoDto toRepresentation(Veiculo veiculo) {
            return builder()
                    .id(veiculo.getId())
                    .nome(veiculo.getNome())
                    .marca(veiculo.getMarca())
                    .modelo(veiculo.getModelo())
                    .ano(veiculo.getAno().getValue())
                    .emUso(veiculo.isEmUso())
                    .tipoAbastecimento(veiculo.getTipoAbastecimento())
                    .placa(veiculo.getPlaca())
                    .apolice(veiculo.getApolice())
                    .links(getLinks(veiculo))
                    .build();
        }

        public Map<String, URI> getLinks(Veiculo veiculo) {
            Map<String, URI> links = new HashMap();
            links.put("self", UriBuilder.fromUri(Api.Veiculos.SELF).build(veiculo.getId()));
            if (!veiculo.isEmUso()) {
                links.put("uso", UriBuilder.fromUri(Api.Veiculos.USO).build(veiculo.getId()));
            }
            return links;
        }
    }

}
