package com.app.main.servicies;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.main.entities.Noticia;
import com.app.main.repositories.NoticiaRepository;


@Service
public class NoticiaService implements com.app.main.servicies.Service<Noticia>{
	
	@Autowired
	private NoticiaRepository repository;

	
	@Override
	@Transactional(readOnly = true)
	public List<Noticia> getAll() throws Exception {
		try {
			List<Noticia> noticias = new ArrayList<Noticia>();
			
			for (Noticia noticia : repository.findAll()) {
				Noticia temp = new Noticia();
				
				temp.setContent(noticia.getContent());
				temp.setFecha(noticia.getFecha());
				temp.setId(noticia.getId());
				temp.setImg(noticia.getImg());
				temp.setPublicado(noticia.isPublicado());
				temp.setResumen(noticia.getResumen());
				temp.setTitulo(noticia.getTitulo());
				
				temp.setEmpresa(noticia.getEmpresa());
				
				noticias.add(temp);
			}
			
			return noticias;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Noticia getOne(int id) throws Exception {
		try {
			Optional<Noticia> optNoticia = repository.findById(id);
			if(optNoticia.isEmpty()) {
				return null;
			} else {
				return optNoticia.get();
			}
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public Noticia save(Noticia entity) throws Exception {
		try {
			Noticia noticia = new Noticia();
			
			noticia.setContent(entity.getContent());
			noticia.setFecha(new Date());
			noticia.setImg(entity.getImg());
			noticia.setPublicado(entity.isPublicado());
			noticia.setResumen(entity.getResumen());
			noticia.setTitulo(entity.getTitulo());
			
			noticia.setEmpresa(entity.getEmpresa());
			
			entity = repository.save(noticia);
			return entity;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public Noticia update(Noticia entity, int id) throws Exception {
		Optional<Noticia> optNoticia = repository.findById(id);
		Noticia temp = new Noticia() ;
		try {
			temp = optNoticia.get();
			temp.setContent(entity.getContent());
			temp.setFecha(new Date());
			temp.setImg(entity.getImg());
			temp.setPublicado(entity.isPublicado());
			temp.setResumen(entity.getResumen());
			temp.setTitulo(entity.getTitulo());
			
			temp.setEmpresa(entity.getEmpresa());
			repository.save(temp);
			entity.setId(temp.getId());
			return entity;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public boolean delete(int id) throws Exception {
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

	
	//Search y Limit
	
	@Transactional(readOnly = true)
	public List<Noticia> search(String query) throws Exception {
		try {
			List<Noticia> noticias = new ArrayList<Noticia>();
			
			for (Noticia noticia : repository.search(query)) {
				Noticia temp = new Noticia();
				
				temp.setContent(noticia.getContent());
				temp.setFecha(noticia.getFecha());
				temp.setId(noticia.getId());
				temp.setImg(noticia.getImg());
				temp.setPublicado(noticia.isPublicado());
				temp.setResumen(noticia.getResumen());
				temp.setTitulo(noticia.getTitulo());
				
				temp.setEmpresa(noticia.getEmpresa());
				
				noticias.add(temp);
			}
			return noticias;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@Transactional(readOnly = true)
	public List<Noticia> fisrtFiveNoticias() throws Exception {
		try {
			List<Noticia> noticias = new ArrayList<Noticia>();
			
			for (Noticia noticia : repository.primerasCincoNoticias()) {
				Noticia temp = new Noticia();
				
				temp.setContent(noticia.getContent());
				temp.setFecha(noticia.getFecha());
				temp.setId(noticia.getId());
				temp.setImg(noticia.getImg());
				temp.setPublicado(noticia.isPublicado());
				temp.setResumen(noticia.getResumen());
				temp.setTitulo(noticia.getTitulo());
				
				temp.setEmpresa(noticia.getEmpresa());
				
				noticias.add(temp);
			}
			return noticias;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
