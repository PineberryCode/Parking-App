create database parking;
use parking;

create table automobile
(
	licensePlate 		char(5) 	not null,
    	identificationOwner 	int 		not null,
    	
	primary key (licensePlate)
);

create table ticket
(
	automobile 		char(5) 	not null,
    	entry 			date 		not null,
	cost 			int 		not null,
	
    	constraint fk_automobile foreign key (automobile) references automobile (licensePlate),
    	primary key (automobile)
);
