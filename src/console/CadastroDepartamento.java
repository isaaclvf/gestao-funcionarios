package console;

import java.util.Scanner;

public class CadastroDepartamento {
    private Scanner scanner;

    private int id;
    private String nome;
    private int gerente;

    private boolean finalizado;

    public CadastroDepartamento() {
        this.scanner = new Scanner(System.in);

        this.id = 0;
        this.nome = null;
        this.gerente = 0;

        this.finalizado = false;
    }

    public void iniciar() {
        String idString;
        String nome;
        String gerenteString;

        System.out.println("Cadastro de Departamento");

        System.out.println("ID: ");
        idString = scanner.nextLine();

        System.out.println("Nome: ");
        nome = scanner.nextLine();

        System.out.println("Gerente (ID): ");
        gerenteString = scanner.nextLine();

        try {
            this.id = Integer.parseInt(idString);
        } catch (NumberFormatException e) {
            System.out.println("ID inválido.");
            System.out.println(e.getMessage());
            return;
        }

        if (!nome.trim().isEmpty()) {
            this.nome = nome.trim();
        }

        if (!gerenteString.trim().isEmpty()) {
            try {
                this.gerente = Integer.parseInt(gerenteString);
            } catch (NumberFormatException e) {
                System.out.println("ID de Gerente inválido.");
                System.out.println(e.getMessage());
                return;
            }
        }
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getGerente() {
        return gerente;
    }

    public boolean isFinalizado() {
        return finalizado;
    }
}
