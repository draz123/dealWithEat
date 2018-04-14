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
  CONSTRAINT restaurant_pkey PRIMARY KEY (id)
);


CREATE TABLE offer (
  id            INTEGER,
  restaurant_id INTEGER                NOT NULL REFERENCES restaurant (id),
  description   CHARACTER VARYING(255) NOT NULL,
  price         DOUBLE PRECISION       NOT NULL,
  discount      INTEGER                NOT NULL,
  count         INTEGER                NOT NULL,
  image         TEXT,
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
  date         TIMESTAMP              NOT NULL,
  state        CHARACTER VARYING(20)  NOT NULL,
  receive_time TIMESTAMP              NOT NULL,
  CONSTRAINT transaction_pkey PRIMARY KEY (id)
);


CREATE TABLE public.transaction_offer_link (
  id             INTEGER,
  transaction_id INTEGER REFERENCES transaction (id),
  offer_id       INTEGER REFERENCES offer (id),
  count        INTEGER                NOT NULL,
  CONSTRAINT transaction_offer_link_pkey PRIMARY KEY (id)
);


CREATE SEQUENCE user_sequence
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 9223372036854775807
CACHE 1;


CREATE SEQUENCE restaurant_sequence
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 9223372036854775807
CACHE 1;


CREATE SEQUENCE transaction_sequence
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 9223372036854775807
CACHE 1;


CREATE SEQUENCE offer_sequence
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 9223372036854775807
CACHE 1;

CREATE SEQUENCE transaction_offer_link_sequence
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 9223372036854775807
CACHE 1;

