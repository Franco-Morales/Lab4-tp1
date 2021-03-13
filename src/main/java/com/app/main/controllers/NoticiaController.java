package com.app.main.controllers;

import java.util.List;

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

import com.app.main.entities.Noticia;
import com.app.main.servicies.NoticiaService;


@Controller
@RestController
@RequestMapping(path = "api/v1/noticias")
public class NoticiaController implements com.app.main.controllers.Controller<Noticia>{
	private NoticiaService service;

	
	public NoticiaController(NoticiaService service) {
		this.service = service;
	}

	
	@Override
	@GetMapping(path = "/")
	@CrossOrigin("*")
	public List<Noticia> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(service.getAll()).getBody();
	}


	@Override
	@GetMapping(path = "/{id}")
	@CrossOrigin("*")
	public Noticia getOne(int id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.getOne(id)).getBody();
	}


	@Override
	@PostMapping(path = "/")
	@CrossOrigin("*")
	public ResponseEntity save(@RequestBody Noticia t) {
		Noticia noticia = this.service.save(t);
		
		if(noticia.getId() != 0) {
			return ResponseEntity.status(HttpStatus.CREATED).body(noticia);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("\"Error\":\"Bad Request\"");
		}
	}


	@Override
	@PutMapping(path = "/{id}")
	@CrossOrigin("*")
	public ResponseEntity update(@RequestBody Noticia t, @PathVariable int id) {
		Noticia noticia = service.update(t, id);
		
		if(noticia.getId() != 0) {
			return ResponseEntity.status(HttpStatus.CREATED).body(noticia);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("\"Error\":\"Bad Request\"");
		}
	}

	@Override
	@DeleteMapping(path = "/{id}")
	@CrossOrigin("*")
	public ResponseEntity delete(@PathVariable int id) {
		boolean isDet = this.service.delete(id);
		
		if (isDet) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("\"Message\":\"Deleted\"");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("\"Error\":\"Bad Request\"");
		}
	}
}