package com.app.main.servicies;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface Service <E> {
	
	public Page<E> getAll(Pageable pageable) throws Exception;
	
	public List<E> getAll() throws Exception;
	
	public E getOne(int id) throws Exception;
	
	public E save(E entity) throws Exception;
	
	public E update(E entity, int id) throws Exception;
	
	public boolean delete(int id) throws Exception;
}
