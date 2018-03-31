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
  image         text,
  CONSTRAINT offer_pkey PRIMARY KEY (id)
);


CREATE TABLE restaurant_employee (
  email         CHARACTER VARYING(255) REFERENCES "user" (email),
  restaurant_id INTEGER NOT NULL REFERENCES restaurant (id),
  CONSTRAINT restaurant_employee_pkey PRIMARY KEY (email, restaurant_id)
);


CREATE TABLE transaction (
  id           INTEGER,
  offer_id     INTEGER REFERENCES offer (id),
  code         CHARACTER VARYING(255) NOT NULL,
  date         TIMESTAMP              NOT NULL,
  count        INTEGER                NOT NULL,
  state        CHARACTER VARYING(20)  NOT NULL,
  receive_time TIMESTAMP              NOT NULL,
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
  id, restaurant_id, description, price, discount, count, image)
VALUES (1, 1, 'Khinhali(200g)', 10, 50, 5, null);

INSERT INTO offer (
  id, restaurant_id, description, price, discount, count, image)
VALUES (2, 1, 'Roladki z bakłażana z orzechami(120g)', 12, 25, 10, null);

INSERT INTO offer (
  id, restaurant_id, description, price, discount, count, image)
VALUES (3, 1, 'Chaczapuri megreuli(350g)', 16, 40, 3, null);

INSERT INTO offer (
  id, restaurant_id, description, price, discount, count, image)
VALUES (4, 1, 'Półmisek gruzińskich przystawek dla dwóch osób(800g)', 52, 50, 10, null);

INSERT INTO offer (
  id, restaurant_id, description, price, discount, count, image)
VALUES (5, 1, 'Zupa charczo(300g)', 14.9, 20, 3, null);

INSERT INTO offer (
  id, restaurant_id, description, price, discount, count, image)
VALUES (6, 1, 'Szaszłyk gruziński z wieprzowiny(600g)', 34, 70, 20, null);

INSERT INTO offer (
  id, restaurant_id, description, price, discount, count, image)
VALUES (7, 1, 'Gulasz z baraniny z bakłażanem', 43, 80, 1, null);

INSERT INTO offer (
  id, restaurant_id, description, price, discount, count, image)
VALUES (8, 2, 'Classic corner', 17, 20, 5, null);

INSERT INTO offer (
  id, restaurant_id, description, price, discount, count, image)
VALUES (9, 2, 'Massive Beef Attack', 27, 45, 4, null);

INSERT INTO offer (
  id, restaurant_id, description, price, discount, count, image)
VALUES (10, 2, 'Polish Pride', 20, 60, 8, null);

INSERT INTO offer (
  id, restaurant_id, description, price, discount, count, image)
VALUES (11, 2, 'The Boss', 21, 33, 3, null);

INSERT INTO offer (
  id, restaurant_id, description, price, discount, count, image)
VALUES (12, 2, 'Pesto Beef', 21, 55, 1, null);

INSERT INTO offer (
  id, restaurant_id, description, price, discount, count, image)
VALUES (13, 3, 'Chipsy z krewetek', 5.5, 10, 1, null);

INSERT INTO offer (
  id, restaurant_id, description, price, discount, count, image)
VALUES (14, 3, 'Pierożki z nadzieniem serowym', 6.3, 5, 11, null);

INSERT INTO offer (
  id, restaurant_id, description, price, discount, count, image)
VALUES (15, 3, 'Cesarski kociołek trzech mięs w sosie sojowym', 42.8, 40, 2, null);

INSERT INTO offer (
  id, restaurant_id, description, price, discount, count, image)
VALUES (16, 3, 'Ostry gulasz dla dwóch osób', 38.8, 50, 6, null);

INSERT INTO offer (
  id, restaurant_id, description, price, discount, count, image)
VALUES (17, 3, 'Tie-pan Gorący półmisek mięs', 30.8, 44, 4, null);

INSERT INTO offer (
  id, restaurant_id, description, price, discount, count, image)
VALUES (18, 3, 'Cielęcina w ostryn sosie', 39.8, 37, 2, null);

INSERT INTO offer (
  id, restaurant_id, description, price, discount, count, image)
VALUES (19, 4, 'Czeburek', 89.8, 77, 2, null);

INSERT INTO offer (
  id, restaurant_id, description, price, discount, count, image)
VALUES (20, 4, 'Cielęcina w ostryn sosie', 39.8, 37, 2, null);

INSERT INTO offer (
  id, restaurant_id, description, price, discount, count, image)
VALUES (21, 4, 'Schab po lwowsku', 55, 61, 22, null);

INSERT INTO offer (
  id, restaurant_id, description, price, discount, count, image)
VALUES (22, 4, 'Stek wieprzowy po kozacku', 39, 33, 6, null);

-- Transactions --

