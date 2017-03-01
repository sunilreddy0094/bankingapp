create database sdkapp;

use sdkapp;

create table UserInfo(
id integer(45) not null auto_increment,
username	varchar(45)	not null,
address	varchar(45)	not null,
PRIMARY KEY(ID)
);