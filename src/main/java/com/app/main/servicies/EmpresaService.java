package com.app.main.servicies;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.main.entities.Empresa;
import com.app.main.repositories.EmpresaRepository;

@Service
public class EmpresaService implements com.app.main.servicies.Service<Empresa>{
	
	private EmpresaRepository repository;
	
	
	public EmpresaService(EmpresaRepository repository) {
		this.repository = repository;
	}
	
	
	@Override
	public List<Empresa> getAll() {
		List<Empresa> empresas = new ArrayList<Empresa>();
		
		for (Empresa emp : this.repository.findAll()) {
			Empresa temp = new Empresa();
			
			temp.setDenominacion(emp.getDenominacion());
			temp.setDomicilio(emp.getDomicilio());
			temp.setEmail(emp.getEmail());
			temp.setHorario(emp.getEmail());
			temp.setLat(emp.getLat());
			temp.setLon(emp.getLon());
			temp.setQuienSomos(emp.getQuienSomos());
			temp.setTelefono(emp.getTelefono());
			
			empresas.add(temp);
		}
		
		return empresas;
	}

	@Override
	public Empresa getOne(int id) {
		Optional<Empresa> optEMpresa = this.repository.findById(id);
		Empresa temp = new Empresa();
		
		try {
			Empresa emp = optEMpresa.get();
			
			temp.setDenominacion(emp.getDenominacion());
			temp.setDomicilio(emp.getDomicilio());
			temp.setEmail(emp.getEmail());
			temp.setHorario(emp.getEmail());
			temp.setLat(emp.getLat());
			temp.setLon(emp.getLon());
			temp.setQuienSomos(emp.getQuienSomos());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return temp;
	}

	@Override
	public Empresa save(Empresa t) {
		Empresa emp = new Empresa();
		
		emp.setDenominacion(t.getDenominacion());
		emp.setDomicilio(t.getDomicilio());
		emp.setEmail(t.getEmail());
		emp.setHorario(t.getHorario());
		emp.setLat(t.getLat());
		emp.setLon(t.getLon());
		emp.setQuienSomos(t.getQuienSomos());
		emp.setTelefono(t.getTelefono());
		
		try {
			this.repository.save(emp);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		t.setId(emp.getId());
		
		return t;
	}

	@Override
	public Empresa update(Empresa t, int id) {
		Optional<Empresa> optEmp = this.repository.findById(id);
		Empresa temp = new Empresa();
		
		try {
			temp = optEmp.get();
			
			temp.setDenominacion(t.getDenominacion());
			temp.setDomicilio(t.getDomicilio());
			temp.setEmail(t.getEmail());
			temp.setHorario(t.getHorario());
			temp.setLat(t.getLat());
			temp.setLon(t.getLon());
			temp.setQuienSomos(t.getQuienSomos());
			temp.setTelefono(t.getTelefono());
			
			this.repository.save(temp);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			temp.setId(0);
		}
		temp.setId(temp.getId());
		return t;
	}

	@Override
	public boolean delete(int id) {
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
