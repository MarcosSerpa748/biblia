package br.com.marcos.biblia2.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Desserializador {
    public static <T> T desserializar(String json,Class<T> classe) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json,classe);
    }
}
