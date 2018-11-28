-- Parte flexível de projeto

ALTER TABLE Projeto ADD financiador varchar(255) not null;

-- Parte flexível de Area

ALTER TABLE Area ADD ip varchar(15) not null;
ALTER TABLE Area ADD modelo varchar(255) not null;
ALTER TABLE Area ADD estaMontada boolean not null;
ALTER TABLE Area ADD observacao varchar(255);

-- Parte flexível de Participante

ALTER TABLE Participante ADD lattes varchar(255);

-- Parte flexível de Pratica

ALTER TABLE Pratica ADD status varchar(255);