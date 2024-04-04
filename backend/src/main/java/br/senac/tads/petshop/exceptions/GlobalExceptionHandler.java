package br.senac.tads.petshop.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.mail.internet.AddressException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException e) {
        String mensagemErro = "Erro durante a execução: " + e.getMessage();
        return new ResponseEntity<>(mensagemErro, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegratityException(DataIntegrityViolationException e) {
        String mensagemErro = "Erro de integridade de dados: " + e.getMessage();
        return new ResponseEntity<>(mensagemErro, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException e) {
        String mensagemErro = "Entidade não encontrada: " + e.getMessage();
        return new ResponseEntity<>(mensagemErro, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AddressException.class)
    public ResponseEntity<String> handleAddressException(AddressException e){
        String mensagemErro = "Email inválido: " + e.getMessage();
        return new ResponseEntity<>(mensagemErro, HttpStatus.BAD_REQUEST);

    }

}