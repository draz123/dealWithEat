-- Test data --

-- Users --
-- At this moment, users are added on the application start through mock package

-- INSERT INTO public."user"
-- (email, password, group_name)
-- VALUES('user1@user.com', '$2a$10$9AnKmdcuiamm3ZOCHqV9f.LmyHRjsckCky84iJMiiK6PN/J1ZL9JS', 'USER');
--
-- -- Backward compatibility --
-- INSERT INTO public."user"
-- (email, password, group_name)
-- VALUES('user3@restaurant.com', '$2a$10$Rk23pDDWy6kTqc2wwaRaceHIBqJ/9Rwt/h7mUlmECdHgbxQA.Ym1m', 'RESTAURANT');
--
-- INSERT INTO public."user"
-- (email, password, group_name)
-- VALUES('user2@user.com', '$2a$10$3fVSHfe0w8SC769JjKSbaOONyoBu9X6/V6BlGM1p4K5rGgfm3lLfK', 'USER');
-- INSERT INTO public."user"
-- (email, password, group_name)
-- VALUES('user3@user.com', '$2a$10$THsBRnOa64/6qAw2DsCvcutheKFc2PtAeegvfS15AIn4IwMbydDya', 'USER');
-- INSERT INTO public."user"
-- (email, password, group_name)
-- VALUES('user11@restaurant.com', '$2a$10$6yAGvN8HbMjVCqIjpl9ksey7USpI9TARL9aCNHx.pAYBi0DyE5ZO2', 'RESTAURANT');
-- INSERT INTO public."user"
-- (email, password, group_name)
-- VALUES('user12@restaurant.com', '$2a$10$FSbLYUZv/wD.HPpHeg3iMuNlVKfyZLtxAgUBB1hishvzwxdi8OVZu', 'RESTAURANT');
-- INSERT INTO public."user"
-- (email, password, group_name)
-- VALUES('user13@restaurant.com', '$2a$10$y/6C0ZRu2HAEe2jS5mO7eO8zGnH5DEN2gJXFjUD9N8H6jcLZaXLOq', 'RESTAURANT');
-- INSERT INTO public."user"
-- (email, password, group_name)
-- VALUES('user14@restaurant.com', '$2a$10$fBkAKf0NzdHwyjxczjeDkuxVc.1g/fFt2JmjsNUltORpOOT9GRvaq', 'RESTAURANT');
--
-- -- User - restaurant --
--
-- --Backward compatibility --
-- INSERT INTO public.restaurant_employee
-- (email, restaurant_id)
-- VALUES('user3@restaurant.com', 3);
--
-- INSERT INTO public.restaurant_employee
-- (email, restaurant_id)
-- VALUES('user11@restaurant.com', 1);
-- INSERT INTO public.restaurant_employee
-- (email, restaurant_id)
-- VALUES('user12@restaurant.com', 2);
-- INSERT INTO public.restaurant_employee
-- (email, restaurant_id)
-- VALUES('user13@restaurant.com', 3);
-- INSERT INTO public.restaurant_employee
-- (email, restaurant_id)
-- VALUES('user14@restaurant.com', 4);
--

-- Restaurants --

INSERT INTO restaurant (
  id, name, address, website, description, latitude, longtitude, image, open_hours)
VALUES
  (1, 'Georgia Taste', 'Krakow Sucha 3/11', 'www.georgia-taste.pl', 'Very good georgian restaurant', 50.060203, 19.968040,
   'https://res.cloudinary.com/alb-pod-yummy/image/upload/v1543105454/yummy/restaurants/georgia_taste.jpg' ,'{
	"week": {
		"openTime": "10:00",
		"closeTime": "20:00"
	},
	"saturday": {
		"openTime": "11:00",
		"closeTime": "18:00"
	},
	"sunday": {
		"openTime": "17:00",
		"closeTime": "20:00"
	}
}');

INSERT INTO restaurant (
  id, name, address, website, description, latitude, longtitude, image, open_hours)
