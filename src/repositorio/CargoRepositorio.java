package repositorio;

import java.util.List;

import dados.Cargo;

public interface CargoRepositorio {
    public void salvar(Cargo cargo);

    public List<Cargo> listar();

    public Cargo buscar(int id);

    public void remover(Cargo cargo);
}