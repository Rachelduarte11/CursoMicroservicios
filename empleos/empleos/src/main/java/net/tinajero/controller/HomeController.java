package net.tinajero.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.tinajero.model.VacanteModel;

@Controller
public class HomeController {
	
	@GetMapping("/tabla")
	public String mostrarTabla(Model model) {
		List<VacanteModel> lista = getVacantes();
		model.addAttribute("vacante", lista);
		return "vacantes";
	}
	
	@GetMapping("/detalle")
	public String mostrarDetalle(Model model) {
		VacanteModel vacante= new VacanteModel();
		vacante.setNombre("Ingeniero electronico");
		vacante.setDescripcion("Se solicita un Ingeniero electronico");
		vacante.setFecha(new Date());
		vacante.setSalario(4000);
		model.addAttribute("vacante", vacante);
		return "detalle";
	}
	
	@GetMapping("/listado")
	public String mostrarListado(Model model) {
		List<String> lista= new LinkedList<String>();
		lista.add("Ingenieria de sistemas");
		lista.add("Marketing");
		lista.add("Contador");
		model.addAttribute("empleos", lista);
		return "listado";
	}
	
	@GetMapping("/")
	public String mostrarHome(Model model) {
		/*model.addAttribute("mensaje", "holis");
		model.addAttribute("fecha", new Date());*/
		String nombre ="Auxiliar de contabilidad";
		Date fechaPub = new Date();
		double salario = 9000.00;
		boolean vigente =true;
		
		model.addAttribute("nombre", nombre);
		model.addAttribute("fecha", fechaPub);
		model.addAttribute("salario", salario);
		model.addAttribute("vigente", vigente);
		return "Home";
	}
	
	private List<VacanteModel> getVacantes(){
		SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");{
		List<VacanteModel> lista= new LinkedList<VacanteModel>();
		try {
			//Creamos la oferta de Trabajo 1
			VacanteModel vacante1 = new VacanteModel();
			vacante1.setId(1);
			vacante1.setNombre("Inginiero Civil");
			vacante1.setDescripcion("Solictamos Ing. Civil para diseñar puente peatonal");
			vacante1.setFecha(sdf.parse("08-02-2019"));
			vacante1.setSalario(8500.0);
			vacante1.setDestacado(1);

			//Creamos la oferta de Trabajo 2
			VacanteModel vacante2 = new VacanteModel();
			vacante2.setId(2);
			vacante2.setNombre("Contador publico");
			vacante2.setDescripcion("Empresa importante solicita contador con 5 años de experiencia");
			vacante2.setFecha(sdf.parse("09-02-2019"));
			vacante2.setSalario(12000.0);
			vacante2.setDestacado(1);

			//Creamos la oferta de Trabajo 3
			VacanteModel vacante3 = new VacanteModel();
			vacante3.setId(3);
			vacante3.setNombre("Inginiero Electronico");
			vacante3.setDescripcion("Empresa internacional solictamos Ing. mecanico para mantenimiento de la instalacion electrica");
			vacante3.setFecha(sdf.parse("10-02-2019"));
			vacante3.setSalario(10500.0);
			vacante3.setDestacado(1);

			//Creamos la oferta de Trabajo 4
			VacanteModel vacante4 = new VacanteModel();
			vacante4.setId(4);
			vacante4.setNombre("Diseñador grafico");
			vacante4.setDescripcion("Solicitamos Idiseñador grafico titulado para diseñar publicidad");
			vacante4.setFecha(sdf.parse("11-02-2019"));
			vacante4.setSalario(7500.0);
			vacante4.setDestacado(1);

			/*
			* Agregamos los 4 objetos de tipo Vacanbte a la lista ...
			*/
			lista.add(vacante1);
			lista.add(vacante2);
			lista.add(vacante3);
			lista.add(vacante4);
			}catch (ParseException e) {
			System.out.println("Error: " + e.getMessage());
			}
			return lista;
			}
		
		}
	}

