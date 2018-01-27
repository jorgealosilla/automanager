import MainController from './controller'

import MainService from './service'

export const mainConfig = (modulo) => {
    modulo.service('MainService', MainService)

    return ['$stateProvider', '$urlRouterProvider', 'NotificationProvider',
        ($stateProvider, $urlRouterProvider, NotificationProvider) => {
            $urlRouterProvider.otherwise('/')
            $stateProvider
                .state('home', {
                    template: require('@views/main/component.html'),
                    controller: MainController,
                    controllerAs: 'vm',
                    url: '/'
                })
            NotificationProvider.setOptions({
                delay: 10000,
                startTop: 20,
                startRight: 10,
                verticalSpacing: 20,
                horizontalSpacing: 20,
                positionX: 'right',
                positionY: 'top'
            })
        }
    ]
}