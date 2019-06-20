package it.uniroma3.siw.progetto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.progetto.model.Admin;
import it.uniroma3.siw.progetto.repository.AdminRepository;

@Service
public class AdminServices {

	@Autowired
	private AdminRepository adminRepository;
	
	@Transactional
	public List<Admin> tutti(){
		return (List<Admin>)adminRepository.findAll();
	}

	@Transactional
	public Admin trovaPerUsername(String username) {
		return adminRepository.findByUsername(username);
	}

	
}
