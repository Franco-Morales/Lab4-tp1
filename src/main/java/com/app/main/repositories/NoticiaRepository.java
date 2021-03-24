package com.app.main.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.app.main.entities.Noticia;

@Repository
public interface NoticiaRepository extends PagingAndSortingRepository<Noticia, Integer>{
	@Query(
		value = "SELECT * FROM noticias WHERE noticias.fk_empresa = :id  ORDER BY noticias.fecha DESC LIMIT 5",
		nativeQuery = true
	)
	List<Noticia> primerasCincoNoticias(int id);
	
	@Query("select n from Noticia n join fetch n.empresa e where e.id =?1 and n.titulo like %?2% or n.resumen like %?2%")
	List<Noticia> searchNoticiaByTituloOrResumenAndEmpresa(int id,String query);
	
}
