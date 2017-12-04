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


insert into operador (nombre, apellido) values ("Ramiro","Capria");
insert into operador (nombre, apellido) values ("Gabriel","Gimenez");
insert into operador (nombre, apellido) values ("Francisco","Piccina");

insert into  medios_actuales values ("","Twitter","400","12000","600","300","3000","900","16000");
insert into  medios_actuales values ("","Facebook","2000","6000","260","200","400","800","12000");
insert into  medios_actuales values ("","Instagram","1200","800","160","500","190","700","10000");
