package it.uniroma3.siw.progetto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import it.uniroma3.siw.progetto.model.Album;
import it.uniroma3.siw.progetto.model.Fotografia;
import it.uniroma3.siw.progetto.model.Fotografo;
import it.uniroma3.siw.progetto.repository.FilesRepository;
import it.uniroma3.siw.progetto.repository.FotografoRepository;
import it.uniroma3.siw.progetto.repository.AdminRepository;


@SpringBootApplication
@EnableJpaRepositories("it.uniroma3.siw.*")
@EntityScan("it.uniroma3.siw.*")
public class ProgettoApplication implements CommandLineRunner{
	
	
	@Autowired(required=true)
	FilesRepository fileRepository;
	
	@Autowired(required=true)
	AdminRepository utenteRepository;
	
	@Autowired(required=true)
	FotografoRepository fotografoRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProgettoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		/*ClassPathResource firstImage = new ClassPathResource("static/orso.jpg");
		byte[] arrayData = new byte[(int) firstImage.contentLength()];
		firstImage.getInputStream().read(arrayData);
		FileModel firstModel = new FileModel("orso", "jpg", arrayData);
		
		ClassPathResource secondImage = new ClassPathResource("static/lemure-balla.jpg");
		arrayData = new byte[(int) secondImage.contentLength()];
		secondImage.getInputStream().read(arrayData);
		FileModel secondModel = new FileModel("lemure-balla", "jpg", arrayData);
		
		ClassPathResource thirdImage = new ClassPathResource("static/leone.jpg");
		arrayData = new byte[(int) thirdImage.contentLength()];
		thirdImage.getInputStream().read(arrayData);
		FileModel thirdModel = new FileModel("leone", "jpg", arrayData);*/
		
		//store files
		/*fileRepository.saveAll(Arrays.asList(firstModel,secondModel));
		
		//retrieve images
		for(FileModel imageModel: fileRepository.findAll()) {
			Files.write(Paths.get("download/" + imageModel.getName() + "." + imageModel.getType()), imageModel.getPic());
		}
		
		/*Utente u1 = new Utente("Mario", "Rossi", "mariorossi", "psw", "GUEST");
		Utente u2 = new Utente("Mario", "Verdi", "marioverdi", "psw", "ADMIN");
		utenteRepository.save(u1);
		utenteRepository.save(u2);*/
		
		/*Fotografia f1 = new Fotografia("orso", "https://upload.wikimedia.org/wikipedia/commons/7/79/2010-brown-bear.jpg", 8.2);
		Fotografia f2 = new Fotografia("lemure", "https://upload.wikimedia.org/wikipedia/commons/5/53/Propithecus_verreauxi_2.JPG", 9.2);
		Fotografia f3 = new Fotografia("leone", "https://upload.wikimedia.org/wikipedia/commons/f/fa/2012_Lion_Gemsbokvlakte.jpg", 9.7);
		Fotografia f4 = new Fotografia("prova1", "https://www.gstatic.com/webp/gallery/1.jpg", 13.2);
		Fotografia f5 = new Fotografia("prova2", "https://www.gstatic.com/webp/gallery/2.webp", 13.0);
		Fotografia f6 = new Fotografia("prova3", "https://www.gstatic.com/webp/gallery/3.webp", 10.0);
		Fotografia f7 = new Fotografia("prova4", "https://www.gstatic.com/webp/gallery/4.webp", 5.7);
		Fotografia f8 = new Fotografia("prova5", "https://www.gstatic.com/webp/gallery/5.webp", 6.8);
		Fotografia f9 = new Fotografia("prova6", "https://picsum.photos/id/237/200/300", 3.5);
		List<Fotografia> foto = new ArrayList<>();
		foto.add(f1);
		foto.add(f2);
		foto.add(f3);
		Album a1 = new Album(foto, "ORSO", "orso");
		List<Fotografia> foto2 = new ArrayList<>();
		foto2.add(f4);
		foto2.add(f5);
		foto2.add(f6);
		Album a2 = new Album(foto2, "LEMURE", "lemure");
		List<Fotografia> foto3 = new ArrayList<>();
		foto3.add(f7);
		foto3.add(f8);
		foto3.add(f9);
		Album a3 = new Album(foto3, "LEONE", "leone");
		
		Fotografo fo1 = new Fotografo("Alessandro","Rossi", Arrays.asList(a1));
		Fotografo fo2 = new Fotografo("Paolo", "Verdi",Arrays.asList(a2));
		Fotografo fo3 = new Fotografo("Francesco", "Bianchi", Arrays.asList(a3));
		fotografoRepository.saveAll(Arrays.asList(fo1,fo2,fo3));*/
	
		
		
	}

}
