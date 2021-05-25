package com.app.files;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WritingDataIntoFile {
	
	public static void main(String[] args) {
		Path path=Paths.get("foo.txt");
		try(FileWriter fileWriter = new FileWriter("foo.txt")) {
			fileWriter.write("Hello World\n");
			fileWriter.write("Learning Files concepts\n");
		}catch (IOException e) {
			System.out.println("An I/O Error Occurred : "+e.getMessage());
		}
		catch (SecurityException e) {
			System.out.println("No permission to create file: " + e.getMessage());
		}
	}
}
