package com.example.xml.jaxb;


import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
 
public class JAXBExample2 {
	public static void main(String[] args) {
 
	 try {
 
		File file = new File("file.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
 
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Customer customer = (Customer) jaxbUnmarshaller.unmarshal(file);
		System.out.println(customer);
 
	  } catch (JAXBException e) {
		e.printStackTrace();
	  }
 
	}
}