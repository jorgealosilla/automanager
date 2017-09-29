(function() {
    'use strict';

    angular.module('app', [
        'ngRoute'
        /*,
                'ui.bootstrap',
                'mgo-angular-wizard'*/
    ]).config(AppConfig);

    AppConfig.$inject = ['$routeProvider'];

    function AppConfig($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'land-page.html',
                controller: 'InteressadoController',
                controllerAs: 'vm'
            })
            .otherwise('/');
    }
})();