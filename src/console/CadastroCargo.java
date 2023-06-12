package console;

import java.util.Scanner;

public class CadastroCargo {
    private Scanner scanner;

    private int id;
    private String nome;
    private String descricao;
    private double salario;

    private boolean finalizado; // Marca se a operação foi concluída sem erros

    public CadastroCargo() {
        this.scanner = new Scanner(System.in);

        this.id = 0;
        this.nome = null;
        this.descricao = null;
        this.salario = 0;

        this.finalizado = false;
    }

    public void iniciar() {
        String idString;
        String nome;
        String descricao;
        String salarioString;

        System.out.println("Cadastro de Cargo");

        System.out.println("ID: ");
        idString = scanner.nextLine();

        System.out.println("Nome: ");
        nome = scanner.nextLine();

        System.out.println("Descrição: ");
        descricao = scanner.nextLine();

        System.out.println("Salário: ");
        salarioString = scanner.nextLine();

        try {
            this.id = Integer.parseInt(idString);
        } catch (NumberFormatException e) {
            System.out.println("ID inválido.");
            System.out.println(e.getMessage());
            return;
        }

        if (!nome.strip().isEmpty()) {
            this.nome = nome.strip();
        }

        if (!descricao.strip().isEmpty()) {
            this.descricao = descricao.strip();
        }

        if (!salarioString.strip().isEmpty()) {
            try {
                this.salario = Double.parseDouble(salarioString);
            } catch (NumberFormatException e) {
                System.out.println("Valor de salário inválido.");
                System.out.println(e.getMessage());
            }
        }

        this.finalizado = true;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getSalario() {
        return salario;
    }

    public boolean isFinalizado() {
        return finalizado;
    }
}
