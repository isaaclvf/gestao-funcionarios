package testes;

import java.util.List;

import dados.Cargo;
import dados.Departamento;
import dados.Gerente;
import repositorio.GerenteRepositorio;
import repositorio.GerenteRepositorioArrayList;

public class GerenteRepositorioArrayListTeste {
    private GerenteRepositorio repositorio;
    private Gerente gerente1;
    private Gerente gerente2;

    public void setup() {
        repositorio = new GerenteRepositorioArrayList();
        Departamento departamento1 = new Departamento(1, "TI", null);
        Departamento departamento2 = new Departamento(2, "Vendas", null);

        Cargo cargo1 = new Cargo(1, "Desenvolvedor", "Responsável por construir e aprimorar soluções tecnológicas",
                5000.0);
        Cargo cargo2 = new Cargo(2, "Vendedor", "Responsável pelas vendas",
                5000.0);

        gerente1 = new Gerente(1, "João", cargo1, 10000.0, departamento1);
        gerente2 = new Gerente(2, "Maria", cargo2, 12000.0, departamento2);

        departamento1.setGerente(gerente1);
        departamento2.setGerente(gerente2);
    }

    public void testeSalvar() {
        setup();
        repositorio.salvar(gerente1);
        repositorio.salvar(gerente2);
        List<Gerente> gerentes = repositorio.listar();
        if (gerentes.size() != 2) {
            throw new AssertionError("Falha ao testar o método salvar. Tamanho da lista incorreto.");
        }
    }

    public void testeListar() {
        setup();
        repositorio.salvar(gerente1);
        repositorio.salvar(gerente2);
        List<Gerente> gerentes = repositorio.listar();
        if (gerentes.size() != 2) {
            throw new AssertionError("Falha ao testar o método listar. Tamanho da lista incorreto.");
        }
    }

    public void testeBuscar() {
        setup();
        repositorio.salvar(gerente1);
        repositorio.salvar(gerente2);
        Gerente gerenteEncontrado = repositorio.buscar(1);
        if (gerenteEncontrado == null || gerenteEncontrado != gerente1) {
            throw new AssertionError("Falha ao testar o método buscar. Gerente não encontrado corretamente.");
        }
    }

    public void testeRemover() {
        setup();
        repositorio.salvar(gerente1);
        repositorio.salvar(gerente2);
        repositorio.remover(gerente1);
        List<Gerente> gerentes = repositorio.listar();
        if (gerentes.size() != 1 || gerentes.contains(gerente1)) {
            throw new AssertionError("Falha ao testar o método remover. Gerente não removido corretamente.");
        }
    }
}
