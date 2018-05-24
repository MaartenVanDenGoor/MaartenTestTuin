package nl.maarten.ocp.m8javaio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirApp {

	public static void main(String[] args) {
		Path dir = Paths.get("./a/b/c/d");
        try {
 			Files.createDirectories(dir );
			Files.walk(Paths.get("."))
		//	     .filter(p -> p.toString().length()==1)
			     .forEach(System.out::println);
			// Verwijderen maar niet recursief gedaan, beetje link
			Files.delete(Paths.get("./a/b/c/d"));
			Files.delete(Paths.get("./a/b/c"));
			Files.delete(Paths.get("./a/b"));
			Files.delete(Paths.get("./a"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
