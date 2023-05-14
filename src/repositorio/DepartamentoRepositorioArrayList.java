package repositorio;

import java.util.ArrayList;
import java.util.List;

import dados.Departamento;

public class DepartamentoRepositorioArrayList implements DepartamentoRepositorio {
    private List<Departamento> departamentos;

    public DepartamentoRepositorioArrayList() {
        this.departamentos = new ArrayList<Departamento>();
    }

    public void salvar(Departamento departamento) {
        this.departamentos.add(departamento);
    }

    public List<Departamento> listar() {
        return new ArrayList<>(this.departamentos);
    }

    public Departamento buscar(int id) {
        for (int i = 0; i < this.departamentos.size(); i++) {
            Departamento departamento = this.departamentos.get(i);
            if (departamento.getId() == id) {
                return departamento;
            }
        }
        return null;
    }

    public void remover(Departamento departamento) {
        if (departamento != null) {
            this.departamentos.remove(departamento);
        }
    }
}
