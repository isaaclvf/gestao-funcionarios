package console;

import java.util.Scanner;

import negocio.Empresa;

public class TelaDepartamento {
    private Empresa fachada;
    private Scanner scanner;

    public TelaDepartamento(Empresa fachada) {
        this.fachada = fachada;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        while (true) {
            System.out.println("## Gerenciamento de Departamentos ##");
            System.out.println("1) Adicionar");
            System.out.println("2) Buscar");
            System.out.println("3) Listar");
            System.out.println("4) Editar");
            System.out.println("5) Remover");
            System.out.println("S) Sair");

            String escolha = scanner.nextLine();

            switch (escolha) {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "s":
                case "S":
                    return;
                default:
                    break;
            }
        }
    }
}