VALUES
  (2, 'Baba Burger', 'Krakow Mazowiecka 3', 'www.boba-burger.pl', 'Very good burger restaurant', 50.460203, 20.118040,
  'https://res.cloudinary.com/alb-pod-yummy/image/upload/v1543105453/yummy/restaurants/burger_bar.jpg' , '{
	"week": {
		"openTime": "10:00",
		"closeTime": "20:00"
	},
	"saturday": {
		"openTime": "11:00",
		"closeTime": "18:00"
	},
	"sunday": {
		"openTime": "17:00",
		"closeTime": "20:00"
	}
}');

INSERT INTO restaurant (
  id, name, address, website, description, latitude, longtitude, image, open_hours)
VALUES
  (3, 'Ching Ye', 'Krakow, Sw. Getrudy 3', 'www.ching-ye.pl', 'Excellent chinesse kitchen', 50.075073, 19.931357, 'https://res.cloudinary.com/alb-pod-yummy/image/upload/v1543105449/yummy/restaurants/ching_ye.jpg', '{
	"week": {
		"openTime": "19:00",
		"closeTime": "21:00"
	},
	"saturday": {
		"openTime": "13:00",
		"closeTime": "20:00"
	},
	"sunday": {
		"openTime": "17:00",
		"closeTime": "20:00"
	}
}');

INSERT INTO restaurant (
  id, name, address, website, description, latitude, longtitude, image, open_hours)
VALUES
  (4, 'Ukraine Tastee', 'Krakow Lodowa 93/1', 'www.ukr-taste.pl', 'Very good ukrainian restaurant', 50.033306, 19.938030,
   'https://res.cloudinary.com/alb-pod-yummy/image/upload/v1543105451/yummy/restaurants/ukrainian_taste.jpg', '{
	"week": {
		"openTime": "15:00",
		"closeTime": "24:00"
	},
	"saturday": {
		"openTime": "11:00",
		"closeTime": "18:00"
	},
	"sunday": {
		"openTime": "17:00",
		"closeTime": "20:00"
	}
}');

-- Offers --

INSERT INTO offer (
  id, restaurant_id, name, description, price, discount, count, image, receive_time_start, receive_time_end, state)
VALUES
  (1, 1, 'Khinhali(200g)', 'Delicious dumplings with meat, potato, onion an all the best tastes of Georgian kitchen',
   10, 50, 5,
   'https://res.cloudinary.com/alb-pod-yummy/image/upload/v1539436987/yummy/khinkali.jpg',
   '2018-05-19T14:18:27.457Z', '2018-05-19T20:19:27.457Z', 'ACTUAL');

INSERT INTO offer (
  id, restaurant_id, name, description, price, discount, count, image, receive_time_start, receive_time_end, state)
VALUES (2, 1, 'Roladki z bakłażana z orzechami(120g)',
        'Niesamowite roladki z pysznego bakłażana pokryte wyśmienitymi orzechami włoskimi z południowych pól kaukazu',
        12, 25, 10, 'https://res.cloudinary.com/alb-pod-yummy/image/upload/v1539437040/yummy/roladki-baklazan.jpg',
         '2018-05-19T14:18:27.457Z', '2018-05-19T14:20:27.457Z', 'ACTUAL');

INSERT INTO offer (
  id, restaurant_id, name, description, price, discount, count, image, receive_time_start, receive_time_end, state)
VALUES (3, 1, 'Chaczapuri megreuli(350g)',
        'Tak się złożyło, że podczas wyjazdu do Gruzji strona ziołowo-kulinarna była dla mnie bardzo ważna i miałam możliwość gotowania razem z gruzińską gospodynią. Będę szczera: bardziej skupiłam się na notowaniu przepisów, dopytywaniu, robieniu zdjęć i  filmów, aby móc się z Wami podzielić po powrocie kawałeczkiem Gruzji! Chociaż oczywiście kilka chaczapuri zrobiłam też samodzielnie!',
        16, 40, 3, 'https://res.cloudinary.com/alb-pod-yummy/image/upload/v1539437693/yummy/chaczapuri-megreuli.jpg', '2018-05-19T14:18:27.457Z', '2018-05-19T14:19:27.457Z', 'ACTUAL');

INSERT INTO offer (
  id, restaurant_id, name, description, price, discount, count, image, receive_time_start, receive_time_end, state)
