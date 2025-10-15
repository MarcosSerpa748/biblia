package br.com.marcos.biblia2.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Capitulo(@JsonAlias("book") String livro,@JsonAlias("chapter")Integer capitulo) {
}
