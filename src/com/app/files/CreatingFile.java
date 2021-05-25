package com.app.files;

import java.io.File;
import java.io.IOException;

public class CreatingFile {

	public static void main(String[] args) {
		File file = new File("./foo.txt");
		try {
			Boolean status=	file.createNewFile();
			//file.delete(); for deleting a file.
			//boolean success = file.setReadOnly(); // or file.setWritable(false); For Read Only
			if(status)
				System.out.println("File Created successfully!.");
			else
				System.out.println("File already exists!");
		}catch (IOException e) {
			System.out.println("An I/O Error Occurred : "+e.getMessage());
			e.printStackTrace();
		}
		catch (SecurityException e) {
			System.out.println("No permission to create file: " + e.getMessage());
		}
	}
}
