package com.raghu.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		
		try {
			
			//create the object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			//read the JSON file and map/convert it into JAVA POJO:
			
			//data/sample-lite.json
			
			Student theStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			//print firstname and lastname
			System.out.println("First Name: "+theStudent.getFirstName()+"\n  LastName: "+theStudent.getLastName());
			
			Address theAddress = theStudent.getAddress();
			
			System.out.println("Street : "+theAddress.getStreet());
			System.out.println("City : "+theAddress.getCity());
			
			//print out the languages
			
			for (String language : theStudent.getLanguages()) {
				System.out.println(language);
				
			}
			
			
			System.out.println(theStudent.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
