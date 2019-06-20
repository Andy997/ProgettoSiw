package it.uniroma3.siw.progetto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import it.uniroma3.siw.progetto.model.Admin;
import it.uniroma3.siw.progetto.model.Album;
import it.uniroma3.siw.progetto.model.Fotografia;
import it.uniroma3.siw.progetto.model.Fotografo;
import it.uniroma3.siw.progetto.repository.AdminRepository;
import it.uniroma3.siw.progetto.repository.FotografoRepository;
import it.uniroma3.siw.progetto.repository.RichiestaRepository;
import it.uniroma3.siw.progetto.services.RichiestaServices;

@Component
public class DBPopulation implements ApplicationRunner {

	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private FotografoRepository fotografoRepository;

	@Autowired
	private RichiestaServices richiestaServices;


	public void run(ApplicationArguments args) throws Exception {
		this.deleteAll();
		this.populateDB();
	}

	private void deleteAll() {
		System.out.println("Deleting all users from DB...");
		adminRepository.deleteAll();
		richiestaServices.deleteAll();
		fotografoRepository.deleteAll();
		
		System.out.println("Done");
	}

	private void populateDB() throws IOException, InterruptedException {

		System.out.println("Storing users...");

		Admin admin = new Admin("Mario", "Rossi", "mariorossi", "psw");
		admin = this.adminRepository.save(admin);
		Fotografia f1 = new Fotografia("orso", "https://truenorth-6aa7.kxcdn.com/wp-content/uploads/2013/12/KILLER-WOODS-500px.jpg", 8.20);
		Fotografia f2 = new Fotografia("lemure", "https://upload.wikimedia.org/wikipedia/commons/5/53/Propithecus_verreauxi_2.JPG", 9.2);
		Fotografia f3 = new Fotografia("leone", "https://upload.wikimedia.org/wikipedia/commons/f/fa/2012_Lion_Gemsbokvlakte.jpg", 9.75);
		Fotografia f4 = new Fotografia("prova1", "https://i.pinimg.com/originals/38/59/66/38596658d9670d77801fc9a4591e6c9c.jpg", 13.2);
		Fotografia f5 = new Fotografia("prova2", "https://www.gstatic.com/webp/gallery/2.webp", 13.07);
		Fotografia f6 = new Fotografia("prova3", "https://www.gstatic.com/webp/gallery/3.webp", 10.0);
		Fotografia f7 = new Fotografia("prova4", "https://robvisserphotography.nl/wp-content/uploads/2018/09/DSC_0110-2-500px-500x500.jpg", 5.72);
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

		Fotografo fo1 = new Fotografo("Alessandro", "Rossi" ,Arrays.asList(a1));
		Fotografo fo2 = new Fotografo("Paolo", "Verdi", Arrays.asList(a2));
		Fotografo fo3 = new Fotografo("Francesco", "Bianchi", Arrays.asList(a3));
		fotografoRepository.saveAll(Arrays.asList(fo1,fo2,fo3));




		System.out.println("Done.\n");
	}
}
