(function() {
    'use strict';

    angular.module('app', ['ngRoute', 'VeiculoService'])
        .config(AppConfig)
        .run(AppRun);

    AppConfig.$inject = ['$routeProvider'];
    AppRun.$inject = ['$rootScope' /*, 'VeiculoService'*/ ];

    function AppConfig($routeProvider) {

        $routeProvider
            .when('/', {
                templateUrl: 'dashboard.html',
                controller: 'DasboardController',
                controllerAs: 'vm'
            })
            .when('/veiculos', {
                templateUrl: 'pages/veiculos/list-veiculos.html',
                controller: 'VeiculoController',
                controllerAs: 'vm'
            })
            .when('/veiculos/new', {
                templateUrl: 'pages/veiculos/cad-veiculos.html',
                controller: 'VeiculoController',
                controllerAs: 'vm'
            })
            .otherwise('/');
    }

    function AppRun($rootScope /*, VeiculoService*/ ) {

        $rootScope.tituloAplicacao = 'Auto Manager';
        $rootScope.paginaAtiva = 'Visao Geral';
        $rootScope.veiculoContext = {};
        $rootScope.veiculos = [];

        /*
        $rootScope.setVeiculoEmUso = function(veiculo) {
            VeiculoService.setEmUso(veiculo)
                .success(function(data) {
                    $rootScope.veiculoContext = data;
                    $route.reload();
                });
        }

        $rootScope.loadParams = function() {
            VeiculoService.getEmUso()
                .success(function(data) {
                    $rootScope.veiculoContext = data;
                });

            VeiculoService.findAll()
                .success(function(data) {
                    $rootScope.veiculos = data;
                })
        }*/

        $rootScope.showNotification = function(msg, type) {
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
})();