-- Parte flexível de projeto

ALTER TABLE Projeto ADD professor varchar(255) not null;
ALTER TABLE Projeto ADD orgao varchar(255);

-- Parte flexível de Area

ALTER TABLE Area ADD local varchar(255);

-- Parte flexível de Participante

ALTER TABLE Participante ADD cpf varchar(11) not null;

ALTER TABLE DadosArquivo ADD path varchar(1023);
