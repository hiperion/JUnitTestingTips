package com.example.xml.sax;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import javax.xml.XMLConstants;
import javax.xml.transform.sax.SAXSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import com.example.common.Principal;

/**
 * Program to validate xml with schemes
 * 
 * @author hiperion
 * @see
 */
@RunWith(Parameterized.class)
public class TestValidatorByXMLSchemaApp extends Principal {

	String xmlFilePath;
	String schemaFilePath;

	public TestValidatorByXMLSchemaApp(String xmlFilePath, String schemaFilePath) {
		super();
		this.xmlFilePath = xmlFilePath;
		this.schemaFilePath = schemaFilePath;
	}

	@SuppressWarnings("rawtypes")
	@Parameters
	public static Collection operationTypeValues() {

		return Arrays.asList(new Object[][] {
				{ "Example1.xml", "Example1.xsd" },
				{ "Example2.xml", "Example2.xsd" },
				{ "Example3.xml", "Example3.xsd" },
				{ "Example4.xml", "Example4.xsd" } });
	}

	@Test
	public void TestXML() {

		try {
			log.debug(xmlFilePath + " - " + schemaFilePath);
			File xml = new File(xmlFilePath);
			File schema = new File(schemaFilePath);
			Document document = XMLSchemaValidatorUtil.validate(xml, schema);

			Assert.assertNotNull(document.getFirstChild().getNodeName());

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test
	public void TestXML2() {
		log.debug(xmlFilePath + " - " + schemaFilePath);
		File documentFile = new File(xmlFilePath);
		File schemaFile = new File(schemaFilePath);

		SchemaFactory factory = SchemaFactory
				.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

		Schema schema = null;
		try {
			schema = factory.newSchema(schemaFile);
		} catch (SAXException ex) {
			ex.printStackTrace();
		}

		Validator validator = schema.newValidator();

		try {
			SAXSource source = new SAXSource(new InputSource(new FileReader(
					documentFile)));
			validator.validate(source);
			
		} catch (SAXException ex) {
			fail(ex);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	static void fail(SAXException e) {
	    if (e instanceof SAXParseException) {
	      SAXParseException spe = (SAXParseException) e;
	      System.err.printf("%s:%d:%d: %s%n", spe.getSystemId(), spe.getLineNumber(), spe
	          .getColumnNumber(), spe.getMessage());
	    } else {
	      System.err.println(e.getMessage());
	    }
	    System.exit(1);
	  }
}
