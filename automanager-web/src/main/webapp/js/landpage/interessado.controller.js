(function() {
    'use strict';

    angular.module('app')
        .controller('InteressadoController', InteressadoController);

    InteressadoController.$inject = ['InteressadoService', '$location', '$routeParams', '$scope'];

    function InteressadoController(InteressadoService, $location, $routeParams, $scope) {
        var vm = this;
        vm.interessado = {};
        vm.salvar = salvar;

        function salvar() {
            InteressadoService.save(vm.interessado)
                .success(function() {
                    $location.path('/interessados');
                });
        }
    }
})();