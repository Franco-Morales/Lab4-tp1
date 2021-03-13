package com.app.main.servicies;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.main.entities.Noticia;
import com.app.main.repositories.NoticiaRepository;

@Service
public class NoticiaService implements com.app.main.servicies.Service<Noticia>{
	private NoticiaRepository repository;

	
	public NoticiaService(NoticiaRepository repository) {
		super();
		this.repository = repository;
	}
	

	@Override
	public List<Noticia> getAll() {
		List<Noticia> noticias = new ArrayList<Noticia>();
		
		for (Noticia noticia : this.repository.findAll()) {
			Noticia temp = new Noticia();
			
			temp.setContent(noticia.getContent());
			temp.setFecha(noticia.getFecha());
			temp.setImg(noticia.getImg());
			temp.setPublicado(noticia.isPublicado());
			temp.setResumen(noticia.getResumen());
			temp.setTitulo(noticia.getTitulo());
			
			temp.setEmpresa(noticia.getEmpresa());
			
			noticias.add(temp);
		}
		return noticias;
	}

	@Override
	public Noticia getOne(int id) {
		Optional<Noticia> optNoticia = this.repository.findById(id);
		Noticia temp = new Noticia();
		try {
			Noticia noticia = optNoticia.get();
			
			temp.setContent(noticia.getContent());
			temp.setFecha(noticia.getFecha());
			temp.setImg(noticia.getImg());
			temp.setPublicado(noticia.isPublicado());
			temp.setResumen(noticia.getResumen());
			temp.setTitulo(noticia.getTitulo());
			
			temp.setEmpresa(noticia.getEmpresa());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return temp;
	}

	@Override
	public Noticia save(Noticia t) {
		Noticia noticia = new Noticia();
		
		noticia.setContent(t.getContent());
		noticia.setFecha(Calendar.getInstance());
		noticia.setImg(t.getImg());
		noticia.setPublicado(t.isPublicado());
		noticia.setResumen(t.getResumen());
		noticia.setTitulo(t.getTitulo());
		
		noticia.setEmpresa(t.getEmpresa());
		try {
			this.repository.save(noticia);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		t.setId(noticia.getId());
		return t;
	}

	@Override
	public Noticia update(Noticia t, int id) {
		Optional<Noticia> optNoticia = this.repository.findById(id);
		Noticia temp = new Noticia();
		
		try {
			temp = optNoticia.get();
			
			temp.setContent(t.getContent());
			temp.setFecha(t.getFecha());
			temp.setImg(t.getImg());
			temp.setPublicado(t.isPublicado());
			temp.setResumen(t.getResumen());
			temp.setTitulo(t.getTitulo());
			
			temp.setEmpresa(t.getEmpresa());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		t.setId(temp.getId());
		return t;
	}

	@Override
	public boolean delete(int id) {
		try {
			this.repository.deleteById(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
}
