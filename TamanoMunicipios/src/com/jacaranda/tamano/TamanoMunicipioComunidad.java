package com.jacaranda.tamano;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class TamanoMunicipioComunidad {

	private ArrayList<Comunidad> lista;

	public TamanoMunicipioComunidad() {
		lista = new ArrayList<>();
	}

	public void leerDatos(String datos) {
		Gson gson = new Gson();
		this.lista = gson.fromJson(datos, new TypeToken<ArrayList<Comunidad>>() {
		}.getType());

	}

	@Override
	public String toString() {
		return "TamanoMunicipioComunidad [lista=" + lista + "]";
	}

	public String mostrar() {
		StringBuilder resultado = new StringBuilder("");
		for (Comunidad c : this.lista) {
			resultado.append(c.toString());
		}
		return resultado.toString();
	}

	public String mostrarComunidad(int anno) {
		StringBuilder resultado = new StringBuilder("");
		for (Comunidad c : this.lista) {
			resultado.append(c.getNombre() + c.getDatos(anno));
		}
		return resultado.toString();
	}

	public String mostrarComunidadAno(int ano, String comunidad) {
		StringBuilder resultado = new StringBuilder("");
		Iterator<Comunidad> siguiente = this.lista.iterator();
		boolean encontrado = false;
		while (siguiente.hasNext() && !encontrado) {
			Comunidad c = siguiente.next();
			if (c.getNombre().equals(comunidad)) {
				resultado.append(c.getNombre() + c.getDatos(ano));
				encontrado = true;
			}
		}
		return resultado.toString();
	}

	public boolean addDato(String comunidad, String descripcion, int anno, int dato) {
		Iterator<Comunidad> siguiente = this.lista.iterator();
		boolean encontrado = false;
		while (siguiente.hasNext() && !encontrado) {
			Comunidad c = siguiente.next();
			if (c.getNombre().equals(comunidad)) {
				c.encuentraDescrip(descripcion, anno, dato);
				encontrado = true;
			}
		}
		return encontrado;
	}

	public String comparar(String comunidad, int anno) {
		String resultado = "No encontrado";
		Comunidad c1 = null;
		Iterator<Comunidad> siguiente = this.lista.iterator();
		boolean encontrado = false;
		while (siguiente.hasNext() && !encontrado) {
			Comunidad c2 = siguiente.next();
			if (c2.getNombre().equals(comunidad)) {
				c1 = c2;
				encontrado = true;
			}
		}
		if (encontrado) {
			int suma = c1.sumarDatos(anno);
			int total = c1.totalDatos(anno);
			if (suma == total) {
				resultado = "Igual";
			} else {
				resultado = "Valor actual: " + suma + ". Deberia estar: " + total;
			}
		}

		return resultado;
	}

	public void guardarDatos(String fichero) {
		Gson gsonBonito = new GsonBuilder().setPrettyPrinting().create();
		String ponerloBonito = gsonBonito.toJson(this.lista);
		escribirEnFichero(fichero, ponerloBonito);
	}

	private static void escribirEnFichero(String nombre, String contenido) {
		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);
			filtroEscritura.println(contenido);
			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
