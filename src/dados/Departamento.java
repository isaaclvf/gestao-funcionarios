package dados;

import java.util.ArrayList;
import java.util.Objects;

public class Departamento {
    private int id;
    private String nome;
    private Gerente gerente;
    private ArrayList<Funcionario> funcionarios;

    public Departamento(int id, String nome, Gerente gerente)
            throws IllegalArgumentException {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do departamento não pode ser vazio");
        }

        this.id = id;
        this.nome = nome;
        this.gerente = gerente;
        this.funcionarios = new ArrayList<Funcionario>();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws IllegalArgumentException {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do departamento não pode ser vazio");
        }

        this.nome = nome;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void removerFuncionario(Funcionario funcionario) {
        funcionarios.remove(funcionario);
    }

    public ArrayList<Funcionario> listarFuncionarios() {
        return funcionarios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        Departamento that = (Departamento) o;
        return this.id == that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
