package console;

import java.util.Scanner;

public class CadastroFuncionario {
    private Scanner scanner;

    private int id;
    private String nome;
    private int cargo;
    private double salario;
    private int departamento;

    private boolean finalizado; // Marca se a operação foi concluída sem erros

    public CadastroFuncionario() {
        this.scanner = new Scanner(System.in);

        this.id = 0;
        this.nome = null;
        this.cargo = 0;
        this.salario = 0;
        this.departamento = 0;

        this.finalizado = false;
    }

    public void iniciar() {
        String idString;
        String nome;
        String cargo;
        String salarioString;
        String departamento;

        System.out.println("Cadastro de Funcionário");

        System.out.println("ID: ");
        idString = scanner.nextLine();

        System.out.println("Nome: ");
        nome = scanner.nextLine();

        System.out.println("Cargo (ID): ");
        cargo = scanner.nextLine();

        System.out.println("Salário: ");
        salarioString = scanner.nextLine();

        System.out.println("Departamento (ID): ");
        departamento = scanner.nextLine();

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

        if (!cargo.strip().isEmpty()) {
            try {
                this.cargo = Integer.parseInt(cargo);
            } catch (NumberFormatException e) {
                System.out.println("ID de Cargo inválido.");
                System.out.println(e.getMessage());
                return;
            }
        }

        if (!salarioString.strip().isEmpty()) {
            try {
                this.salario = Double.parseDouble(salarioString);
            } catch (NumberFormatException e) {
                System.out.println("Valor de salário inválido.");
                System.out.println(e.getMessage());
            }
        }

        if (!departamento.strip().isEmpty()) {
            try {
                this.departamento = Integer.parseInt(departamento);
            } catch (NumberFormatException e) {
                System.out.println("ID de Departamento inválido.");
                System.out.println(e.getMessage());
                return;
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

    public int getCargo() {
        return cargo;
    }

    public double getSalario() {
        return salario;
    }

    public int getDepartamento() {
        return departamento;
    }

    public boolean isFinalizado() {
        return finalizado;
    }
}
