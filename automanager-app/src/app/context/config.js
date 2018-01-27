//import ListController from './list.controller'
//import FormController from './form.controller'

import AbastecimentoService from './service'

export const contextConfig = (modulo) => {
    modulo.service('ContextService', ContextService)
}