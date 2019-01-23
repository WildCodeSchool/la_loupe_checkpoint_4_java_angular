package fr.checkpoint.back.controllers;

import java.io.File;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin( origins="*")
@RestController
public class FileUploaderController {
	
	@PostMapping("/upload")
	public boolean uploadFile(
			@RequestParam("file") MultipartFile transferFile
			) {
		try {
			// verification si le fichier est une image
			if( transfereFile.getContentType().startWith("image/")    )
			// /home/blh2hmr/Documents/WCS/Checkpoint-4/la_loupe_checkpoint_4_java_angular/back
			File tmp = new File(".").getCanonicalFile();
			return
		} catch (Exception param_Exception) {
			param_Exception.printStackTrace();
			return " ";
		}
	}
	
}
