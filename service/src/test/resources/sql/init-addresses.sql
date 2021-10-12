create table address(
    id serial NOT NULL,
    currency character varying(60) NOT NULL,
    person_identifier character varying(10) NOT NULL,
    city character varying(60) NOT NULL,
    province character varying(60) NOT NULL,
    country character varying(60) NOT NULL,
    streetName character varying(255) NOT NULL,
    postalCode character varying(5) NOT NULL,
    streetType character varying(10) NOT NULL
);