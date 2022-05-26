package com.jacaranda.main;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.google.gson.Gson;

public class Main {

	public static void main(String[] args) {
		
		
		String fichero=leerFichero("Ficheros//prueba.json");
		// Creamos un objeto Gson
		Gson gson = new Gson();
		// Para obtener cada una de las propiedad del objeto
		// Recordad que no funcionario si tenemos un array.
		Properties properties = gson.fromJson(fichero, Properties.class);
		// Mostrarmos cada una de las propiedades.
		System.out.println(properties.get("nombre"));
		System.out.println(properties.get("apellidos"));
		System.out.println(properties.get("edad"));

	}
	
	

	public static String leerFichero(String nombreFichero) {
		String linea;
		StringBuilder resultado = new StringBuilder();

		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);

			linea = filtroLectura.readLine();
			while (linea != null) {
				resultado.append(linea);
				linea = filtroLectura.readLine();
			}
			filtroLectura.close();
			flujoLectura.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado.toString();

	}
}
