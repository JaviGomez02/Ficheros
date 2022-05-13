package com.jacaranda.country;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.jacaranda.city.City;

public class Country {
	
	private String coundry_id;
	private String country;
	private List<City> list_city;
	public Country(String coundry_id, String country) {
		super();
		this.coundry_id = coundry_id;
		this.country = country;
		this.list_city=new ArrayList<>();
	}
	public String getCoundry_id() {
		return coundry_id;
	}
	public void setCoundry_id(String coundry_id) {
		this.coundry_id = coundry_id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public List<City> getList_city() {
		return list_city;
	}
	@Override
	public String toString() {
		return "Country [coundry_id=" + coundry_id + ", country=" + country + ", list_city=" + list_city + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(coundry_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		return Objects.equals(coundry_id, other.coundry_id);
	}
	
	
}
