package console;

import java.util.List;
import java.util.Scanner;

import dados.Departamento;
import dados.Gerente;
import excecoes.DepartamentoJaExisteException;
import excecoes.DepartamentoNaoExisteException;
import excecoes.FuncionarioNaoExisteException;
import negocio.Empresa;

public class TelaDepartamento {
    private Empresa fachada;
    private Scanner scanner;
    private CadastroDepartamento cadastro;

    public TelaDepartamento(Empresa fachada) {
        this.fachada = fachada;
        this.scanner = new Scanner(System.in);
        this.cadastro = new CadastroDepartamento();
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
                    adicionaDepartamento();
                    break;
                case "2":
                    buscaDepartamento();
                    break;
                case "3":
                    printDepartamentos();
                    break;
                case "4":
                    editaDepartamento();
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

    private void editaDepartamento() {
        cadastro.iniciar();

        if (!cadastro.isFinalizado()) {
            return;
        }

        Gerente gerente = null;

        if (cadastro.getGerente() != 0) {
            try {
                gerente = (Gerente) fachada.buscarFuncionario(cadastro.getGerente());
            } catch (FuncionarioNaoExisteException e) {
                System.out.println(e.getMessage());
                return;
            } catch (ClassCastException e) {
                System.out.println("Esse funcionário não é um gerente");
                return;
            }
        }

        try {
            fachada.editarDepartamento(cadastro.getId(), cadastro.getNome(), gerente);
        } catch (DepartamentoNaoExisteException e) {
            System.out.println(e.getMessage());
            return;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
    }

    private void adicionaDepartamento() {
        cadastro.iniciar();

        if (!cadastro.isFinalizado()) {
            return;
        }

        Gerente gerente = null;

        if (cadastro.getGerente() != 0) {
            try {
                gerente = (Gerente) fachada.buscarFuncionario(cadastro.getGerente());
            } catch (FuncionarioNaoExisteException e) {
                System.out.println(e.getMessage());
                return;
            } catch (ClassCastException e) {
                System.out.println("Esse funcionário não é um gerente");
                return;
            } catch (IllegalAccessError e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        try {
            fachada.adicionarDepartamento(cadastro.getId(), cadastro.getNome(), gerente);
        } catch (DepartamentoJaExisteException e) {
            System.out.println(e.getMessage());
            Departamento departamento = e.getDepartamento();
            System.out.println(departamento.getId() + " " + departamento.getNome());
            return;
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
