package com.app.main.servicies;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.main.entities.Empresa;
import com.app.main.repositories.EmpresaRepository;

@Service
public class EmpresaService implements com.app.main.servicies.Service<Empresa>{
	@Autowired
	private EmpresaRepository repository;
	
	
	@Override
	@Transactional
	public List<Empresa> getAll() throws Exception{
		try {
			List<Empresa> empresas = new ArrayList<Empresa>();
			
			for (Empresa emp : repository.findAll()) {
				Empresa temp = new Empresa();
				
				temp.setDenominacion(emp.getDenominacion());
				temp.setDomicilio(emp.getDomicilio());
				temp.setEmail(emp.getEmail());
				temp.setHorario(emp.getHorario());
				temp.setQuienSomos(emp.getQuienSomos());
				temp.setLat(emp.getLat());
				temp.setLon(emp.getLon());
				temp.setTelefono(emp.getTelefono());
				temp.setId(emp.getId());
				
				empresas.add(temp);
			}
			return empresas;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public Empresa getOne(int id) throws Exception{
		try {
			Optional<Empresa> optEmpresa = repository.findById(id);
			return optEmpresa.get();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public Empresa save(Empresa entity) throws Exception{
		try {
			Empresa emp = new Empresa();
			
			emp.setDenominacion(entity.getDenominacion());
			emp.setDomicilio(entity.getDomicilio());
			emp.setEmail(entity.getEmail());
			emp.setHorario(entity.getHorario());
			emp.setQuienSomos(entity.getQuienSomos());
			emp.setLat(entity.getLat());
			emp.setLon(entity.getLon());
			emp.setTelefono(entity.getTelefono());
			
			entity = repository.save(emp);
			return entity;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}

	@Override
	@Transactional
	public Empresa update(Empresa entity, int id) throws Exception{
		Optional<Empresa> optEmpresa = repository.findById(id);
		Empresa temp = new Empresa();
		try {
			temp = optEmpresa.get();
			
			temp.setDenominacion(entity.getDenominacion());
			temp.setDomicilio(entity.getDomicilio());
			temp.setEmail(entity.getEmail());
			temp.setHorario(entity.getHorario());
			temp.setQuienSomos(entity.getQuienSomos());
			temp.setLat(entity.getLat());
			temp.setLon(entity.getLon());
			temp.setTelefono(entity.getTelefono());
			
			temp = repository.save(temp);
			entity.setId(temp.getId());
			return entity;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}

	@Override
	@Transactional
	public boolean delete(int id) throws Exception{
		try {
			if (repository.existsById(id)) {
				repository.deleteById(id);
				return true;
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
