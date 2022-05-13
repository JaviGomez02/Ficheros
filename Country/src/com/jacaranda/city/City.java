package com.jacaranda.city;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.jacaranda.address.Address;

public class City {

	private String city_id;
	private String city;
	private List<Address> listAddress;
	private String countryId;

	public City(String city_id, String city, String countryId) {
		super();
		this.city_id = city_id;
		this.city = city;
		this.countryId = countryId;
		this.listAddress = new ArrayList<>();
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getCity_id() {
		return city_id;
	}

	public void setCity_id(String city_id) {
		this.city_id = city_id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Address> getListAddress() {
		return listAddress;
	}

	@Override
	public String toString() {
		return "City [city_id=" + city_id + ", city=" + city + ", listAddress=" + listAddress + ", countryId="
				+ countryId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(city_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		return Objects.equals(city_id, other.city_id);
	}

}
