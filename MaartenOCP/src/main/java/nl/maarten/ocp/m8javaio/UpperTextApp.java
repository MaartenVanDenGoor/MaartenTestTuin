package nl.maarten.ocp.m8javaio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class UpperTextApp {

	public static void main(String[] args) {
       Path pin = Paths.get("c:\\tmp\\input.txt");
        try {
		  Files.lines(pin)
		       .forEach(line -> writeS(line));
		} catch (IOException e) {
			e.printStackTrace();
		}
       //  OF
       try (BufferedReader br = new BufferedReader(new FileReader("c:\\tmp\\input.txt"));
    		FileOutputStream fos = new FileOutputStream(new File(".\\output2.txt"));
    		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
    		) {
    	   String line = br.readLine();
    	   while (line!=null) {
    		   bw.write(line.toUpperCase());
    		   bw.newLine();
    		   line = br.readLine();
    	   }
       } catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public static void writeS (String s) {
		try {
			Files.write(Paths.get("c:\\\\tmp\\\\output.txt")
					,(s.toUpperCase()+ System.lineSeparator()).getBytes()
					,StandardOpenOption.CREATE
					,StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

}
/*
Maak een applicatie UpperTextApp die een opgegeven tekstbestand inleest, 
en naar een opgegeven nieuw bestand wegschrijft. 
De inhoud van het nieuwe bestand dient daarna in hoofdletters te staan. 
*/