create database consultora;

use consultora;

create table tema (
cod_tema varchar (6) primary key,
palabra_clave varchar (20),
descripcion varchar (100),
fecha_inicio date,
fecha_fin date
);

create table operador (
id_operador int  not null auto_increment primary key,
nombre varchar (20),
apellido varchar (20)
);

create table seguimiento (
cod_seguimiento int not null auto_increment primary key,
cod_tema varchar (6),
id_operador int ,
mintv int,
mincentral int,
cant_notas int,
cant_tapas int,
apreciacion varchar (100),
foreign key (cod_tema) references tema(cod_tema),
foreign key (id_operador) references operador(id_operador)
);

create table redes_sociales (
cod_tema varchar(6),
red_social varchar (20) primary key,
-- cod_seguimiento int,
pub_apoyo int,
pub_rechazo int,
pub_neutral int,
replicas int,
mg int,
foreign key (cod_seguimiento) references seguimiento(cod_seguimiento),
foreign key (cod_tema) references tema(cod_tema)
);

select * from seguimiento;
insert into operador (nombre, apellido) values ("Ramiro","Capria");
insert into operador (nombre, apellido) values ("Gabriel","Gimenez");
insert into operador (nombre, apellido) values ("Francisco","Piccina");
