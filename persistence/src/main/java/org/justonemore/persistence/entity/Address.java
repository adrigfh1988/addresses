package org.justonemore.persistence.entity;

import org.springframework.data.annotation.Id;


public record Address(@Id Integer id, String personIdentifier,
					  String city, String province,
					  String country, String streetName,
					  String postalCode, String streetType) {

}
