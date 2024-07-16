CREATE TABLE usuarios (
	idUsuario bigint auto_increment NOT NULL,
	nombre varchar(200) NOT NULL,
	clave varchar(100) NOT NULL,
	PRIMARY KEY (idUsuario)
);

ALTER TABLE challenge_foro.usuarios ADD CONSTRAINT nombre_unique UNIQUE KEY (nombre);