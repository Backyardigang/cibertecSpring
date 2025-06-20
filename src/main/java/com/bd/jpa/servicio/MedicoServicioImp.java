package com.bd.jpa.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.jpa.modelo.TblMedico;

import com.bd.jpa.repositorio.IMedicoRepositorio;


@Service
public class MedicoServicioImp implements IMedicoServicio{
	//aplicamos la inyeccion de dependencia...
	@Autowired
	private IMedicoRepositorio imedicorepositorio;
	@Override
	public void RegistrarProducto(TblMedico tblprod) {

		imedicorepositorio.save(tblprod);
		
	}//fin del metodo

	@Override
	public void EliminarProducto(TblMedico tblprod) {

		imedicorepositorio.deleteById(tblprod.getIDMEDICOT2());
		
	}//fin del metodo

	@Override
	public List<TblMedico> ListadoProductos() {

		return (List<TblMedico>) imedicorepositorio.findAll();
		
	}//fin del metodo

	@Override
	public TblMedico BuscarporId(Integer id) {
		
		return imedicorepositorio.findById(id).orElse(null);
		
	}//fin del metodo

}
