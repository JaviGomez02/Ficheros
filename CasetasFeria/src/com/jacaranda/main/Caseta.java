package com.jacaranda.main;

import java.util.Objects;

public class Caseta {

	private String titulo;
	private String calle;
	private int numero;
	private int modulos;
	private String clase;
	private Integer id;
	private Integer id_calle;

	public Caseta(String titulo, String calle, Integer numero, Integer modulos, String clase, Integer id,
			Integer id_calle) {
		super();
		this.titulo = titulo;
		this.calle = calle;
		this.numero = numero;
		this.modulos = modulos;
		this.clase = clase;
		this.id = id;
		this.id_calle = id_calle;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getCalle() {
		return calle;
	}

	public Integer getNumero() {
		return numero;
	}

	public Integer getModulos() {
		return modulos;
	}

	public String getClase() {
		return clase;
	}

	public Integer getId() {
		return id;
	}

	public Integer getId_calle() {
		return id_calle;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public void setModulos(Integer modulos) {
		this.modulos = modulos;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setId_calle(Integer id_calle) {
		this.id_calle = id_calle;
	}

	@Override
	public String toString() {
		return "Caseta [titulo=" + titulo + ", calle=" + calle + ", numero=" + numero + ", modulos=" + modulos
				+ ", clase=" + clase + ", id=" + id + ", id_calle=" + id_calle + "\n";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Caseta other = (Caseta) obj;
		return Objects.equals(id, other.id);
	}

}
