package com.jacaranda.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import com.jacaranda.address.Address;
import com.jacaranda.city.City;
import com.jacaranda.country.Country;

public class Main {

	public static ArrayList<City> listaCiudades = new ArrayList<>();
	public static ArrayList<Address> listaDirecciones = new ArrayList<>();
	public static ArrayList<Country> listaPaises = new ArrayList<>();

	public static void main(String[] args) {

		leerFicheroAddress("Ficheros//address2.txt");
		leerFicheroCiudad("Ficheros//city.txt");
		leerFicheroCountry("Ficheros//country.txt");

		crearFichero("Ficheros//resultado.txt");
		crearFichero2("Ficheros//resultadoCiudades.txt");
//		Iterator<Country> iterador = listaPaises.iterator();
//		String resultado = "";
//		while (iterador.hasNext()) {
//			Country c = iterador.next();
//			resultado = resultado + c.toString() + "\n";
//		}
//		System.out.println(resultado);
	}

	public static void leerFicheroAddress(String nombreFichero) {
		String linea;
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);
			linea = filtroLectura.readLine();
			while (linea != null) {
				String[] campos = linea.split(",");
				Address a = new Address(campos[0], campos[1], campos[4]);
				listaDirecciones.add(a);
				linea = filtroLectura.readLine();

			}

			filtroLectura.close();
			flujoLectura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void leerFicheroCiudad(String nombreFichero) {
		String linea;
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);
			linea = filtroLectura.readLine();
			while (linea != null) {
				String[] campos = linea.split(",");
				City c = new City(campos[0], campos[1], campos[2]);
				listaCiudades.add(c);
				Iterator<Address> iterador = listaDirecciones.iterator();
				while (iterador.hasNext()) {
					Address a = iterador.next();
					if (a.getCity_id().equals(c.getCity_id())) {
						c.getListAddress().add(a);
					}
				}
				linea = filtroLectura.readLine();

			}

			filtroLectura.close();
			flujoLectura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void leerFicheroCountry(String nombreFichero) {
		String linea;
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);
			linea = filtroLectura.readLine();
			while (linea != null) {
				String[] campos = linea.split(",");
				Country c = new Country(campos[0], campos[1]);
				listaPaises.add(c);

				Iterator<City> iterador = listaCiudades.iterator();
				while (iterador.hasNext()) {
					City city = iterador.next();
					if (city.getCountryId().equals(c.getCoundry_id())) {
						c.getList_city().add(city);
					}
				}
				linea = filtroLectura.readLine();

			}

			filtroLectura.close();
			flujoLectura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void crearFichero(String nombreFichero) {
		try {
			FileWriter flujoEscritura = new FileWriter(nombreFichero);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);
			Iterator<Country> iterador = listaPaises.iterator();

			while (iterador.hasNext()) {
				Country c = iterador.next();
				Iterator<City> iterador2 = c.getList_city().iterator();
				int numDirecciones = 0;
				while (iterador2.hasNext()) {
					City c2 = iterador2.next();
					numDirecciones = numDirecciones + c2.getListAddress().size();
				}
				String cadena = "ID: " + c.getCoundry_id() + ", Pais: " + c.getCountry() + ", Numero de Ciudades: "
						+ c.getList_city().size() + ", Numero de Direcciones: " + numDirecciones;
				filtroEscritura.println(cadena);
			}
			filtroEscritura.close();
			flujoEscritura.close();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void crearFichero2(String nombreFichero) {
		try {
			FileWriter flujoEscritura = new FileWriter(nombreFichero);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);
			Iterator<City> iterador = listaCiudades.iterator();

			while (iterador.hasNext()) {
				City c = iterador.next();
				String cadena = "ID: " + c.getCity_id() + ", Ciudad: " + c.getCity() + ", Numero de direcciones: "
						+ c.getListAddress().size();
				filtroEscritura.println(cadena);
			}
			filtroEscritura.close();
			flujoEscritura.close();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}
}
