package br.com.marcos.biblia2.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ListaVersiculoEspecifico(@JsonAlias("verses") List<VersiculoExpecifico>versiculo) {

    public static List<VersiculoExpecifico> achatar(List<ListaVersiculoEspecifico>lista){
        return lista.stream().flatMap(e->e.versiculo().stream()).collect(Collectors.toList());
    }
}
