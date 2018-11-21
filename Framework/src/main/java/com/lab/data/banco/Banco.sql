drop database data;

create database data;

use data;

create table Projeto (
    
    codigoProjeto int auto_increment not null,
    nome varchar(255) not null,
    dataInicio date not null,
    dataTermino date,

    financiador varchar(255) not null,
    contato varchar(255) not null,
    
    primary key (codigoProjeto)
) engine=innodb;

create table Area (
    
    codigoArea int auto_increment not null,
    nome varchar(255) not null,
    
    cidade varchar(255),
    estado varchar(255),
    pais varchar(255),
    coordenadas point,
    
    primary key (codigoArea)
    
) engine=innodb;

create table Pratica (
    
    codigoPratica int auto_increment not null,
    dataInicio date not null,
    dataTermino date,
    codigoArea int,
    codigoProjeto int,
    
    primary key (codigoPratica),
    foreign key (codigoArea) references Area(codigoArea),
    foreign key (codigoProjeto) references Projeto(codigoProjeto)
    
) engine=innodb;

create table Participante (
    
    codigoParticipante int auto_increment not null,
    nome varchar(255) not null,
    universidade varchar(255),

    cpfParticipante varchar(11),
    categoria enum('Professor', 'Mestrando', 'Doutorando', 'IC', 'Convidado') not null,
    
    primary key (codigoParticipante)
) engine=innodb;

create table Arquivo (
    
    codigoArquivo int auto_increment not null,
    nome varchar(255) not null,
    tamanho int not null,

    primary key (codigoArquivo)
) engine=innodb;


