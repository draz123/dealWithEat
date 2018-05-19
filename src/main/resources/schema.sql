DROP TABLE IF EXISTS restaurant_employee;
DROP TABLE IF EXISTS transaction_offer_link;
DROP TABLE IF EXISTS "user";
DROP TABLE IF EXISTS transaction;
DROP TABLE IF EXISTS offer;
DROP TABLE IF EXISTS restaurant;


CREATE TABLE "user" (
  email      CHARACTER VARYING(255) NOT NULL,
  password   CHARACTER VARYING(255) NOT NULL,
  group_name CHARACTER VARYING(255) NOT NULL,
  CONSTRAINT user_pkey PRIMARY KEY (email)
);


CREATE TABLE restaurant (
  id          INTEGER,
  name        CHARACTER VARYING(255),
  address     CHARACTER VARYING(255),
  website     CHARACTER VARYING(255),
  description CHARACTER VARYING(255),
  latitude    DOUBLE PRECISION NOT NULL,
  longtitude  DOUBLE PRECISION NOT NULL,
  image       TEXT,
  open_hours  TEXT,
  CONSTRAINT restaurant_pkey PRIMARY KEY (id)
);


CREATE TABLE offer (
  id                 INTEGER,
  restaurant_id      INTEGER                 NOT NULL REFERENCES restaurant (id),
  name               CHARACTER VARYING(100)  NOT NULL,
  description        CHARACTER VARYING(1000) NOT NULL,
  price              DOUBLE PRECISION        NOT NULL,
  discount           INTEGER                 NOT NULL,
  count              INTEGER                 NOT NULL,
  image              TEXT,
  receive_time_start TIMESTAMP               NOT NULL,
  receive_time_end   TIMESTAMP               NOT NULL,
  state              CHARACTER VARYING(20)   NOT NULL,
  CONSTRAINT offer_pkey PRIMARY KEY (id)
);


CREATE TABLE restaurant_employee (
  email         CHARACTER VARYING(255) REFERENCES "user" (email),
  restaurant_id INTEGER NOT NULL REFERENCES restaurant (id),
  CONSTRAINT restaurant_employee_pkey PRIMARY KEY (email, restaurant_id)
);


CREATE TABLE transaction (
  id           INTEGER,
  code         CHARACTER VARYING(255) NOT NULL,
  order_time   TIMESTAMP              NOT NULL,
  state        CHARACTER VARYING(20)  NOT NULL,
  receive_time TIMESTAMP              NOT NULL,
  CONSTRAINT transaction_pkey PRIMARY KEY (id)
);


CREATE TABLE public.transaction_offer_link (
  id             INTEGER,
  transaction_id INTEGER REFERENCES transaction (id),
  offer_id       INTEGER REFERENCES offer (id),
  count          INTEGER NOT NULL,
  CONSTRAINT transaction_offer_link_pkey PRIMARY KEY (id)
);


CREATE SEQUENCE IF NOT EXISTS user_sequence
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 9223372036854775807
CACHE 1;


CREATE SEQUENCE IF NOT EXISTS restaurant_sequence
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 9223372036854775807
CACHE 1;


CREATE SEQUENCE IF NOT EXISTS transaction_sequence
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 9223372036854775807
CACHE 1;


CREATE SEQUENCE IF NOT EXISTS offer_sequence
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 9223372036854775807
CACHE 1;

CREATE SEQUENCE IF NOT EXISTS transaction_offer_link_sequence
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 9223372036854775807
CACHE 1;

