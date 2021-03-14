package com.app.main.entities;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Noticia implements Serializable{
	
	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String titulo;
	private String resumen;
	private String img;
	private String content;
	private boolean publicado;
	
	@Temporal(TemporalType.DATE)
	@Column(updatable = false, nullable = false)
	private Calendar fecha;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "fk_empresa")
	private Empresa empresa;

	
	public Noticia() { }
	
	public Noticia(String titulo, String resumen, String img, String content, boolean publicado, Calendar fecha, Empresa empresa) {
		this.titulo = titulo;
		this.resumen = resumen;
		this.img = img;
		this.content = content;
		this.publicado = publicado;
		this.fecha = fecha;
		this.empresa = empresa;
	}

	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		 this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getResumen() {
		return resumen;
	}
	public void setResumen(String resumen) {
		this.resumen = resumen;
	}


	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}


	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}


	public boolean isPublicado() {
		return publicado;
	}
	public void setPublicado(boolean publicado) {
		this.publicado = publicado;
	}


	public Calendar getFecha() {
		return fecha;
	}
	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
}
