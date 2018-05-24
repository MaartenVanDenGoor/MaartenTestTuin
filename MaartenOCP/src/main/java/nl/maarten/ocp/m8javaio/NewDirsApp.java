package nl.maarten.ocp.m8javaio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NewDirsApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path dir = Paths.get("./new");
		Path abc = Paths.get("./a/b/c");
		dir = dir.resolve(abc).normalize();
		System.out.println(dir);
		try {
			Files.createDirectories(dir );
			Files.walk(Paths.get("."))
		     .filter(path -> path.getFileName().equals("new"))
            .forEach(path -> {
				try {
					Files.delete(path);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
/*
Maak een Path "new" aan   
• Maak daarvan een subdirectory van de huidige directory   
• Maak een Path "a/b/c/" aan   
• Plaats dat Path onder new m.b.v. resolve   
• Maak alle onderliggende subdirectories aan.   
• optioneel: Verwijder alle directories met behulp van Files.walk(...) 
*/