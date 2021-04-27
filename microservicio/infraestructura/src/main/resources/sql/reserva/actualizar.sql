update reserva
set id_vehiculo = :idVehiculo,
	id_conductor = :idConductor,
	id_espacio = :idEspacio,
	estado = :estado,
	fecha_inicio = :fechaInicio,
	fecha_fin = :fechaFin
where id = :id