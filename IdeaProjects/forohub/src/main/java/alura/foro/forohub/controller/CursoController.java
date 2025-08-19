package alura.foro.forohub.controller;

import alura.foro.forohub.domain.curso.Curso;
import alura.foro.forohub.domain.curso.CursoRepository;
import alura.foro.forohub.domain.curso.record.DatosDetalleCurso;
import alura.foro.forohub.domain.curso.record.DatosListaCurso;
import alura.foro.forohub.domain.curso.record.DatosRegistroCurso;
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
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository repo;

    @Transactional
    @PostMapping
    public ResponseEntity registrar(@RequestBody @Valid DatosRegistroCurso datos, UriComponentsBuilder uriComponentsBuilder) { //valid indica a spring que vea las validaciones que tenga DatosRegistroMedico
        var curso = new Curso(datos);
        repo.save(curso);
        var uri = uriComponentsBuilder.path("/cursos/{id}").buildAndExpand(curso.getId()).toUri();
        return ResponseEntity.created(uri).body(new DatosDetalleCurso(curso));
    }

    @GetMapping
    public ResponseEntity<Page<DatosListaCurso>> listar(@PageableDefault(size = 10, sort = {"nombre"}) Pageable paginacion) {
        var page = repo.findAll(paginacion).map(DatosListaCurso::new);
        return ResponseEntity.ok(page);
    }
}