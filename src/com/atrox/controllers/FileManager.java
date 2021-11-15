package com.atrox.controllers;

import com.atrox.tools.Debug;

import java.io.File;
import java.util.Scanner;

public class FileManager {
	
	private static String path;
	
	public FileManager() {
		path = "";
		
	}
	
	public void setWorkingDirectory(String path) {
		this.path = path;
	}
	
	public static File readFile(String fileName) {
		
		File fileToRead = null;
		try {
			fileToRead = new File(path+"/"+fileName);

			
		}catch(Exception e) {
			e.printStackTrace();
			Debug.logln(e.toString());
		}
		
		return fileToRead;
	}
	
	public static String readTextFile(File file) {
		String data = "";
		
		try {
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				data += scan.nextLine();
				
				
			}
		}catch(Exception e) {
		
		}
		
		return data;
	}
	
	public static String getWorkingDirectory() {
		return path;
	}

}
