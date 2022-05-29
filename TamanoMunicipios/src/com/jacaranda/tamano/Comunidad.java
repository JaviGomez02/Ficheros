package com.jacaranda.tamano;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Comunidad {
	private String nombre;
	private ArrayList<Municipio> listMunicipio;

	public Comunidad(String descrip) {

		this.nombre = descrip;
		this.listMunicipio = new ArrayList<>();

	}

	public String getNombre() {
		return nombre;
	}

	public String getDatos(int anno) {
		StringBuilder resultado = new StringBuilder("");
		for (Municipio m : this.listMunicipio) {
			resultado.append(m.getDescrip() + "\n" + m.getDatos(anno));
		}
		return resultado.toString();
	}

	public boolean encuentraDescrip(String descripcion, int anno, int dato) {
		Iterator<Municipio> siguiente = this.listMunicipio.iterator();
		boolean encontrado = false;
		while (siguiente.hasNext() && !encontrado) {
			Municipio m = siguiente.next();
			if (m.getDescrip().equals(descripcion)) {
				m.anadirDato(anno, dato);
				encontrado = true;
			}
		}

		return encontrado;
	}

	public int totalDatos(int anno) {
		int total = 0;
		for (Municipio m : this.listMunicipio) {
			if (m.getDescrip().equals("Total")) {
				total = m.numeroDatos(anno);
			}
		}
		return total;
	}

	public int sumarDatos(int anno) {
		int suma = 0;
		for (Municipio m : this.listMunicipio) {
			if (!m.getDescrip().equals("Total")) {
				suma += m.numeroDatos(anno);
			}
		}
		return suma;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comunidad other = (Comunidad) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Comunidad [nombre=" + nombre + ", listMunicipio=" + listMunicipio + "]";
	}

}
