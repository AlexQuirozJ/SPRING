package com.init.products.rest;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/incidencias")//ruta de consulta	
public class Incidencias {
		
		@Autowired
		public Incidencias incidenciaService;
		
		@PostMapping("/alta")
		public ResponseEntity<Incidencia>registroIncidencia(@RequestBody Incidencia incidencia){
			Incidencia nuevaIncidencia = incidenciaService.registroIncidencia(incidencia);
			return ResponseEntity.ok(nuevaIncidencia);
		}
		
		
		@GetMapping("/{id}")
		public ResponseEntity<Incidencia>obtenerIncidencia(@PathVariable int id){
			Incidencia incidencia=incidenciaService.obtenerIncidencia(id);
			if(incidencia==null) {
				return ResponseEntity.notFound();
			}
			return ResponseEntity.ok(incidencia);
		}
		
		@GetMapping("/dia/{fecha}")
		public ResponseEntity<Incidencia>obtenerPorFecha(@PathVariable @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate fecha){
		List<Incidencia> incidencia=incidenciaService.obtenerPorFecha(fecha);
		return ResponseEntity.ok(incidencia);
}
		
		@GetMapping("/operador/{operadorId}")
		public ResponseEntity<Incidencia>obtenerPorOperador(@PathVariable int operadorId){
		List<Incidencia> incidencia=incidenciaService.obtenerPorOperador(operadorId);
		return ResponseEntity.ok(incidencia);
}
		
		@GetMapping("/Dashboard")
		public ResponseEntity<Dashboard>obtenerDashboard(){
		Dashboard dashboard=incidenciaService.obtenerDashboard();
		return ResponseEntity.ok(dashboard);
}
		
	}


	

