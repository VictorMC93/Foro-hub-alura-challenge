create table topicos(
    id bigint not null auto_increment,
    titulo varchar(200) not null,
    mensaje text,
    fecha_creacion datetime not null,
    activo tinyint not null,
    autor_id bigint not null,
    curso_id bigint,
    primary key(id),
    constraint fk_topicos_autor_id foreign key(autor_id) references usuarios(id),
    constraint fk_topicos_curso_id foreign key(curso_id) references cursos(id)
    );