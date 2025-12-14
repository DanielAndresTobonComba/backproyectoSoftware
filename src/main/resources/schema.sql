CREATE TABLE IF NOT EXISTS usuario (
  id_usuario INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(45) NOT NULL UNIQUE,
  contrasena VARCHAR(100) NOT NULL,
  correo VARCHAR(100) NOT NULL UNIQUE,
  telefono VARCHAR(25),
  PRIMARY KEY (id_usuario)
);

CREATE TABLE IF NOT EXISTS producto_surtitiendas (
  id_producto VARCHAR(45) NOT NULL,
  nombre VARCHAR(45) NOT NULL UNIQUE,
  precio DECIMAL(10,2) NOT NULL,
  imagen_url VARCHAR(255),
  tamano VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_producto)
);

CREATE TABLE IF NOT EXISTS producto_alqueria (
  id_producto_alqueria VARCHAR(45) NOT NULL,
  nombre VARCHAR(45) NOT NULL UNIQUE,
  precio DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (id_producto_alqueria)
);

CREATE TABLE IF NOT EXISTS factura_surtitiendas (
  id_factura INT NOT NULL AUTO_INCREMENT,
  total DECIMAL(10,2),
  id_usuario INT NOT NULL,
  PRIMARY KEY (id_factura),
  FOREIGN KEY (id_usuario)
    REFERENCES usuario (id_usuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS factura_alqueria (
  id_factura INT NOT NULL AUTO_INCREMENT,
  total DECIMAL(10,2),
  id_usuario INT NOT NULL,
  PRIMARY KEY (id_factura),
  FOREIGN KEY (id_usuario)
    REFERENCES usuario (id_usuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS producto_factura_alqueria (
  id_factura INT NOT NULL,
  id_producto_alqueria VARCHAR(45) NOT NULL,
  cantidad INT NOT NULL,
  precio_base DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (id_factura, id_producto_alqueria),
  FOREIGN KEY (id_factura)
    REFERENCES factura_alqueria (id_factura)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  FOREIGN KEY (id_producto_alqueria)
    REFERENCES producto_alqueria (id_producto_alqueria)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS producto_surtitiendas_factura (
  id_producto VARCHAR(45) NOT NULL,
  id_factura INT NOT NULL,
  cantidad INT NOT NULL,
  PRIMARY KEY (id_producto, id_factura),
  FOREIGN KEY (id_producto)
    REFERENCES producto_surtitiendas (id_producto)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  FOREIGN KEY (id_factura)
    REFERENCES factura_surtitiendas (id_factura)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS resena (
  id_resena INT NOT NULL AUTO_INCREMENT,
  comentario TEXT,
  usuario TEXT,
  PRIMARY KEY (id_resena)
);

CREATE TABLE IF NOT EXISTS contacto (
  id_contacto INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(45),
  apellido VARCHAR(45),
  correo VARCHAR(45),
  direccion VARCHAR(45),
  telefono VARCHAR(45),
  tipo_facturacion VARCHAR(45),
  comentarios TEXT,
  PRIMARY KEY (id_contacto)
);
