package testes;

public class Teste {
    public static void executaTestes() {
        testaFuncionarioRepo();
        System.out.println("Testes de operações CRUD com repositório de Funcionario concluído com sucesso.");

        testaCargoRepo();
        System.out.println("Testes de operações CRUD com repositório de Cargo concluído com sucesso.");

        testaDepartamentoRepo();
        System.out.println("Testes de operações CRUD com repositório de Departamento concluído com sucesso.");

    }

    private static void testaFuncionarioRepo() {
        FuncionarioRepositorioArrayListTeste teste = new FuncionarioRepositorioArrayListTeste();
        teste.testeSalvar();
        teste.testeListar();
        teste.testeBuscar();
        teste.testeRemover();
    }

    private static void testaCargoRepo() {
        CargoRepositorioArrayListTeste teste = new CargoRepositorioArrayListTeste();
        teste.testeSalvar();
        teste.testeListar();
        teste.testeBuscar();
        teste.testeRemover();
    }

    private static void testaDepartamentoRepo() {
        DepartamentoRepositorioArrayListTeste teste = new DepartamentoRepositorioArrayListTeste();
        teste.testeSalvar();
        teste.testeListar();
        teste.testeBuscar();
        teste.testeRemover();
    }
}
