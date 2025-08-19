package alura.foro.forohub.infra.security.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice //Ayuda con la gestion de errores
public class GestorDeErrores {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity gestionarError404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity gestionarError400(MethodArgumentNotValidException ex){
        var errores=ex.getFieldErrors();
        return ResponseEntity.badRequest().body(errores.stream()
                .map(DatosErrorValidacion::new).toList());
    }
    public record DatosErrorValidacion( //Este record es para poder hacer un mensaje de error 400 customizado
            String campo,
            String mensaje
    ){
        public DatosErrorValidacion(FieldError error){ //Este es el msj customizado, originalmente era mas largo y lleno de cosas innecesarias
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