VALUES (4, 1, 'Półmisek gruzińskich przystawek dla dwóch osób(800g)',
        'W Gruzji je się pysznie, obficie, stosunkowo prosto i raczej tanio. Porcje są ogromne, czego nie zawsze wyrazem jest cena, dlatego też niemal każdy obiad czy kolacja kończyła się nadmiarem dań i zabieraniem placków chaczapuri na wynos.',
        52, 50, 10, 'https://res.cloudinary.com/alb-pod-yummy/image/upload/v1539437695/yummy/gruzinskie-przystawki.jpg', '2018-05-19T14:18:27.457Z', '2018-05-19T14:19:27.457Z', 'ACTUAL');

INSERT INTO offer (
  id, restaurant_id, name, description, price, discount, count, image, receive_time_start, receive_time_end, state)
VALUES (5, 1, 'Zupa charczo(300g)',
        'Zupa o konsystencji gulaszu i ostrym, wyrazistym smaku przygotowywana z wołowiny lub jesiotra z dodatkiem migdałów, orzechów włoskich lub laskowych. Tradycyjne danie kuchni kaukaskiej (gruzińskiej). Charczo przyprawiane jest chmeli-suneli.',
        14.9, 20, 3, 'https://res.cloudinary.com/alb-pod-yummy/image/upload/v1539437691/yummy/zupa-charczo.jpg', '2018-05-19T14:18:27.457Z', '2018-05-19T14:19:27.457Z', 'ACTUAL');

INSERT INTO offer (
  id, restaurant_id, name, description, price, discount, count, image, receive_time_start, receive_time_end, state)
VALUES (6, 1, 'Szaszłyk gruziński z wieprzowiny(600g)',
        'Z cielęciny lub wieprzowiny. To duże kawałki mięsa, marynowane w occie, jogurcie i przyprawach, a następnie opiekane na węglach. Soczyste w środku, spieczone po wierzchu podaje się z cebulą, sosem tkemali i gruzińskim chlebkiem. Lub chaczapuri.',
        34, 70, 20, 'https://res.cloudinary.com/alb-pod-yummy/image/upload/v1539437691/yummy/szaszlyk-gruzinski.jpg', '2018-05-19T14:18:27.457Z', '2018-05-19T14:14:27.457Z', 'ACTUAL');

INSERT INTO offer (
  id, restaurant_id, name, description, price, discount, count, image, receive_time_start, receive_time_end, state)
VALUES (7, 1, 'Gulasz z baraniny z bakłażanem',
        'Nieziemsko pyszna i aromatyczna potrawka z baraniny w Gruzji zwana "chanakhi". Zdrowa, bo pieczona w sosie własnym i pełna warzyw. Można ją również przyrządzić z wołowiny.',
        43, 80, 1, 'https://res.cloudinary.com/alb-pod-yummy/image/upload/v1539437692/yummy/gulasz-z-baraniny.jpg', '2018-05-19T14:18:27.457Z', '2018-05-19T14:19:27.457Z', 'ACTUAL');

INSERT INTO offer (
  id, restaurant_id, name, description, price, discount, count, image, receive_time_start, receive_time_end, state)
VALUES (8, 2, 'Classic corner',
        'czyli mojego pierwszego burgera z oferty tego lokalu, spróbowałam w wersji na wynos. Nie ulega wątpliwości, że w takich okolicznościach (na zewnątrz było jakieś minus siedem stopni) trudno zarzucać mu brak odpowiedniej temperatury, ale już kwestią wartą rozważenia jest to, czy całkowicie przesiąknięta na obrzeżach buła, która wyglądała jak namoknięta sosami gąbka, jest winą temperatury, kolegi-dostawcy czy Corner Burgera.',
        17, 20, 5, 'https://res.cloudinary.com/alb-pod-yummy/image/upload/v1539436868/yummy/burger.jpg', '2018-05-19T14:18:27.457Z', '2018-05-19T14:19:27.457Z', 'ACTUAL');

INSERT INTO offer (
  id, restaurant_id, name, description, price, discount, count, image, receive_time_start, receive_time_end, state)
VALUES (9, 2, 'Massive Beef Attack', 'Wołowina 400g, ogórek kiszony, ser cheddar, pomior, bekon', 27, 45, 4, 'https://res.cloudinary.com/alb-pod-yummy/image/upload/v1539437692/yummy/massive-beef-attack.jpg',
        '2018-05-19T14:18:27.457Z', '2018-05-19T14:19:27.457Z', 'ACTUAL');

