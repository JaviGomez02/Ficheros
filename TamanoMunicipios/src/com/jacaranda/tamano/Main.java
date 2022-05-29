package com.jacaranda.tamano;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		TamanoMunicipioComunidad t = new TamanoMunicipioComunidad();
		String fichero = leerJson("tamanoMunicipioComunidad.json");
		t.leerDatos(fichero);
		boolean salir = false;
		while (!salir) {
			int anno, dato;
			String comunidad, descripcion;
			System.out.println(menu());
			int opc = leerEntero("Introduce una opción: ");
			switch (opc) {
			case 1:
				anno = leerEntero("Introduce un anno: ");
				System.out.println(t.mostrarComunidad(anno));
				break;
			case 2:
				comunidad = leerCadena("Introduce una comunidad: ");
				anno = leerEntero("Introduce un anno: ");
				System.out.println(t.mostrarComunidadAno(anno, comunidad));
				break;
			case 3:
				comunidad = leerCadena("Introduce una comunidad: ");
				descripcion = leerCadena("Introduce una descripcion: ");
				anno = leerEntero("Introduce un anno: ");
				dato = leerEntero("Introduce un dato: ");
				if (t.addDato(comunidad, descripcion, anno, dato)) {
					System.out.println("Dati annadido.");
				}
				break;
			case 4:
				comunidad = leerCadena("Introduce una comunidad: ");
				anno = leerEntero("Introduce un anno: ");
				System.out.println(t.comparar(comunidad, anno));

				break;
			case 5:
				String guardar = leerCadena("¿Quieres guardar los datos? S/N");
				if (guardar.equals("S")) {
					t.guardarDatos("fichero.json");
					System.out.println("Datos guardados");
				}
				System.out.println("Saliendo...");
				salir = true;
				break;

			default:
				System.out.println("Opcion incorrecta");
				break;
			}
		}

	}

	private static String leerJson(String nombreFichero) {
		StringBuilder resultado = new StringBuilder();
		String linea;
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
		} catch (FileNotFoundException e) {
			System.out.println("No existe el fichero " + nombreFichero);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return resultado.toString();
	}

	public static String menu() {
		return "1. Mostrar los datos de un año\n2. Mostrar los datos de un año y una comunidad\n3. Anadir dato\n4. Comprobar totales\n5. Salir";
	}

	public static String leerCadena(String texto) {
		System.out.println(texto);
		return teclado.nextLine();
	}

	public static int leerEntero(String texto) {
		System.out.println(texto);
		return Integer.parseInt(teclado.nextLine());
	}
}
