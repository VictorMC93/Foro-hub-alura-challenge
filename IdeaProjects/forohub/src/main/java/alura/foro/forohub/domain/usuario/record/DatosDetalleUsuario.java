package alura.foro.forohub.domain.usuario.record;

import alura.foro.forohub.domain.usuario.Usuario;

public record DatosDetalleUsuario(
        Long id,
        String nombre,
        String email
) {
    public DatosDetalleUsuario(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getEmail()
        );
    }
}
