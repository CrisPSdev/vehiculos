package cl.duoc.vehiculo.exception.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import cl.duoc.vehiculo.exception.custom.VehicleAlreadyExistsException;
import cl.duoc.vehiculo.exception.custom.VehicleAlreadySoldException;
import cl.duoc.vehiculo.exception.custom.VehicleNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGeneral(Exception ex) {
        Map<String, String> error = Map.of("error", "error interno");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

   
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> ValidExceptions(MethodArgumentNotValidException ex) {

        Map<String, String> errores = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errores.put(error.getField(), error.getDefaultMessage());
        });
        
        return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(VehicleNotFoundException.class) 
    public ResponseEntity<Map<String, String>> VehicleNotFound(VehicleNotFoundException ex) {

        Map<String, String> error = Map.of(
            "error", ex.getMessage()
        );
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    } 

    @ExceptionHandler(VehicleAlreadySoldException.class) 
    public ResponseEntity<Map<String, String>> VehicleAlreadySold(VehicleAlreadySoldException ex) {

        Map<String, String> error = Map.of(
            "error", ex.getMessage()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(VehicleAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> VehicleAlreadyExists(VehicleAlreadyExistsException ex) {

        Map<String, String> error = Map.of(
            "error", ex.getMessage()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
