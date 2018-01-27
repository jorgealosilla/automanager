package br.com.alosilla.automanager.model;

import br.com.alosilla.automanager.util.AbstractBuilder;
import br.com.alosilla.automanager.util.AbstractEntityId;
import java.time.Year;
import java.util.Arrays;
import java.util.List;
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
    @NotNull(message = "Informe o nome do seu veículo")
    private String nome;

    @Column(name = "MARCA")
    private String marca;

    @Column(name = "MODELO")
    private String modelo;

    @Column(name = "ANO")
    private Year ano;

    @Column(name = "TIPO_ABASTECIMENTO")
    @Enumerated(EnumType.STRING)
    private TipoAbastecimento tipoAbastecimento;

    @Column(name = "UNIDADE_COMBUSTIVEL")
    @Enumerated(EnumType.STRING)
    private UnidadeCombustivel unidadeCombustivel;

    @Column(name = "UNIDADE_DISTANCIA")
    @Enumerated(EnumType.STRING)
    private UnidadeDistancia unidadeDistancia;

    @Column(name = "PLACA")
    private String placa;

    @Column(name = "APOLICE")
    private String apolice;
    
    @Column(name="EM_USO")
    private boolean emUso;

    @Override
    public Long getId() {
        return id;
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

    public boolean isEmUso() {
        return emUso;
    }

    public void setEmUso(boolean emUso) {
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

    public enum Tipo {
        CARRO("Carro"),
        MOTO("Moto"),
        CAMINHAO("Caminhão");

        final String descricao;

        Tipo(String descricao) {
            this.descricao = descricao;
        }
    }

    public enum UnidadeDistancia {
        QUILOMETROS("Quilômetros");

        final String descricao;

        private UnidadeDistancia(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }
    }

    public enum UnidadeCombustivel {
        LITROS("Litros"),
        METROS_CUBICOS("Metros³");

        private final String descricao;

        private UnidadeCombustivel(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }

    }

    public enum UnidadeConsumo {
        KM_L("km/litro"),
        L_100KM("litros/100km"),
        KM_M3("km/metro³"),
        M3_100KM("metros³/100km");

        private final String descricao;

        private UnidadeConsumo(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }

    }

    public enum TipoAbastecimento {
        GASOLINA("G", "Gasolina", "Gasolina") {
            @Override
            public List<Abastecimento.TipoCombustivel> getTiposCombustiveis() {
                return Arrays.asList(Abastecimento.TipoCombustivel.GASOLINA);
            }
        },
        ETANOL("E", "Etanol", "Etanol") {
            @Override
            public List<Abastecimento.TipoCombustivel> getTiposCombustiveis() {
                return Arrays.asList(Abastecimento.TipoCombustivel.ETANOL);
            }
        },
        DIESEL("D", "Diesel", "Diesel") {
            @Override
            public List<Abastecimento.TipoCombustivel> getTiposCombustiveis() {
                return Arrays.asList(Abastecimento.TipoCombustivel.DIESEL);
            }
        },
        GNV("V", "GNV", "Gás Natural Veicular") {
            @Override
            public List<Abastecimento.TipoCombustivel> getTiposCombustiveis() {
                return Arrays.asList(Abastecimento.TipoCombustivel.GNV);
            }
        },
        //        ELETRICO("L", "Elétrico", "Elétrico") {
        //            @Override
        //            public List<Abastecimento.TipoCombustivel> getTiposCombustiveis() {
        //                return Arrays.asList(Abastecimento.TipoCombustivel.ELETRICIDADE);
        //            }
        //        },
        FLEX("F", "Flex", "Flex") {
            @Override
            public List<Abastecimento.TipoCombustivel> getTiposCombustiveis() {
                return Arrays.asList(Abastecimento.TipoCombustivel.GASOLINA, Abastecimento.TipoCombustivel.ETANOL);
            }
        };

        private final String sigla;
        private final String nome;
        private final String descricao;

        TipoAbastecimento(String sigla, String nome, String descricao) {
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

        public abstract List<Abastecimento.TipoCombustivel> getTiposCombustiveis();
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
        
        public Builder emUso(final boolean emUso){
            entity.setEmUso(emUso);
            return this;
        }

        public Builder tipoAbastecimento(final TipoAbastecimento tipoCombustivel) {
            entity.setTipoAbastecimento(tipoCombustivel);
            return this;
        }

        public Builder unidadeCombustivel(final UnidadeCombustivel unidadeCombustivel) {
            entity.setUnidadeCombustivel(unidadeCombustivel);
            return this;
        }

        public Builder unidadeDistancia(final UnidadeDistancia unidadeDistancia) {
            entity.setUnidadeDistancia(unidadeDistancia);
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
