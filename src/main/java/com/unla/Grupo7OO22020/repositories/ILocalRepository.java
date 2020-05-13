package com.unla.Grupo7OO22020.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.Grupo7OO22020.entities.Local;


@Repository("localRepository")
public interface ILocalRepository extends JpaRepository<Local, Serializable>{	
	public List<Local> findAll();
	public Local findByIdLocal(long id);
}
