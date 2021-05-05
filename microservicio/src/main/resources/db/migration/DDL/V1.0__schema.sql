create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table conductor (
 id int(11) not null auto_increment,
 tipo_identificacion varchar(10) not null,
 numero_identificacion varchar(20) not null,
 primer_nombre varchar(50) not null,
 segundo_nombre varchar(50) null,
 primer_apellido varchar(50) not null,
 segundo_apellido varchar(50) null,
 fecha_creacion datetime null,
 primary key (id)
);

create table espacio (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 estado smallint(6) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table tipo_vehiculo (
id int(11) not null,
valor decimal(8,2) not null,
primary key (id)
);

create table vehiculo (
 id int(11) not null auto_increment,
 placa varchar(10) not null,
 id_tipo_vehiculo int(11) not null,
 fecha_creacion datetime null,
 primary key (id),
 foreign key (id_tipo_vehiculo) references tipo_vehiculo(id)
);

create table reserva (
 id int(11) not null auto_increment,
 id_conductor int(11) not null,
 id_vehiculo int(11) not null,
 id_espacio int(11) not null,
 estado smallint(6) not null,
 fecha_inicio datetime not null,
 fecha_fin datetime not null,
 fecha_creacion datetime not null,
 primary key (id),
 constraint fk_reserva_conductor foreign key (id_conductor) references conductor(id),
 constraint fk_reserva_vehiculo foreign key (id_vehiculo) references vehiculo(id),
 foreign key (id_espacio) references espacio(id)
);

create table ocupacion (
 id int(11) not null auto_increment,
 id_conductor int(11) not null,
 id_vehiculo int(11) not null,
 id_espacio int(11) not null,
 id_reserva int(11) null,
 total decimal(10,2) null,
 fecha_inicio datetime null,
 fecha_fin datetime null,
 primary key (id),
 constraint fk_ocupacion_conductor foreign key (id_conductor) references conductor(id),
 constraint fk_ocupacion_vehiculo foreign key (id_vehiculo) references vehiculo(id),
 foreign key (id_espacio) references espacio(id),
 foreign key (id_reserva) references reserva(id)
);


insert into tipo_vehiculo (id,  valor) values ( 1, 5000);
insert into tipo_vehiculo (id, valor) values ( 2, 1000);

create table festivo (
  id int(11) not null auto_increment,
  dia datetime not null,
  primary key (id)
);

insert into festivo (dia) values ('2021-01-01');
insert into festivo (dia) values ('2021-01-11');
insert into festivo (dia) values ('2021-03-22');
insert into festivo (dia) values ('2021-04-01');
insert into festivo (dia) values ('2021-04-02');
insert into festivo (dia) values ('2021-05-01');
insert into festivo (dia) values ('2021-05-17');
insert into festivo (dia) values ('2021-06-03');
insert into festivo (dia) values ('2021-06-14');
insert into festivo (dia) values ('2021-07-05');
insert into festivo (dia) values ('2021-07-20');
insert into festivo (dia) values ('2021-08-07');
insert into festivo (dia) values ('2021-08-16');
insert into festivo (dia) values ('2021-10-18');
insert into festivo (dia) values ('2021-11-01');
insert into festivo (dia) values ('2021-11-15');
insert into festivo (dia) values ('2021-12-08');
insert into festivo (dia) values ('2021-12-25');