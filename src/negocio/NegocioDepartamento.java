package negocio;

import java.util.List;

import dados.Departamento;
import dados.Gerente;
import excecoes.DepartamentoJaExisteException;
import excecoes.DepartamentoNaoExisteException;
import repositorio.DepartamentoRepositorio;

public class NegocioDepartamento {
    private DepartamentoRepositorio repo;

    public NegocioDepartamento(DepartamentoRepositorio repo) {
        this.repo = repo;
    }

    public void adicionar(int id, String nome, Gerente gerente) throws DepartamentoJaExisteException {
        Departamento g = repo.buscar(id);

        if (g != null) {
            throw new DepartamentoJaExisteException(g);
        }

        Departamento departamento = new Departamento(id, nome, gerente);
        repo.salvar(departamento);
    }

    public List<Departamento> listar() {
        return repo.listar();
    }

    public Departamento buscar(int id) throws DepartamentoNaoExisteException {
        Departamento departamento = repo.buscar(id);

        if (departamento == null) {
            throw new DepartamentoNaoExisteException(id);
        }

        return departamento;
    }

    public void remover(int id) throws DepartamentoNaoExisteException {
        Departamento departamento = repo.buscar(id);

        if (departamento == null) {
            throw new DepartamentoNaoExisteException(id);
        }

        repo.remover(departamento);
    }

    public void editar(int id, String nome, Gerente gerente) throws DepartamentoNaoExisteException {
        Departamento departamento = repo.buscar(id);

        if (departamento == null) {
            throw new DepartamentoNaoExisteException(id);
        }

        if (nome != null) {
            departamento.setNome(nome);
        }

        if (gerente != null) {
            departamento.setGerente(gerente);
        }

        repo.salvar(departamento);
    }
}
