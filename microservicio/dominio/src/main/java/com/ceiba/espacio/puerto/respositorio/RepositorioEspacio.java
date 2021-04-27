package com.ceiba.espacio.puerto.respositorio;

import com.ceiba.espacio.modelo.entidad.Espacio;

public interface RepositorioEspacio {

    /**
     * Permite crear un espacio en el sistema
     *
     * @param espacio
     * @return
     */
    Long crear(Espacio espacio);

    /**
     * Permite actualizar un espacio del sistema
     *
     * @param espacio
     * @return
     */
    int actualizar(Espacio espacio);

    /**
     * Permite inactivar un espacio en el sistema
     *
     * @param id
     * @return
     */
    void inactivar(long id);

    /**
     * Permite eliminar un espacio
     *
     * @param id
     */
    void eliminar(long id);

    /**
     * Permite actualizar el estado
     *
     * @param id
     * @param estado
     */
    void actualizarEstado(long id, int estado);

    /**
     * Permite validar si el espacio esta en ese estado
     *
     * @param idEspacio
     * @return
     */
    boolean estadoEspacio(long idEspacio, int estado);

    /**
     * Permite consultar el espacio por el id
     *
     * @param id
     * @return
     */
    Espacio consultarPorId(long id);
}
