CREATE TABLE topicos (
                         id BIGSERIAL NOT NULL,
                         titulo VARCHAR(100) NOT NULL,
                         mensaje VARCHAR(500) NOT NULL,
                         fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         status BOOLEAN NOT NULL,  -- ¡Este es el cambio clave!
                         autor VARCHAR(100) NOT NULL,
                         curso VARCHAR(100) NOT NULL,

                         PRIMARY KEY (id),
                         CONSTRAINT uk_topico_titulo_mensaje UNIQUE (titulo, mensaje)
);