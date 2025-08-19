package alura.foro.forohub.domain.topico;

import alura.foro.forohub.domain.curso.Curso;
import alura.foro.forohub.domain.curso.CursoRepository;
import alura.foro.forohub.domain.topico.record.DatosActualizacionTopico;
import alura.foro.forohub.domain.topico.record.DatosRegistroTopico;
import alura.foro.forohub.domain.usuario.Usuario;
import alura.foro.forohub.domain.usuario.UsuarioRepository;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@Table(name = "topicos")
@Entity(name = "Topico")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean activo;
    private String titulo;
    private String mensaje;
    private LocalDateTime fecha_creacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    public void actualizarInformaciones(@Valid DatosActualizacionTopico datos) {
        if (datos.titulo()!=null) {
            this.titulo = datos.titulo();
        }
        if (datos.mensaje()!=null) { //para evitar que queden null los datos
            this.mensaje = datos.mensaje();
        }
    }

    public void eliminar() {
        this.activo=false;
    }
}
