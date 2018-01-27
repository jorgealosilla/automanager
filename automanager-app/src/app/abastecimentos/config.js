import ListController from './list.controller'
import FormController from './form.controller'

import AbastecimentoService from './service'

export const abastecimentoConfig = (modulo) => {
    modulo.service('AbastecimentoService', AbastecimentoService)

    return ['$stateProvider', ($stateProvider) => {
        $stateProvider
            .state('abastecimento', {
                template: require('@views/default.html'),
                url: '/abastecimentos',
                onEnter: ['$state', function($state) {
                    $state.go('abastecimento.list')
                }]
            })
            .state('abastecimento.list', {
                template: require('@views/abastecimentos/list.html'),
                url: '/list',
                controller: ListController,
                controllerAs: 'vm'
            })
            .state('abastecimento.new', {
                template: require('@views/abastecimentos/form.html'),
                url: '/new',
                controller: FormController,
                controllerAs: 'vm'
            })
            .state('abastecimento.edit', {
                template: require('@views/abastecimentos/form.html'),
                url: '/{id}',
                controller: FormController,
                controllerAs: 'vm'
            })
    }]
}