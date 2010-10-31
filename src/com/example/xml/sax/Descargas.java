
package com.example.xml.sax;

public class Descargas {
	//Variables
    private int id;
    private String titulo;
    private String ruta;
    private int hits;
    //Constructor de la clase
    public Descargas(int id, String titulo, String ruta, int hits){
    	this.id = id;
    	this.titulo = titulo;
    	this.ruta = ruta;
    	this.hits = hits;
    }
    //Metodos Setters y Getters
    public void setID(int id) { 
        this.id = id; 
    }
    public int getID() { 
        return this.id; 
    }
    public void setTitulo(String titulo) { 
        this.titulo = titulo;
    }
    public String getTitulo() { 
        return this.titulo;
    }
    public void setRuta(String ruta) { 
        this.ruta = ruta;
    }
    public String getRuta() { 
        return this.ruta;
    }
    public void setHits(int hits) { 
        this.hits = hits; 
    }
    public int getHits() { 
        return this.hits; 
    }
    public String toString() {
    	StringBuffer sb = new StringBuffer();
		sb.append("Datos de descarga " + getID());
		sb.append("; nombre: " + getTitulo());
		sb.append("; ruta: " + getRuta());
		sb.append("; hits: " + getHits());
		return sb.toString();
	}
}