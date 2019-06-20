package it.uniroma3.siw.progetto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.uniroma3.siw.progetto.model.FileModel;

@Repository
public interface FilesRepository extends JpaRepository<FileModel, Long> {

	

}
