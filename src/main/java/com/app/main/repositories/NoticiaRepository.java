package com.app.main.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.main.entities.Noticia;

@Repository
public interface NoticiaRepository extends PagingAndSortingRepository<Noticia, Integer>{
	@Query(
		value = "SELECT * FROM noticias WHERE noticias.publicado = true AND noticias.fk_empresa = :id ORDER BY noticias.fecha DESC LIMIT 5",
		nativeQuery = true
	)
	List<Noticia> primerasCincoNoticias(@Param("id") int id);
	
	@Query(
	value = "SELECT * FROM noticias WHERE noticias.publicado = true AND noticias.fk_empresa = :id AND noticias.titulo LIKE %:q% OR noticias.resumen LIKE %:q% ORDER BY noticias.fecha DESC LIMIT 20 "
	, nativeQuery = true)
	List<Noticia> searchNoticiaByTituloOrResumen(@Param("id") int id,@Param("q") String query);
	
	
}
