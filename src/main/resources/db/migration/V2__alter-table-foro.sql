ALTER TABLE challenge_foro.tema MODIFY COLUMN mensaje varchar(400) NOT NULL;
ALTER TABLE challenge_foro.tema ADD CONSTRAINT titulo_unique UNIQUE KEY (titulo);
ALTER TABLE challenge_foro.tema ADD CONSTRAINT mensaje_unique UNIQUE KEY (mensaje);
