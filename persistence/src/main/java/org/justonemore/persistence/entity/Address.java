package org.justonemore.persistence.entity;

import java.util.Objects;

import org.springframework.data.annotation.Id;


public final class Address {

	@Id
	private final Integer id;

	private final String personIdentifier;

	private final String city;

	private final String province;

	private final String country;

	private final String streetName;

	private final String postalCode;

	private final String streetType;

	public Address(Integer id, String personIdentifier, String city, String province, String country,
			String streetName, String postalCode, String streetType) {
		this.id = id;
		this.personIdentifier = personIdentifier;
		this.city = city;
		this.province = province;
		this.country = country;
		this.streetName = streetName;
		this.postalCode = postalCode;
		this.streetType = streetType;
	}

	@Id
	public Integer id() {
		return id;
	}

	public String personIdentifier() {
		return personIdentifier;
	}

	public String city() {
		return city;
	}

	public String province() {
		return province;
	}

	public String country() {
		return country;
	}

	public String streetName() {
		return streetName;
	}

	public String postalCode() {
		return postalCode;
	}

	public String streetType() {
		return streetType;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (obj == null || obj.getClass() != this.getClass()) return false;
		var that = (Address) obj;
		return Objects.equals(this.id, that.id) &&
				Objects.equals(this.personIdentifier, that.personIdentifier) &&
				Objects.equals(this.city, that.city) &&
				Objects.equals(this.province, that.province) &&
				Objects.equals(this.country, that.country) &&
				Objects.equals(this.streetName, that.streetName) &&
				Objects.equals(this.postalCode, that.postalCode) &&
				Objects.equals(this.streetType, that.streetType);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, personIdentifier, city, province, country, streetName, postalCode, streetType);
	}

	@Override
	public String toString() {
		return "Address[" +
				"id=" + id + ", " +
				"personIdentifier=" + personIdentifier + ", " +
				"city=" + city + ", " +
				"province=" + province + ", " +
				"country=" + country + ", " +
				"streetName=" + streetName + ", " +
				"postalCode=" + postalCode + ", " +
				"streetType=" + streetType + ']';
	}

}
