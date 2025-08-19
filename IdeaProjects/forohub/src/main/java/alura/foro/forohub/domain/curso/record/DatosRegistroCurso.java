package alura.foro.forohub.domain.curso.record;

import alura.foro.forohub.domain.curso.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroCurso(
        @NotBlank String nombre,
        @NotNull Categoria categoria
        ) {
}
