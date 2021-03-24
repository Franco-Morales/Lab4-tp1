package com.app.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.main.entities.Noticia;
import com.app.main.servicies.NoticiaService;


@Controller
@RestController
@CrossOrigin("*")
@RequestMapping(path = "api/v1/crud/noticia")
public class NoticiaController implements com.app.main.controllers.Controller<Noticia>{
	@Autowired
	private NoticiaService service;

	
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
	
	@GetMapping(path = "/search/{id}/{query}")
	public ResponseEntity<?> searchByTituloOrResumen(@PathVariable int id,@PathVariable String query) throws Exception {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findNoticiaWithTitleOrResumen(id,query));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("\"Error\":\""+e.getMessage()+"\"");
		}
	}
	
	
	@GetMapping(path = "/{id}/firstFive")
	public ResponseEntity<?> firstFive(@PathVariable int id) throws Exception {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.fisrtFiveNoticias(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("\"Error\":\""+e.getMessage()+"\"");
		}
	}
	
	
	@Override
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> getOne(@PathVariable int id) throws Exception {
		try {
			Noticia noticia = service.getOne(id);
			if(noticia != null) {
				return ResponseEntity.status(HttpStatus.OK).body(noticia);
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("\"Error\":\""+e.getMessage()+"\"");
		}
	}
	
	@GetMapping(path = "/uploads/noticia/img/{id}")
	public ResponseEntity<?> verImg(@PathVariable int id)throws Exception{
		try {
			Noticia noticia = service.getOne(id);
			Resource img = new ByteArrayResource(noticia.getImg());
			System.out.println(noticia.getImg());
			return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(img);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception();
		}
	}

	@Override
	@PostMapping(path = "/")
	public ResponseEntity<?> save(@RequestBody Noticia entity) throws Exception {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("\"Error\":\""+e.getMessage()+"\"");
		}
	}
	
	@PostMapping("/crear-con-foto")
	public ResponseEntity<?> saveWithFoto(Noticia entity, @RequestParam MultipartFile archivo) throws Exception {
		try {
			if(!archivo.isEmpty()) {
				entity.setImg(archivo.getBytes());
			}
			return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("\"Error\":\""+e.getMessage()+"\"");
		}
	}


	@Override
	@PutMapping(path = "/{id}")
	public ResponseEntity<?> update(@RequestBody Noticia entity, @PathVariable int id) throws Exception {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(service.update(entity, id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("\"Error\":\""+e.getMessage()+"\"");
		}
	}
	
	@PutMapping(path = "/editar-con-foto/{id}")
	public ResponseEntity<?> updateWithFoto(Noticia entity, @PathVariable int id, @RequestParam MultipartFile archivo) throws Exception {
		try {
			if(!archivo.isEmpty()) {
				entity.setImg(archivo.getBytes());
			}
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