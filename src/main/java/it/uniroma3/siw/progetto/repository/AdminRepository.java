package it.uniroma3.siw.progetto.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.progetto.model.Admin;

public interface AdminRepository extends CrudRepository<Admin, Long>{
	
	public List<Admin> findAll();

	public Admin findByUsername(String username);

	

}
