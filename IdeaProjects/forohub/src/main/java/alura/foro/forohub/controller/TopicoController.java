package alura.foro.forohub.controller;

import alura.foro.forohub.domain.topico.TopicoRepository;
import alura.foro.forohub.domain.topico.TopicoService;
import alura.foro.forohub.domain.topico.record.DatosActualizacionTopico;
import alura.foro.forohub.domain.topico.record.DatosDetalleTopico;
import alura.foro.forohub.domain.topico.record.DatosListaTopico;
import alura.foro.forohub.domain.topico.record.DatosRegistroTopico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @Autowired
    private TopicoService topicoService;

    @Transactional
    @PostMapping
    public ResponseEntity crearTopico(@RequestBody @Valid DatosRegistroTopico datos){
        var detalleTopico=topicoService.crear(datos);
        return ResponseEntity.ok(detalleTopico);
    }
    @GetMapping
    public ResponseEntity<Page<DatosListaTopico>> listar(@PageableDefault(size=10, sort ={"titulo"}) Pageable paginacion){
        var page=repository.findAllByActivoTrue(paginacion).map(DatosListaTopico::new);
        return ResponseEntity.ok(page);
    }

    @Transactional
    @PutMapping
    public ResponseEntity actualizar(@RequestBody @Valid DatosActualizacionTopico datos){
        var topico=repository.getReferenceById(datos.id());
        topico.actualizarInformaciones(datos);
        return ResponseEntity.ok(new DatosDetalleTopico(topico));
    }
    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id){
        var topico=repository.getReferenceById(id);
        topico.eliminar();
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity detallar(@PathVariable Long id){
        var topico=repository.getReferenceById(id);
        return ResponseEntity.ok(new DatosDetalleTopico(topico));
    }
}
