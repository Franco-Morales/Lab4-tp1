package com.app.main.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.app.main.entities.Empresa;


@Repository
public interface EmpresaRepository extends PagingAndSortingRepository<Empresa, Integer>{ }
