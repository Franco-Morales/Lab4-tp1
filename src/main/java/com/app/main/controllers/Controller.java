package com.app.main.controllers;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;


public interface Controller <E>{
	
	public ResponseEntity<?> getAll(Pageable pageable) throws Exception;
	
	public ResponseEntity<?> getAll() throws Exception;
	
	public ResponseEntity<?> getOne(int id) throws Exception;
	
	public ResponseEntity<?>save(E entity) throws Exception;
	
	public ResponseEntity<?> update(E entity, int id) throws Exception;
	
	public ResponseEntity<?> delete(int id) throws Exception;
}
