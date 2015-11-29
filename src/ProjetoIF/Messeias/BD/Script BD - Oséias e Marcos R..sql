-- DROP DATABASE Messeias;
CREATE DATABASE Messeias;
USE Messeias;

CREATE TABLE Usuario(
	Id_Usuario INT UNSIGNED NOT NULL AUTO_INCREMENT,
	Nome 	   VARCHAR(50)  NOT NULL,
    Senha 	   VARCHAR(250) NOT NULL,
    Tipo	   VARCHAR(50)  NOT NULL,
    CONSTRAINT PK_Usuario PRIMARY KEY (Id_Usuario),
    CONSTRAINT UK_Nome    UNIQUE 	  (Nome)
);

CREATE TABLE Turma(
	Id_Turma INT UNSIGNED NOT NULL AUTO_INCREMENT,
    Nome 	 VARCHAR(5)   NOT NULL,
    CONSTRAINT PK_Turma PRIMARY KEY (Id_Turma)
);

CREATE TABLE Usuario_Turma(
	Id		   INT UNSIGNED NOT NULL AUTO_INCREMENT,
    Id_Turma   INT UNSIGNED NOT NULL,
    Id_Usuario INT UNSIGNED NOT NULL,
    CONSTRAINT PK_Usuario_Turma 		PRIMARY KEY (Id),
    CONSTRAINT FK_Usuario_Turma_Turma   FOREIGN KEY (Id_Turma)   REFERENCES Turma   (Id_Turma),
    CONSTRAINT FK_Usuario_Turma_Usuario FOREIGN KEY (Id_Usuario) REFERENCES Usuario (Id_Usuario),
    INDEX (Id_Turma),
    INDEX (Id_Usuario)
);

CREATE TABLE Avaliacao(
	Id_Avaliacao   INT UNSIGNED NOT NULL AUTO_INCREMENT,
    Tipo 		   VARCHAR(50)  NOT NULL,
    Data_Avaliacao DATETIME 	NOT NULL,
    Conteudo 	   VARCHAR(150) NOT NULL,
    Disciplina 	   VARCHAR(50)  NOT NULL,
    Id_Turma 	   INT UNSIGNED NOT NULL,
    Id_Usuario     INT UNSIGNED NOT NULL,
    CONSTRAINT PK_Avaliacao			PRIMARY KEY (Id_Avaliacao),
    CONSTRAINT FK_Avaliacao_Turma 	FOREIGN KEY (Id_Turma) 	 REFERENCES Turma 	(Id_Turma),
    CONSTRAINT FK_Avaliacao_Usuario FOREIGN KEY (Id_Usuario) REFERENCES Usuario (Id_Usuario),
    INDEX (Id_Turma),
    INDEX (Id_Usuario)
);

CREATE TABLE Comentario(
	Id_Comentario INT UNSIGNED 	NOT NULL AUTO_INCREMENT,
    Texto 		  VARCHAR(1000) NOT NULL,
    Id_Usuario 	  INT UNSIGNED,
    Id_Avaliacao  INT UNSIGNED,
    CONSTRAINT PK_Comentario 		   PRIMARY KEY (Id_Comentario),
    CONSTRAINT FK_Comentario_Usuario   FOREIGN KEY (Id_Usuario)   REFERENCES Usuario   (Id_Usuario),
    CONSTRAINT FK_Comentario_Avaliacao FOREIGN KEY (Id_Avaliacao) REFERENCES Avaliacao (Id_Avaliacao),
    INDEX (Id_Usuario),
    INDEX (Id_Avaliacao)
);











