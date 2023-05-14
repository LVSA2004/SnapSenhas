package br.com.fiap.snapsenhasteste.config;

import br.com.fiap.snapsenhasteste.models.RestErrors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class RestExceptionHandler {
    Logger log = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<RestErrors> argumentExceptionHandler(){
        log.error("Erro de argumento invalido");
        return ResponseEntity.badRequest().body(new RestErrors(400, "campos inválidos"));
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<RestErrors> responseStatusExceptionHandler(ResponseStatusException e){
        return ResponseEntity.status(e.getStatusCode()).body(
                new RestErrors(e.getStatusCode().value(), e.getBody().getDetail())
        );
    }
}
