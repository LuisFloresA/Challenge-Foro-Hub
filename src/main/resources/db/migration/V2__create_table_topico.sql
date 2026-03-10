CREATE TABLE topicos (
                         id BIGSERIAL NOT NULL,
                         titulo VARCHAR(100) NOT NULL,
                         mensaje VARCHAR(500) NOT NULL,
                         fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         status BOOLEAN NOT NULL,
                         usuario_id BIGINT NOT NULL,
                         curso VARCHAR(100) NOT NULL,

                         PRIMARY KEY (id),
                         CONSTRAINT fk_topicos_usuario_id FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
                         CONSTRAINT uk_topico_titulo_mensaje UNIQUE (titulo, mensaje)
);