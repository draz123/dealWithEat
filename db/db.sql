DO $$
BEGIN

  IF NOT EXISTS(
      SELECT 1
      FROM pg_catalog.pg_user
      WHERE usename = 'yummy')
  THEN

    CREATE USER yummy WITH
      LOGIN
      PASSWORD 'yummy1234'
      SUPERUSER
      INHERIT
      NOREPLICATION;
  END IF;
END
$$;

CREATE SCHEMA IF NOT EXISTS yummy;

CREATE TABLE yummy.user (
  email      CHARACTER VARYING(255) NOT NULL,
  password   CHARACTER VARYING(255) NOT NULL,
  group_name CHARACTER VARYING(255) NOT NULL,
  CONSTRAINT user_pkey PRIMARY KEY (email)
);


CREATE TABLE yummy.restaurant (
  id          INTEGER,
  name        CHARACTER VARYING(255),
  address     CHARACTER VARYING(255),
  website     CHARACTER VARYING(255),
  description CHARACTER VARYING(255),
  latitude    DOUBLE PRECISION NOT NULL,
  longtitude  DOUBLE PRECISION NOT NULL,
  CONSTRAINT restaurant_pkey PRIMARY KEY (id)
);


CREATE TABLE yummy.offer (
  id            INTEGER,
  restaurant_id INTEGER                NOT NULL REFERENCES yummy.restaurant (id),
  descriptipn   CHARACTER VARYING(255) NOT NULL,
  price         DOUBLE PRECISION       NOT NULL,
  discount      INTEGER                NOT NULL,
  count         INTEGER                NOT NULL,
  CONSTRAINT offer_pkey PRIMARY KEY (id)
);


CREATE TABLE yummy.restaurant_employee (
  email         CHARACTER VARYING(255) REFERENCES yummy.user (email),
  restaurant_id INTEGER NOT NULL REFERENCES yummy.restaurant (id),
  CONSTRAINT restaurant_employee_pkey PRIMARY KEY (email, restaurant_id)
);


CREATE TABLE yummy.transaction (
  id          INTEGER,
  offer_id    INTEGER REFERENCES yummy.offer (id),
  code        CHARACTER VARYING(255) NOT NULL,
  date        TIMESTAMP              NOT NULL,
  offer_count INTEGER                NOT NULL,
  CONSTRAINT transaction_pkey PRIMARY KEY (id)
);


CREATE TABLE yummy.offer_history (
  id       INTEGER,
  offer_id INTEGER REFERENCES yummy.offer (id),
  count    INTEGER NOT NULL,
  CONSTRAINT offer_history_pkey PRIMARY KEY (id)
);


CREATE SEQUENCE yummy.user_sequence
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 9223372036854775807
CACHE 1;


CREATE SEQUENCE yummy.restaurant_sequence
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 9223372036854775807
CACHE 1;


CREATE SEQUENCE yummy.transaction_sequence
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 9223372036854775807
CACHE 1;


CREATE SEQUENCE yummy.offer_sequence
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 9223372036854775807
CACHE 1;

CREATE SEQUENCE yummy.offer_history_sequence
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 9223372036854775807
CACHE 1;

-- Test data

INSERT INTO yummy.restaurant (
  id, name, address, website, description, latitude, longtitude)
VALUES
  (1, 'Georgia Taste', 'Krakow Sucha 3/11', 'www.georgia-taste.pl', 'Very good georgian restaurant', 11.223, 22.111);
INSERT INTO yummy.restaurant (
  id, name, address, website, description, latitude, longtitude)
VALUES
  (2, 'Ukraine Tastee', 'Krakow Lodowa 93/1', 'www.ukr-taste.pl', 'Very good ukrainian restaurant', 11.624, 24.011);
INSERT INTO yummy.restaurant (
  id, name, address, website, description, latitude, longtitude)
VALUES
  (3, 'Baba Burger', 'Krakow Mazowiecka 3', 'www.boba-burger.pl', 'Very good burger restaurant', 12.623, 23.908);


INSERT INTO yummy.user
VALUES ('user1@user.com', 'user1', 'user');

INSERT INTO yummy.user
VALUES ('user2@restaurant.com', 'user2', 'restaurant');


INSERT INTO yummy.offer (
  id, restaurant_id, descriptipn, price, discount, count)
VALUES (1, 1, 'Khinhali', 10, 50, 3);

INSERT INTO yummy.offer (
  id, restaurant_id, descriptipn, price, discount, count)
VALUES (2, 2, 'Ukrainina dumplings', 5, 30, 10);

INSERT INTO yummy.offer (
  id, restaurant_id, descriptipn, price, discount, count)
VALUES (3, 3, 'Super Burger', 10, 40, 4);


INSERT INTO yummy.restaurant_employee(
email, restaurant_id)
VALUES ('user2@restaurant.com', 1);