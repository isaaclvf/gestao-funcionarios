package dados;

import java.time.LocalDate;

public class Funcionario {

    private int id;
    private LocalDate dataAdmissao;
    private String nome;
    private Cargo cargo;
    private double salario;
    private Departamento departamento;

    public Funcionario(int id, String nome, Cargo cargo, double salario, Departamento departamento) {
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

    public void setNome(String nome) {
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

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }


}
