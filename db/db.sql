CREATE TABLE batch.user (
  id       INTEGER,
  NAME     CHARACTER VARYING(255) NOT NULL,
  surname  CHARACTER VARYING(255) NOT NULL,
  nickname CHARACTER VARYING(255) NOT NULL,
  CONSTRAINT user_pkey PRIMARY KEY (id)
);


CREATE TABLE batch.restaurant (
  id          INTEGER,
  name        CHARACTER VARYING(255),
  address     CHARACTER VARYING(255),
  website     CHARACTER VARYING(255),
  description CHARACTER VARYING(255),
  latitude    DOUBLE PRECISION NOT NULL,
  longtitude  DOUBLE PRECISION NOT NULL,
  CONSTRAINT restaurant_pkey PRIMARY KEY (id)
);


CREATE TABLE batch.payment (
  id            INTEGER,
  user_id       INTEGER                NOT NULL REFERENCES batch.user (id),
  restaurant_id INTEGER                NOT NULL REFERENCES batch.restaurant (id),
  code          CHARACTER VARYING(255) NOT NULL,
  CONSTRAINT payment_pkey PRIMARY KEY (id)
);


CREATE TABLE batch.meal (
  id            INTEGER,
  restaurant_id INTEGER                NOT NULL REFERENCES batch.restaurant (id),
  descriptipn   CHARACTER VARYING(255) NOT NULL,
  price         DOUBLE PRECISION       NOT NULL,
  discount      INTEGER                NOT NULL,
  CONSTRAINT meal_pkey PRIMARY KEY (id)
);


CREATE SEQUENCE batch.user_sequence
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 9223372036854775807
CACHE 1;


CREATE SEQUENCE batch.restaurant_sequence
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 9223372036854775807
CACHE 1;


CREATE SEQUENCE batch.payment_sequence
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 9223372036854775807
CACHE 1;


CREATE SEQUENCE batch.meal_sequence
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 9223372036854775807
CACHE 1;

-- Test data

INSERT INTO batch.restaurant (
  id, name, address, website, description, latitude, longtitude)
VALUES (1000, 'Georgia Taste', 'Krakow Sucha 3/11', 'www.georgia-taste.pl', 'Very good georgian restaurant', 11.223, 22.111);
INSERT INTO batch.restaurant (
  id, name, address, website, description, latitude, longtitude)
VALUES (1001, 'Ukraine Tastee', 'Krakow Lodowa 93/1', 'www.ukr-taste.pl', 'Very good ukrainian restaurant', 11.624, 24.011);
INSERT INTO batch.restaurant (
  id, name, address, website, description, latitude, longtitude)
VALUES (1002, 'Baba Burger', 'Krakow Mazowiecka 3', 'www.boba-burger.pl', 'Very good burger restaurant', 12.623, 23.908);

INSERT INTO batch.restaurant
VALUES (100, 'Albert', 'Podraza', 'albpod')

