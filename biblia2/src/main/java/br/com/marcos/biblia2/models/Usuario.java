package br.com.marcos.biblia2.models;

import br.com.marcos.biblia2.execoes.EmailInvalidoException;
import br.com.marcos.biblia2.execoes.NomeInvalidoException;
import br.com.marcos.biblia2.execoes.SenhaInvalidaException;
import br.com.marcos.biblia2.menus.Exibir;
import br.com.marcos.biblia2.services.HTTP;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private List<VersiculoExpecifico> lista;

    public Usuario(String nome,String email,String senha){
        if (nome.matches("^[a-zA-ZÀ-ú\\s]+$")){
            this.nome = nome;
        }else{
            throw new NomeInvalidoException("Nome inválido!");
        }
        if(email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")) {
            this.email = email;
        }else{
            throw new EmailInvalidoException("E-mail inválido");
        }
        if(senha.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()]).{8,}$")) {
            this.senha = senha;
        }else{
            throw new SenhaInvalidaException("Senha inválida!");
        }
        this.lista = new ArrayList<>();
    }
    public void pesquisarVersiculo(Scanner sc) throws IOException, InterruptedException {
        List<ListaVersiculoEspecifico> lista = new ArrayList<>();
        List<VersiculoExpecifico> listaUnica = new ArrayList<>();

        Exibir.linguasDisponiveisVersiculo();
        try {
            System.out.println("Digite o o código da lingua que você deseja:");
            var lingua = sc.nextLine();
            System.out.println("Digite o nome do livro, capítulo e seu versículo, no idioma escolhido:");
            var pesquisa = sc.nextLine();

            var resultado = HTTP.desserializarVersiculo(pesquisa, lingua);
            lista.add(resultado);

            listaUnica = ListaVersiculoEspecifico.achatar(lista);

            System.out.println(listaUnica.getFirst());

            System.out.println("Você deseja que esse versículo seja adicionado a sua lista? (S/N)");
            var resposta = sc.nextLine();
            if (resposta.equalsIgnoreCase("s")){
                this.lista.add(listaUnica.getFirst());
            }
        }catch (NullPointerException|IllegalArgumentException ex){
            System.out.println("Código inválido ou versículo mal digitado!");
        }
    }
    public void lerCapitulo(Scanner sc) throws IOException, InterruptedException {
        List<ListaCapitulo> lista1 = new ArrayList<>();
        List<ListaVersiculo> lista2 = new ArrayList<>();

        try {
            var lingua = Exibir.exibirLivros(sc);

            System.out.println("Digite o ID do livro que deseja ler:");
            var id = sc.nextLine();

            var resultado1 = HTTP.desserializaListaCapitulos(lingua, id);
            lista1.add(resultado1);

            List<Capitulo> listaUnica1 = ListaCapitulo.achatar(lista1);

            listaUnica1.stream().forEach(System.out::println);

            System.out.println("Digite o numero do capitulo que deseja ler:");
            var capitulo = sc.nextLine();

            var resultado2 = HTTP.desserializarListaVersiculos(lingua, id, capitulo);
            lista2.add(resultado2);

            List<Versiculo> listaUnica2 = ListaVersiculo.achatar(lista2);

            listaUnica2.stream().forEach(System.out::println);
        }catch (NullPointerException| IllegalArgumentException ex){
            System.out.println("Valor inválido!");
        }

    }
    public  static Usuario gerarUsuario(Scanner sc){
        System.out.println("Digite seu nome:");
        var nome = sc.nextLine();
        System.out.println("Digite seu email:");
        var email = sc.nextLine();
        System.out.println("Digite sua senha:");
        var senha = sc.nextLine();
        try {
            return new Usuario(nome,email,senha);
        }catch(NomeInvalidoException|EmailInvalidoException|SenhaInvalidaException ex){
            System.out.println(ex.getMessage());
            return null;
            }
    }

    public List<VersiculoExpecifico> getLista() {
        if (lista.isEmpty()){
            System.out.println("Lista vazia");
        }
        return this.lista;
    }

    public void setLista(List<VersiculoExpecifico> lista) {
        this.lista = lista;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", lista=" + lista +
                '}';
    }
}
