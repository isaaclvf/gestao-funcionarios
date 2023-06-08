package excecoes;

public class FuncionarioNaoExisteException extends Exception {
    private int id;

    public FuncionarioNaoExisteException(int id) {
        super("Funcionário com id " + id + " não existe no banco de dados");
        this.id = id;
    }

    public FuncionarioNaoExisteException(String msg, int id) {
        super(msg);
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
