package com.app.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.main.entities.Noticia;

@Repository
public interface NoticiaRepository extends JpaRepository<Noticia, Integer>{

}
