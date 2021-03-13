package com.app.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.main.entities.Empresa;


@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer>{

}
