package br.com.marcos.biblia2.menus;

import br.com.marcos.biblia2.models.ListaLivro;
import br.com.marcos.biblia2.models.Livro;
import br.com.marcos.biblia2.models.Usuario;
import br.com.marcos.biblia2.services.HTTP;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exibir {


    public static void opcoes(){
        System.out.println("""
                *****FUNCIONALIDADES*****
                Digite 1 para ler um capítulo
                Digite 2 para ler um versículo específico
                Digite 3 pare ler seus versículos lidos
                Digite 0 para finalizar o programa
                """);
    }

    public static void linguasDisponiveis(){
        System.out.println("""
                ****LINGUAS DISPONÍVEIS****
                INGLÊS = BBE
                PORTUGUÊS = ALMEIDA
                LATIM = CLEMENTINE
                CHINES = CUV
                """);
    }
    public static void linguasDisponiveisVersiculo(){
        System.out.println("""
                 ****LINGUAS DISPONÍVEIS****
                INGLÊS = BBE
                PORTUGUÊS = ALMEIDA
                LATIM = CLEMENTINE
                """);
    }

    public static String exibirLivros(Scanner sc)throws IOException, InterruptedException {
        List<ListaLivro> lista = new ArrayList<>();

        linguasDisponiveis();
        System.out.println("Digite o código da lingua que você deseja ler:");
        var lingua = sc.nextLine();

        ListaLivro livros = HTTP.exibirLivros(lingua);

        lista.add(livros);

        List<Livro> listaUnica = ListaLivro.achatar(lista);

        listaUnica.stream().forEach(System.out::println);

        return lingua;
    }

    public static void sistema(Usuario u,Scanner sc) throws IOException, InterruptedException {
        String escolha;
        do{
            opcoes();
            escolha = sc.nextLine();
            switch (escolha){
                case "1":
                    String resposta1;
                    do{
                        u.lerCapitulo(sc);
                        System.out.println("Deseja pesquisar novamente? (S/N)");
                        resposta1 = sc.nextLine();
                    }while(resposta1.equalsIgnoreCase("s"));
                    break;
                case "2":
                    String resposta2;
                    do {
                        u.pesquisarVersiculo(sc);
                        System.out.println("Deseja pesquisar novamente?(S/N)");
                        resposta2 = sc.nextLine();
                    }while (resposta2.equalsIgnoreCase("S"));
                    break;
                case "3":
                    System.out.println("Lista:"+u.getLista());
                    break;
                default:
                    break;
            }
        }while (!(escolha.equalsIgnoreCase("0")));
        System.out.println("Finalizando....");
        System.out.println(u);
    }
}
