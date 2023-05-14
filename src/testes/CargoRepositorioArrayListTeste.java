package testes;

import java.util.List;

import dados.Cargo;
import repositorio.CargoRepositorio;
import repositorio.CargoRepositorioArrayList;

public class CargoRepositorioArrayListTeste {

    private CargoRepositorio repositorio;
    private Cargo cargo1;
    private Cargo cargo2;

    public void setup() {
        repositorio = new CargoRepositorioArrayList();
        cargo1 = new Cargo(1, "Desenvolvedor", "Responsável por construir e aprimorar soluções tecnológicas", 5000.0);
        cargo2 = new Cargo(2, "Vendedor", "Responsável pelas vendas", 2500.0);
    }

    public void testeSalvar() {
        setup();
        repositorio.salvar(cargo1);
        repositorio.salvar(cargo2);
        List<Cargo> cargos = repositorio.listar();
        if (cargos.size() != 2) {
            throw new AssertionError("Falha ao testar o método salvar. Tamanho da lista incorreto.");
        }
    }

    public void testeListar() {
        setup();
        repositorio.salvar(cargo1);
        repositorio.salvar(cargo2);
        List<Cargo> cargos = repositorio.listar();
        if (cargos.size() != 2) {
            throw new AssertionError("Falha ao testar o método listar. Tamanho da lista incorreto.");
        }
    }

    public void testeBuscar() {
        setup();
        repositorio.salvar(cargo1);
        repositorio.salvar(cargo2);
        Cargo cargoEncontrado = repositorio.buscar(1);
        if (cargoEncontrado == null || cargoEncontrado != cargo1) {
            throw new AssertionError("Falha ao testar o método buscar. Cargo não encontrado corretamente.");
        }
    }

    public void testeRemover() {
        setup();
        repositorio.salvar(cargo1);
        repositorio.salvar(cargo2);
        repositorio.remover(cargo1);
        List<Cargo> cargos = repositorio.listar();
        if (cargos.size() != 1 || cargos.contains(cargo1)) {
            throw new AssertionError("Falha ao testar o método remover. Cargo não removido corretamente.");
        }
    }
}
