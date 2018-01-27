import swal from "sweetalert2";

export default class ListController {

    constructor(VeiculoService, Notification) {
        this.records = []
        this._service = VeiculoService
        this._notify = Notification
        this.load()
    }

    load() {
        this._service.findAll()
            .then(data => {
                this.records = data
            }).catch(erro => {
                console.log(erro)
                this._notify.error('Erro ao carregar a lista de veiculos!')
            })
    }

    usar(id) {
        this._service.setEmUso(id)
            .then(data => {
                this.load()
                this._notify.success(`${data.marca} ${data.nome} agora está em uso`)
            }).catch(erro => {
                console.log(erro)
                this._notify.error('Erro ao definir veiculo em uso!')
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
            this._notify.success('Veículo excluído com sucesso!')
            this.load()
        }).catch(erro => {
            this._notify.error(erro.message)
        })
    }
}

ListController.$inject = ['VeiculoService', 'Notification']