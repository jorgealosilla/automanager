export default class MainController {

    constructor($stateParams, $state, MainService, Notification) {

        this._servico = MainService
        this._notify = Notification

        this.veiculoContext = {}
        this.abastecimentos = []
        this.ultimoAbastecimento = {}

        this.setContext()
    }

    setContext() {
        this._servico.getVeiculoContext().then(data => {
            this.veiculoContext = data
            this.load()
        })
    }

    load() {
        this._servico.getAbastecimentos().then(records => {
            this.abastecimentos = records
            this.ultimoAbastecimento = this.abastecimentos.slice(-1)[0];
            console.log(this.ultimoAbastecimento)
        })
    }
}

MainController.$inject = ['$stateParams', '$state', 'MainService', 'Notification']