package com.app.files;

import java.io.BufferedReader;
import java.io.LineNumberReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadingDataFromFile {
	public static void main(String[] args) {
		Path path=Paths.get("foo.txt");
		try(BufferedReader reader=Files.newBufferedReader(path);
			LineNumberReader lineNumberReader = new LineNumberReader(reader)
		   ){
			
			String line;
			if((line=lineNumberReader.readLine())!=null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
