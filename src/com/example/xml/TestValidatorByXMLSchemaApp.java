package com.example.xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collection;
import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.w3c.dom.Document;

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
			Document document = XmlSchemaValidatorUtil.validate(xml, schema);

			Assert.assertNotNull(document.getFirstChild().getNodeName());

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
