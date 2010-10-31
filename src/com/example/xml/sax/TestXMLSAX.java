package com.example.xml.sax;

import static org.junit.Assert.assertTrue;
import java.io.*;
import java.util.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.jdom.*;
import org.jdom.input.*;
import org.jdom.output.*;
import org.junit.Test;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.example.common.Principal;

public class TestXMLSAX extends Principal {

	@Test
	public void testReadXml1() {
		try {
			SAXBuilder builder = new SAXBuilder(false);

			Document doc = builder.build("League.xml");
			Element root = doc.getRootElement();
			log.info("The League is: "
					+ root.getAttributeValue("classification"));
			// todos los hijos que tengan como nombre plantilla
			List teams = root.getChildren("team");

			log.info("It has: " + teams.size() + " teams");
			assertTrue("It's equal", 2 == teams.size());

			Iterator i = teams.iterator();
			while (i.hasNext()) {
				Element e = (Element) i.next();
				// primer hijo que tenga como nombre club
				Element club = e.getChild("club");
				List players = e.getChildren("players");
				log.info(club.getText() + ":" + "assessment="
						+ club.getAttributeValue("assessment") + "," + "city="
						+ club.getAttributeValue("city") + "," + "It has:"
						+ players.size() + " players");
				assertTrue("Its not equal:" + players.size(),
						3 == players.size());
				if (e.getChildren("withforeign").size() == 0)
					log.info("It hasn't got foreign");
				else
					log.info("It has got foreign");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testReadXml2() {
		try {

			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();

			DefaultHandler handler = new DefaultHandler() {

				boolean bfname = false;
				boolean blname = false;
				boolean bnname = false;
				boolean bsalary = false;

				public void startElement(String uri, String localName,
						String qName, Attributes attributes)
						throws SAXException {

					log.info("Start Element :" + qName);

					if (qName.equalsIgnoreCase("FIRSTNAME")) {
						bfname = true;
					}

					if (qName.equalsIgnoreCase("LASTNAME")) {
						blname = true;
					}

					if (qName.equalsIgnoreCase("NICKNAME")) {
						bnname = true;
					}

					if (qName.equalsIgnoreCase("SALARY")) {
						bsalary = true;
					}

				}

				public void endElement(String uri, String localName,
						String qName) throws SAXException {

					log.info("End Element :" + qName);

				}

				public void characters(char ch[], int start, int length)
						throws SAXException {

					String localString;

					if (bfname) {
						localString = new String(ch, start, length);
						log.info("Testing .....First Name : "
								+ new String(ch, start, length));
						assertTrue("It should be equal:" + localString,
								(localString.compareTo("yong") == 0)
										|| (localString.compareTo("low") == 0));
						bfname = false;
					}

					if (blname) {
						log.info("Last Name : " + new String(ch, start, length));
						blname = false;
					}

					if (bnname) {
						log.info("Nick Name : " + new String(ch, start, length));
						bnname = false;
					}

					if (bsalary) {
						log.info("Salary : " + new String(ch, start, length));
						bsalary = false;
					}

				}

			};

			saxParser.parse("Examplefile1.xml", handler);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testReadXml3() {
		String xml = "contratos.xml";
		String xsl = "formato.xsl";

		try {

			TransformerFactory f = TransformerFactory.newInstance();
			Transformer t = f.newTransformer(new StreamSource(new File(xsl)));

			t.transform(new StreamSource(new File(xml)), new StreamResult(
					System.out));
		}

		catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Test
	public void testReadXml4() {
		/*
		  // factory for creating DocumentBuilders
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

		// factory for creating Transformers
		TransformerFactory transformerFactory = TransformerFactory.newInstance();

		DocumentBuilder builder = null;
		try {
			builder = builderFactory.newDocumentBuilder();

			Document document;

			document = builder.parse(new File("Examplefile1.xml"));

			// create DOMSource for source XML document
			Source xmlSource = new DOMSource(document);

			// create StreamSource for XSLT document
			Source xslSource = new StreamSource(new File("Examplefile1.xsl"));

			// create StreamResult for transformation result
			Result result = new StreamResult(new File("Examplefileres.xml"));

			// create Transformer for XSL transformation
			Transformer transformer = transformerFactory
					.newTransformer(xslSource);

			// transform and deliver content to client
			transformer.transform(xmlSource, result);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	}
}
