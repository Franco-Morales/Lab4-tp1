package com.app.main.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Empresa implements Serializable{
	
	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String denominacion;
	private String telefono;
	private String horario;
	private String quienSomos;
	private float lat;
	private float lon;
	private String domicilio;
	private String email;
	
	
	public Empresa() { }

	public Empresa(String denominacion, String telefono, String horario, String quienSomos, float lat, float lon, String domicilio, String email) {
		this.denominacion = denominacion;
		this.telefono = telefono;
		this.horario = horario;
		this.quienSomos = quienSomos;
		this.lat = lat;
		this.lon = lon;
		this.domicilio = domicilio;
		this.email = email;
	}
	
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		 this.id = id;
	}
	
	public String getDenominacion() {
		return denominacion;
	}
	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}
	
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	public String getQuienSomos() {
		return quienSomos;
	}
	public void setQuienSomos(String quienSomos) {
		this.quienSomos = quienSomos;
	}
	
	public float getLat() {
		return lat;
	}
	public void setLat(float lat) {
		this.lat = lat;
	}
	
	public float getLon() {
		return lon;
	}
	public void setLon(float lon) {
		this.lon = lon;
	}
	
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
