package br.com.marcos.biblia2.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ListaVersiculo(@JsonAlias("verses")List<Versiculo> versiculos) {

    public static List<Versiculo> achatar(List<ListaVersiculo>lista){
        return lista.stream().flatMap(e ->e.versiculos().stream()).collect(Collectors.toList());
    }
}
