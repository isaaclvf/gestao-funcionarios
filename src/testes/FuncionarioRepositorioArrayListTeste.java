package testes;

import java.util.List;

import dados.Cargo;
import dados.Departamento;
import dados.Funcionario;
import dados.Gerente;
import repositorio.FuncionarioRepositorio;
import repositorio.FuncionarioRepositorioArrayList;

public class FuncionarioRepositorioArrayListTeste {
    private FuncionarioRepositorio repositorio;
    private Funcionario funcionario1;
    private Funcionario funcionario2;

    public void setup() {
        repositorio = new FuncionarioRepositorioArrayList();

        Departamento departamento = new Departamento(1, "TI", null);
        Cargo cargo = new Cargo(1, "Desenvolvedor", "Responsável por construir e aprimorar soluções tecnológicas",
                5000.0);
        Gerente gerente = new Gerente(1, "Ana", cargo, 8000.0, departamento);

        departamento.setGerente(gerente);

        funcionario1 = new Funcionario(1, "João", cargo, 5000.0, departamento);
        funcionario2 = new Funcionario(2, "Maria", cargo, 5000.0, departamento);
    }

    public void testeSalvar() {
        setup();
        repositorio.salvar(funcionario1);
        repositorio.salvar(funcionario2);
        List<Funcionario> funcionarios = repositorio.listar();
        if (funcionarios.size() != 2) {
            throw new AssertionError("Falha ao testar o método salvar. Tamanho da lista incorreto.");
        }
    }

    public void testeListar() {
        setup();
        repositorio.salvar(funcionario1);
        repositorio.salvar(funcionario2);
        List<Funcionario> funcionarios = repositorio.listar();
        if (funcionarios.size() != 2) {
            throw new AssertionError("Falha ao testar o método listar. Tamanho da lista incorreto.");
        }
    }

    public void testeBuscar() {
        setup();
        repositorio.salvar(funcionario1);
        repositorio.salvar(funcionario2);
        Funcionario funcionarioEncontrado = repositorio.buscar(1);
        if (funcionarioEncontrado == null || funcionarioEncontrado != funcionario1) {
            throw new AssertionError("Falha ao testar o método buscar. Funcionário não encontrado corretamente.");
        }
    }

    public void testeRemover() {
        setup();
        repositorio.salvar(funcionario1);
        repositorio.salvar(funcionario2);
        repositorio.remover(funcionario1);
        List<Funcionario> funcionarios = repositorio.listar();
        if (funcionarios.size() != 1 || funcionarios.contains(funcionario1)) {
            throw new AssertionError("Falha ao testar o método remover. Funcionário não removido corretamente.");
        }
    }
}
