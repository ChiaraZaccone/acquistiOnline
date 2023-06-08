create database if not exists acquistionline;

create table if not exists magazzini(
id int auto_increment not null primary key,
    id_magazzino char(4) not null,
    qt_disp smallint not null,
    cod_articolo char(4)not null,
    nome_articolo varchar(50) not null,
    prezzo_unitario decimal(6,2) not null,
    descrizione varchar(100) not null
);

insert into magazzini (id_magazzino, qt_disp, cod_articolo, nome_articolo, prezzo_unitario, descrizione)
values
("MG01",29,"AR01","bracciale","21.00","bracciale con perla"),
("MG02",40,"AR02","anello","10.00","anello con perla"),
("MG03",80,"AR03","penna","3.00","penna con inchiostro blu"),
("MG04",100,"AR04","t-shirt","30.00","maglietta con scimmia"),
("MG05",200,"AR05","lampada","51.30","lampada da tavolo"),
("MG06",60,"AR06","smart-watch", "92.10","smart-watch con quadrante quadrato"),
("MG07",90,"AR07","borraccia","12.30","Borraccia marvel"),
("MG08",100,"AR08","Occhiali da sole","78.00","Occhiali da sole Ray-Ban"),
("MG09",90,"AR09","Sveglia","65.00","Sveglia da comodino digitale"),
("MG10",500,"AR10","TV","99.90","Smart tv"),
("MG11",90,"AR11","Mouse","22.50","Mouse bluetooth"),
("MG12",300,"AR12","Scarpe","64.90","Snikers nike"),
("MG13",100,"AR13","Quadro","21.99","Qaudro stampato"),
("MG14",90,"AR14","Smartphone","99.99","Smartphone scrauso");

create table if not exists clienti(
id int auto_increment not null primary key,
    nome varchar(50) not null,
    cognome varchar(50) not null,
    cod_cliente varchar(4) not null
);

insert into clienti (nome, cognome,cod_cliente)
values
("Chiara","Zaccone","CL01"),
("Marco","Pedretti","CL02"),
("Carmine","Ruggiero","CL03"),
("Alessandro","Borghi","CL04"),
("Alessandro","Solidoro","CL05"),
("Laura","Zaccone","CL06"),
("Elisabetta","Penna","CL07"),
("Roberto","Blasi","CL08"),
("Facundo","Acosta","CL09"),
("Antonio","Fiumanò","CL10"),
("Samuele","Richetto","CL11"),
("Josue","Condori","CL12"),
("Eugenio","Aloi","CL13"),
("Gabriele","Sucato","CL14");


create table if not exists carrelli(
id int auto_increment primary key not null,
    cod_cliente varchar(4),
    tipo_pagamento varchar(50),
    qt_articoli smallint,
    cod_articolo varchar(4)
);

insert into carrelli (cod_cliente,tipo_pagamento,qt_articoli,cod_articolo)
values
("CL01","carta di credito",1,"AR01"),
("CL02","bancomat",2,"AR02"),
("CL03","bancomat",4,"AR03"),
("CL04","satispay",2,"AR04"),
("CL05","bancomat",1,"AR05"),
("CL06","paypal",2,"AR06"),
("CL07","satispay",1,"AR07"),
("CL08","paypal",4,"AR08"),
("CL09","bancomat",6,"AR09"),
("CL10","bancomat",7,"AR1O"),
("CL11","satispay",4,"AR11"),
("CL12","paypal",8,"AR12"),
("CL13","paypal",1,"AR13"),
("CL14","satispay",1,"AR14");
