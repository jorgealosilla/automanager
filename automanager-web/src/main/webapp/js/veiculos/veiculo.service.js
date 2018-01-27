(function() {
    'use strict';

    angular
        .module('app')
        .factory('VeiculoService', VeiculoService);

    VeiculoService.$inject = ['$http', '$location'];

    function VeiculoService($http, $location) {
        var service = {
            get: _get,
            getEmUso: _getEmUso,
            setEmUso: _setEmUso,
            save: _save,
            delete: _delete,
            findAll: _findAll
        };

        var resource = 'veiculos';
        var URL = window.location.pathname + 'api/' + resource;

        return service;

        function _get(id) {
            return $http.get(URL + '/' + id);
        }

        function _getEmUso() {
            return $http.get(URL + '/' + id + '/uso');
        }

        function _setEmUso(obj) {
            return $http.put(URL + '/' + obj.id + '/uso');
        }

        function _save(obj) {
            delete obj['isUpdate'];
            if (obj.id) {
                return $http.put(URL + '/' + obj.id, obj);
            } else {
                return $http.post(URL, obj);
            }
        }

        function _delete(obj) {
            if (confirm("Confirma a exclusão: " + obj.nome + "?")) {
                return $http.delete(URL + '/' + obj.id);
            };
        }

        function _findAll() {
            return $http.get(URL);
        }
    }
})();