package excecoes;

public class CargoNaoExisteException extends Exception {
    private int id;

    public CargoNaoExisteException(int id) {
        super("Cargo com id " + id + " não existe no banco de dados");
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
