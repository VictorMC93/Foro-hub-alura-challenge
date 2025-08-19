package alura.foro.forohub.domain.usuario.record;

import alura.foro.forohub.domain.usuario.Usuario;

public record DatosListaUsuario(Long id,
                                String nombre,
                                String email
) {
    public DatosListaUsuario(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getEmail()
        );
    }
}
