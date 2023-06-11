package console;

import java.util.List;
import java.util.Scanner;

import dados.Funcionario;
import excecoes.FuncionarioNaoExisteException;
import negocio.Empresa;

public class TelaFuncionario {
    private Empresa fachada;
    private Scanner scanner;

    public TelaFuncionario(Empresa fachada) {
        this.fachada = fachada;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        while (true) {
            System.out.println("## Gerenciamento de Funcionários ##");
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
                    buscaFuncionario();
                    break;
                case "3":
                    printFuncionarios();
                    break;
                case "4":
                    break;
                case "5":
                    removeFuncionario();
                    break;
                case "s":
                case "S":
                    return;
                default:
                    break;
            }
        }
    }

    private void removeFuncionario() {
        System.out.println("ID do funcionário a ser removido: ");
        String escolhaString = scanner.nextLine();

        int escolha;

        try {
            escolha = Integer.parseInt(escolhaString);
        } catch (NumberFormatException ex) {
            System.out.println("O ID deve ser um número inteiro. Tente novamente.");
            return;
        }

        try {
            fachada.removerFuncionario(escolha);
        } catch (FuncionarioNaoExisteException ex) {
            System.out.println("Operação falhou.");
            System.out.println(ex.getMessage());
            return;
        }
    }

    private void buscaFuncionario() {
        System.out.println("Buscar por ID: ");
        String escolhaString = scanner.nextLine();

        int escolha;

        try {
            escolha = Integer.parseInt(escolhaString);
        } catch (NumberFormatException ex) {
            System.out.println("O ID deve ser um número inteiro. Tente novamente.");
            return;
        }

        Funcionario funcionario;

        try {
            funcionario = fachada.buscarFuncionario(escolha);
        } catch (FuncionarioNaoExisteException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        System.out.println(funcionario.getId() + " " + funcionario.getNome());
    }

    private void printFuncionarios() {
        List<Funcionario> lista = fachada.listarFuncionarios();

        for (Funcionario funcionario : lista) {
            System.out.println(funcionario.getId() + " " + funcionario.getNome());
        }
    }
}
