var veiculoModule = angular.module('veiculoModule', []);

veiculoModule.controller('VeiculoController', ['VeiculoService', '$location', '$route', '$rootScope',
    function(VeiculoService, $location, $route, $rootScope) {

        $rootScope.paginaAtiva = 'Veiculos';

        var vm = this;
        vm.veiculo = {};
        vm.salvar = _salvar;
        vm.excluir = _excluir;
        vm.loadAll = _loadAll;
        vm.loadRow = _loadRow;
        vm.refresh = _refresh;
        vm.openCad = _openCad;
        vm.showCad = false;
        vm.veiculos = null;

        function _salvar() {
            VeiculoService.save(vm.veiculo)
                .success(function(data) {
                    $rootScope.setVeiculoEmUso(data);
                    $route.reload();
                    _closeCad();
                });
        }

        function _excluir(veiculo) {
            VeiculoService.delete(veiculo)
                .success(function() {
                    $rootScope.showNotification(veiculo.nome + " excluído com sucesso", 'success');
                    $route.reload();
                });
        }

        function _loadRow(veiculo) {
            if (veiculo.id != null) {

                VeiculoService.get(veiculo.id).success(function(data) {
                    vm.veiculo = data;
                    vm.veiculo.isUpdate = true;
                });
                _openCad();

                /*
                $http.get($rootScope.server("/api/lista/" + $routeParams.id)).success(function(data) {
                    $rootScope.row = data;
                    $rootScope.row.isUpdate = true;
                });
                */
            } else {

                vm.veiculo = {};
                vm.veiculo.idLista = null;
                vm.veiculo.isUpdate = false;
                /*
                $rootScope.row = {};
                $rootScope.row.idLista = null;
                $rootScope.row.isUpdate = false;
                */
            }
        };

        function _loadAll() {
            VeiculoService.findAll().success(function(data) {
                vm.veiculos = data;
            });
        }

        function _refresh() {
            $route.reload();
        }

        function _openCad() {
            vm.showCad = true;
        }

        function _closeCad() {
            vm.showCad = false;
        }
    }
]);

/*(function() {
    'use strict';

    angular.module('app')
        .controller('VeiculoController', VeiculoController);

    VeiculoController.$inject = ['VeiculoService', '$location', '$route'];

    function VeiculoController(VeiculoService, $location, $route) {
        var vm = this;
        vm.veiculo = {};
        vm.salvar = _salvar;
        vm.excluir = _excluir;
        vm.loadAll = _loadAll;
        vm.refresh = _refresh;
        vm.openCad = _openCad;
        vm.showCad = false;
        vm.veiculos = null;

        function _salvar() {
            VeiculoService.save(vm.veiculo)
                .success(function() {
                    $route.reload();
                });
            _closeCad();
        }

        function _excluir(veiculo) {
            VeiculoService.delete(veiculo)
                .success(function() {
                    showNotification(veiculo.nome + " excluído com sucesso", 'success');
                    $route.reload();
                });
        }

        function _loadAll() {
            VeiculoService.findAll().success(function(data) {
                vm.veiculos = data;
            });
            _closeCad();
        }

        function _refresh() {
            $route.reload();
        }

        function _openCad() {
            vm.showCad = true;
        }

        function _closeCad() {
            vm.showCad = false;
        }

        function showNotification(msg, type) {
            $.notify({
                icon: "notifications",
                message: msg

            }, {
                type: type,
                timer: 3000,
                placement: {
                    from: 'top',
                    align: 'right'
                }
            });
        }
    }
})();*/