package excecoes;

import dados.Funcionario;

public class FuncionarioJaExisteException extends Exception {
    private Funcionario funcionario;

    public FuncionarioJaExisteException(Funcionario funcionario) {
        super("Funcionário já existe no banco de dados");
        this.funcionario = funcionario;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }
}
