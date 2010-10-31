package com.example.mysql;

import org.junit.After;
import org.junit.Test;

import java.sql.*;
import org.junit.Before;

public class bases {

	@Before
	public void setUp() throws Exception {
		try {
			// Cargar clase de controlador de base de datos
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println( "could not load JDBC driver: " + e );  
		}

	}
	

	@Test
	public void test1() throws Exception {
		try {
			// Establecer conexion a la base de datos

			Connection conexion = DriverManager.getConnection(
					"jdbc:mysql://localhost/schemapfc", "user1", "user1");

			// CreateXml objeto Statement para realizar queries a la base de datos
			Statement instruccion = conexion.createStatement();
			// Consultar a la base de datos
			ResultSet conjuntoResultados = instruccion
					.executeQuery("SELECT Column1 AS Codigo, Column2 AS Nombre FROM table1");
			// Procesar los resultados de la consulta
			StringBuffer resultados = new StringBuffer();
			ResultSetMetaData metaDatos = conjuntoResultados.getMetaData();
			int numeroDeColumnas = metaDatos.getColumnCount();
			for (int i = 1; i <= numeroDeColumnas; i++)
				resultados.append(metaDatos.getColumnName(i) + "\t");
			resultados.append("\n");
			while (conjuntoResultados.next()) {
				for (int i = 1; i <= numeroDeColumnas; i++)
					resultados.append(conjuntoResultados.getObject(i) + "\t");
				resultados.append("\n");
			}
			System.out.println(resultados.toString());
		}

		catch (SQLException e1) {
			System.out.println(e1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void test2() throws Exception {

		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost/schemapfc", "user1", "user1");

		try {
			Statement statement = con.createStatement();

			ResultSet rs = statement.executeQuery("SELECT COLUMN1 FROM table1");

			while (rs.next()) {
				System.out.println(rs.getString("COLUMN1"));
			}
			rs.close();
			statement.close();
		} catch (SQLException e) {
			System.out.println("JDBC error: " + e);
		} finally {
			con.close();
		}
	}

	@After
	public void tearDown() throws Exception {
	}

}
