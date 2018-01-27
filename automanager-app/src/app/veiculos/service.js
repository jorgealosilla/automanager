import AbstractCrudService from "../abstract.crud.service";

export default class VeiculoService extends AbstractCrudService {

    constructor($http) {
        super($http, 'http://localhost:8080/automanager-web/api/veiculos')
    }

    setEmUso(id) {
        return this._http.put(`${this._url}/${id}/uso`)
            .then(response => response.data)
    }

    getEmUso() {
        return this._http.get(`${this._url}/em-uso`)
            .then(response => response.data)
    }
}

VeiculoService.$inject = ['$http']