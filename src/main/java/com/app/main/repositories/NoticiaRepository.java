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
		value = "SELECT * FROM noticia ORDER BY	noticia.fecha DESC LIMIT 5",
		nativeQuery = true
	)
	List<Noticia> primerasCincoNoticias();
	
	@Query(
		value = "SELECT * FROM noticia WHERE noticia.titulo LIKE %:q% OR noticia.resumen LIKE %:q%",
		nativeQuery = true
	)
	List<Noticia> search(@Param("q") String query);
}
