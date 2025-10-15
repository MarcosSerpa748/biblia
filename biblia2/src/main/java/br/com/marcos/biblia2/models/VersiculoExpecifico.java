package br.com.marcos.biblia2.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record VersiculoExpecifico(@JsonAlias("book_name")String livro,@JsonAlias("chapter")Integer capitulo,@JsonAlias("verse")Integer verisculo,@JsonAlias("text")String texto) {
    @Override
    public String toString() {
        return "Referência:"+livro()+capitulo()+":"+verisculo()+"\n"+
                "Texto:"+texto()+"\n";
    }
}
