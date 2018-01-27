package br.com.alosilla.automanager.model;

import br.com.alosilla.automanager.util.AbstractBuilder;
import br.com.alosilla.automanager.util.AbstractEntityId;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ABASTECIMENTOS")
public class Abastecimento implements AbstractEntityId<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ID_VEICULO")
    private Veiculo veiculo;

    @NotNull
    @Column(name = "DT_ABASTECIMENTO")
    private LocalDate data;

    @NotNull
    @Column(name = "QUILOMETRO")
    private Integer quilometro;

    @Column(name = "TIPO_COMBUSTIVEL")
    private TipoCombustivel tipoCombustivel;

    @NotNull
    @Column(name = "VL_UNITARIO")
    private BigDecimal valorUnitario;

    @NotNull
    @Column(name = "QUANTIDADE")
    private BigDecimal quantidade;

    @Column(name = "VL_TOTAL")
    private BigDecimal valorTotal;

    @Column(name = "ANOTACAO")
    private String anotacao;

    public Abastecimento() {
    }

    public Abastecimento(final Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    @Override
    public Long getId() {
        return id;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    private void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public LocalDate getData() {
        return data;
    }

    private void setData(LocalDate data) {
        this.data = data;
    }

    public Integer getQuilometro() {
        return quilometro;
    }

    private void setQuilometro(Integer quilometro) {
        this.quilometro = quilometro;
    }

    public TipoCombustivel getTipoCombustivel() {
        return tipoCombustivel;
    }

    private void setTipoCombustivel(TipoCombustivel tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    private void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    private void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    private void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getAnotacao() {
        return anotacao;
    }

    private void setAnotacao(String anotacao) {
        this.anotacao = anotacao;
    }

    public enum TipoCombustivel {
        GASOLINA("G", "Gasolina"),
        ETANOL("E", "Etanol"),
        DIESEL("D", "Diesel"),
        GNV("V", "GNV");
//        ELETRICIDADE("L", "Elétricidade");

        private final String sigla;
        private final String descricao;

        TipoCombustivel(String sigla, String descricao) {
            this.sigla = sigla;
            this.descricao = descricao;
        }

        public String getSigla() {
            return sigla;
        }

        public String getDescricao() {
            return descricao;
        }
    }

    public static class Builder extends AbstractBuilder<Abastecimento, Builder> {

        private Builder(Abastecimento abastecimento) {
            super(abastecimento);
        }

        public static Builder create(final Veiculo veiculo) {
            return new Builder(new Abastecimento(veiculo));
        }

        public static Builder from(Abastecimento abastecimento) {
            return new Builder(abastecimento);
        }

        public Builder data(final LocalDate data) {
            entity.setData(data);
            return this;
        }

        public Builder quilometro(final Integer quilometro) {
            entity.setQuilometro(quilometro);
            return this;
        }

        public Builder tipoCombustivel(final TipoCombustivel tipoCombustivel) {
            entity.setTipoCombustivel(tipoCombustivel);
            return this;
        }

        public Builder valorUnitario(final BigDecimal valorUnitario) {
            entity.setValorUnitario(valorUnitario);
            return this;
        }

        public Builder quantidade(final BigDecimal quantidade) {
            entity.setQuantidade(quantidade);
            return this;
        }

        public Builder valorTotal(final BigDecimal valorTotal) {
            entity.setValorTotal(valorTotal);
            return this;
        }

        public Builder anotacao(final String anotacao) {
            entity.setAnotacao(anotacao);
            return this;
        }
    }
}
