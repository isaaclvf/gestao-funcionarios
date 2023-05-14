package testes;

import java.util.List;

import dados.Departamento;
import repositorio.DepartamentoRepositorio;
import repositorio.DepartamentoRepositorioArrayList;

public class DepartamentoRepositorioArrayListTeste {
    private DepartamentoRepositorio repositorio;
    private Departamento departamento1;
    private Departamento departamento2;

    public void setup() {
        repositorio = new DepartamentoRepositorioArrayList();
        departamento1 = new Departamento(1, "Vendas", null);
        departamento2 = new Departamento(2, "Logística", null);
    }

    public void testeSalvar() {
        setup();
        repositorio.salvar(departamento1);
        repositorio.salvar(departamento2);
        List<Departamento> departamentos = repositorio.listar();
        if (departamentos.size() != 2) {
            throw new AssertionError("Falha ao testar o método salvar. Tamanho da lista incorreto.");
        }
    }

    public void testeListar() {
        setup();
        repositorio.salvar(departamento1);
        repositorio.salvar(departamento2);
        List<Departamento> departamentos = repositorio.listar();
        if (departamentos.size() != 2) {
            throw new AssertionError("Falha ao testar o método listar. Tamanho da lista incorreto.");
        }
    }

    public void testeBuscar() {
        setup();
        repositorio.salvar(departamento1);
        repositorio.salvar(departamento2);
        Departamento departamentoEncontrado = repositorio.buscar(1);
        if (departamentoEncontrado == null || departamentoEncontrado != departamento1) {
            throw new AssertionError("Falha ao testar o método buscar. Departamento não encontrado corretamente.");
        }
    }

    public void testeRemover() {
        setup();
        repositorio.salvar(departamento1);
        repositorio.salvar(departamento2);
        repositorio.remover(departamento1);
        List<Departamento> departamentos = repositorio.listar();
        if (departamentos.size() != 1 || departamentos.contains(departamento1)) {
            throw new AssertionError("Falha ao testar o método remover. Departamento não removido corretamente.");
        }
    }
}
