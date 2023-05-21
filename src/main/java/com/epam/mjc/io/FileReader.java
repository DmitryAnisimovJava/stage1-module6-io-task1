package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;




public class FileReader {
	
	private String name;
	private Integer age;
	private String email;
	private Long phone;
	
	public String getStringFromFile(String pathname) throws NullPointerException {
		if (pathname == null) {
			throw new NullPointerException("Pathname is equals to null");
		}
		String stringFromFile = null;
		StringBuilder stringBuilder = new StringBuilder();
		try (java.io.FileReader fr = new java.io.FileReader(pathname);
			 BufferedReader bReader = new BufferedReader(fr)) {
			while((stringFromFile = bReader.readLine()) != null) {
				stringBuilder.append(stringFromFile);
				stringBuilder.append(System.lineSeparator());
			}
			return stringBuilder.toString();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return stringBuilder.toString();
	}
	
    public Profile getDataFromFile(File file) {
    	FileReader readFromFileReader = new FileReader();
    	String allDataString = readFromFileReader.getStringFromFile(file.getAbsolutePath());
    	String[] valuePairs = allDataString.split("\n");
    	int counter = 0;
    	while(counter < valuePairs.length) {
    		name = valuePairs[counter].split(" ")[1];
    		counter++;
    		age = Integer.parseInt((valuePairs[counter].split(" ")[1]).replaceAll("\\s+", ""));
    		counter++;
    		email = valuePairs[counter].split(" ")[1];
    		counter++;
    		phone = Long.parseLong((valuePairs[counter].split(" ")[1]).replaceAll("\\s+", ""));
    		counter++;
    		
    	}
        return new Profile(name, age, email, phone);
    }
}
