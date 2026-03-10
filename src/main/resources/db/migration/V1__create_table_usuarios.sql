CREATE TABLE usuarios (
                          id BIGSERIAL NOT NULL,
                          nombre_usuario VARCHAR(100) NOT NULL,
                          login VARCHAR(100) NOT NULL UNIQUE,
                          contrasena VARCHAR(255) NOT NULL,

                          PRIMARY KEY(id)
);