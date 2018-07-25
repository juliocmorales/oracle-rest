package com.neoris.oraclerestapi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;
import com.neoris.oraclerestapi.entity.Proveedor;
import com.neoris.oraclerestapi.service.IProveedorService;

@Controller
@RequestMapping("api")
public class ProveedorController {
	
	@Autowired
	private IProveedorService proveedorService;

	@GetMapping("proveedores")
	public ResponseEntity<List<Proveedor>> getAllProveedores() {
		Logger log = LoggerFactory.getLogger(ProveedorController.class);	
		List<Proveedor> list = proveedorService.getAllProveedores();
		
		
		
		 if( list.isEmpty()) {
			 log.error("Peticion: /api/proveedores  ERROR lista vacia" );
		 }
		 else {
			 log.info("Peticion: /api/proveedores  operacion correcta OK" );
		 }
		return new ResponseEntity<List<Proveedor>>(list, HttpStatus.OK);
	}
	
	@GetMapping("proveedor/{id}")
	public ResponseEntity<Proveedor> getProveedorById(@PathVariable("id") Integer id){
		Proveedor proveedor= proveedorService.getProveedorById(id);
		return new ResponseEntity<Proveedor>(proveedor,HttpStatus.OK);
		
	}
	
	@PostMapping("proveedor")
	public ResponseEntity<Void> addProveedor(@RequestBody Proveedor proveedor, UriComponentsBuilder builder) {
                boolean flag = proveedorService.addProveedor(proveedor);
                if (flag == false) {
        	    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
                }
                HttpHeaders headers = new HttpHeaders();
                headers.setLocation(builder.path("/proveedor/{id}").buildAndExpand(proveedor.getProveedorid()).toUri());
                return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("proveedor")
	public ResponseEntity<Proveedor> updateProveedor(@RequestBody Proveedor proveedor) {
		proveedorService.updateProveedor(proveedor);
		return new ResponseEntity<Proveedor>(proveedor, HttpStatus.OK);
	}
	@DeleteMapping("proveedor/{id}")
	public ResponseEntity<Void> deleteLibro(@PathVariable("id") Integer id) {
		proveedorService.deleteProveedor(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
}
