import * as angular from 'angular';

import { default as uiRouter } from '@uirouter/angularjs';
import { default as uiNotification } from 'angular-ui-notification';

import { mainConfig } from './main/config';

import { veiculoConfig } from './veiculos/config';
import { abastecimentoConfig } from './abastecimentos/config';
import { despesaConfig } from './despesas/config';
//import { contextConfig } from './context/config';

export const appModule = 'app';

const modulo = angular.module(appModule, [uiRouter, uiNotification])

modulo.config(mainConfig(modulo))
    .config(veiculoConfig(modulo))
    .config(abastecimentoConfig(modulo))
    .config(despesaConfig(modulo))
    //.config(contextConfig(modulo))