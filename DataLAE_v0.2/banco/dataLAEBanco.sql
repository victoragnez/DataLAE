create database dataLae;
use dataLae;

create table Diretor (
	
    codigoDiretor int auto_increment,
    nome varchar(255),
    email varchar(255),
    telefone varchar(11),
    cargo varchar(255),
    
    primary key (codigoDiretor)
)  engine=innodb;

create table Financiador (

	codigoFinanciador int auto_increment,
    nome varchar(255),
    cnpj varchar(16),
        
    primary key (codigoFinanciador)
)  engine=innodb;


create table Projeto (

	codigoProjeto int auto_increment,
    nome varchar(255),
    sigla varchar(255),
    nomeCoordenado varchar(255),
    dataInicio datetime,
    dataTermino datetime,
        
    primary key (codigoProjeto)
) engine=innodb;

create table FinanciamentoProjeto (
	codigoProjeto int,
    codigoFinanciador int,
    codigoDiretor int,
    
    constraint codFinanciamentoProjeto 
    primary key (codigoProjeto, codigoFinanciador, codigoDiretor),
    
    constraint foreign key (codigoProjeto) references Projeto(codigoProjeto),
	constraint foreign key (codigoFinanciador) references Financiador(codigoFinanciador),
	constraint foreign key (codigoDiretor) references Diretor(codigoDiretor)
)  engine=innodb;

create table LocalPesquisa (

	codigoLocal int auto_increment,
    nome varchar(255),
    cidade varchar(255),
    estado varchar(255),
    pais varchar(255),
    codigoProjeto int,
    
    primary key (codigoLocal),
    foreign key (codigoProjeto) references Projeto(codigoProjeto)

) engine=innodb;

create table Viagem (

	codigoViagem int auto_increment,
    dataInicio datetime,
    dataTermino datetime,
	codigoLocal int,
    
    primary key (codigoViagem),
    foreign key (codigoLocal) references LocalPesquisa(codigoLocal)

) engine=innodb;

create table Pesquisador (
	
    cpfPesquisador varchar(11),
    titulacao varchar(255),
    universidade varchar(255),
    nome varchar(255),
    
    primary key (cpfPesquisador)
) engine=innodb;

create table PesquisadorViagem(
	codigoViagem int,
    cpfPesquisador varchar(255),
    
    primary key (codigoViagem, cpfPesquisador),
    
    foreign key (codigoViagem) references Viagem(codigoViagem),
    foreign key (cpfPesquisador) references Pesquisador(cpfPesquisador)
) engine=innodb;

create table PesquisadorProjeto (
	
    cpfPesquisador varchar(11),
    codigoProjeto int,
    
    primary key (cpfPesquisador, codigoProjeto),
    
    foreign key (cpfPesquisador) references Pesquisador(cpfPesquisador),
    foreign key (codigoProjeto) references Projeto(codigoProjeto)
) engine=innodb;