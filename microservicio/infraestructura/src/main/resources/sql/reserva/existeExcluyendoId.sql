select count(1) from reserva where id <> :id and fecha_inicio <= :fechaFin and fecha_fin >= :fechaInicio and estado = :estado