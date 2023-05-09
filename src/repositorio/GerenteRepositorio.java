package repositorio;

import java.util.List;

import dados.Gerente;

public interface GerenteRepositorio {
    public void salvar(Gerente gerente);

    public List<Gerente> listar();

    public Gerente buscar(int id);

    public void remover(Gerente gerente);
}