INSERT INTO offer (
  id, restaurant_id, name, description, price, discount, count, image, receive_time_start, receive_time_end, state)
VALUES (10, 2, 'Polish Pride', 'Wołowina 200g, ogórek kiszony, ser kozi wiejski, kiełbasa, cebula', 20, 60, 8, 'https://res.cloudinary.com/alb-pod-yummy/image/upload/v1539437691/yummy/polish-pride-burger.jpg',
        '2018-05-19T14:18:27.457Z', '2018-05-19T14:19:27.457Z', 'ACTUAL');

INSERT INTO offer (
  id, restaurant_id, name, description, price, discount, count, image, receive_time_start, receive_time_end, state)
VALUES (11, 2, 'The Boss', 'Wołowina 200g, bekon 2x, ser cheddar, sos BBQ, ogórek', 21, 33, 3, 'https://res.cloudinary.com/alb-pod-yummy/image/upload/v1539437692/yummy/the-boss-burger.jpg',
        '2018-05-19T14:18:27.457Z', '2018-05-19T14:19:27.457Z', 'ACTUAL');

INSERT INTO offer (
  id, restaurant_id, name, description, price, discount, count, image, receive_time_start, receive_time_end, state)
VALUES (12, 2, 'Pesto Beef', 'Wołowina 200g, pesto bazyliowe, ser cheddar, bekon', 21, 55, 1, 'https://res.cloudinary.com/alb-pod-yummy/image/upload/v1539437693/yummy/pesto-beef-burger.jpg',
        '2018-05-19T14:18:27.457Z', '2018-05-19T14:19:27.457Z', 'ACTUAL');

INSERT INTO offer (
  id, restaurant_id, name, description, price, discount, count, image, receive_time_start, receive_time_end, state)
VALUES (13, 3, 'Chipsy z krewetek', 'Krewetki 300g, posypka serowa, kanapka cebulowa', 5.5, 10, 1,
        'https://res.cloudinary.com/alb-pod-yummy/image/upload/v1539437692/yummy/czipsy-z-krewetek.jpg',
        '2018-05-19T14:18:27.457Z', '2018-05-19T14:19:27.457Z', 'ACTUAL');

INSERT INTO offer (
  id, restaurant_id, name, description, price, discount, count, image, receive_time_start, receive_time_end, state)
VALUES (14, 3, 'Pierożki z nadzieniem serowym', 'Pierogi 300g, ser, ziemniaki, pieprz, rozmaryn', 6.3, 5, 11,
        'https://res.cloudinary.com/alb-pod-yummy/image/upload/v1539437692/yummy/pierozki-z-nadzieniem.jpg',
        '2018-05-19T14:18:27.457Z', '2018-05-19T14:19:27.457Z', 'ACTUAL');

INSERT INTO offer (
  id, restaurant_id, name, description, price, discount, count, image, receive_time_start, receive_time_end, state)
VALUES (15, 3, 'Cesarski kociołek trzech mięs w sosie sojowym',
        '500g kociołka, wieprzowina, wołowina, kurczak, zestaw sałatek, cesarska maska', 42.8, 40, 2,
        'https://res.cloudinary.com/alb-pod-yummy/image/upload/v1539437691/yummy/cesarski-kociolek.jpg',
        '2018-05-19T14:18:27.457Z', '2018-05-19T14:19:27.457Z', 'ACTUAL');

INSERT INTO offer (
  id, restaurant_id, name, description, price, discount, count, image, receive_time_start, receive_time_end, state)
VALUES (16, 3, 'Ostry gulasz dla dwóch osób', '500g pysznego gulaszu że aż cium pum pum um om nom nom', 38.8, 50, 6, '', '2018-05-19T14:18:27.457Z', '2018-05-19T14:19:27.457Z', 'ACTUAL');

INSERT INTO offer (
  id, restaurant_id, name, description, price, discount, count, image, receive_time_start, receive_time_end, state)
