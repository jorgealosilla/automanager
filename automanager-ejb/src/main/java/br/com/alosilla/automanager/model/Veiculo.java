package br.com.alosilla.automanager.model;

import br.com.alosilla.automanager.util.AbstractBuilder;
import br.com.alosilla.automanager.util.AbstractEntityId;
import java.time.Year;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
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
