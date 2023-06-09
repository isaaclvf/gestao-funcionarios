package excecoes;

public class DepartamentoNaoExisteException extends Exception {
    private int id;

    public DepartamentoNaoExisteException(int id) {
        super("Departamento com id " + id + " não existe no banco de dados");
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
