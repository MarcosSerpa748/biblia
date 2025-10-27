package br.com.marcos.biblia2.services;

import br.com.marcos.biblia2.models.*;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HTTP implements Desserializador {
    private static final String URL1 = "https://bible-api.com/";
    private static final String URLLINGUA = "?translation=";
    private static final String URL2 = "https://bible-api.com/data/";


    private static String requisicao(String url) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request =  HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client
                .send(request,HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public static ListaVersiculoEspecifico desserializarVersiculo(String livroCapituloVersiculo,String lingua) throws IOException, InterruptedException {
        var livroCapituloVersiculoReforcado = URLEncoder.encode(livroCapituloVersiculo);
        var linguaReforcado = URLEncoder.encode(lingua);
        var json = requisicao(URL1 +livroCapituloVersiculoReforcado+ URLLINGUA +linguaReforcado);

        return Desserializador.desserializar(json, ListaVersiculoEspecifico.class);
    }
    public static ListaLivro exibirLivros(String lingua)throws IOException, InterruptedException {
        var linguaReforcada = URLEncoder.encode(lingua);
        var json = requisicao(URL2 +linguaReforcada);

        return Desserializador.desserializar(json, ListaLivro.class);
    }
    public static ListaCapitulo desserializaListaCapitulos(String lingua,String livro) throws IOException, InterruptedException {
        var linguaReforcada = URLEncoder.encode(lingua);
        var idReforcado = URLEncoder.encode(livro);
        var json = requisicao(URL2+linguaReforcada+"/"+idReforcado);

        return Desserializador.desserializar(json,ListaCapitulo.class);
    }
    public static ListaVersiculo desserializarListaVersiculos(String lingua,String id,String capitulo) throws IOException, InterruptedException {
        var linguaReforcada = URLEncoder.encode(lingua);
        var idReforcado = URLEncoder.encode(id);
        var capituloReforcado = URLEncoder.encode(capitulo);
        var json = requisicao(URL2+linguaReforcada+"/"+idReforcado+"/"+capituloReforcado);

        return Desserializador.desserializar(json,ListaVersiculo.class);
    }


}
