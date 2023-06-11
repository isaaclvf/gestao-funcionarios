package console;

import java.util.Scanner;

import negocio.Empresa;

public class TelaPrincipal {
    private Scanner scanner;
    private TelaFuncionario funcionario;
    private TelaCargo cargo;
    private TelaDepartamento departamento;

    public TelaPrincipal(Empresa fachada) {
        this.scanner = new Scanner(System.in);

        this.funcionario = new TelaFuncionario(fachada);
        this.cargo = new TelaCargo(fachada);
        this.departamento = new TelaDepartamento(fachada);
    }

    public void iniciar() {
        while (true) {
            System.out.println("## Gerenciamento de Recursos Humanos ##");
            System.out.println("1) Gerenciar Funcionários");
            System.out.println("2) Gerenciar Departamentos");
            System.out.println("3) Gerenciar Cargos");
            System.out.println("S) Sair");

            String escolha = scanner.nextLine();

            switch (escolha) {
                case "1":
                    funcionario.iniciar();
                    break;
                case "2":
                    departamento.iniciar();
                    break;
                case "3":
                    cargo.iniciar();
                    break;
                case "s":
                case "S":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Tente novamente.");
            }
        }
    }
}
