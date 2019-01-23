package fr.wildcodeschool.Checkpoint4.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@CrossOrigin(origins = "*")
@RestController
public class FileUploadController {

	@PostMapping("/songs/upload")
	public String handleFileUpload(@RequestParam("file") MultipartFile transferedFile) {

		try {
			// retrouve le chemin sur le disque dur de l'application java
			// chez moi c'est dans D:/java_projects/myquizz/back
			File tmp = new File(".").getCanonicalFile();

			// on ajoute au chemin en question le nom original du fichier
			// et on obtient le nouveau chemin sur le disque
			String destination = tmp.getPath() + "/" + transferedFile.getOriginalFilename();

			// on crée un nouvel objet de type File et on lui passe le chemin
			// que l'on vient de construire ( en gros cela représente notre nouveau
			// fichier )
			File data = new File(destination);

			// et on transfère le fichier envoyé par le client dans le nouveau fichier
			// crée, ce faisant on crée une copie du fichier d'origine dans le
			// répertoire que l'on veut.
			transferedFile.transferTo(data);

			// et on retourne le chemin sur le disque
			return destination;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ko";
		}

	}

}