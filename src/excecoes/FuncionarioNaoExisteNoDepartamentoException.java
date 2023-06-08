package excecoes;

import dados.Departamento;

public class FuncionarioNaoExisteNoDepartamentoException extends FuncionarioNaoExisteException {
    private Departamento departamento;

    public FuncionarioNaoExisteNoDepartamentoException(int id, Departamento departamento) {
        super("Funcionário com id " + id + " não existe no departamento com id " + departamento.getId(), id);
        this.departamento = departamento;
    }

    public Departamento getDepartamento() {
        return departamento;
    }
}
