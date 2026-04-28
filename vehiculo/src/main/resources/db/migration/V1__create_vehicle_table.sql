CREATE TABLE vehicle (
    id BIGINT NOT NULL AUTO_INCREMENT,
    modelo VARCHAR(30) NOT NULL,
    marca VARCHAR(30) NOT NULL,
    anio INT NOT NULL,
    patente VARCHAR(6) NOT NULL UNIQUE,
    color VARCHAR(30) NOT NULL,
    kilometraje INT NOT NULL,
    tipo_vehiculo VARCHAR(20) NOT NULL,
    estado VARCHAR(20) NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    PRIMARY KEY(id)
)
