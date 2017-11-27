create database consultora;

use consultora;

create table tema (
cod_tema varchar (6) primary key,
palabra_clave varchar (20),
descripcion varchar (100),
fecha_inicio date,
fecha_fin date
);

create table medios_tradicionales (
cod_tema varchar (6),
id_operador int ,
mintv int,
mincentral int,
cant_notas int,
cant_tapas int,
apreciacion varchar (100),
foreign key (cod_tema) references tema(cod_tema) on delete cascade,
foreign key (id_operador) references operador(id_operador)
);

create table medios_actuales (
cod_tema varchar(6),
red_social varchar (20) primary key,
pub_apoyo int,
mg_apoyo int,
pub_rechazo int,
mg_rechazo int,
pub_neutral int,
mg_neutral int,
replicas int,
foreign key (cod_tema) references tema(cod_tema) on delete cascade
);

create table operador (
id_operador int  not null auto_increment primary key,
nombre varchar (20),
apellido varchar (20)
);

insert into operador (nombre, apellido) values ("Ramiro","Capria");
insert into operador (nombre, apellido) values ("Gabriel","Gimenez");
insert into operador (nombre, apellido) values ("Francisco","Piccina");
