package repositorio;

import java.util.List;

import dados.Departamento;

public interface DepartamentoRepositorio {
    public void salvar(Departamento departamento);

    public List<Departamento> listar();

    public Departamento buscar(int id);

    public void remover(Departamento departamento);
}