VALUES (17, 3, 'Tie-pan Gorący półmisek mięs',
        'Super gorący półmisek mięs dla każdego smakosza kuchni chińskiej. 500g rozkoszy w ustach', 30.8, 44, 4,
        'https://res.cloudinary.com/alb-pod-yummy/image/upload/v1539437692/yummy/tie-pan-goracy-polmisek-mies.jpg',
        '2018-05-19T14:18:27.457Z', '2018-05-19T14:19:27.457Z', 'ACTUAL');

INSERT INTO offer (
  id, restaurant_id, name, description, price, discount, count, image, receive_time_start, receive_time_end, state)
VALUES (18, 3, 'Cielęcina w ostrym sosie', '300g cielęciny, ostry sos hai mai, ziemnniaki, zestaw sałatek', 39.8, 37, 2,
        'https://res.cloudinary.com/alb-pod-yummy/image/upload/v1539437692/yummy/cielecina-w-ostrym-sosie.jpg',
        '2018-05-19T14:18:27.457Z', '2018-05-19T14:19:27.457Z', 'ACTUAL');

INSERT INTO offer (
  id, restaurant_id, name, description, price, discount, count, image, receive_time_start, receive_time_end, state)
VALUES (19, 4, 'Czeburek',
        ' pieróg z przaśnego ciasta (z mąki, wody i soli) z mięsnym nadzieniem. Tradycyjna potrawa wielu tureckich i mongolskich ludów. Danie jest także popularne wśród ludów kaukaskich. Spożywa się je bez użycia sztućców.',
        89.8, 77, 2, NULL, '2018-05-19T14:18:27.457Z', '2018-05-19T14:19:27.457Z', 'ACTUAL');

INSERT INTO offer (
  id, restaurant_id, name, description, price, discount, count, image, receive_time_start, receive_time_end, state)
VALUES (20, 4, 'Cielęcina pieczona z rozmarynem w sosie cumberland',
        'Cielęcina pieczona to doskonały pomysł na danie na świąteczny, np. wielkanocny obiad. Cielęcina upieczona z dodatkiem przyprawy ziołowej i świeżego rozmarynu świetnie smakuje z ostrym sosem cumberland',
        39.8, 37, 2, 'https://res.cloudinary.com/alb-pod-yummy/image/upload/v1539437692/yummy/cielecina-pieczona-z-rozmarynem.jpg', '2018-05-19T14:18:27.457Z', '2018-05-19T14:19:27.457Z', 'ACTUAL');

INSERT INTO offer (
  id, restaurant_id, name, description, price, discount, count, image, receive_time_start, receive_time_end, state)
VALUES (21, 4, 'Schab po lwowsku',
        'Składniki kg schabu bez kości 10 dag orzechów włoskich łuskanych 15 dag suszonych śliwek żółtko sok z cytryny smalec sól, pieprz, majeranek',
        55, 61, 22, 'https://res.cloudinary.com/alb-pod-yummy/image/upload/v1539437693/yummy/schab-po-lwowsku.jpg', '2018-05-19T14:18:27.457Z', '2018-05-19T14:19:27.457Z', 'ACTUAL');

INSERT INTO offer (
  id, restaurant_id, name, description, price, discount, count, image, receive_time_start, receive_time_end, state)
VALUES (22, 4, 'Stek wieprzowy po kozacku',
        '75 dag baraniny z udźca z kością (schabu wieprzowego, mięsa od szynki z kością, ew. 60 dag combra baraniego albo sznyclówki cielęcej - bez kości), sól, mielony pieprz (lub czosnek), 1 dag mąki, 3 - 5 dag smalcu.',
        39, 33, 6, 'https://res.cloudinary.com/alb-pod-yummy/image/upload/v1539437691/yummy/stek-wieprzowy-po-kozacku.jpg', '2018-05-19T14:18:27.457Z', '2018-05-19T14:19:27.457Z', 'ACTUAL');

SELECT setval('public.offer_sequence', 23, TRUE);

--Transactions --

INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (1, 53850, '2018-02-20 22:52:27', 'MISSED', ' 2018-02-20 22:13:00');
INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (2, 15076, '2018-01-24 12:48:44', 'COMPLETED', ' 2018-01-24 14:16:00');
INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (3, 92351, '2018-02-21 22:36:31', 'MISSED', ' 2018-02-21 11:52:00');
INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (4, 66594, '2018-02-19 04:11:37', 'COMPLETED', ' 2018-02-19 13:01:00');
INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (5, 92894, '2018-01-20 13:41:38', 'COMPLETED', ' 2018-01-20 21:28:00');
INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (6, 51258, '2018-01-12 03:11:59', 'MISSED', ' 2018-01-12 23:05:00');
INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (7, 63696, '2018-02-24 09:31:24', 'COMPLETED', ' 2018-02-24 13:42:00');
INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (8, 54542, '2018-03-04 06:42:11', 'COMPLETED', ' 2018-03-04 11:00:52');
INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (9, 52171, '2018-01-28 22:48:23', 'COMPLETED', ' 2018-01-28 15:08:00');
INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (10, 64669, '2018-02-24 13:12:31', 'CANCELED', ' 2018-02-24 18:07:00');
INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (11, 86900, '2018-02-24 04:54:04', 'MISSED', ' 2018-02-24 18:46:00');
INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (12, 63622, '2018-01-22 12:43:21', 'MISSED', ' 2018-01-22 22:17:00');
INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (13, 63528, '2018-02-16 18:58:45', 'MISSED', ' 2018-02-16 13:25:00');
INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (14, 29729, '2018-03-16 16:51:05', 'MISSED', ' 2018-03-16 13:25:00');
INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (15, 13327, '2018-01-24 14:55:20', 'COMPLETED', ' 2018-01-24 21:12:00');
INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (16, 75793, '2018-01-04 12:28:24', 'MISSED', ' 2018-01-04 17:25:00');
INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (17, 38218, '2018-02-18 20:32:20', 'MISSED', ' 2018-02-18 12:59:00');
INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (18, 28178, '2018-01-05 16:20:54', 'MISSED', ' 2018-01-05 20:32:00');
INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (19, 92097, '2018-01-11 05:23:22', 'COMPLETED', ' 2018-01-11 15:11:00');
INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (20, 14883, '2018-03-13 01:53:38', 'COMPLETED', ' 2018-03-13 21:49:00');
INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (21, 21370, '2018-01-21 05:27:05', 'MISSED', ' 2018-01-21 14:50:00');
INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (22, 85469, '2018-01-29 03:16:06', 'COMPLETED', ' 2018-01-29 11:32:00');
INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (23, 15616, '2018-02-12 10:55:33', 'COMPLETED', ' 2018-02-12 19:18:00');
INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (24, 94010, '2018-01-07 10:28:54', 'CANCELED', ' 2018-01-07 12:46:00');
INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (25, 19108, '2018-01-19 08:25:16', 'COMPLETED', ' 2018-01-19 19:38:00');
INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (26, 63566, '2018-03-13 15:11:10', 'MISSED', ' 2018-03-13 12:17:00');
INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (27, 77058, '2018-01-10 06:05:21', 'COMPLETED', ' 2018-01-10 20:23:00');
INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (28, 52705, '2018-01-10 09:30:05', 'MISSED', ' 2018-01-10 19:26:00');
INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (29, 29498, '2018-03-30 12:47:20', 'COMPLETED', ' 2018-03-30 20:43:00');
INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (30, 69997, '2018-01-12 08:35:19', 'MISSED', ' 2018-01-12 18:35:00');
INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (31, 48886, '2018-01-24 21:49:10', 'CANCELED', ' 2018-01-24 20:17:00');
INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (32, 66358, '2018-02-15 14:28:45', 'COMPLETED', ' 2018-02-15 23:46:00');
INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (33, 33501, '2018-01-01 07:38:22', 'MISSED', ' 2018-01-01 22:33:00');
INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (34, 20641, '2018-03-17 16:59:42', 'MISSED', ' 2018-03-17 18:00:00');
INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (35, 55804, '2018-03-02 04:09:43', 'COMPLETED', ' 2018-03-02 19:20:00');
INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (36, 89124, '2018-03-15 20:24:32', 'CANCELED', ' 2018-03-15 12:50:00');
INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (37, 81526, '2018-03-13 10:54:17', 'CANCELED', ' 2018-03-13 22:06:00');
INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (38, 13906, '2018-02-18 16:16:19', 'COMPLETED', ' 2018-02-18 17:30:00');
INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (39, 38408, '2018-03-05 11:35:06', 'COMPLETED', ' 2018-03-05 20:54:00');
INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (40, 17637, '2018-03-10 14:46:38', 'COMPLETED', ' 2018-03-10 15:19:00');
INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (41, 68455, '2018-03-12 15:52:23', 'COMPLETED', ' 2018-03-12 20:10:00');
INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (42, 33166, '2018-01-25 06:31:03', 'CANCELED', ' 2018-01-25 13:21:00');
INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (43, 73299, '2018-03-06 22:15:25', 'CANCELED', ' 2018-03-06 20:15:00');
INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (44, 24164, '2018-01-29 01:11:58', 'CANCELED', ' 2018-01-29 20:10:00');
INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (45, 96987, '2018-01-19 14:22:43', 'MISSED', ' 2018-01-28 23:47:00');
INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (46, 61336, '2018-01-09 03:25:48', 'CANCELED', ' 2018-05-28 22:48:00');
INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (47, 17504, '2018-02-03 15:31:48', 'PENDING', ' 2018-05-28 22:09:00');
INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (48, 58271, '2018-03-31 12:28:17', 'PENDING', ' 2018-05-28 23:30:00');
INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (49, 86595, '2018-03-31 10:52:49', 'PENDING', ' 2018-05-28 21:00:00');
INSERT INTO transaction (id, code, order_time, state, receive_time)
VALUES (50, 45293, '2018-03-31 14:37:20', 'PENDING', ' 2018-05-28 22:30:00');

