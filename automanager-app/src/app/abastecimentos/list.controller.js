import swal from "sweetalert2";

export default class ListController {

    constructor(AbastecimentoService, Notification) {
        this.records = []
        this.veiculoContext = {}
        this._service = AbastecimentoService
        this._notify = Notification
        this.setContext()
        this.load()
    }

    setContext() {
        this._service.getVeiculoContext().then(data => {
            this.veiculoContext = data
        })
    }

    load() {
        this._service.findAll()
            .then(data => {
                this.records = data
            }).catch(erro => {
                console.log(erro)
                this._notify.error('Erro ao carregar a lista de abastecimentos!')
            })
    }

    excluir(id) {
        swal({
            title: 'Você tem certeza?',
            text: "Deseja realmente apagar o registro?",
            type: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Sim, é claro!',
            cancelButtonText: 'Não!',
        }).then((result) => {
            if (result.value) {
                return this._service.remove(id)
            }
            return Promise.reject({})
        }).then(data => {
            this._notify.success('Abastecimento excluído com sucesso!')
            this.load()
        }).catch(erro => {
            this._notify.error(erro.message)
        })
    }
}

ListController.$inject = ['AbastecimentoService', 'Notification']