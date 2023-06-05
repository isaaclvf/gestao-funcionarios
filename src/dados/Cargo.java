package dados;

import java.util.Objects;

public class Cargo {
    private int id;
    private String nome, descricao;
    private double salarioBase;

    public Cargo(int id, String nome, String descricao, double salarioBase)
            throws IllegalArgumentException {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do cargo não pode ser vazio");
        }

        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Descrição do cargo não pode ser vazio");
        }

        if (salarioBase <= 0) {
            throw new IllegalArgumentException("Salário base deve ser maior que 0");
        }

        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.salarioBase = salarioBase;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws IllegalArgumentException {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do cargo não pode ser vazio");
        }
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) throws IllegalArgumentException {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Descrição do cargo não pode ser vazio");
        }
        this.descricao = descricao;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) throws IllegalArgumentException {
        if (salarioBase <= 0) {
            throw new IllegalArgumentException("Salário base deve ser maior que 0");
        }
        this.salarioBase = salarioBase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        Cargo that = (Cargo) o;
        return this.id == that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
