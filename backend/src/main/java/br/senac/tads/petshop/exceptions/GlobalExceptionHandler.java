package br.senac.tads.petshop.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import javax.mail.internet.AddressException;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException e) {
        String mensagemErro = "Erro durante a execução: " + e.getMessage();
        return new ResponseEntity<>(mensagemErro, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegratityException(DataIntegrityViolationException e) {
        String mensagemErro = "Erro de integridade de dados: ";
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        /* Validando possíveis erros de integridade de dados*/
        if (e.getMessage().contains("uk_nome_produto")) {
            mensagemErro += "Nome de produto já em uso.";
            status = HttpStatus.CONFLICT; // Código 409 - Conflito
        }
        else {
            mensagemErro += e.getMessage();
        }
        return new ResponseEntity<>(mensagemErro, status);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException e) {
        String mensagemErro = "Entidade não encontrada: " + e.getMessage();
        return new ResponseEntity<>(mensagemErro, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class) // Manipula exceções do tipo MethodArgumentNotValidException
    public ResponseEntity<String> handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
        // Obtém as mensagens de erro de validação e as concatena em uma única string
        String mensagemErro = e.getBindingResult().getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage) // Mapeia cada erro de campo para sua mensagem de erro
                .collect(Collectors.joining(", ")); // Coleta todas as mensagens de erro em uma única string separada por vírgulas

        // Retorna uma resposta com status HTTP 400 (Bad Request) e as mensagens de erro de validação no corpo da resposta
        return ResponseEntity.badRequest().body(mensagemErro);
    }

    @ExceptionHandler(AddressException.class)
    public ResponseEntity<String> handleAddressException(AddressException e){
        String mensagemErro = "Email inválido: " + e.getMessage();
        return new ResponseEntity<>(mensagemErro, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<String> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e){
        String mensagemErro = "Método de requisição não suportado: " + e.getMessage();
        return new ResponseEntity<>(mensagemErro, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<String> handleNoResourceFoundException(NoResourceFoundException e){
        String mensagemErro = "Recurso não encontrado: " + e.getMessage();
        return new ResponseEntity<>(mensagemErro, HttpStatus.NOT_FOUND);
    }
}