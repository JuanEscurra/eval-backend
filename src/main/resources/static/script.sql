create table bd_eval.clientes
(
    id        bigint auto_increment
        primary key,
    apellidos varchar(255) not null,
    dni       varchar(255) not null,
    email     varchar(255) null,
    nombres   varchar(255) not null,
    telefono  varchar(255) null,
    constraint UK_m6ysdwsqke00e5piajbvgn6lg
        unique (dni)
);

create table bd_eval.productos
(
    id     bigint auto_increment
        primary key,
    nombre varchar(255) not null,
    precio double       not null,
    constraint UK_mlgw7js72hh2xtd4mvpdqfsbe
        unique (nombre)
);

create table bd_eval.ventas
(
    id         bigint auto_increment
        primary key,
    fecha      date   not null,
    id_cliente bigint not null,
    constraint FKleerof1mym3gc1ah8hsarel3f
        foreign key (id_cliente) references bd_eval.clientes (id)
);

create table bd_eval.detalles_venta
(
    id          bigint auto_increment
        primary key,
    cantidad    int    not null,
    id_producto bigint not null,
    id_venta    bigint not null,
    constraint FK2fuu7ebh2xmy22qcxm7vhhmp8
        foreign key (id_venta) references bd_eval.ventas (id),
    constraint FKkjfngeq4lktx0kji13qwthihk
        foreign key (id_producto) references bd_eval.productos (id)
);







INSERT INTO bd_eval.clientes (id, apellidos, dni, email, nombres, telefono) VALUES (1, 'Connor Rowe', '16348743', 'sapien@hotmail.org', 'Sopoline Mccullough', '938524276');
INSERT INTO bd_eval.clientes (id, apellidos, dni, email, nombres, telefono) VALUES (2, 'Lewis Cummings', '53555842', 'nunc.sed@google.net', 'Kermit Haley', '927178468');
INSERT INTO bd_eval.clientes (id, apellidos, dni, email, nombres, telefono) VALUES (3, 'Nevada Ball', '65284432', 'dui.nec@yahoo.net', 'Simon Duncan', '944884785');
INSERT INTO bd_eval.clientes (id, apellidos, dni, email, nombres, telefono) VALUES (4, 'Fredericka Ferguson', '79973527', 'enim.mauris@aol.org', 'Yen Benton', '948123888');
INSERT INTO bd_eval.clientes (id, apellidos, dni, email, nombres, telefono) VALUES (5, 'Travis Clay', '88797848', 'nunc.ac@outlook.net', 'Kimberley Hardin', '927272877');
INSERT INTO bd_eval.clientes (id, apellidos, dni, email, nombres, telefono) VALUES (6, 'Talon Moore', '45763557', 'blandit.mattis.cras@aol.ca', 'Ahmed Elliott', '923339628');
INSERT INTO bd_eval.clientes (id, apellidos, dni, email, nombres, telefono) VALUES (7, 'Adara Edwards', '65674722', 'eros.turpis.non@outlook.org', 'Charde Ingram', '981331778');
INSERT INTO bd_eval.clientes (id, apellidos, dni, email, nombres, telefono) VALUES (8, 'Jesse Harper', '26683922', 'felis.eget@aol.org', 'Arsenio Holloway', '966845989');
INSERT INTO bd_eval.clientes (id, apellidos, dni, email, nombres, telefono) VALUES (9, 'Xyla Barnes', '37489362', 'interdum.nunc@icloud.couk', 'Pamela Hayes', '992668785');
INSERT INTO bd_eval.clientes (id, apellidos, dni, email, nombres, telefono) VALUES (10, 'Maite Martin', '63518163', 'scelerisque@protonmail.com', 'Yvonne Key', '981893497');
INSERT INTO bd_eval.clientes (id, apellidos, dni, email, nombres, telefono) VALUES (11, 'Inez Clark', '32324622', 'magna@hotmail.couk', 'Hiram Wilcox', '913366668');
INSERT INTO bd_eval.clientes (id, apellidos, dni, email, nombres, telefono) VALUES (12, 'Reagan Shepard', '73533753', 'ac.mattis@outlook.ca', 'Constance Bates', '923179546');
INSERT INTO bd_eval.clientes (id, apellidos, dni, email, nombres, telefono) VALUES (13, 'Tashya Hicks', '86362952', 'orci.in@icloud.couk', 'Larissa Chang', '963238696');
INSERT INTO bd_eval.clientes (id, apellidos, dni, email, nombres, telefono) VALUES (14, 'Nathaniel Morton', '73741456', 'risus.duis.a@protonmail.couk', 'Jameson Maddox', '951382655');
INSERT INTO bd_eval.clientes (id, apellidos, dni, email, nombres, telefono) VALUES (15, 'Cruz Trujillo', '54998245', 'primis.in@aol.edu', 'Dustin Williams', '929665582');
INSERT INTO bd_eval.clientes (id, apellidos, dni, email, nombres, telefono) VALUES (16, 'Francis Shepherd', '57591574', 'sapien.cursus@google.com', 'Micah Holt', '914442622');
INSERT INTO bd_eval.clientes (id, apellidos, dni, email, nombres, telefono) VALUES (17, 'Briar Sexton', '32651243', 'mi@google.net', 'Jeremy Luna', '979717455');
INSERT INTO bd_eval.clientes (id, apellidos, dni, email, nombres, telefono) VALUES (18, 'Geoffrey Hanson', '19323235', 'mauris.blandit@outlook.net', 'Britanney Carney', '918592783');
INSERT INTO bd_eval.clientes (id, apellidos, dni, email, nombres, telefono) VALUES (19, 'Reed Dickson', '85974834', 'sed.dictum@outlook.edu', 'Shay Silva', '942951298');
INSERT INTO bd_eval.clientes (id, apellidos, dni, email, nombres, telefono) VALUES (20, 'Amelia Wolf', '43862389', 'laoreet.lectus@protonmail.org', 'Baxter Henry', '977541828');




