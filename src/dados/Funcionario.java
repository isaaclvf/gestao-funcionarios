package dados;

import java.time.LocalDate;
import java.util.Objects;

public class Funcionario {
    private int id;
    private LocalDate dataAdmissao;
    private String nome;
    private Cargo cargo;
    private double salario;
    private Departamento departamento;

    public Funcionario(int id, String nome, Cargo cargo, double salario, Departamento departamento)
            throws IllegalArgumentException {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do funcionário não pode ser vazio");
        }

        if (salario <= 0) {
            throw new IllegalArgumentException("Salário deve ser maior que 0");
        }

        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.departamento = departamento;
        this.dataAdmissao = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws IllegalArgumentException {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do funcionário não pode ser vazio");
        }

        this.nome = nome;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) throws IllegalArgumentException {
        if (salario <= 0) {
            throw new IllegalArgumentException("Salário deve ser maior que 0");
        }
        this.salario = salario;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    // Funcionários são iguais se tiverem o mesmo id
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        Funcionario that = (Funcionario) o;
        return this.id == that.getId();
    }

    // Recomendado pela documentação do Java
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
