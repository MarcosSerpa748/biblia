package br.com.marcos.biblia2.execoes;

public class EmailInvalidoException extends RuntimeException {
    private String mensagem;

    public EmailInvalidoException(String mensagem){
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
