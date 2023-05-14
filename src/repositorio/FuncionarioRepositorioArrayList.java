package repositorio;

import java.util.ArrayList;
import java.util.List;

import dados.Funcionario;

public class FuncionarioRepositorioArrayList implements FuncionarioRepositorio {
    private List<Funcionario> funcionarios;

    public FuncionarioRepositorioArrayList() {
        this.funcionarios = new ArrayList<Funcionario>();
    }

    public void salvar(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
    }

    public List<Funcionario> listar() {
        return new ArrayList<>(this.funcionarios);
    }

    public Funcionario buscar(int id) {
        for (int i = 0; i < this.funcionarios.size(); i++) {
            Funcionario funcionario = this.funcionarios.get(i);
            if (funcionario.getId() == id) {
                return funcionario;
            }
        }
        return null;
    }

    public void remover(Funcionario funcionario) {
        if (funcionario != null) {
            this.funcionarios.remove(funcionario);
        }
    }
}
