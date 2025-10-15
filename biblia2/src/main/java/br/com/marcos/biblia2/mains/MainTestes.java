package br.com.marcos.biblia2.mains;

import br.com.marcos.biblia2.menus.Exibir;
import br.com.marcos.biblia2.models.Usuario;

import java.io.IOException;
import java.util.Scanner;

public class MainTestes {
    public static void main(String[]args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        Usuario objeto;
        do {
            objeto = Usuario.gerarUsuario(sc);
        } while (objeto == null);

        Exibir.sistema(objeto,sc);
    }
}
