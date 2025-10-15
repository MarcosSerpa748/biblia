package br.com.marcos.biblia2.services;

import br.com.marcos.biblia2.models.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

public class HTTP {
    public static String requisicao(String url) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request =  HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client
                .send(request,HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
    public static ListaVersiculoEspecifico desserializarVersiculo(String livroCapituloVersiculo,String lingua) throws IOException, InterruptedException {
        var url = "https://bible-api.com/"+livroCapituloVersiculo+"?translation="+lingua;
        var json = requisicao(url);

        return Desserializador.desserializar(json, ListaVersiculoEspecifico.class);
    }
    public static ListaLivro exibirLivros(String lingua)throws IOException, InterruptedException {
        var url = "https://bible-api.com/data/"+lingua;
        var json = requisicao(url);

        return Desserializador.desserializar(json, ListaLivro.class);
    }
    public static ListaCapitulo desserializaListaCapitulos(String lingua,String livro) throws IOException, InterruptedException {
        var url ="https://bible-api.com/data/"+lingua+"/"+livro;
        var json = requisicao(url);

        return Desserializador.desserializar(json,ListaCapitulo.class);
    }
    public static ListaVersiculo desserializarListaVersiculos(String lingua,String id,String capitulo) throws IOException, InterruptedException {
        var url ="https://bible-api.com/data/"+lingua+"/"+id+"/"+capitulo;
        var json = requisicao(url);

        return Desserializador.desserializar(json,ListaVersiculo.class);
    }
}
