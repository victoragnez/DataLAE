create table Projeto (
    
    codigoProjeto int auto_increment not null,
    nome varchar(255) not null,
    financiador varchar(255) not null,
    diretor varchar(255) not null,
    dataInicio date not null,
    dataTermino date,
    
    primary key (codigoProjeto)
) engine=innodb;
