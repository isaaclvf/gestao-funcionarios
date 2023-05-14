package repositorio;

import java.util.ArrayList;
import java.util.List;

import dados.Cargo;

public class CargoRepositorioArrayList implements CargoRepositorio {
    private List<Cargo> cargos;

    public CargoRepositorioArrayList() {
        this.cargos = new ArrayList<Cargo>();
    }

    public void salvar(Cargo cargo) {
        this.cargos.add(cargo);
    }

    public List<Cargo> listar() {
        return new ArrayList<>(this.cargos);
    }

    public Cargo buscar(int id) {
        for (int i = 0; i < this.cargos.size(); i++) {
            Cargo cargo = this.cargos.get(i);
            if (cargo.getId() == id) {
                return cargo;
            }
        }
        return null;
    }

    public void remover(Cargo cargo) {
        if (cargo != null) {
            this.cargos.remove(cargo);
        }
    }
}
