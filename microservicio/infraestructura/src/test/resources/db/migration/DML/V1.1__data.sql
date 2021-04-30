insert into usuario(nombre,clave,fecha_creacion) values('test','1234',now());

insert into espacio (nombre, estado, fecha_creacion) values ('M-1', 1, now());

insert into vehiculo (placa,id_tipo_vehiculo,fecha_creacion) values ('PLACA1', 1, now());

insert into conductor (tipo_identificacion, numero_identificacion, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido ,fecha_creacion) values ('CC', '123456789', 'CEIBA', null, 'SOFT', null , now());