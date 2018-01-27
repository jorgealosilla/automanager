import AbstractCrudService from "../abstract.crud.service";
import VeiculoService from "../veiculos/service";
import AbastecimentoService from "../abastecimentos/service";

export default class MainService extends AbstractCrudService {

    constructor($http, VeiculoService, AbastecimentoService) {
        super($http, 'http://localhost:8080/automanager-web/api/veiculos')
        this._veiculoServico = VeiculoService
        this._abastecimentoService = AbastecimentoService
        this._urlContext = this._url
    }

    getVeiculoContext() {
        return this._veiculoServico.getEmUso()
    }

    getAbastecimentos() {
        return this._abastecimentoService.findAll()
    }
}

MainService.$inject = ['$http', 'VeiculoService', 'AbastecimentoService']