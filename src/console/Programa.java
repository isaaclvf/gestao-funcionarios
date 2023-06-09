package console;

import negocio.Empresa;
import negocio.FachadaEmpresa;

public class Programa {
    public static void main(String[] args) {
        Empresa empresa = new FachadaEmpresa();
        TelaPrincipal tela = new TelaPrincipal(empresa);
        tela.iniciar();
    }
}
