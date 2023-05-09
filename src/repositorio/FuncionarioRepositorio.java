package repositorio;

import java.util.List;

import dados.Funcionario;

public interface FuncionarioRepositorio {
    public void salvar(Funcionario funcionario);

    public List<Funcionario> listar();

    public Funcionario buscar(int id);

    public void remover(Funcionario funcionario);
}
