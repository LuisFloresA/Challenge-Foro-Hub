create table medicos(

    id bigint not null auto_increment,
    titulo varchar(100) not null unique,
    mensaje varchar(100) not null unique,
    fechaCreacion varchar(100) not null,
    estado char(100) not null,
    autor varchar(100) not null,
    curso varchar(100) not null,

    primary key(id)

);