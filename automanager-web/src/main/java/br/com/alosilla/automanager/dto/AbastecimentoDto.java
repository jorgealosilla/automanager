package br.com.alosilla.automanager.dto;

import br.com.alosilla.automanager.api.Api;
import br.com.alosilla.automanager.model.Abastecimento;
import br.com.alosilla.automanager.model.Abastecimento.TipoCombustivel;
import br.com.alosilla.automanager.util.AbstractRepresentationBuilder;
import br.com.alosilla.automanager.util.CollectionsBuilder;
import java.math.BigDecimal;
import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
public class AbastecimentoDto {

    private Long id;
    private String data;
    private Integer quilometro;
    private TipoCombustivel tipoCombustivel;
    private BigDecimal valorUnitario;
    private BigDecimal quantidade;
    private BigDecimal valorTotal;
    private String anotacao;
    private Map<String, URI> links;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getQuilometro() {
        return quilometro;
    }

    public void setQuilometro(Integer quilometro) {
        this.quilometro = quilometro;
    }

    public TipoCombustivel getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(TipoCombustivel tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getAnotacao() {
        return anotacao;
    }

    public void setAnotacao(String anotacao) {
        this.anotacao = anotacao;
    }

    public Map<String, URI> getLinks() {
        return links;
    }

    private void setLinks(Map<String, URI> links) {
        this.links = links;
    }

    public static class Builder {

        private AbastecimentoDto entityDto;

        private Builder() {
            entityDto = new AbastecimentoDto();
        }

        public Builder id(Long id) {
            entityDto.setId(id);
            return this;
        }

        public Builder data(String data) {
            entityDto.setData(data);
            return this;
        }

        public Builder quilometro(Integer quilometro) {
            entityDto.setQuilometro(quilometro);
            return this;
        }

        public Builder tipoCombustivel(TipoCombustivel tipoCombustivel) {
            entityDto.setTipoCombustivel(tipoCombustivel);
            return this;
        }

        public Builder valorUnitario(BigDecimal valorUnitario) {
            entityDto.setValorUnitario(valorUnitario);
            return this;
        }

        public Builder quantidade(BigDecimal quantidade) {
            entityDto.setQuantidade(quantidade);
            return this;
        }

        public Builder valorTotal(BigDecimal valorTotal) {
            entityDto.setValorTotal(valorTotal);
            return this;
        }

        public Builder anotacao(String anotacao) {
            entityDto.setAnotacao(anotacao);
            return this;
        }

        public Builder links(Map<String, URI> links) {
            entityDto.setLinks(links);
            return this;
        }

        public AbastecimentoDto build() {
            return entityDto;
        }

    }

    public static class RepresentationBuilder
            extends AbstractRepresentationBuilder<Abastecimento, AbastecimentoDto, Abastecimento.Builder> {

        @Context
        private UriInfo uriInfo;
        private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.nnn'Z'");

        public static Builder builder() {
            return new Builder();
        }

        @Override
        public Abastecimento fromRepresentation(AbastecimentoDto dto, Abastecimento.Builder builder) {
            LocalDateTime data = LocalDateTime.parse(dto.getData(), dtf);

            return builder
                    .data(data.toLocalDate())
                    .quilometro(dto.getQuilometro())
                    .tipoCombustivel(dto.getTipoCombustivel())
                    .valorUnitario(dto.getValorUnitario())
                    .quantidade(dto.getQuantidade())
                    .valorTotal(dto.getValorTotal())
                    .anotacao(dto.getAnotacao())
                    .build();
        }

        public List<Abastecimento> fromRepresentation(List<AbastecimentoDto> dtos, Abastecimento.Builder builder) {
            List<Abastecimento> abastecimento = CollectionsBuilder.createDefaultArrayList();
            dtos.forEach(dto -> abastecimento.add(fromRepresentation(dto, builder)));
            return abastecimento;
        }

        @Override
        public AbastecimentoDto toRepresentation(Abastecimento abastecimento) {
            return builder()
                    .id(abastecimento.getId())
                    .data(abastecimento.getData().atStartOfDay().format(dtf))
                    .quilometro(abastecimento.getQuilometro())
                    .tipoCombustivel(abastecimento.getTipoCombustivel())
                    .valorUnitario(abastecimento.getValorUnitario())
                    .quantidade(abastecimento.getQuantidade())
                    .valorTotal(abastecimento.getValorTotal())
                    .anotacao(abastecimento.getAnotacao())
                    .links(getLinks(abastecimento))
                    .build();
        }

        public Map<String, URI> getLinks(Abastecimento abastecimento) {
            Map<String, URI> links = new HashMap();
            URI uri = UriBuilder.fromUri(Api.Veiculos.Abastecimentos.SELF).build(abastecimento.getVeiculo().getId(), abastecimento.getId());
            links.put("self", uri);
            return links;
        }
    }

}
