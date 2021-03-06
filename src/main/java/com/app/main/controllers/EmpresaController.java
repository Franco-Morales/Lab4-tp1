package com.app.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.main.entities.Empresa;
import com.app.main.servicies.EmpresaService;


@Controller
@RestController
@CrossOrigin("*")
@RequestMapping(path = "api/v1/crud/empresa")
public class EmpresaController implements com.app.main.controllers.Controller<Empresa>{
	@Autowired
	private EmpresaService service;

	
	@Override
	@GetMapping(path = "/")
	public ResponseEntity<?> getAll() throws Exception {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("\"Error\":\""+e.getMessage()+"\"");
		}
	}
	
	@Override
	@GetMapping(path = "/pagina")
	public ResponseEntity<?> getAll(Pageable pageable) throws Exception {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.getAll(pageable));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("\"Error\":\""+e.getMessage()+"\"");
		}
	}

	@Override
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> getOne(@PathVariable int id) throws Exception {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.getOne(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("\"Error\":\""+e.getMessage()+"\"");
		}
	}

	@Override
	@PostMapping(path = "/")
	public ResponseEntity<?> save(@RequestBody Empresa entity) throws Exception {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("\"Error\":\""+e.getMessage()+"\"");
		}
	}

	@Override
	@PutMapping(path = "/{id}")
	public ResponseEntity<?> update(@RequestBody Empresa entity, @PathVariable int id) throws Exception {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(service.update(entity, id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("\"Error\":\""+e.getMessage()+"\"");
		}
	}

	@Override
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) throws Exception {
		try {
			boolean isDet = this.service.delete(id);
			if (isDet) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body("\"Message\":\"Deleted\"");
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("\"Error\":\"Bad Request\"");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("\"Error\":\""+e.getMessage()+"\"");
		}
	}
}
