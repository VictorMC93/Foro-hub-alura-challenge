package alura.foro.forohub.domain.topico.record;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistroTopico(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotNull LocalDateTime fecha_creacion,
        @NotNull Long autor_id,
        @NotNull Long curso_id
) {
}
