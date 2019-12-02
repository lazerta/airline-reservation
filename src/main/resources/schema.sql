DROP DATABASE IF EXISTS db_airline;
CREATE DATABASE db_airline;
USE db_airline;
CREATE TABLE tbl_user
(
    username varchar(20) not null,
    alias    varchar(256),
    password varchar(20) not null,
    role     tinyint default 0,
    primary key (username)
);

CREATE TABLE tbl_flight
(
    id                     int(5) auto_increment,
    capacity               int(4),
    fare                   decimal(6, 2),
    departure_airport_id   int(4),
    destination_airport_id int(4),
    departure_time         datetime,
    arrive_time            datetime,
    airline_id             int(4),
    primary key (id)


);

CREATE TABLE tbl_reservation
(
    customer_username varchar(20) not null,
    flight_id         int(5)      not null,
    primary key (customer_username, flight_id)
);

CREATE TABLE tbl_airport
(
    id   int(4) AUTO_INCREMENT not null,
    name varchar(256),
    primary key (id)
);

CREATE TABLE tbl_airline
(
    id         int(4) auto_increment,
    name       varchar(256),
    airport_id int(5),
    primary key (id)

);


CREATE  TABLE tbl_operating_airport(
    operating_airline_id int(4),
    operating_airport_id int(4),
    primary key (operating_airline_id,operating_airport_id)
);


select * from tbl_flight,tbl_user where  username = t.customer_username AND tbl_flight.id = tbl_reservation.flight_id;
