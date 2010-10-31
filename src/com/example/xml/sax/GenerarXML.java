package com.example.xml.sax;


import java.io.*;
import java.io.StringWriter;
import org.w3c.dom.Element;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.xerces.jaxp.DocumentBuilderImpl;
import org.apache.xerces.jaxp.DocumentBuilderFactoryImpl;
public class GenerarXML
{
	private static final String TAG_DESCARGAS = "Descargas";
	private static final String TAG_DESCARGA = "descarga";
	private static final String TAG_ID = "id";
	private static final String TAG_TITULO = "titulo";
	private static final String TAG_RUTA = "ruta";
	private static final String TAG_HITS = "hits";
	// Codificacion
	private static final String XML_VERSION = "1.0";
	private static final String XML_ENCODING = "ISO-8859-1";
	private static final String JAVA_ENCODING = "8859_1";
	// Nombre del archivo
	private static final String NOMBRE_ARCHIVO_XML = "Example5.xml";
	// Objetos
	private Document documentoXML = null;
	private Element descarga = null;
	
	public void generaDocumentoXML() {
		try {
			// 1. TestXMLDom objeto DocumentBuilderFactory
			DocumentBuilderFactory dbFactory = DocumentBuilderFactoryImpl.newInstance();
			// 2. A partir del objeto DocumentBuilderFactory crear un objeto DocumentBuilder 
			DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
			// 3. Generar el documento XML
			documentoXML = docBuilder.newDocument();
		} catch (Exception e) {
			System.out.println("Error : " + e);
		}
		// 4. TestXMLDom el elemento "descargas"
		descarga = documentoXML.createElement(TAG_DESCARGAS);
		// 5. Agregar al documento principal
		documentoXML.appendChild(descarga);
	}
	
	public void generarDocumentoXMLDescarga(Descargas descargas)
	{
		Element elemento;
		Element item;

		// 1. TestXMLDom elemento
		elemento = documentoXML.createElement(TAG_DESCARGA);
		// 2. Asignar un atributo
		elemento.setAttribute(TAG_ID, ""+descargas.getID());
		// 3. Aniadir elemento al documento
		descarga.appendChild(elemento);

		// a. TestXMLDom item
		item = documentoXML.createElement(TAG_TITULO);
		// b. Asignar un dato al item
		item.appendChild(documentoXML.createTextNode(descargas.getTitulo()));
		// c. Aniadir el item
		elemento.appendChild(item);

		// a. TestXMLDom item
		item = documentoXML.createElement(TAG_RUTA);
		// b. Asignar un dato al item
		item.appendChild(documentoXML.createTextNode(descargas.getRuta()));
		// c. Aniadir el item
		elemento.appendChild(item);

		// a. TestXMLDom item
		item = documentoXML.createElement(TAG_HITS);
		// b. Asignar un dato al item
		item.appendChild(documentoXML.createTextNode(""+descargas.getHits()));
		// c. Aniadir el item
		elemento.appendChild(item);

	}
	
	private String generaTextoXML() {
		StringWriter strWriter = null;
		XMLSerializer seliarizadorXML = null;
		OutputFormat formatoSalida = null;
		try {
			seliarizadorXML = new XMLSerializer();
			strWriter = new StringWriter();
			formatoSalida = new OutputFormat();
			// 1. Establecer el formato
			formatoSalida.setEncoding(XML_ENCODING);
			formatoSalida.setVersion(XML_VERSION);
			formatoSalida.setIndenting(true);
			formatoSalida.setIndent(4);
			// 2. Definir un objeto donde se generara el codigo
			seliarizadorXML.setOutputCharStream(strWriter);
			// 3. Aplicar el formato
			seliarizadorXML.setOutputFormat(formatoSalida);
			// 4. Serializar documento XML
			seliarizadorXML.serialize(documentoXML);
			strWriter.close();
		} catch (IOException ioEx) {
			System.out.println("Error : " + ioEx);
		}
		return strWriter.toString();
	}
	public void guardarDocumentoXML(String texto) {
		try {
			OutputStream fout = new FileOutputStream(NOMBRE_ARCHIVO_XML);
			OutputStream bout = new BufferedOutputStream(fout);
			OutputStreamWriter out = new OutputStreamWriter(bout, JAVA_ENCODING);
			out.write(texto);
			out.flush();
			out.close();
		} catch (UnsupportedEncodingException e) {
			System.out.println("Error codificacion");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Error : " + e);
		}
	}
	public String obtenerTextoXML()
	{
		return generaTextoXML();
	}
	public static void main(String args[])
	{
		GenerarXML generador = new GenerarXML();
		// A. TestXMLDom el objeto(s) a Descargas
		Descargas descarga = new Descargas(1, "Books Java", "http://books.zip", 2546);
		Descargas descarga2 = new Descargas(2, "Books C Sharp", "http://booksc.zip", 1654);
		// B. Generar un documento XML usando Document
		generador.generaDocumentoXML();
		// C. Generar XML para el/los objeto(s)
		generador.generarDocumentoXMLDescarga(descarga);
		generador.generarDocumentoXMLDescarga(descarga2);
		// D. Obtener el código XML
		String textoXML = generador.obtenerTextoXML();
		generador.guardarDocumentoXML(textoXML);
		System.out.println(textoXML);
	}
}