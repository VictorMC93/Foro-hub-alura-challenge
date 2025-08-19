package alura.foro.forohub.domain.curso.record;

import alura.foro.forohub.domain.curso.Categoria;
import alura.foro.forohub.domain.curso.Curso;

public record DatosListaCurso(
        Long id,
        String nombre,
        Categoria categoria
) {
    public DatosListaCurso(Curso curso) {
        this(curso.getId(), curso.getNombre(), curso.getCategoria());
    }
}
