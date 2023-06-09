package excecoes;

import dados.Cargo;

public class CargoJaExisteException extends Exception {
    private Cargo cargo;

    public CargoJaExisteException(Cargo cargo) {
        super("Cargo já existe no banco de dados");
        this.cargo = cargo;
    }

    public Cargo getCargo() {
        return cargo;
    }
}
