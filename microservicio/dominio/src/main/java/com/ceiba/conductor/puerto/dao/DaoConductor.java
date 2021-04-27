package com.ceiba.conductor.puerto.dao;

import com.ceiba.conductor.modelo.dto.DtoConductor;
import com.ceiba.usuario.modelo.dto.DtoUsuario;

import java.util.List;

public interface DaoConductor {

	/**
	 * Permite listar conductores
	 * 
	 * @return los conductores
	 */
	List<DtoConductor> listar();
}
