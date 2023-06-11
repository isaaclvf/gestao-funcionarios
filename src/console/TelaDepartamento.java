package console;

import java.util.List;
import java.util.Scanner;

import dados.Departamento;
import excecoes.DepartamentoNaoExisteException;
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
                    buscaDepartamento();
                    break;
                case "3":
                    printDepartamentos();
                    break;
                case "4":
                    break;
                case "5":
                    removeDepartamento();
                    break;
                case "s":
                case "S":
                    return;
                default:
                    break;
            }
        }
    }

    private void removeDepartamento() {
        System.out.println("ID do departamento a ser removido: ");
        String escolhaString = scanner.nextLine();

        int escolha;

        try {
            escolha = Integer.parseInt(escolhaString);
        } catch (NumberFormatException ex) {
            System.out.println("O ID deve ser um número inteiro. Tente novamente.");
            return;
        }

        try {
            fachada.removerDepartamento(escolha);
        } catch (DepartamentoNaoExisteException ex) {
            System.out.println("Operação falhou.");
            System.out.println(ex.getMessage());
            return;
        }
    }

    private void buscaDepartamento() {
        System.out.println("Buscar por ID: ");
        String escolhaString = scanner.nextLine();

        int escolha;

        try {
            escolha = Integer.parseInt(escolhaString);
        } catch (NumberFormatException ex) {
            System.out.println("O ID deve ser um número inteiro. Tente novamente.");
            return;
        }

        Departamento departamento;

        try {
            departamento = fachada.buscarDepartamento(escolha);
        } catch (DepartamentoNaoExisteException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        System.out.println(departamento.getId() + " " + departamento.getNome());
    }

    private void printDepartamentos() {
        List<Departamento> departamentos = fachada.listarDepartamentos();
        for (Departamento d : departamentos) {
            System.out.println(d.getNome());
        }
    }
}
