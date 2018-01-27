export default class FormController {

    constructor($stateParams, $state, VeiculoService, Notification) {
        this._servico = VeiculoService

        this.record = {}
        this.titulo = 'Adicionando veículo'

        this._state = $state
        this._notify = Notification

        if ($stateParams.id) {
            this.titulo = 'Editando veículo'
            this.load($stateParams.id)
        }
    }

    load(id) {
        this._servico.findById(id)
            .then(data => {
                this.record = data
            })
    }

    usar(id) {
        this._servico.setEmUso(id)
            .then(data => {
                this.record = data
            })
    }

    salvar() {
        this._servico.save(this.record)
            .then(response => {
                this._notify.success(`${this.record.marca} ${this.record.nome} ${response.status == 201 ? 'inserido' : 'atualizado'} com sucesso`)
                this._state.go('veiculo.list')
            }).catch(erro => {
                console.log(erro)
                this._notify.error(erro)
            })
    }
}

FormController.$inject = ['$stateParams', '$state', 'VeiculoService', 'Notification']