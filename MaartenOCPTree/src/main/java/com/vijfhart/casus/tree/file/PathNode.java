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
    private FileTime       lastModified, lastAccessed, created;  
    private int            numberOfFiles; // Aantal betanden
    private String         sizeHr;

    public PathNode(Path object) {
		super(object);
		setCache();
	}
	public PathNode(Path object, PathNode parent ) {
		super (object.normalize(),parent);
		setCache();
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

	public void setOptions(FilePrintOption... opties) {
		for (FilePrintOption optie:opties) {
			switch (optie) {
			case HUMAN_READABLE:
			     break;
			case DATE:
				break;
			case DIRS_ONLY:
				break;
			case LANGUAGE:
				break;
			case MAX_DEPTH:
			    break;
			}
			
		}
		
	}
	public String toString() {
		return "PN-"+super.toString();
	}

	private void setCache(	) {
		final Path path = this.getObject();
		try {
			BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
		    lastModified = attr.lastModifiedTime();
		    lastAccessed = attr.lastAccessTime();
		    created = attr.creationTime();
			size = attr.isDirectory()?OptionalLong.empty():OptionalLong.of(attr.size());
			name = path.getFileName().toString();
			numberOfFiles = path.toFile().list()==null?0:path.toFile().list().length;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	public FileTime getLastModified() {
		return lastModified;
	}
	public FileTime getLastAccessed() {
		return lastAccessed;
	}
	public FileTime getCreated() {
		return created;
	}
	public String getSizeHr() {
		return sizeHr;
	}
	public int getNumberOfFiles() {
		return numberOfFiles;
	}

}
