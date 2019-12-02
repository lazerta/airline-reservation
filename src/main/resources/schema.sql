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
    id                       int(5) auto_increment,
    capacity                 int(4),
    count                    int(5)  default 0,
    fare                     decimal(6, 2),
    departure_airport_name   varchar(256) NOT NULL,
    destination_airport_name varchar(256) NOT NULL,
    departure_time           datetime,
    arrive_time              datetime,
    airline_name             varchar(256) NOT NULL,
    isCancelled              boolean default false,
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
    name     varchar(256),
    location varchar(256),
    primary key (name)
);

CREATE TABLE tbl_airline
(

    airline_name varchar(256),
    airport_name varchar(256),
    primary key (airline_name)

);


CREATE TABLE tbl_operating_airport
(
    operating_airline_name varchar(256),
    operating_airport_name varchar(256),
    primary key (operating_airline_name, operating_airport_name)
);

