package com.jacaranda.main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Main {
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<Caseta> lista = new ArrayList<>();
		File file = new File("ficheros//fichero.xml");

		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();

			NodeList listaNodos = doc.getElementsByTagName("DatosLeidos");

			for (int i = 0; i < listaNodos.getLength(); i++) {
				Element elemento = (Element) listaNodos.item(i);

				if (elemento.getNodeType() == elemento.ELEMENT_NODE) {

					String titulo = elemento.getElementsByTagName("TITULO").item(0).getTextContent();
					String calle = elemento.getElementsByTagName("CALLE").item(0).getTextContent();
					int numeros = Integer.parseInt(elemento.getElementsByTagName("NUMERO").item(0).getTextContent());
					int modulos = Integer.parseInt(elemento.getElementsByTagName("MODULOS").item(0).getTextContent());
					String clase = elemento.getElementsByTagName("CLASE").item(0).getTextContent();

					int id = Integer.parseInt(elemento.getElementsByTagName("ID").item(0).getTextContent());
					int id_calle = Integer.parseInt(elemento.getElementsByTagName("ID_CALLE").item(0).getTextContent());

					Caseta c = new Caseta(titulo, calle, numeros, modulos, clase, id, id_calle);
					lista.add(c);

				}

			}
		} catch (SAXException | IOException e) {
			System.out.println(e.getMessage());
		} catch (ParserConfigurationException e) {
			System.out.println(e.getMessage());
		}

//		Iterator<Caseta> iterador = lista.iterator();
//		StringBuilder cadena = new StringBuilder();
//		while (iterador.hasNext()) {
//			Caseta c = iterador.next();
//			cadena.append(c.toString());
//		}
//		System.out.println(cadena.toString());

		System.out.println(menu());

		boolean salir = false;
		while (!salir) {
			int opc = leerEntero("Introduce una opcion: ");
			switch (opc) {
			case 1: {
				String cadena = leerCadena("Introduce la calle: ");
				Iterator<Caseta> iterador = lista.iterator();
				StringBuilder resultado = new StringBuilder();
				while (iterador.hasNext()) {
					Caseta c = iterador.next();
					if (c.getCalle().equals(cadena)) {
						resultado.append(c.toString());
					}
				}
				System.out.println(resultado.toString());
				break;
			}
			case 2: {
				Iterator<Caseta> iterador = lista.iterator();
				StringBuilder resultado = new StringBuilder();
				while (iterador.hasNext()) {
					Caseta c = iterador.next();
					if (c.getClase().equals("FAMILIAR")) {
						resultado.append(c.toString());
					}
				}
				System.out.println(resultado.toString());

				break;
			}
			case 3: {
				Iterator<Caseta> iterador = lista.iterator();
				StringBuilder resultado = new StringBuilder();
				while (iterador.hasNext()) {
					Caseta c = iterador.next();
					if (c.getClase().equals("DISTRITO")) {
						resultado.append(c.toString());
					}
				}
				System.out.println(resultado.toString());

				break;
			}
			case 4: {
				Iterator<Caseta> iterador = lista.iterator();
				StringBuilder resultado = new StringBuilder();
				while (iterador.hasNext()) {
					Caseta c = iterador.next();
					if (!c.getClase().equals("DISTRITO") && !c.getClase().equals("FAMILIAR")) {
						resultado.append(c.toString());
					}
				}
				System.out.println(resultado.toString());

				break;
			}
			case 5: {
				Iterator<Caseta> iterador = lista.iterator();
				StringBuilder resultado = new StringBuilder();
				String calle="";
				int contador;
				while (iterador.hasNext()) {
					Caseta c = iterador.next();
					
				}
				System.out.println(resultado.toString());

				break;
			}
			case 6: {
				Iterator<Caseta> iterador = lista.iterator();
				StringBuilder resultado = new StringBuilder();
				int contador;
				while (iterador.hasNext()) {
					Caseta c = iterador.next();

				}
				System.out.println(resultado.toString());

				break;
			}
			case 7: {
				String cadena = leerCadena("Introduce el nombre de la caseta a eliminar: ");
				Iterator<Caseta> iterador = lista.iterator();
				boolean encontrado=false;
				String devuelve="No se ha encontrado la caseta";
				while (iterador.hasNext() && !encontrado) {
					Caseta c = iterador.next();
					if (c.getTitulo().equals(cadena)) {
						lista.remove(c);
						encontrado=true;
						devuelve="Caseta eliminada";
					}
				}
				System.out.println(devuelve);

				break;
			}
			case 8: {
				salir = true;
				System.out.println("Saliendo...");
				break;
			}
			default:
				System.out.println("Opcion incorrecta");
			}
		}

	}

	private static String menu() {
		String cadena = "1. Mostrar todas las casetas existentes en una calle.\n"
				+ "2. Mostrar todas las casetas de tipo familiar. \n"
				+ "3. Mostrar todas las casetas de tipo Distrito. \n"
				+ "4. Mostrar todas las casetas que no sean ni familiares ni distritos. \n"
				+ "5. Mostrar para cada una de las calles del recinto ferial el número de casetas de tipo familiar que existen. \n"
				+ "6. Mostrar para cada una de las calles del recinto ferial el número de casetas de tipo Distrito que existen. \n"
				+ "7. Eliminar una caseta.\n" + "8. Salir. ";
		return cadena;
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