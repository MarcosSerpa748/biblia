package br.com.marcos.biblia2.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ListaLivro(@JsonAlias("books")List<Livro>livros) {

    public static List<Livro> achatar(List<ListaLivro> lista){
        return lista.stream().flatMap(e ->e.livros.stream()).collect(Collectors.toList());
    }
}
