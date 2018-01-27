export default class FormController {

    constructor($stateParams, $state, AbastecimentoService, Notification) {
        this.record = {}
        this.veiculoContext = {}
        this.titulo = 'Adicionando abastecimento'
        this._servico = AbastecimentoService

        this._state = $state
        this._notify = Notification

        if ($stateParams.id) {
            this.titulo = 'Editando abastecimento'
            this.load($stateParams.id)
        }

        this.setContext()
    }

    calculaTotal() {
        if (this.record.valorUnitario && this.record.quantidade) {
            this.record.valorTotal = this.record.valorUnitario * this.record.quantidade
        } else {
            this.record.valorTotal = this.record.valorUnitario || 0
        }
    }

    setContext() {
        this._servico.getVeiculoContext().then(data => {
            this.veiculoContext = data
        })
    }

    load(id) {
        this._servico.findById(id)
            .then(data => {
                this.record = data
            })
    }

    salvar() {
        this._servico.save(this.record)
            .then(response => {
                this._notify.success(`Abastecimento ${response.status == 201 ? 'inserido' : 'atualizado'} com sucesso`)
                this._state.go('abastecimento.list')
            }).catch(erro => {
                console.log(erro)
                this._notify.error(erro)
            })
    }
}

FormController.$inject = ['$stateParams', '$state', 'AbastecimentoService', 'Notification']