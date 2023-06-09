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
import repositorio.CargoRepositorioArrayList;
import repositorio.DepartamentoRepositorioArrayList;
import repositorio.FuncionarioRepositorioArrayList;

public class FachadaEmpresa implements Empresa {
    private NegocioFuncionario funcionarios;
    private NegocioCargo cargos;
    private NegocioDepartamento departamentos;

    public FachadaEmpresa() {
        this.funcionarios = new NegocioFuncionario(new FuncionarioRepositorioArrayList());
        this.cargos = new NegocioCargo(new CargoRepositorioArrayList());
        this.departamentos = new NegocioDepartamento(new DepartamentoRepositorioArrayList());
    }

    @Override
    public void adicionarFuncionario(int id, String nome, Cargo cargo, double salario, Departamento departamento)
            throws FuncionarioJaExisteException, IllegalArgumentException {
        funcionarios.adicionar(id, nome, cargo, salario, departamento);
    }

    @Override
    public void adicionarCargo(int id, String nome, String descricao, double salarioBase)
            throws CargoJaExisteException {
        cargos.adicionar(id, nome, descricao, salarioBase);
    }

    @Override
    public void adicionarDepartamento(int id, String nome, Gerente gerente) throws DepartamentoJaExisteException {
        departamentos.adicionar(id, nome, gerente);
    }

    @Override
    public List<Funcionario> listarFuncionarios() {
        return funcionarios.listar();
    }

    @Override
    public List<Cargo> listarCargos() {
        return cargos.listar();
    }

    @Override
    public List<Departamento> listarDepartamentos() {
        return departamentos.listar();
    }

    @Override
    public Funcionario buscarFuncionario(int id) throws FuncionarioNaoExisteException {
        return funcionarios.buscar(id);
    }

    @Override
    public Cargo buscarCargo(int id) throws CargoNaoExisteException {
        return cargos.buscar(id);
    }

    @Override
    public Departamento buscarDepartamento(int id) throws DepartamentoNaoExisteException {
        return departamentos.buscar(id);
    }

    @Override
    public void removerFuncionario(int id) throws FuncionarioNaoExisteException {
        funcionarios.remover(id);
    }

    @Override
    public void removerCargo(int id) throws CargoNaoExisteException {
        cargos.remover(id);
    }

    @Override
    public void removerDepartamento(int id) throws DepartamentoNaoExisteException {
        departamentos.remover(id);
    }

    @Override
    public void editarFuncionario(int id, String nome, Cargo cargo, double salario, Departamento departamento)
            throws FuncionarioNaoExisteException {
        funcionarios.editar(id, nome, cargo, salario, departamento);
    }

    @Override
    public void editarCargo(int id, String nome, String descricao, double salarioBase) throws CargoNaoExisteException {
        cargos.editar(id, nome, descricao, salarioBase);
    }

    @Override
    public void editarDepartamento(int id, String nome, Gerente gerente) throws DepartamentoNaoExisteException {
        departamentos.editar(id, nome, gerente);
    }
}
