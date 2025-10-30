package br.com.marcos.biblia2.Interfaces;

import java.util.Scanner;

public interface Gerador<T>{
    T gerarObjeto(Scanner sc);
}
