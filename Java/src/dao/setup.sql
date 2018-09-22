drop database if exists datalae;

create database datalae;

use datalae;

create table projetos (
        proj_id int not null auto_increment primary key,
        proj_denominacao varchar(300) not null,
        proj_sigla varchar(30),
        proj_financiador varchar(100),
        proj_coordenador varchar(100) not null
    ) engine=innodb;

create table area (
        area_id int not null auto_increment primary key,
        area_local varchar(300) not null,
        proj_id int not null,
        foreign key fk_area(proj_id)
        references projetos(proj_id)
        on update cascade
        on delete cascade
    ) engine=innodb;

create table viagem(
        viagem_id int not null auto_increment primary key,
        area_id int not null,
        viagem_data date not null,
        foreign key fk_viagem(area_id)
        references area(area_id)
        on update cascade
        on delete cascade
    ) engine=innodb;

create table modelagem (
        modelagem_id int not null auto_increment primary key,
        proj_id int not null,
        modelagem_tipo enum('imagem', 'report', 'superficie', 'visualizacao') not null, 
        modelagem_endereco varchar(300) not null,
        foreign key fk_modelagem(proj_id)
        references projetos(proj_id)
        on update cascade
        on delete cascade
    ) engine=innodb;

create table modeloIntegrado (
        modeloIntegrado_id int not null auto_increment primary key,
        proj_id int not null,
        modeloIntegrado_tipo enum('imagem', 'report', 'superficie', 'visualizacao') not null, 
        modeloIntegrado_endereco varchar(300) not null,
        foreign key fk_modeloIntegrado(proj_id)
        references projetos(proj_id)
        on update cascade
        on delete cascade
    ) engine=innodb;

create table publicacoes (
        publicacao_id int not null auto_increment primary key,
        proj_id int not null,
        publicacao_tipo enum('artigo', 'congresso', 'dissertacao', 'tcc', 'tese') not null,
        publicacao_nome varchar(500) not null,
        publicacao_endereco varchar(300) not null,
        foreign key fk_publicacoes(proj_id)
        references projetos(proj_id)
        on update cascade
        on delete cascade
    ) engine=innodb;

create table autores (
		autor_id int not null auto_increment primary key,
		publicacao_id int not null,
		autor_nome varchar(200) not null,
		foreign key fk_autores(publicacao_id)
        references publicacoes(publicacao_id)
        on update cascade
        on delete cascade
	) engine=innodb;

create table relatorios (
        relatorio_id int not null auto_increment primary key,
        proj_id int not null,
        relatorio_tipo enum('parcial', 'final') not null,
        relatorio_nome varchar(300) not null,
        relatorio_endereco varchar(300) not null,
        foreign key fk_relatorios(proj_id)
        references projetos(proj_id)
        on update cascade
        on delete cascade
    ) engine=innodb;

create table sigDados (
        sigDados_id int not null auto_increment primary key,
        proj_id int not null,
        dado_tipo enum('cad', 'imagem', 'modelo', 'planilha', 'shape') not null,
        dado_endereco varchar(300) not null,
        foreign key fk_relatorios(proj_id)
        references projetos(proj_id)
        on update cascade
        on delete cascade
    ) engine=innodb;



