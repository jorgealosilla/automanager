import AbstractCrudService from "../abstract.crud.service";
import VeiculoService from "../veiculos/service";

export default class AbastecimentoService extends AbstractCrudService {

    constructor($http, VeiculoService) {
        super($http, 'http://localhost:8080/automanager-web/api/veiculos')
        this._veiculoServico = VeiculoService
        this._urlContext = this._url
    }

    getVeiculoContext() {
        return this._veiculoServico.getEmUso()
    }

    findAll() {
        return this._veiculoServico.getEmUso().then(data => {
            return this._http.get(`${this._url}/${data.id}/abastecimentos`)
                .then(response => response.data)
        })
    }

    findById(id) {
        return this._veiculoServico.getEmUso().then(data => {
            return this._http.get(`${this._url}/${data.id}/abastecimentos/${id}`)
                .then(response => response.data)
        })
    }

    save(record) {
        return this._veiculoServico.getEmUso().then(data => {
            if (record.id) {
                return this._http.put(`${this._url}/${data.id}/abastecimentos/${record.id}`, record)
                    .then(response => response.data)

            } else {
                return this._http.post(`${this._url}/${data.id}/abastecimentos/`, record)
                    .then(response => response.data)

            }
        })
    }

    remove(id) {
        return this._veiculoServico.getEmUso().then(data => {
            return this._http.delete(`${this._url}/${data.id}/abastecimentos/${id}`)
                .then(response => response.data)
        })
    }
}

AbastecimentoService.$inject = ['$http', 'VeiculoService']