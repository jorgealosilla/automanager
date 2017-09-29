(function() {
    'use strict';

    angular
        .module('app')
        .factory('InteressadoService', InteressadoService);

    InteressadoService.$inject = ['$http'];

    function InteressadoService($http) {
        var service = {
            save: _save
        };

        var resource = 'interessados';
        var URL = window.location.pathname + 'api/' + resource;

        return service;

        function _save(record) {
            if (record._id) {
                return $http.put(URL + '/' + record._id, record);
            } else {
                return $http.post(URL, record);
            }
        }
    }
})();