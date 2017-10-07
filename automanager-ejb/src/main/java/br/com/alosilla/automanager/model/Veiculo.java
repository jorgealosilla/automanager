package br.com.alosilla.automanager.model;

import br.com.alosilla.automanager.util.AbstractBuilder;
import br.com.alosilla.automanager.util.AbstractEntityId;
import java.time.Year;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "VEICULOS")
public class Veiculo implements AbstractEntityId<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME")
    @NotNull
    private String nome;

    @Column(name = "MARCA")
    private String marca;

    @Column(name = "MODELO")
    private String modelo;

    @Column(name = "ANO")
    private Year ano;

    @Column(name = "TIPO_COMBUSTIVEL")
    @Enumerated(EnumType.STRING)
    private TipoCombustivel tipoCombustivel;

    @Column(name = "PLACA")
    private String placa;

    @Column(name = "APOLICE")
    private String apolice;

    @Override
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

    public Year getAno() {
        return ano;
    }

    private void setAno(Year ano) {
        this.ano = ano;
    }

    public TipoCombustivel getTipoCombustivel() {
        return tipoCombustivel;
    }

    private void setTipoCombustivel(TipoCombustivel tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
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

    public enum TipoCombustivel {
        GASOLINA("G", "Gasolina", "Gasolina"),
        ETANOL("E", "Etanol", "Etanol"),
        DIESEL("D", "Diesel", "Diesel"),
        GLP("P", "GPL", "Gás Liquefeito de Petróleo"),
        GNV("V", "GNV", "Gás Natural Veicular"),
        ELETRICO("L", "Elétrico", "Elétrico"),
        FLEX("F", "Flex", "Flex");

        private final String sigla;
        private final String nome;
        private final String descricao;

        TipoCombustivel(String sigla, String nome, String descricao) {
            this.sigla = sigla;
            this.nome = nome;
            this.descricao = descricao;
        }

        public String getSigla() {
            return sigla;
        }

        public String getNome() {
            return nome;
        }

        public String getDescricao() {
            return descricao;
        }
    }

    public static class Builder extends AbstractBuilder<Veiculo, Builder> {

        private Builder(Veiculo veiculo) {
            super(veiculo);
        }

        public static Builder create() {
            return new Builder(new Veiculo());
        }

        public static Builder from(Veiculo veiculo) {
            return new Builder(veiculo);
        }

        public Builder nome(final String nome) {
            entity.setNome(nome);
            return this;
        }

        public Builder marca(final String marca) {
            entity.setMarca(marca);
            return this;
        }

        public Builder modelo(final String modelo) {
            entity.setModelo(modelo);
            return this;
        }

        public Builder ano(final Year ano) {
            entity.setAno(ano);
            return this;
        }

        public Builder tipoCombustível(final TipoCombustivel tipoCombustivel) {
            entity.setTipoCombustivel(tipoCombustivel);
            return this;
        }

        public Builder placa(final String placa) {
            entity.setPlaca(placa);
            return this;
        }

        public Builder apolice(final String apolice) {
            entity.setApolice(apolice);
            return this;
        }
    }
}
