package com.app.main.servicies;

import java.util.List;

public interface Service <T> {
	public List<T> getAll();
	
	public T getOne(int id);
	
	public T save(T t);
	
	public T update(T t, int id);
	
	public boolean delete(int id);
}
