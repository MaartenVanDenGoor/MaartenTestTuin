package nl.maarten.ocp.m9javaio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FindFilesContaining {

	public static void main(String[] args) {

		try (Stream<Path> stream = Files.list(Paths.get("."))) {
			stream.filter(Files::isRegularFile)   // Alleen bestanden
			      .filter(Files::isReadable)
//			      .peek(System.out::println)
			      .forEach(p -> {
			          	try {Files.lines(p)
					              .filter(line -> line.contains(args[0]))
					              .forEach(line -> System.out.println(p+" "+line));
				        } catch (IOException e) {
     					      e.printStackTrace();
				        }
			        });

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
/*
Maak een applicatie FindFilesContaining, die binnen de huidige directory zoekt naar bestanden 
die een opgegeven tekst bevatten. Toon de bestandsnamen en de gevonden regels. 
*/