
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
  CONSTRAINT restaurant_pkey PRIMARY KEY (id)
);


CREATE TABLE offer (
  id            INTEGER,
  restaurant_id INTEGER                NOT NULL REFERENCES restaurant (id),
  description   CHARACTER VARYING(255) NOT NULL,
  price         DOUBLE PRECISION       NOT NULL,
  discount      INTEGER                NOT NULL,
  count         INTEGER                NOT NULL,
  CONSTRAINT offer_pkey PRIMARY KEY (id)
);


CREATE TABLE restaurant_employee (
  email         CHARACTER VARYING(255) REFERENCES "user" (email),
  restaurant_id INTEGER NOT NULL REFERENCES restaurant (id),
  CONSTRAINT restaurant_employee_pkey PRIMARY KEY (email, restaurant_id)
);


CREATE TABLE transaction (
  id       INTEGER,
  offer_id INTEGER REFERENCES offer (id),
  code     CHARACTER VARYING(255) NOT NULL,
  date     TIMESTAMP              NOT NULL,
  count    INTEGER                NOT NULL,
  state    CHARACTER VARYING(20)  NOT NULL,
  CONSTRAINT transaction_pkey PRIMARY KEY (id)
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

-- Test data --


-- Restaurants --

INSERT INTO restaurant (
  id, name, address, website, description, latitude, longtitude)
VALUES
  (1, 'Georgia Taste', 'Krakow Sucha 3/11', 'www.georgia-taste.pl', 'Very good georgian restaurant', 11.223, 22.111);

INSERT INTO restaurant (
  id, name, address, website, description, latitude, longtitude)
VALUES
  (2, 'Baba Burger', 'Krakow Mazowiecka 3', 'www.boba-burger.pl', 'Very good burger restaurant', 12.623, 23.908);

INSERT INTO restaurant (
  id, name, address, website, description, latitude, longtitude)
VALUES
  (3, 'Ching Ye', 'Krakow, Sw. Getrudy 3', 'www.ching-ye.pl', 'Excellent chinesse kitchen', 13.623, 22.908);

INSERT INTO restaurant (
  id, name, address, website, description, latitude, longtitude)
VALUES
  (4, 'Ukraine Tastee', 'Krakow Lodowa 93/1', 'www.ukr-taste.pl', 'Very good ukrainian restaurant', 11.624, 24.011);

-- Users --
INSERT INTO "user"
VALUES ('user1@user.com', '﻿$2a$10$.hrDfkuRmSjgLklytVcVd.c6vFRlm51D9UVpgdUIJjEWYh5xd/2bW', 'USER');

INSERT INTO "user"
VALUES ('user2@restaurant.com', '﻿$2a$10$9udkxEFkrI9tiuzbthIBaOUx6eK9YOMBW9d15nGCKYnUfMrW.HaGC', 'RESTAURANT');


INSERT INTO "user"
VALUES ('user3@user.com', '﻿$2a$10$fnzPdsK9d6UAZjEe3HgPXes/8PpKOTWn7FMB/Fo6MLGs6myIcYNZG.HaGC', 'USER');

-- Restaurant employees --

INSERT INTO restaurant_employee (
  email, restaurant_id)
VALUES ('user2@restaurant.com', 3);
-- Offers --

INSERT INTO offer (
  id, restaurant_id, description, price, discount, count)
VALUES (1, 1, 'Khinhali(200g)', 10, 50, 5);

INSERT INTO offer (
  id, restaurant_id, description, price, discount, count)
VALUES (2, 1, 'Roladki z bakłażana z orzechami(120g)', 12, 25, 10);

INSERT INTO offer (
  id, restaurant_id, description, price, discount, count)
VALUES (3, 1, 'Chaczapuri megreuli(350g)', 16, 40, 3);

INSERT INTO offer (
  id, restaurant_id, description, price, discount, count)
VALUES (4, 1, 'Półmisek gruzińskich przystawek dla dwóch osób(800g)', 52, 50, 10);

INSERT INTO offer (
  id, restaurant_id, description, price, discount, count)
VALUES (5, 1, 'Zupa charczo(300g)', 14.9, 20, 3);

INSERT INTO offer (
  id, restaurant_id, description, price, discount, count)
VALUES (6, 1, 'Szaszłyk gruziński z wieprzowiny(600g)', 34, 70, 20);

INSERT INTO offer (
  id, restaurant_id, description, price, discount, count)
VALUES (7, 1, 'Gulasz z baraniny z bakłażanem', 43, 80, 1);

INSERT INTO offer (
  id, restaurant_id, description, price, discount, count)
VALUES (8, 2, 'Classic corner', 17, 20, 5);

INSERT INTO offer (
  id, restaurant_id, description, price, discount, count)
VALUES (9, 2, 'Massive Beef Attack', 27, 45, 4);

INSERT INTO offer (
  id, restaurant_id, description, price, discount, count)
VALUES (10, 2, 'Polish Pride', 20, 60, 8);

INSERT INTO offer (
  id, restaurant_id, description, price, discount, count)
VALUES (11, 2, 'The Boss', 21, 33, 3);

INSERT INTO offer (
  id, restaurant_id, description, price, discount, count)
VALUES (12, 2, 'Pesto Beef', 21, 55, 1);

INSERT INTO offer (
  id, restaurant_id, description, price, discount, count)
VALUES (13, 3, 'Chipsy z krewetek', 5.5, 10, 1);

INSERT INTO offer (
  id, restaurant_id, description, price, discount, count)
VALUES (14, 3, 'Pierożki z nadzieniem serowym', 6.3, 5, 11);

INSERT INTO offer (
  id, restaurant_id, description, price, discount, count)
VALUES (15, 3, 'Cesarski kociołek trzech mięs w sosie sojowym', 42.8, 40, 2);

INSERT INTO offer (
  id, restaurant_id, description, price, discount, count)
VALUES (16, 3, 'Ostry gulasz dla dwóch osób', 38.8, 50, 6);

INSERT INTO offer (
  id, restaurant_id, description, price, discount, count)
VALUES (17, 3, 'Tie-pan Gorący półmisek mięs', 30.8, 44, 4);

INSERT INTO offer (
  id, restaurant_id, description, price, discount, count)
VALUES (18, 3, 'Cielęcina w ostryn sosie', 39.8, 37, 2);

INSERT INTO offer (
  id, restaurant_id, description, price, discount, count)
VALUES (19, 4, 'Czeburek', 89.8, 77, 2);

INSERT INTO offer (
  id, restaurant_id, description, price, discount, count)
VALUES (20, 4, 'Cielęcina w ostryn sosie', 39.8, 37, 2);

INSERT INTO offer (
  id, restaurant_id, description, price, discount, count)
VALUES (21, 4, 'Schab po lwowsku', 55, 61, 22);

INSERT INTO offer (
  id, restaurant_id, description, price, discount, count)
VALUES (22, 4, 'Stek wieprzowy po kozacku', 39, 33, 6);

-- Transactions --

INSERT INTO transaction (id, offer_id, code, date, count, state)
VALUES (2, 1, '58885', '2018-03-7 14:18:07.513', 2, 'COMPLETED');
INSERT INTO transaction (id, offer_id, code, date, count, state)
VALUES (3, 3, '26985', '2018-03-7 10:18:20.358', 1, 'CANCELED');
INSERT INTO transaction (id, offer_id, code, date, count, state)
VALUES (4, 5, '12122', '2018-03-7 16:18:26.225', 2, 'COMPLETED');
INSERT INTO transaction (id, offer_id, code, date, count, state)
VALUES (5, 22, '44246', '2018-03-7 11:18:29.994', 1, 'MISSED');
INSERT INTO transaction (id, offer_id, code, date, count, state)
VALUES (6, 22, '16269', '2018-03-7 13:18:30.98', 1, 'COMPLETED');
INSERT INTO transaction (id, offer_id, code, date, count, state)
VALUES (7, 21, '99652', '2018-03-7 14:18:33.781', 1, 'MISSED');
INSERT INTO transaction (id, offer_id, code, date, count, state)
VALUES (8, 19, '94006', '2018-03-3 10:18:42.255', 3, 'COMPLETED');
INSERT INTO transaction (id, offer_id, code, date, count, state)
VALUES (9, 18, '91151', '2018-02-11 10:18:48.448', 1, 'CANCELED');
INSERT INTO transaction (id, offer_id, code, date, count, state)
VALUES (10, 14, '56773', '2018-03-2 17:18:52.042', 1, 'COMPLETED');
INSERT INTO transaction (id, offer_id, code, date, count, state)
VALUES (11, 14, '63100', '2018-03-10 19:18:52.931', 1, 'MISSED');
INSERT INTO transaction (id, offer_id, code, date, count, state)
VALUES (12, 14, '54566', '2018-03-10 15:18:55.24', 2, 'COMPLETED');
INSERT INTO transaction (id, offer_id, code, date, count, state)
VALUES (13, 12, '83749', '2018-03-10 13:19:01.586', 1, 'MISSED');
INSERT INTO transaction (id, offer_id, code, date, count, state)
VALUES (14, 11, '12536', '2018-03-10 9:19:40.781', 1, 'COMPLETED');
INSERT INTO transaction (id, offer_id, code, date, count, state)
VALUES (15, 11, '76537', '2018-03-10 12:19:41.526', 1, 'MISSED');
INSERT INTO transaction (id, offer_id, code, date, count, state)
VALUES (16, 11, '18774', '2018-03-10 14:19:42.166', 1, 'COMPLETED');
INSERT INTO transaction (id, offer_id, code, date, count, state)
VALUES (17, 11, '72497', '2018-03-10 14:19:42.789', 1, 'CANCELED');
INSERT INTO transaction (id, offer_id, code, date, count, state)
VALUES (18, 11, '96182', '2018-03-10 14:19:43.336', 1, 'COMPLETED');
INSERT INTO transaction (id, offer_id, code, date, count, state)
VALUES (19, 9, '95211', '2018-03-10 14:19:49.367', 1, 'MISSED');
INSERT INTO transaction (id, offer_id, code, date, count, state)
VALUES (20, 13, '85061', '2018-03-10 14:19:58.739', 2, 'COMPLETED');
INSERT INTO transaction (id, offer_id, code, date, count, state)
VALUES (21, 4, '22708', '2018-03-4 14:20:14.049', 1, 'MISSED');
INSERT INTO transaction (id, offer_id, code, date, count, state)
VALUES (22, 4, '60720', '2018-03-6 14:20:14.66', 1, 'COMPLETED');
INSERT INTO transaction (id, offer_id, code, date, count, state)
VALUES (23, 4, '58616', '2018-03-8 14:20:15.227', 1, 'MISSED');
INSERT INTO transaction (id, offer_id, code, date, count, state)
VALUES (24, 5, '79005', '2018-03-9 14:20:17.988', 1, 'COMPLETED');
INSERT INTO transaction (id, offer_id, code, date, count, state)
VALUES (25, 5, '96541', '2018-03-10 14:20:18.499', 1, 'CANCELED');
INSERT INTO transaction (id, offer_id, code, date, count, state)
VALUES (26, 6, '10214', '2018-03-10 14:20:24.934', 2, 'COMPLETED');
INSERT INTO transaction (id, offer_id, code, date, count, state)
VALUES (27, 8, '54480', '2018-03-7 14:20:42.988', 1, 'MISSED');
INSERT INTO transaction (id, offer_id, code, date, count, state)
VALUES (28, 8, '89889', '2018-03-1 14:20:43.437', 1, 'COMPLETED');
INSERT INTO transaction (id, offer_id, code, date, count, state)
VALUES (29, 8, '81651', '2018-03-10 14:20:44.083', 1, 'MISSED');
INSERT INTO transaction (id, offer_id, code, date, count, state)
VALUES (30, 8, '86256', '2018-03-6 14:20:44.713', 1, 'COMPLETED');
INSERT INTO transaction (id, offer_id, code, date, count, state)
VALUES (31, 8, '78704', '2018-03-10 14:20:46.286', 1, 'MISSED');
INSERT INTO transaction (id, offer_id, code, date, count, state)
VALUES (32, 8, '39815', '2018-03-4 14:20:47.569', 1, 'COMPLETED');
INSERT INTO transaction (id, offer_id, code, date, count, state)
VALUES (33, 18, '98537', '2018-03-10 14:20:57.128', 1, 'CANCELED');
INSERT INTO transaction (id, offer_id, code, date, count, state)
VALUES (34, 18, '43682', '2018-03-10 14:20:57.799', 1, 'COMPLETED');
INSERT INTO transaction (id, offer_id, code, date, count, state)
VALUES (35, 10, '12898', '2018-03-10 14:21:14.319', 1, 'MISSED');
INSERT INTO transaction (id, offer_id, code, date, count, state)
VALUES (36, 7, '73210', '2018-03-3 14:21:19.767', 1, 'COMPLETED');
INSERT INTO transaction (id, offer_id, code, date, count, state)
VALUES (37, 7, '70903', '2018-03-2 14:21:20.288', 1, 'MISSED');
INSERT INTO transaction (id, offer_id, code, date, count, state)
VALUES (38, 6, '40570', '2018-03-10 14:21:51.75', 1, 'COMPLETED');
INSERT INTO transaction (id, offer_id, code, date, count, state)
VALUES (39, 6, '67426', '2018-03-8 14:21:52.24', 1, 'MISSED');
INSERT INTO transaction (id, offer_id, code, date, count, state)
VALUES (40, 6, '96384', '2018-02-10 14:21:52.716', 1, 'COMPLETED');
INSERT INTO transaction (id, offer_id, code, date, count, state)
VALUES (41, 6, '79106', '2018-03-10 14:21:53.191', 1, 'CANCELED');
INSERT INTO transaction (id, offer_id, code, date, count, state)
VALUES (42, 6, '50601', '2018-03-5 14:21:53.658', 1, 'COMPLETED');
INSERT INTO transaction (id, offer_id, code, date, count, state)
VALUES (43, 6, '89355', '2018-03-7 14:21:54.214', 1, 'CANCELED');
