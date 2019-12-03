CREATE TABLE tbl_user
(
  username VARCHAR(20) NOT NULL,
  alias    VARCHAR(256),
  password VARCHAR(20) NOT NULL,
  role     TINYINT DEFAULT 0,
  PRIMARY KEY (username)
);

CREATE TABLE tbl_flight
(
  id                       INT(5) AUTO_INCREMENT,
  capacity                 INT(4),
  count                    INT(5)  DEFAULT 0,
  fare                     DECIMAL(6, 2),
  departure_airport_name   VARCHAR(256) NOT NULL,
  destination_airport_name VARCHAR(256) NOT NULL,
  departure_time           DATETIME,
  arrive_time              DATETIME,
  airline_name             VARCHAR(256) NOT NULL,
  isCancelled              BOOLEAN DEFAULT FALSE,
  isFull                   BOOLEAN DEFAULT FALSE,
  PRIMARY KEY (id)


);

CREATE TABLE tbl_reservation
(
  customer_username VARCHAR(20) NOT NULL,
  flight_id         INT(5)      NOT NULL,
  PRIMARY KEY (customer_username, flight_id)
);

CREATE TABLE tbl_airport
(
  name     VARCHAR(256),
  location VARCHAR(256),
  PRIMARY KEY (name)
);

CREATE TABLE tbl_airline
(

  airline_name VARCHAR(256),
  airport_name VARCHAR(256),
  PRIMARY KEY (airline_name)

);


CREATE TABLE tbl_operating_airport
(
  operating_airline_name VARCHAR(256),
  operating_airport_name VARCHAR(256),
  PRIMARY KEY (operating_airline_name, operating_airport_name)
);

