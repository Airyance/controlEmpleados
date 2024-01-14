CREATE TABLE evaluacionBD (
    id SERIAL PRIMARY KEY,
    cedula BIGINT NOT NULL UNIQUE,
    nombre VARCHAR(255),
    fotografia BYTEA,
    fechaIngreso DATE,
    cargo INTEGER
);

CREATE TABLE cargos(
    id SERIAL PRIMARY KEY,
    descripcion VARCHAR(30) NOT NULL UNIQUE
);