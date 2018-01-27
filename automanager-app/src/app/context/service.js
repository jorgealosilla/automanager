import VeiculoService from "../veiculos/service";

export default class ContextService {

    constructor(VeiculoService) {
        this.veiculoContext = {}
        this._servico = VeiculoService

        this.loadVeiculoEmUso()
    }

    loadVeiculoEmUso() {
        this._servico.findVeiculoEmUso()
            .then(data => {
                this.veiculoContext = { "id": 1, "nome": "Ferrari", "marca": "Chevrolet", "modelo": null, "ano": 2013, "emUso": false, "tipoAbastecimento": "FLEX", "unidadeCombustivel": null, "unidadeDistancia": null, "placa": "MKH-7843" }
            })
    }

    getVeiculoContext() {
        return this.veiculoContext
    }
}

ContextService.$inject = ['VeiculoService']