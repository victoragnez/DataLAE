create database dataLae;
use dataLae;

create table Diretor (
    
    codigoDiretor int auto_increment not null,
    nome varchar(255) not null,
    email varchar(255),
    telefone varchar(11),
    cargo varchar(255),
    
    primary key (codigoDiretor)
)  engine=innodb;

create table Financiador (
    
    codigoFinanciador int auto_increment not null,
    nome varchar(255) not null,
    cnpj varchar(16),
    
    primary key (codigoFinanciador)
)  engine=innodb;


create table Projeto (
    
    codigoProjeto int auto_increment not null,
    nome varchar(255) not null,
    descricao varchar(1000),
    sigla varchar(255),
    nomeCoordenador varchar(255) not null,
    dataInicio date not null,
    dataTermino date,
    
    primary key (codigoProjeto)
) engine=innodb;

create table FinanciamentoProjeto (
    codigoProjeto int not null,
    codigoFinanciador int not null,
    codigoDiretor int not null,
    
    constraint codFinanciamentoProjeto 
    primary key (codigoProjeto, codigoFinanciador, codigoDiretor),
    
    foreign key (codigoProjeto) references Projeto(codigoProjeto),
    foreign key (codigoFinanciador) references Financiador(codigoFinanciador),
    foreign key (codigoDiretor) references Diretor(codigoDiretor)
)  engine=innodb;

create table LocalPesquisa (
    
    codigoLocal int auto_increment not null,
    nome varchar(255) not null,
    cidade varchar(255),
    estado varchar(255),
    pais varchar(255),
    coordenadas point,
    
    primary key (codigoLocal)
    
) engine=innodb;

create table LocalProjeto (
    
    codigoLocal int not null,
    codigoProjeto int not null,
    
    constraint codLocalProjeto
    primary key (codigoLocal, codigoProjeto),
    
    foreign key (codigoLocal) references LocalPesquisa(codigoLocal),
    foreign key (codigoProjeto) references Projeto(codigoProjeto)
) engine=innodb;

create table Viagem (
    
    codigoViagem int auto_increment not null,
    dataInicio date not null,
    dataTermino date not null,
    codigoLocal int not null,
    codigoProjeto int not null,
    
    primary key (codigoViagem),
    foreign key (codigoLocal) references LocalPesquisa(codigoLocal),
    foreign key (codigoProjeto) references Projeto(codigoProjeto)
    
) engine=innodb;

create table Pesquisador (
    
    codigoPesquisador int auto_increment not null,
    cpfPesquisador varchar(11),
    universidade varchar(255) not null,
    nome varchar(255) not null,
    categoria enum('Professor', 'Mestrando', 'Doutorando', 'IC', 'Convidado') not null,
    
    primary key (codigoPesquisador)
) engine=innodb;

create table PesquisadorViagem(
    codigoViagem int not null,
    codigoPesquisador int not null,
    categoria enum('Professor', 'Mestrando', 'Doutorando', 'IC', 'Convidado') not null,
    
    primary key (codigoViagem, codigoPesquisador),
    
    foreign key (codigoViagem) references Viagem(codigoViagem),
    foreign key (codigoPesquisador) references Pesquisador(codigoPesquisador)
) engine=innodb;

create table PesquisadorProjeto (
    
    codigoProjeto int not null,
    codigoPesquisador int not null,
    categoria enum('Professor', 'Mestrando', 'Doutorando', 'IC', 'Convidado') not null,
    
    primary key (codigoPesquisador, codigoProjeto),
    
    foreign key (codigoPesquisador) references Pesquisador(codigoPesquisador),
    foreign key (codigoProjeto) references Projeto(codigoProjeto)
) engine=innodb;

create table User (
    email varchar(255) not null,
    username varchar(255) not null unique,
    password varchar(255) not null,
    
    primary key (email)    
) engine=innodb;

create table Arquivo (
    codigoArquivo int auto_increment not null,
    nome varchar(255) not null,
    dataInsercao date not null,
    tamanho long not null,
    tipo enum('DadosBrutos', 'DadosProcessados', 'Foto', 'Imagem', 'Mapa', 'Documentacao', 'Report',
        'RelatorioFinal', 'RelatorioParcial', 'TCC', 'Artigo', 'Congresso', 'Tese', 'Dissertacao'),
    metodo enum('GPR', 'GPS', 'ERT', 'Reflexao', 'Refracao', 'LaserScanner', 'Ambiental'),
    codigoProjeto int not null,
    codigoViagem int,
    conteudo longblob not null,
    
    primary key (codigoArquivo),
    
    foreign key (codigoProjeto) references Projeto(codigoProjeto),
    foreign key (codigoViagem) references Viagem(codigoViagem)
) engine=innodb;