INSERT INTO bd_eval.productos (id, nombre, precio) VALUES (1, 'Refrigeradora Z', 966.41);
INSERT INTO bd_eval.productos (id, nombre, precio) VALUES (2, 'TV Smart', 2071.95);
INSERT INTO bd_eval.productos (id, nombre, precio) VALUES (3, 'Macbook Air 13 pulgadas', 2288.87);
INSERT INTO bd_eval.productos (id, nombre, precio) VALUES (4, 'Zenbook Duo 15', 2297.43);
INSERT INTO bd_eval.productos (id, nombre, precio) VALUES (5, 'IdeaPad 5I Intel Core i7', 211.36);
INSERT INTO bd_eval.productos (id, nombre, precio) VALUES (6, 'Impresora multifuncional L3210', 2118.6);
INSERT INTO bd_eval.productos (id, nombre, precio) VALUES (7, 'Impresora Pixma', 1718.17);
INSERT INTO bd_eval.productos (id, nombre, precio) VALUES (8, 'HP Ink Tank 315', 2297.35);
INSERT INTO bd_eval.productos (id, nombre, precio) VALUES (9, 'HP DeskJet Ink', 1522.28);
INSERT INTO bd_eval.productos (id, nombre, precio) VALUES (10, 'Ecotank L1210', 838.41);
INSERT INTO bd_eval.productos (id, nombre, precio) VALUES (11, 'LED 50 50A6GSA', 1311.83);
INSERT INTO bd_eval.productos (id, nombre, precio) VALUES (12, 'Proyector Samsung TV 120', 806.63);
INSERT INTO bd_eval.productos (id, nombre, precio) VALUES (13, 'LED 50 50A6GSA F', 744.74);
INSERT INTO bd_eval.productos (id, nombre, precio) VALUES (14, 'Google chromecast 3', 1000.16);
INSERT INTO bd_eval.productos (id, nombre, precio) VALUES (15, 'Router Inalámbrico DIR-819', 701.45);
INSERT INTO bd_eval.productos (id, nombre, precio) VALUES (16, 'Lampara Solar Ultrabyte', 292.14);
INSERT INTO bd_eval.productos (id, nombre, precio) VALUES (17, 'Cuerda para saltar inteligente', 900.19);
INSERT INTO bd_eval.productos (id, nombre, precio) VALUES (18, 'Amazon Echo Dot 3 Parlante', 1825.39);
INSERT INTO bd_eval.productos (id, nombre, precio) VALUES (19, 'Foco LED con parlante RGB', 2075.35);
INSERT INTO bd_eval.productos (id, nombre, precio) VALUES (20, 'Dicroico inteligente', 266.9);
INSERT INTO bd_eval.productos (id, nombre, precio) VALUES (21, 'Robot Aspirador', 975.8);
INSERT INTO bd_eval.productos (id, nombre, precio) VALUES (22, 'Alexa flex', 2076.65);
INSERT INTO bd_eval.productos (id, nombre, precio) VALUES (23, 'Interruptor wifi', 1696.46);
INSERT INTO bd_eval.productos (id, nombre, precio) VALUES (24, 'Iphone 11', 997.16);





