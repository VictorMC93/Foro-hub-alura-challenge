package alura.foro.forohub.domain.topico.record;

import alura.foro.forohub.domain.topico.Topico;

import java.time.LocalDateTime;

public record DatosDetalleTopico(
        Long id,
        Long autor_id,
        Long curso_id,
        String titulo,
        String mensaje,
        LocalDateTime fecha_creacion) {
    public DatosDetalleTopico(Topico topico) {
        this(topico.getId(),topico.getUsuario().getId(),topico.getCurso().getId(),
                topico.getTitulo(), topico.getMensaje(), topico.getFecha_creacion());
    }
}
