package repositorio;

import java.util.ArrayList;
import java.util.List;

import dados.Gerente;

public class GerenteRepositorioArrayList implements GerenteRepositorio {
    private List<Gerente> gerentes;

    public GerenteRepositorioArrayList() {
        this.gerentes = new ArrayList<Gerente>();
    }

    public void salvar(Gerente gerente) {
        this.gerentes.add(gerente);
    }

    public List<Gerente> listar() {
        return new ArrayList<>(this.gerentes);
    }

    public Gerente buscar(int id) {
        for (int i = 0; i < this.gerentes.size(); i++) {
            Gerente gerente = this.gerentes.get(i);
            if (gerente.getId() == id) {
                return gerente;
            }
        }
        return null;
    }

    public void remover(Gerente gerente) {
        if (gerente != null) {
            this.gerentes.remove(gerente);
        }
    }
}
