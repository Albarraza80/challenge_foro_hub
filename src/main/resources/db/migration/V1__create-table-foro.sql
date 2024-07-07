CREATE TABLE tema (
	idTema bigint auto_increment NOT NULL,
	titulo varchar(200) NOT NULL,
	mensaje varchar(4000) NOT NULL,
	fecha_creacion DATETIME DEFAULT now() NOT NULL,
	estado varchar(20) NOT NULL,
	autor varchar(100) NOT NULL,
	curso varchar(100) NOT NULL,
	PRIMARY KEY (idTema)
);