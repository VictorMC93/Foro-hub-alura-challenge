package alura.foro.forohub.controller;

import alura.foro.forohub.domain.usuario.Usuario;
import alura.foro.forohub.domain.usuario.UsuarioRepository;
import alura.foro.forohub.domain.usuario.record.DatosDetalleUsuario;
import alura.foro.forohub.domain.usuario.record.DatosListaUsuario;
import alura.foro.forohub.domain.usuario.record.DatosRegistroUsuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuRepo;

    @Transactional
    @PostMapping
    public ResponseEntity registrar(@RequestBody @Valid DatosRegistroUsuario datos, UriComponentsBuilder uriComponentsBuilder){ //valid indica a spring que vea las validaciones que tenga DatosRegistroMedico
        var usuario=new Usuario(datos);
        usuRepo.save(usuario);
        var uri=uriComponentsBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new DatosDetalleUsuario(usuario));
    }
    @GetMapping
    public ResponseEntity<Page<DatosListaUsuario>> listar(@PageableDefault(size=10, sort ={"nombre"}) Pageable paginacion){
        var page=usuRepo.findAllByActivoTrue(paginacion).map(DatosListaUsuario::new);
        return ResponseEntity.ok(page);
    }

}
