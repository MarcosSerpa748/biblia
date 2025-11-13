package br.com.marcos.biblia2.mains;

import br.com.marcos.biblia2.menus.Exibir;
import br.com.marcos.biblia2.models.Usuario;

import java.io.IOException;
import java.util.Scanner;

public class MainTestes {
    public static void main(String[]args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        Usuario usuario;
        do {
            usuario = Usuario.gerarObjeto(sc);
        } while (usuario == null);

        Exibir.sistema(usuario,sc);
    }
}
