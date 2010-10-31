package com.example.xml.sax;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
public class ProcessingXML {
    private Document dom;
    private List listadoDescargas;
    public ProcessingXML() {
        listadoDescargas = new ArrayList();
        // A. Parsear el archivo XML
        parsearArchivoXml();
        // B. Obtener datos del documento XML
        parsearDocumento();
        // C. Imprimir los resultados
        imprimirResultados();
    }
    //Parsea el archivo XML
    public void parsearArchivoXml() {
        // 1. Obteher el objeto DocumentBuilderFactory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            // 2. Usar DocumentBuilderFactory para crear un DocumentBuilder
            DocumentBuilder db = dbf.newDocumentBuilder();
            // 3. Parsear a partir de un archivo
            dom = db.parse("Example5.xml");
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (SAXException se) {
            se.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    //Parsea el documento XML y extrae los datos
    public void parsearDocumento() {
        // 1. Obtener el documento raiz
        Element docEle = dom.getDocumentElement();
        // 2. Obtener un nodelist de elementos <descarga>
        NodeList nl = docEle.getElementsByTagName("descarga");
        if (nl != null && nl.getLength() > 0) {
            for (int i = 0; i < nl.getLength(); i++) {
                // a. Obtener el elemento
                Element elemento = (Element) nl.item(i);
                // b. Obtener el objeto empleado
                Descargas descarga = obtenerDescarga(elemento);
                // c. Aniadirlo a la lista
                listadoDescargas.add(descarga);
            }
        }
    }
    //Imprimir los datos
    public void imprimirResultados() {
        Iterator it = listadoDescargas.iterator();
        while (it.hasNext())
            System.out.println(it.next().toString());
    }
    //Devuelve un objeto Descarga generado con los datos de un elemento XML
    public Descargas obtenerDescarga(Element elemento) {
        int id = Integer.parseInt(elemento.getAttribute("id"));
        String titulo = obtenerTexto(elemento, "titulo");
        String ruta = obtenerTexto(elemento, "ruta");
        int hits = obtenerEntero(elemento, "hits");
        // CreateXml un objeto Descargas con los datos recibidos
        Descargas d = new Descargas(id, titulo, ruta, hits);
        return d;
    }
    //Devuelve un valor entero del elemento recibido
    private int obtenerEntero(Element elemento, String nombreEtiqueta) {
        return Integer.parseInt(obtenerTexto(elemento, nombreEtiqueta));
    }
    //Devuelve los datos del elemento recibido
    private String obtenerTexto(Element elemento, String nombreEtiqueta) {
        String texto = null;
        NodeList nl = elemento.getElementsByTagName(nombreEtiqueta);
        if (nl != null && nl.getLength() > 0) {
            Element el = (Element) nl.item(0);
            texto = el.getFirstChild().getNodeValue();
        }
        return texto;
    }
    public static void main(String args[]) {
        ProcessingXML procesador = new ProcessingXML();
    }
}