INSERT INTO bd_eval.ventas (id, fecha, id_cliente) VALUES (3, '2022-07-15', 1);
INSERT INTO bd_eval.ventas (id, fecha, id_cliente) VALUES (4, '2022-07-15', 4);
INSERT INTO bd_eval.ventas (id, fecha, id_cliente) VALUES (5, '2022-07-14', 10);
INSERT INTO bd_eval.ventas (id, fecha, id_cliente) VALUES (6, '2022-07-12', 6);
INSERT INTO bd_eval.ventas (id, fecha, id_cliente) VALUES (7, '2022-07-19', 2);
INSERT INTO bd_eval.ventas (id, fecha, id_cliente) VALUES (8, '2022-07-20', 12);
INSERT INTO bd_eval.ventas (id, fecha, id_cliente) VALUES (9, '2022-07-20', 12);
INSERT INTO bd_eval.ventas (id, fecha, id_cliente) VALUES (10, '2022-07-19', 12);






INSERT INTO bd_eval.detalles_venta (id, cantidad, id_producto, id_venta) VALUES (1, 1, 1, 3);
INSERT INTO bd_eval.detalles_venta (id, cantidad, id_producto, id_venta) VALUES (2, 2, 3, 3);
INSERT INTO bd_eval.detalles_venta (id, cantidad, id_producto, id_venta) VALUES (3, 1, 4, 4);
INSERT INTO bd_eval.detalles_venta (id, cantidad, id_producto, id_venta) VALUES (4, 3, 3, 4);
INSERT INTO bd_eval.detalles_venta (id, cantidad, id_producto, id_venta) VALUES (5, 1, 10, 5);
INSERT INTO bd_eval.detalles_venta (id, cantidad, id_producto, id_venta) VALUES (6, 5, 2, 5);
INSERT INTO bd_eval.detalles_venta (id, cantidad, id_producto, id_venta) VALUES (7, 4, 13, 6);
INSERT INTO bd_eval.detalles_venta (id, cantidad, id_producto, id_venta) VALUES (8, 12, 8, 7);
INSERT INTO bd_eval.detalles_venta (id, cantidad, id_producto, id_venta) VALUES (9, 1, 3, 7);
INSERT INTO bd_eval.detalles_venta (id, cantidad, id_producto, id_venta) VALUES (10, 3, 9, 8);
INSERT INTO bd_eval.detalles_venta (id, cantidad, id_producto, id_venta) VALUES (11, 2, 3, 8);
INSERT INTO bd_eval.detalles_venta (id, cantidad, id_producto, id_venta) VALUES (12, 1, 2, 9);
INSERT INTO bd_eval.detalles_venta (id, cantidad, id_producto, id_venta) VALUES (13, 3, 5, 9);
INSERT INTO bd_eval.detalles_venta (id, cantidad, id_producto, id_venta) VALUES (14, 5, 9, 10);
INSERT INTO bd_eval.detalles_venta (id, cantidad, id_producto, id_venta) VALUES (15, 6, 3, 10);







