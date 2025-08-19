package alura.foro.forohub.domain.topico;

import alura.foro.forohub.domain.curso.CursoRepository;
import alura.foro.forohub.domain.topico.record.DatosDetalleTopico;
import alura.foro.forohub.domain.topico.record.DatosRegistroTopico;
import alura.foro.forohub.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    TopicoRepository topicoRepository;

    @Autowired
    CursoRepository cursoRepository;

    public DatosDetalleTopico crear(DatosRegistroTopico datos){
        var usuario=usuarioRepository.getReferenceById(datos.autor_id());
        var curso=cursoRepository.findById(datos.curso_id()).get();
        var topico=new Topico(null,true, datos.titulo(), datos.mensaje(), datos.fecha_creacion(),usuario,curso);
        topicoRepository.save(topico);
        return new DatosDetalleTopico(topico);
    }

//    public TopicData publish(@RequestBody @Valid TopicData topicData)
//    {
//        var user = usuarioRepository.findById(topicData.usuario()).get();
//        Topico topic;
//        topic = new Topico(null,null, topicData.titulo(), topicData.mensaje(),topicData.fecha(),usuarioRepository.getReferenceById(topicData.usuario()));
//
//        topicoRepository.save(topic);
//        return new TopicData(topic);}
//    public DatosListaTopico registro(DatosRegistroTopico datos){
//        Optional<Usuario> usuario=usuarioRepository.findById(datos.autor_id());
//        Optional<Curso> curso=cursoRepository.findById(datos.curso_id());
//    }
}