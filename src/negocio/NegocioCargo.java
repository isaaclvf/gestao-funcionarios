package negocio;

import java.util.List;

import dados.Cargo;
import excecoes.CargoJaExisteException;
import excecoes.CargoNaoExisteException;
import repositorio.CargoRepositorio;

public class NegocioCargo {
    private CargoRepositorio repo;

    public NegocioCargo(CargoRepositorio repo) {
        this.repo = repo;
    }

    public void adicionar(int id, String nome, String descricao, double salarioBase) throws CargoJaExisteException {
        Cargo c = repo.buscar(id);

        if (c != null) {
            throw new CargoJaExisteException(c);
        }

        Cargo cargo = new Cargo(id, nome, descricao, salarioBase);
        repo.salvar(cargo);
    }

    public List<Cargo> listar() {
        return repo.listar();
    }

    public Cargo buscar(int id) throws CargoNaoExisteException {
        Cargo cargo = repo.buscar(id);

        if (cargo == null) {
            throw new CargoNaoExisteException(id);
        }

        return cargo;
    }

    public void remover(int id) throws CargoNaoExisteException {
        Cargo cargo = repo.buscar(id);

        if (cargo == null) {
            throw new CargoNaoExisteException(id);
        }

        repo.remover(cargo);
    }

    public void editar(int id, String nome, String descricao, double salarioBase) throws CargoNaoExisteException {
        Cargo cargo = repo.buscar(id);

        if (cargo == null) {
            throw new CargoNaoExisteException(id);
        }

        if (nome != null) {
            cargo.setNome(nome);
        }

        if (descricao != null) {
            cargo.setDescricao(descricao);
        }

        if (salarioBase > 0) {
            cargo.setSalarioBase(salarioBase);
        }

        repo.salvar(cargo);
    }
}
