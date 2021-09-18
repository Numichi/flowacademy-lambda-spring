package hu.flowacademy.lambda.elmelet.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Globális exception elkapó
 */
@RestControllerAdvice
public class AdviceController {

    @ExceptionHandler({MethodArgumentNotValidException.class}) // Mit vagy miket
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String methodArgumentNotValidException(MethodArgumentNotValidException exception) {
        //Ez lehetne barátságosabb, de majd látunk rá példát.
        return exception.getMessage();
    }
}
