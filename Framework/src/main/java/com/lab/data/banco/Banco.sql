drop database data;

create database data;

use data;

create table Projeto (
    
    codigoProjeto int auto_increment not null,
    nome varchar(255) not null,
    dataInicio date not null,
    dataTermino date,
   
    primary key (codigoProjeto)

) engine=innodb;

create table Area (
    
    codigoArea int auto_increment not null,
    nome varchar(255) not null,

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
    email varchar(255) not null,
    instituicao varchar(255) not null,
    
    primary key (codigoParticipante)

) engine=innodb;

create table DadosArquivo (
	codigoDados int auto_increment not null,
	
	primary key (codigoDados)
) engine=innodb;

create table Arquivo (
    
    codigoArquivo int auto_increment not null,
    nome varchar(255) not null,
    tipo varchar(255),
    tamanho bigint not null,
    codigoProjeto int not null,
    codigoPratica int,
    codigoDados int not null,

    primary key (codigoArquivo),
    constraint foreign key (codigoProjeto) references Projeto(codigoProjeto),
    constraint foreign key (codigoPratica) references Pratica(codigoPratica),
    constraint foreign key (codigoDados) references DadosArquivo(codigoDados)

) engine=innodb;

create table ParticipanteProjeto (
    
    codigoParticipante int not null,
    codigoProjeto int not null,

    constraint primary key (codigoParticipante, codigoProjeto),
    constraint foreign key (codigoProjeto) references Projeto(codigoProjeto) on delete cascade,
    constraint foreign key (codigoParticipante) references Participante(codigoParticipante) on delete cascade

)engine=innodb;

create table ParticipantePratica (

    codigoPratica int not null,
    codigoParticipante int not null,

    constraint primary key (codigoPratica, codigoParticipante),
    constraint foreign key (codigoPratica) references Pratica(codigoPratica) on delete cascade,
    constraint foreign key (codigoParticipante) references Participante(codigoParticipante) on delete cascade


) engine=innodb;

create view DadosProjetoParticipante as (select Projeto.codigoProjeto, Projeto.nome as nomeProjeto, Projeto.dataInicio, Projeto.dataTermino, Participante.* from Projeto left join ParticipanteProjeto on Projeto.codigoProjeto = ParticipanteProjeto.codigoProjeto inner join Participante on ParticipanteProjeto.codigoParticipante = Participante.codigoParticipante);

create view DadosPraticaParticipante as (select Pratica.codigoPratica, Pratica.dataInicio, Pratica.dataTermino, Participante.* from Pratica left join ParticipantePratica on Pratica.codigoPratica = ParticipantePratica.codigoPratica inner join Participante on ParticipantePratica.codigoParticipante = Participante.codigoParticipante);