insert into transaction (id, offer_id, code, date, count, state, receive_time) values (1, 15, 53850, '2018-02-20 22:52:27', 10, 'MISSED', ' 2018-02-20 22:13:00');
insert into transaction (id, offer_id, code, date, count, state, receive_time) values (2, 6, 15076, '2018-01-24 12:48:44', 7, 'COMPLETED', ' 2018-01-24 14:16:00');
insert into transaction (id, offer_id, code, date, count, state, receive_time) values (3, 1, 92351, '2018-02-21 22:36:31', 5, 'MISSED', ' 2018-02-21 11:52:00');
insert into transaction (id, offer_id, code, date, count, state, receive_time) values (4, 22, 66594, '2018-02-19 04:11:37', 7, 'COMPLETED', ' 2018-02-19 13:01:00');
insert into transaction (id, offer_id, code, date, count, state, receive_time) values (5, 19, 92894, '2018-01-20 13:41:38', 1, 'COMPLETED', ' 2018-01-20 21:28:00');
insert into transaction (id, offer_id, code, date, count, state, receive_time) values (6, 7, 51258, '2018-01-12 03:11:59', 4, 'MISSED', ' 2018-01-12 23:05:00');
insert into transaction (id, offer_id, code, date, count, state, receive_time) values (7, 1, 63696, '2018-02-24 09:31:24', 1, 'COMPLETED', ' 2018-02-24 13:42:00');
insert into transaction (id, offer_id, code, date, count, state, receive_time) values (8, 15, 54542, '2018-03-04 06:42:11', 1, 'COMPLETED', ' 2018-03-04 11:00:52');
insert into transaction (id, offer_id, code, date, count, state, receive_time) values (9, 6, 52171, '2018-01-28 22:48:23', 1, 'COMPLETED', ' 2018-01-28 15:08:00');
insert into transaction (id, offer_id, code, date, count, state, receive_time) values (10, 8, 64669, '2018-02-24 13:12:31', 1, 'CANCELED', ' 2018-02-24 18:07:00');
insert into transaction (id, offer_id, code, date, count, state, receive_time) values (11, 9, 86900, '2018-02-24 04:54:04', 7, 'MISSED', ' 2018-02-24 18:46:00');
insert into transaction (id, offer_id, code, date, count, state, receive_time) values (12, 4, 63622, '2018-01-22 12:43:21', 4, 'MISSED', ' 2018-01-22 22:17:00');
insert into transaction (id, offer_id, code, date, count, state, receive_time) values (13, 3, 63528, '2018-02-16 18:58:45', 6, 'MISSED', ' 2018-02-16 13:25:00');
insert into transaction (id, offer_id, code, date, count, state, receive_time) values (14, 6, 29729, '2018-03-16 16:51:05', 4, 'MISSED', ' 2018-03-16 13:25:00');
insert into transaction (id, offer_id, code, date, count, state, receive_time) values (15, 9, 13327, '2018-01-24 14:55:20', 2, 'COMPLETED', ' 2018-01-24 21:12:00');
insert into transaction (id, offer_id, code, date, count, state, receive_time) values (16, 2, 75793, '2018-01-04 12:28:24', 1, 'MISSED', ' 2018-01-04 17:25:00');
insert into transaction (id, offer_id, code, date, count, state, receive_time) values (17, 5, 38218, '2018-02-18 20:32:20', 1, 'MISSED', ' 2018-02-18 12:59:00');
insert into transaction (id, offer_id, code, date, count, state, receive_time) values (18, 18, 28178, '2018-01-05 16:20:54', 1, 'MISSED', ' 2018-01-05 20:32:00');
insert into transaction (id, offer_id, code, date, count, state, receive_time) values (19, 15, 92097, '2018-01-11 05:23:22', 1, 'COMPLETED', ' 2018-01-11 15:11:00');
insert into transaction (id, offer_id, code, date, count, state, receive_time) values (20, 7, 14883, '2018-03-13 01:53:38', 4, 'COMPLETED', ' 2018-03-13 21:49:00');
insert into transaction (id, offer_id, code, date, count, state, receive_time) values (21, 14, 21370, '2018-01-21 05:27:05', 4, 'MISSED', ' 2018-01-21 14:50:00');
insert into transaction (id, offer_id, code, date, count, state, receive_time) values (22, 14, 85469, '2018-01-29 03:16:06', 2, 'COMPLETED', ' 2018-01-29 11:32:00');
insert into transaction (id, offer_id, code, date, count, state, receive_time) values (23, 2, 15616, '2018-02-12 10:55:33', 9, 'COMPLETED', ' 2018-02-12 19:18:00');
insert into transaction (id, offer_id, code, date, count, state, receive_time) values (24, 7, 94010, '2018-01-07 10:28:54', 9, 'CANCELED', ' 2018-01-07 12:46:00');
insert into transaction (id, offer_id, code, date, count, state, receive_time) values (25, 14, 19108, '2018-01-19 08:25:16', 6, 'COMPLETED', ' 2018-01-19 19:38:00');
insert into transaction (id, offer_id, code, date, count, state, receive_time) values (26, 22, 63566, '2018-03-13 15:11:10', 2, 'MISSED', ' 2018-03-13 12:17:00');
insert into transaction (id, offer_id, code, date, count, state, receive_time) values (27, 16, 77058, '2018-01-10 06:05:21', 1, 'COMPLETED', ' 2018-01-10 20:23:00');
insert into transaction (id, offer_id, code, date, count, state, receive_time) values (28, 6, 52705, '2018-01-10 09:30:05', 1, 'MISSED', ' 2018-01-10 19:26:00');
insert into transaction (id, offer_id, code, date, count, state, receive_time) values (29, 4, 29498, '2018-03-30 12:47:20', 2, 'COMPLETED', ' 2018-03-30 20:43:00');
insert into transaction (id, offer_id, code, date, count, state, receive_time) values (30, 21, 69997, '2018-01-12 08:35:19', 1, 'MISSED', ' 2018-01-12 18:35:00');
insert into transaction (id, offer_id, code, date, count, state, receive_time) values (31, 20, 48886, '2018-01-24 21:49:10', 3, 'CANCELED', ' 2018-01-24 20:17:00');
insert into transaction (id, offer_id, code, date, count, state, receive_time) values (32, 14, 66358, '2018-02-15 14:28:45', 1, 'COMPLETED', ' 2018-02-15 23:46:00');
insert into transaction (id, offer_id, code, date, count, state, receive_time) values (33, 21, 33501, '2018-01-01 07:38:22', 2, 'MISSED', ' 2018-01-01 22:33:00');
insert into transaction (id, offer_id, code, date, count, state, receive_time) values (34, 9, 20641, '2018-03-17 16:59:42', 3, 'MISSED', ' 2018-03-17 18:00:00');
insert into transaction (id, offer_id, code, date, count, state, receive_time) values (35, 8, 55804, '2018-03-02 04:09:43', 1, 'COMPLETED', ' 2018-03-02 19:20:00');
insert into transaction (id, offer_id, code, date, count, state, receive_time) values (36, 21, 89124, '2018-03-15 20:24:32', 2, 'CANCELED', ' 2018-03-15 12:50:00');
insert into transaction (id, offer_id, code, date, count, state, receive_time) values (37, 12, 81526, '2018-03-13 10:54:17', 1, 'CANCELED', ' 2018-03-13 22:06:00');
insert into transaction (id, offer_id, code, date, count, state, receive_time) values (38, 19, 13906, '2018-02-18 16:16:19', 4, 'COMPLETED', ' 2018-02-18 17:30:00');
insert into transaction (id, offer_id, code, date, count, state, receive_time) values (39, 1, 38408, '2018-03-05 11:35:06', 1, 'COMPLETED', ' 2018-03-05 20:54:00');
insert into transaction (id, offer_id, code, date, count, state, receive_time) values (40, 3, 17637, '2018-03-10 14:46:38', 8, 'COMPLETED', ' 2018-03-10 15:19:00');
insert into transaction (id, offer_id, code, date, count, state, receive_time) values (41, 4, 68455, '2018-03-12 15:52:23', 9, 'COMPLETED', ' 2018-03-12 20:10:00');
insert into transaction (id, offer_id, code, date, count, state, receive_time) values (42, 2, 33166, '2018-01-25 06:31:03', 1, 'CANCELED', ' 2018-01-25 13:21:00');
insert into transaction (id, offer_id, code, date, count, state, receive_time) values (43, 7, 73299, '2018-03-06 22:15:25', 1, 'CANCELED', ' 2018-03-06 20:15:00');
insert into transaction (id, offer_id, code, date, count, state, receive_time) values (44, 16, 24164, '2018-01-29 01:11:58', 1, 'CANCELED', ' 2018-01-29 20:10:00');
insert into transaction (id, offer_id, code, date, count, state, receive_time) values (45, 9, 96987, '2018-01-19 14:22:43', 5, 'MISSED', ' 2018-01-19 23:47:00');
insert into transaction (id, offer_id, code, date, count, state, receive_time) values (46, 20, 61336, '2018-01-09 03:25:48', 1, 'CANCELED', ' 2018-01-09 14:48:00');
insert into transaction (id, offer_id, code, date, count, state, receive_time) values (47, 11, 17504, '2018-02-03 15:31:48', 9, 'COMPLETED', ' 2018-02-03 22:09:00');
insert into transaction (id, offer_id, code, date, count, state, receive_time) values (48, 5, 58271, '2018-03-31 12:28:17', 4, 'PENDING', ' 2018-02-27 16:30:00');
insert into transaction (id, offer_id, code, date, count, state, receive_time) values (49, 5, 86595, '2018-03-31 10:52:49', 1, 'PENDING', ' 2018-03-16 12:00:00');
insert into transaction (id, offer_id, code, date, count, state, receive_time) values (50, 7, 45293, '2018-03-31 14:37:20', 1, 'PENDING', ' 2018-01-01 18:30:00');

