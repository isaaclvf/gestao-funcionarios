package console;

import java.util.List;
import java.util.Scanner;

import dados.Cargo;
import excecoes.CargoJaExisteException;
import excecoes.CargoNaoExisteException;
import negocio.Empresa;

public class TelaCargo {
    private Empresa fachada;
    private Scanner scanner;
    private CadastroCargo cadastro;

    public TelaCargo(Empresa fachada) {
        this.fachada = fachada;
        this.scanner = new Scanner(System.in);
        this.cadastro = new CadastroCargo();
    }

    public void iniciar() {
        while (true) {
            System.out.println("## Gerenciamento de Cargos ##");
            System.out.println("1) Adicionar");
            System.out.println("2) Buscar");
            System.out.println("3) Listar");
            System.out.println("4) Editar");
            System.out.println("5) Remover");
            System.out.println("S) Sair");

            String escolha = scanner.nextLine();

            switch (escolha) {
                case "1":
                    adicionaCargo();
                    break;
                case "2":
                    buscaCargo();
                    break;
                case "3":
                    printCargos();
                    break;
                case "4":
                    editaCargo();
                    break;
                case "5":
                    removeCargo();
                    break;
                case "s":
                case "S":
                    return;
                default:
                    break;
            }
        }
    }

    private void editaCargo() {
        cadastro.iniciar();

        if (!cadastro.isFinalizado()) {
            return;
        }

        try {
            fachada.editarCargo(cadastro.getId(), cadastro.getNome(), cadastro.getDescricao(), cadastro.getSalario());
        } catch (CargoNaoExisteException e) {
            System.out.println(e.getMessage());
            return;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
    }

    private void adicionaCargo() {
        cadastro.iniciar();

        if (!cadastro.isFinalizado()) {
            return;
        }

        try {
            fachada.adicionarCargo(cadastro.getId(), cadastro.getNome(), cadastro.getDescricao(),
                    cadastro.getSalario());
        } catch (CargoJaExisteException e) {
            System.out.println(e.getMessage());
            return;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
    }

    private void removeCargo() {
        System.out.println("ID do cargo a ser removido: ");
        String escolhaString = scanner.nextLine();

        int escolha;

        try {
            escolha = Integer.parseInt(escolhaString);
        } catch (NumberFormatException ex) {
            System.out.println("O ID deve ser um número inteiro. Tente novamente.");
            return;
        }

        try {
            fachada.removerCargo(escolha);
        } catch (CargoNaoExisteException ex) {
            System.out.println("Operação falhou.");
            System.out.println(ex.getMessage());
            return;
        }
    }

    private void buscaCargo() {
        System.out.println("Buscar por ID: ");
        String escolhaString = scanner.nextLine();
        int escolha;

        try {
            escolha = Integer.parseInt(escolhaString);
        } catch (NumberFormatException ex) {
            System.out.println("O ID deve ser um número inteiro. Tente novamente.");
            return;
        }

        Cargo cargo;

        try {
            cargo = fachada.buscarCargo(escolha);
        } catch (CargoNaoExisteException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        System.out.println(cargo.getNome() + " " + cargo.getDescricao());
    }

    private void printCargos() {
        List<Cargo> cargos = fachada.listarCargos();

        for (Cargo c : cargos) {
            System.out.println(c.getNome() + " " + c.getDescricao());
        }
    }
}
