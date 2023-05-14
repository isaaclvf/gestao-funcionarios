package dados;

import java.util.Objects;

public class Gerente extends Funcionario {
  public Gerente(int id, String nome, Cargo cargo, double salario, Departamento departamento) {
    super(id, nome, cargo, salario, departamento);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof Gerente))
      return false;
    if (!super.equals(o))
      return false;

    // Caso tenha alguma lógica específica para comparar gerentes, colocar aqui

    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode());
  }
}