SELECT setval('public.transaction_sequence', 51, TRUE);


INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (1, 43, 20, 2);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (2, 7, 12, 1);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (3, 37, 9, 2);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (4, 21, 22, 1);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (5, 44, 22, 1);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (6, 45, 18, 2);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (7, 32, 21, 1);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (8, 27, 2, 1);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (9, 27, 3, 1);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (10, 46, 10, 1);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (11, 9, 22, 2);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (12, 34, 2, 1);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (13, 47, 4, 1);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (14, 41, 20, 2);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (15, 42, 11, 1);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (16, 32, 19, 1);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (17, 20, 14, 2);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (18, 12, 21, 2);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (19, 39, 3, 2);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (20, 17, 1, 1);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (21, 15, 19, 2);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (22, 8, 7, 2);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (23, 37, 2, 1);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (24, 34, 15, 1);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (25, 29, 5, 1);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (26, 21, 7, 2);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (27, 3, 15, 2);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (28, 33, 16, 1);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (29, 2, 14, 1);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (30, 26, 1, 2);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (31, 33, 15, 1);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (32, 4, 21, 1);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (33, 36, 8, 1);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (34, 27, 22, 2);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (35, 37, 4, 2);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (36, 30, 18, 1);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (37, 32, 19, 2);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (38, 48, 11, 1);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (39, 5, 17, 2);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (40, 39, 1, 1);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (41, 28, 22, 1);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (42, 36, 8, 2);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (43, 16, 11, 2);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (44, 26, 21, 2);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (45, 29, 19, 2);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (46, 13, 11, 1);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (47, 47, 14, 2);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (48, 16, 6, 2);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (49, 4, 6, 2);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (50, 22, 20, 2);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (51, 43, 18, 2);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (52, 33, 21, 1);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (53, 11, 22, 2);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (54, 12, 2, 2);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (55, 39, 22, 1);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (56, 31, 16, 2);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (57, 46, 15, 1);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (58, 50, 19, 2);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (59, 44, 19, 2);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (60, 2, 3, 1);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (61, 9, 17, 1);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (62, 47, 15, 1);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (63, 17, 18, 2);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (64, 29, 13, 2);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (65, 6, 4, 1);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (66, 32, 12, 1);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (67, 2, 15, 1);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (68, 48, 15, 1);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (69, 49, 14, 2);
INSERT INTO transaction_offer_link (id, transaction_id, offer_id, count) VALUES (70, 41, 16, 1);

SELECT setval('public.transaction_offer_link_sequence', 71, TRUE);
