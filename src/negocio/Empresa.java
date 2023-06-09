package negocio;

import java.util.List;

import dados.Cargo;
import dados.Departamento;
import dados.Funcionario;
import dados.Gerente;
import excecoes.CargoJaExisteException;
import excecoes.CargoNaoExisteException;
import excecoes.DepartamentoJaExisteException;
import excecoes.DepartamentoNaoExisteException;
import excecoes.FuncionarioJaExisteException;
import excecoes.FuncionarioNaoExisteException;

public interface Empresa {
    void adicionarFuncionario(int id, String nome, Cargo cargo, double salario, Departamento departamento)
            throws FuncionarioJaExisteException, IllegalArgumentException;

    void adicionarCargo(int id, String nome, String descricao, double salarioBase)
            throws CargoJaExisteException;

    void adicionarDepartamento(int id, String nome, Gerente gerente) throws DepartamentoJaExisteException;

    List<Funcionario> listarFuncionarios();

    List<Cargo> listarCargos();

    List<Departamento> listarDepartamentos();

    Funcionario buscarFuncionario(int id) throws FuncionarioNaoExisteException;

    Cargo buscarCargo(int id) throws CargoNaoExisteException;

    Departamento buscarDepartamento(int id) throws DepartamentoNaoExisteException;

    void removerFuncionario(int id) throws FuncionarioNaoExisteException;

    void removerCargo(int id) throws CargoNaoExisteException;

    void removerDepartamento(int id) throws DepartamentoNaoExisteException;

    void editarFuncionario(int id, String nome, Cargo cargo, double salario, Departamento departamento)
            throws FuncionarioNaoExisteException;

    void editarCargo(int id, String nome, String descricao, double salarioBase) throws CargoNaoExisteException;

    void editarDepartamento(int id, String nome, Gerente gerente) throws DepartamentoNaoExisteException;
}