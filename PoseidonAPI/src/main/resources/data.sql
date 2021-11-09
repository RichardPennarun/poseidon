
/* Setting up poseidon DB */
create database poseidon;
use poseidon;

 TABLE IF EXISTS bid_lists;

CREATE TABLE bids (
  id tinyint(4) NOT NULL AUTO_INCREMENT,
  account VARCHAR(30) NOT NULL,
  type VARCHAR(30) NOT NULL,
  bid_quantity DOUBLE,
  ask_quantity DOUBLE,
  bid DOUBLE ,
  ask DOUBLE,
  benchmark VARCHAR(125),
  bid_date TIMESTAMP,
  commentary VARCHAR(125),
  security VARCHAR(125),
  status VARCHAR(10),
  trader VARCHAR(125),
  book VARCHAR(125),
  creation_name VARCHAR(125),
  creation_date TIMESTAMP ,
  revision_name VARCHAR(125),
  revision_date TIMESTAMP ,
  deal_name VARCHAR(125),
  deal_type VARCHAR(125),
  source_list_id VARCHAR(125),
  side VARCHAR(125),

  PRIMARY KEY (id)
)


DROP TABLE IF EXISTS curve_points;

CREATE TABLE curve_points (
  id tinyint(4) NOT NULL AUTO_INCREMENT,
  curve_id tinyint(4) NOT NULL,
  as_of_date TIMESTAMP,
  term DOUBLE ,
  value DOUBLE ,
  creation_date TIMESTAMP ,

  PRIMARY KEY (id)
)


DROP TABLE IF EXISTS trades;

CREATE TABLE trades (
  id tinyint(4) NOT NULL AUTO_INCREMENT,
  account VARCHAR(30) NOT NULL,
  type VARCHAR(30) NOT NULL,
  buy_quantity DOUBLE,
  sell_quantity DOUBLE,
  buy_price DOUBLE ,
  sell_price DOUBLE,
  trade_date TIMESTAMP,
  security VARCHAR(125),
  status VARCHAR(10),
  trader VARCHAR(125),
  benchmark VARCHAR(125),
  book VARCHAR(125),
  creation_name VARCHAR(125),
  creation_date TIMESTAMP ,
  revision_name VARCHAR(125),
  revision_date TIMESTAMP ,
  deal_name VARCHAR(125),
  deal_type VARCHAR(125),
  source_list_id VARCHAR(125),
  side VARCHAR(125),

  PRIMARY KEY (id)
)


DROP TABLE IF EXISTS ratings;

CREATE TABLE ratings (
  id tinyint(4) NOT NULL AUTO_INCREMENT,
  moodys_rating VARCHAR(125),
  s_and_p_rating VARCHAR(125),
  fitch_rating VARCHAR(125),
  order_number tinyint,

  PRIMARY KEY (id)
)

DROP TABLE IF EXISTS rules;

CREATE TABLE rules (
  id tinyint(4) NOT NULL AUTO_INCREMENT,
  name VARCHAR(125),
  description VARCHAR(125),
  json VARCHAR(125),
  template VARCHAR(512),
  sql_str VARCHAR(125),
  sql_part VARCHAR(125),

  PRIMARY KEY (id)
)

DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id tinyint(4) NOT NULL AUTO_INCREMENT,
  user_name VARCHAR(125),
  password VARCHAR(125),
  full_name VARCHAR(125),
  role VARCHAR(125),

  PRIMARY KEY (id)
)



insert into Users(full_name, user_name, password, role) 
values("User", "user", "$2a$10$8PjulY0Mv8adyvcWie/KI..uRo3JRBBB2beGAr1FD2bu5LX230wfW", "USER")

insert into Users(full_name, user_name, password, role) 
values("Administrator", "admin", "$2a$10$pBV8ILO/s/nao4wVnGLrh.sa/rnr5pDpbeC4E.KNzQWoy8obFZdaa", "ADMIN")
insert into Users(full_name, user_name, password, role) 
values("User", "user", "$2a$10$pBV8ILO/s/nao4wVnGLrh.sa/rnr5pDpbeC4E.KNzQWoy8obFZdaa", "USER")






/* Setting up TEST DB */
create database poseidon_test;
use poseidon_test;


DROP TABLE IF EXISTS bid_lists;

CREATE TABLE bids (
  id tinyint(4) NOT NULL AUTO_INCREMENT,
  account VARCHAR(30) NOT NULL,
  type VARCHAR(30) NOT NULL,
  bid_quantity DOUBLE,
  ask_quantity DOUBLE,
  bid DOUBLE ,
  ask DOUBLE,
  benchmark VARCHAR(125),
  bid_date TIMESTAMP,
  commentary VARCHAR(125),
  security VARCHAR(125),
  status VARCHAR(10),
  trader VARCHAR(125),
  book VARCHAR(125),
  creation_name VARCHAR(125),
  creation_date TIMESTAMP ,
  revision_name VARCHAR(125),
  revision_date TIMESTAMP ,
  deal_name VARCHAR(125),
  deal_type VARCHAR(125),
  source_list_id VARCHAR(125),
  side VARCHAR(125),

  PRIMARY KEY (id)
)


DROP TABLE IF EXISTS curve_points;

CREATE TABLE curve_points (
  id tinyint(4) NOT NULL AUTO_INCREMENT,
  curve_id tinyint(4) NOT NULL,
  as_of_date TIMESTAMP,
  term DOUBLE ,
  value DOUBLE ,
  creation_date TIMESTAMP ,

  PRIMARY KEY (id)
)


DROP TABLE IF EXISTS trades;

CREATE TABLE trades (
  id tinyint(4) NOT NULL AUTO_INCREMENT,
  account VARCHAR(30) NOT NULL,
  type VARCHAR(30) NOT NULL,
  buy_quantity DOUBLE,
  sell_quantity DOUBLE,
  buy_price DOUBLE ,
  sell_price DOUBLE,
  trade_date TIMESTAMP,
  security VARCHAR(125),
  status VARCHAR(10),
  trader VARCHAR(125),
  benchmark VARCHAR(125),
  book VARCHAR(125),
  creation_name VARCHAR(125),
  creation_date TIMESTAMP ,
  revision_name VARCHAR(125),
  revision_date TIMESTAMP ,
  deal_name VARCHAR(125),
  deal_type VARCHAR(125),
  source_list_id VARCHAR(125),
  side VARCHAR(125),

  PRIMARY KEY (id)
)


DROP TABLE IF EXISTS ratings;

CREATE TABLE ratings (
  id tinyint(4) NOT NULL AUTO_INCREMENT,
  moodys_rating VARCHAR(125),
  s_and_p_rating VARCHAR(125),
  fitch_rating VARCHAR(125),
  order_number tinyint,

  PRIMARY KEY (id)
)

DROP TABLE IF EXISTS rules;

CREATE TABLE rules (
  id tinyint(4) NOT NULL AUTO_INCREMENT,
  name VARCHAR(125),
  description VARCHAR(125),
  json VARCHAR(125),
  template VARCHAR(512),
  sql_str VARCHAR(125),
  sql_part VARCHAR(125),

  PRIMARY KEY (id)
)

DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id tinyint(4) NOT NULL AUTO_INCREMENT,
  user_name VARCHAR(125),
  password VARCHAR(125),
  full_name VARCHAR(125),
  role VARCHAR(125),

  PRIMARY KEY (id)
)


