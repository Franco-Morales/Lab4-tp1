package com.app.main.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.app.main.entities.Empresa;


@Repository
public interface EmpresaRepository extends PagingAndSortingRepository<Empresa, Integer>{ 
	
	@Modifying
	@Query("DELETE FROM Noticia n WHERE n.empresa.id = ?1")
	public int deleteNoticiasByEmpresa(int id);
}