package br.com.marcos.biblia2.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ListaCapitulo(@JsonAlias("chapters") List<Capitulo>capitulos) {

    public static List<Capitulo> achatar(List<ListaCapitulo>lista){
        return lista.stream().flatMap(e ->e.capitulos().stream()).collect(Collectors.toList());
    }
}
