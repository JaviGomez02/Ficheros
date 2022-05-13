package com.jacaranda.address;

import java.util.Objects;

public class Address {

	private String address_id;
	private String address;
	private String city_id;

	public Address(String address_id, String address, String city_id) {
		super();
		this.address_id = address_id;
		this.address = address;
		this.city_id = city_id;
	}

	public String getCity_id() {
		return city_id;
	}

	public void setCity_id(String city_id) {
		this.city_id = city_id;
	}

	public String getAddress_id() {
		return address_id;
	}

	public void setAddress_id(String address_id) {
		this.address_id = address_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	

	@Override
	public String toString() {
		return "Address [address_id=" + address_id + ", address=" + address + ", city_id=" + city_id + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(address_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(address_id, other.address_id);
	}

}
