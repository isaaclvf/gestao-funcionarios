package negocio;

import java.util.List;

import dados.Cargo;
import dados.Departamento;
import dados.Funcionario;
import excecoes.FuncionarioJaExisteException;
import excecoes.FuncionarioNaoExisteException;
import repositorio.FuncionarioRepositorio;

public class NegocioFuncionario {
    private FuncionarioRepositorio repo;

    public NegocioFuncionario(FuncionarioRepositorio repo) {
        this.repo = repo;
    }

    public void adicionar(int id, String nome, Cargo cargo, double salario, Departamento departamento)
            throws FuncionarioJaExisteException {
        Funcionario f = repo.buscar(id);

        if (f != null) {
            throw new FuncionarioJaExisteException(f);
        }

        Funcionario funcionario = new Funcionario(id, nome, cargo, salario, departamento);
        repo.salvar(funcionario);
    }

    public List<Funcionario> listar() {
        return repo.listar();
    }

    public Funcionario buscar(int id) throws FuncionarioNaoExisteException {
        Funcionario funcionario = repo.buscar(id);

        if (funcionario == null) {
            throw new FuncionarioNaoExisteException(id);
        }

        return funcionario;
    }

    public void remover(int id) throws FuncionarioNaoExisteException {
        Funcionario funcionario = repo.buscar(id);

        if (funcionario == null) {
            throw new FuncionarioNaoExisteException(id);
        }

        repo.remover(funcionario);
    }

    public void editar(int id, String nome, Cargo cargo, double salario, Departamento departamento)
            throws FuncionarioNaoExisteException {
        Funcionario funcionario = repo.buscar(id);

        if (funcionario == null) {
            throw new FuncionarioNaoExisteException(id);
        }

        if (nome != null) {
            funcionario.setNome(nome);
        }

        if (cargo != null) {
            funcionario.setCargo(cargo);
        }

        // Caso tenha um valor mínimo para o salário, colocar aqui
        if (salario > 0) {
            funcionario.setSalario(salario);
        }

        if (departamento != null) {
            funcionario.setDepartamento(departamento);
        }

        repo.salvar(funcionario);
    }
}
