package com.example.xml.sax;


import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * Validation of xml with schemas 
 * @author hiperion
 * @see 
 */
public class XMLSchemaValidatorUtil {
	
	/**
	 * Valida un documento XML con un esquema XML (XSD).
	 * @param xml File to validate
	 * @param xmlSchema File with the schema
	 * @return Dom document
	 * @throws ParserConfigurationException 
	 * @throws SAXException 
	 * @throws IOException  
	 */
	public static Document validate(File xml, File xmlSchema) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		factory.setNamespaceAware(true);  
		factory.setValidating(true);
		factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
		factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaSource",   xmlSchema);  


		// Parsing 
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();  
		documentBuilder.setErrorHandler(new ErrorHandler() {
			public void warning(SAXParseException ex) throws SAXException {
				throw ex;
			} 	
			public void error(SAXParseException ex) throws SAXException {
				throw ex;
			}
			public void fatalError(SAXParseException ex) throws SAXException {
				throw ex;
			}				
		});  

		return documentBuilder.parse(xml);  
	}
}
    
    