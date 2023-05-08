package dados;

public class Cargo {
    private int id;
    private String nome, descricao;
    private double salarioBase;

    public Cargo(int id, String nome, String descricao, double salarioBase) {
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    
}
