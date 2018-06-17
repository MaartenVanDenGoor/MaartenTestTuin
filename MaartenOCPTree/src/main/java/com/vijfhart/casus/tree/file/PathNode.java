package com.vijfhart.casus.tree.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.LocalDate;
import java.util.OptionalLong;

import com.vijfhart.casus.tree.WrapperNode;

public class PathNode extends WrapperNode<PathNode, Path> {
    private String         name; // De naam van het bestand / de directory  
    private OptionalLong   size; // De bestandsgrootte , leeg als het een directory betreft
    private FileTime      date;  // De datum dat het bestand of de directory voor het laatst is aangepast
    private int           numberOfFiles; // Aantal betanden

    public PathNode(Path object) {
		super(object);
		fillFields(object);
	}
	public PathNode(Path object, PathNode parent ) {
		super (object,parent);
		fillFields(object);
	}    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public OptionalLong getSize() {
		return size;
	}
	public void setSize(OptionalLong size) {
		this.size = size;
	}
	public FileTime getDate() {
		return date;
	}
	public void setOptions(FilePrintOption... opties) {
		
	}
	public String toString() {
		return "PN-"+super.toString();
	}
	public void setDate(FileTime date) {
		this.date = date;
	}
	private void fillFields(Path object) {
		name = object.getFileName().toString();
		try {
			BasicFileAttributes attr = Files.readAttributes(object, BasicFileAttributes.class);
			size = OptionalLong.of(attr.size());
			date = attr.lastModifiedTime();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		numberOfFiles = object.toFile().list()==null?0:object.toFile().list().length;
	}
	public int getNumberOfFiles() {
		return numberOfFiles;
	}

}
