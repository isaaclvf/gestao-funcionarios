package excecoes;

import dados.Departamento;

public class DepartamentoJaExisteException extends Exception {
    private Departamento departamento;

    public DepartamentoJaExisteException(Departamento departamento) {
        super("Departamento já existe no banco de dados");
        this.departamento = departamento;
    }

    public Departamento getDepartamento() {
        return departamento;
    }
}
