package alura.foro.forohub.domain.topico.record;

import alura.foro.forohub.domain.topico.Topico;

import java.time.LocalDateTime;

public record DatosListaTopico(
        Long id,
        Long autor_id,
        Long curso_id,
        String titulo,
        LocalDateTime fecha_creacion) {
    public DatosListaTopico(Topico topico) {
        this(topico.getId(), topico.getUsuario().getId(), topico.getCurso().getId(),
                topico.getTitulo(), topico.getFecha_creacion());
    }
}
