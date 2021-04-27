update conductor
set primer_nombre = :primerNombre,
	segundo_nombre = :segundoNombre,
	primer_apellido = :primerApellido,
	segundo_apellido = :segundoApellido,
	fecha_creacion = :fechaCreacion
where id = :id