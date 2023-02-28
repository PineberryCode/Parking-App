create database parking;
use parking;

create table automobile
(
	licensePlate char(5) not null,
    identificationOwner int not null,
    primary key (licensePlate)
);
alter table ticket add cost int not null;
create table ticket
(
	automobile char(5) not null,
    entry date not null,
    constraint fk_automobile foreign key (automobile) references automobile (licensePlate),
    primary key (automobile)
);

insert into automobile values ("ABS34",2346534);
insert into ticket values ("ABS34","2022/04/10", 5);



delete from ticket where automobile = "122d";
delete from automobile where licensePlate = "122d";
select * from automobile;
select * from ticket;

SELECT auto.licensePlate, auto.identificationOwner, tckt.entry, tckt.cost
                        FROM ticket tckt INNER JOIN automobile auto
                        ON tckt.automobile = auto.licensePlate order by tckt.entry DESC;