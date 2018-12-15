-- Parte flexível de projeto

ALTER TABLE Projeto ADD financiador varchar(255) not null;
ALTER TABLE Projeto ADD contato varchar(255) not null;

-- Parte flexível de Area

ALTER TABLE Area ADD cidade varchar(255);
ALTER TABLE Area ADD estado varchar(255);
ALTER TABLE Area ADD pais varchar(255) not null;
ALTER TABLE Area ADD latitude float not null;
ALTER TABLE Area ADD longitude float not null;

-- Parte flexível de Participante

ALTER TABLE Participante ADD cpfParticipante varchar(11);
ALTER TABLE Participante ADD categoria 
	enum('Professor', 'Mestrando', 'Doutorando', 'IC', 'Convidado') not null;

-- Salvar arquivo em banco

ALTER TABLE DadosArquivo ADD dados MEDIUMBLOB;
