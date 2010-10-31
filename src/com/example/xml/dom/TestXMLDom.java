package com.example.xml.dom;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
import org.jdom.xpath.XPath;
import org.junit.Test;

import com.example.common.Principal;

public class TestXMLDom extends Principal {

	// Read the XML file and create the object Document
	public Document readXML(String filePath) throws JDOMException, IOException {

		File f = new File(filePath);
		SAXBuilder b = new SAXBuilder(false);

		return b.build(f);
	}

	@Test
	public void testCreateXML() {
		// Creation of the root
		Element root = new Element("root");

		// Child of the root
		Element article = new Element("article");
		Element title = new Element("title").setText("Description");
		title.setAttribute("valoration", "5");
		Person person = new Person(23);

		article.addContent(title).addContent(person);

		// Modification of the element
		Person person2 = new Person(24);
		article.removeContent(person);
		article.addContent(person2);

		root.addContent(article);

		Document doc = new Document(root);// Creation of the xml document

		log.info("Storing and displaying the xml document...");

		try {
			XMLOutputter out = new XMLOutputter();
			FileOutputStream file = new FileOutputStream("ExampleDom.xml");
			out.output(doc, file);
			file.flush();
			file.close();
			out.output(doc, System.out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testReadXML() {

		try {
			Document input = readXML("ExampleDom.xml");

			showClassesForNodes(input);

			log.info("Nodes: " + countSelectedNodes(input, "/root/article"));
			assertTrue("It should be 1: ",  countSelectedNodes(input, "/root/article")==1);
			
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void showClassesForNodes(Document doc) {

		Iterator it = doc.getDescendants();
		while (it.hasNext()) {
			Object o = it.next();
			log.info("Object: " + o.toString());
			log.info("*** JDOM Class: " + o.getClass().getCanonicalName());

			if (o instanceof Element) {
				showElementAttributes((Element) o);
			}
		}
	}

	// Print the attributes of an element
	public static void showElementAttributes(Element e) {

		List attributes = e.getAttributes();
		for (Object o : attributes) {
			log.info("Object: " + o.toString());
			log.info("*** JDOM Class: " + o.getClass().getCanonicalName());
		}
	}

	public static int countSelectedNodes(Document doc, String xPath)
			throws JDOMException {

		int count = 0;
		XPath xPathProc = XPath.newInstance(xPath);
		List list = xPathProc.selectNodes(doc);
		count = list.size();
		return count;
	}
}
