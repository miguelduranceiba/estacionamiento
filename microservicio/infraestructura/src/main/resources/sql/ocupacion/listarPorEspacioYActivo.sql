select id, id_conductor, id_vehiculo, id_espacio, id_reserva, total, fecha_inicio, fecha_fin
from ocupacion
where id_espacio = :idEspacio