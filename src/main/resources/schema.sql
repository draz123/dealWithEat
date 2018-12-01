DROP TABLE IF EXISTS restaurant_employee;
DROP TABLE IF EXISTS transaction_offer_link;
DROP TABLE IF EXISTS "user";
DROP TABLE IF EXISTS transaction;
DROP TABLE IF EXISTS offer;
DROP TABLE IF EXISTS restaurant;


CREATE TABLE "user" (
  id         INTEGER,
  email      CHARACTER VARYING(255) NOT NULL UNIQUE,
  password   CHARACTER VARYING(255) NOT NULL,
  CONSTRAINT user_pkey PRIMARY KEY (id)
);


CREATE TABLE restaurant (
  id          INTEGER,
  name        CHARACTER VARYING(255),
  address     CHARACTER VARYING(255),
  website     CHARACTER VARYING(255),
  description CHARACTER VARYING(255),
  latitude    DOUBLE PRECISION NOT NULL,
  longtitude  DOUBLE PRECISION NOT NULL,
  image       CHARACTER VARYING(500),
  open_hours  TEXT,
  CONSTRAINT restaurant_pkey PRIMARY KEY (id)
);


CREATE TABLE offer (
  id                 INTEGER,
  restaurant_id      INTEGER                 NOT NULL REFERENCES restaurant (id),
  name               CHARACTER VARYING(500)  NOT NULL,
  description        CHARACTER VARYING(1000) NOT NULL,
  price              DOUBLE PRECISION        NOT NULL,
  discount           INTEGER                 NOT NULL,
  count              INTEGER                 NOT NULL,
  image              CHARACTER VARYING(400),
  receive_time_start TIMESTAMP               NOT NULL,
  receive_time_end   TIMESTAMP               NOT NULL,
  availability_state              CHARACTER VARYING(20)   NOT NULL,
  preparation_time   INTEGER,
  CONSTRAINT offer_pkey PRIMARY KEY (id)
);


CREATE TABLE restaurant_employee (
  user_id         CHARACTER VARYING(255) REFERENCES "user" (id),
  restaurant_id INTEGER NOT NULL REFERENCES restaurant (id),
  CONSTRAINT restaurant_employee_pkey PRIMARY KEY (user_id, restaurant_id)
);


CREATE TABLE transaction (
  id           INTEGER,
  code         CHARACTER VARYING(255) NOT NULL,
  order_time   TIMESTAMP              NOT NULL,
  transaction_state CHARACTER VARYING(20)  NOT NULL,
  cause_state        CHARACTER VARYING(20)  ,
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

CREATE TABLE public.transaction_user_link (
  id             INTEGER,
  transaction_id INTEGER REFERENCES transaction (id),
  user_id       INTEGER REFERENCES offer (id),
  CONSTRAINT transaction_user_link_pkey PRIMARY KEY (id)
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

CREATE SEQUENCE IF NOT EXISTS transaction_user_link_sequence
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 9223372036854775807
CACHE 1;


CREATE SEQUENCE IF NOT EXISTS user_sequence
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 9223372036854775807
CACHE 1;