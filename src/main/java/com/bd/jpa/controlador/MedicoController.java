package com.bd.jpa.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bd.jpa.modelo.TblMedico;

import com.bd.jpa.servicio.IMedicoServicio;

@Controller
@RequestMapping("/vistas")
public class MedicoController {
	//inyeccion de dependencias
	@Autowired
	private IMedicoServicio imedicoservicio;
	@GetMapping("ListadoProductos")
	public String ListadoProducto(Model modelo) {
		
		//Recuperamos los datos de la bd
		List<TblMedico> listado=imedicoservicio.ListadoProductos();
		//enviamos hacia la vista
		modelo.addAttribute("listado",listado);
		return "/vistas/ListadoProducto";
		
		
	}//fin del metodo ListadoProducto
	
	//creamos el metodo para registrar...
		@GetMapping("/RegistrarProducto")
		public String RegistrarProducto(Model modelo) {
			//realizamos la respectiva instancia....
			TblMedico tblprod=new TblMedico();
			//enviamos hacia la vista
			modelo.addAttribute("regproducto",tblprod);
			//retornamos el formulario
			return "/vistas/RegistrarProducto";
			
	}//fin del metodo
		
	@PostMapping("/GuardarProducto")
	public String GuardarProducto(@ModelAttribute TblMedico tblprod, Model modelo) {
		imedicoservicio.RegistrarProducto(tblprod);
		
		System.out.println("Dato registrado en la BD!!!!!1");
		
		return "redirect:/vistas/ListadoProductos";
	} // fin del metodo.....

}//fin del controller
