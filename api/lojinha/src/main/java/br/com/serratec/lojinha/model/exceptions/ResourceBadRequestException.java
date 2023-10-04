package br.com.serratec.lojinha.model.exceptions;

public class ResourceBadRequestException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    public ResourceBadRequestException(String mensagem){
        super(mensagem);
    }

    // Not Found = 404
    // Bad Request = 400
}
