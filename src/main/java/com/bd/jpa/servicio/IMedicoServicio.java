package com.bd.jpa.servicio;

import java.util.List;

import com.bd.jpa.modelo.TblMedico;


public interface IMedicoServicio {
	void RegistrarProducto(TblMedico tblprod);
	void EliminarProducto(TblMedico tblprod);
	List<TblMedico> ListadoProductos ();
	TblMedico BuscarporId(Integer id);
}
