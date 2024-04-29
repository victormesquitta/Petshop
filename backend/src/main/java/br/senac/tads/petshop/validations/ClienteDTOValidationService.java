package br.senac.tads.petshop.validations;

import org.springframework.stereotype.Service;
import jakarta.validation.Validator;
import jakarta.validation.ConstraintViolationException;

@Service
public class ClienteDTOValidationService implements ValidationService {

    private final Validator validator;

    public ClienteDTOValidationService(Validator validator) {
        this.validator = validator;
    }

    @Override
    public void validate(Object object) {
        var violations = validator.validate(object);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}
