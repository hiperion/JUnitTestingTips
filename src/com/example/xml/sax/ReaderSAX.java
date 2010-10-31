package com.example.xml.sax;



import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ReaderSAX  {
	
	ArrayList nodes;

	public ArrayList getNodes(){
		return this.nodes;
	}

	
    public void read(String url){
       try{
            SAXParserFactory spf=SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser();
           	sp.parse(url, new LibraryXMLReader() );
        }catch(ParserConfigurationException e){
        	System.err.println("error de  parseo");
        }catch(SAXException e2){
        	System.err.println("error de  sax : " + e2.getStackTrace());
        } catch (IOException e3) {
			// TODO Auto-generated catch block
        	System.err.println("error de  io : " + e3.getMessage() );
        }

    }

	public static void main(String[] args){
	ReaderSAX lector = new ReaderSAX();
	lector.	read("http://badopi.net/atom.xml");
}

	 
    private class LibraryXMLReader extends DefaultHandler {
    	String contenido="";
    	private SourceXML nodoActual= new SourceXML();

    	/* 
    	 * Esta funcion el llamada cuando se produce el evento  de ver una nueva etiqueta
    	 */
    	public void startElement(String uri, String localName, String qName, Attributes attributes) {
            if ("item".equals(qName)) {
            	nodoActual = new SourceXML();
            }
          
        	
        }
    	/* 
    	 * Esta funcion es llamada cuando ve el contenido de una etiqueta      
    	 */
        public void characters(char buf[], int offset, int len)
        throws SAXException
        {
        	contenido = new String(buf, offset, len);
           
        }
        /* 
         * y esta al llegar al final
         */
        public void endElement(String uri, String localName, String qName) {
        	 if("title".equals(qName)){	
     	    	nodoActual.setTitulo(contenido);
     	    	
     	      } 
        	 if("link".equals(qName)) {
     	    	  nodoActual.setEnlace(contenido);
     	    	  
     	      } 
        	 if("description".equals(qName)) {
     	    	  nodoActual.setDescripcion(contenido);
     	    	  
     	      } 
        	 if("pubDate".equals(qName)) {
     	    	 nodoActual.setFecha(contenido);
     	    	 
     	      } 
        	 if("item".equals(qName)) {
     	    	 nodes.add(nodoActual);    	    
     	      }
     	  
        }
    }
    
}