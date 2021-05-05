select id, id_conductor, id_vehiculo, id_espacio, estado, fecha_inicio, fecha_fin, fecha_creacion
from reserva
where id = :id