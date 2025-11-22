
-- -----------------------------------------------------
-- Crear la base de datos
-- -----------------------------------------------------
DROP DATABASE IF EXISTS mydb;
CREATE DATABASE IF NOT EXISTS mydb DEFAULT CHARACTER SET utf8;
USE mydb;

-- -----------------------------------------------------
-- Tabla: Usuario
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Usuario (
  idUsuario INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(45) NOT NULL UNIQUE,
  contrasena VARCHAR(100) NOT NULL,
  correo VARCHAR(100) NOT NULL UNIQUE,
  telefono VARCHAR(25),
  PRIMARY KEY (idUsuario)
);

-- -----------------------------------------------------
-- Tabla: Producto_surtitiendas
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Producto_surtitiendas (
  id_producto VARCHAR(45) NOT NULL,
  nombre VARCHAR(45) NOT NULL UNIQUE,
  precio DECIMAL(10,2) NOT NULL,
  imagen_url VARCHAR(255),
  tamano VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_producto)
);

-- -----------------------------------------------------
-- Tabla: Producto_alqueria
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Producto_alqueria (
  id_producto_alqueria VARCHAR(45) NOT NULL,
  nombre VARCHAR(45) NOT NULL UNIQUE,
  precio DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (id_producto_alqueria)
);

-- -----------------------------------------------------
-- Tabla: Factura_surtitiendas
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Factura_surtitiendas (
  idFactura INT NOT NULL AUTO_INCREMENT,
  total DECIMAL(10,2),
  idUsuario INT NOT NULL,
  PRIMARY KEY (idFactura),
  FOREIGN KEY (idUsuario)
    REFERENCES Usuario (idUsuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- -----------------------------------------------------
-- Tabla: Factura_alqueria
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Factura_alqueria (
  idFactura INT NOT NULL AUTO_INCREMENT,
  total DECIMAL(10,2),
  idUsuario INT NOT NULL,
  PRIMARY KEY (idFactura),
  FOREIGN KEY (idUsuario)
    REFERENCES Usuario (idUsuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- -----------------------------------------------------
-- Tabla: Producto_factura_alqueria
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Producto_factura_alqueria (
  idFactura INT NOT NULL,
  idProducto VARCHAR(45) NOT NULL,
  cantidad INT NOT NULL,
  PRIMARY KEY (idFactura, idProducto),
  FOREIGN KEY (idFactura)
    REFERENCES Factura_alqueria (idFactura)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  FOREIGN KEY (idProducto)
    REFERENCES Producto_alqueria (id_producto_alqueria)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- -----------------------------------------------------
-- Tabla: Productos_surtitiendas_factura
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Productos_surtitiendas_factura (
  id_producto VARCHAR(45) NOT NULL,
  idFactura INT NOT NULL,
  cantidad INT NOT NULL,
  PRIMARY KEY (id_producto, idFactura),
  FOREIGN KEY (id_producto)
    REFERENCES Producto_surtitiendas (id_producto)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  FOREIGN KEY (idFactura)
    REFERENCES Factura_surtitiendas (idFactura)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- -----------------------------------------------------
-- Tabla: Reseña
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Reseña (
  comentario TEXT,
  usuario text
  
);


-- -----------------------------------------------------
-- Tabla: Reseña
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Contacto (
  
  Nombre VARCHAR(45),
  Apellido VARCHAR(45),
  Correo VARCHAR(45),
  Direccion VARCHAR(45),
  Telefono VARCHAR(45),
  tipoFacturacion VARCHAR(45),
  comentarios text
  
);


INSERT INTO Producto_surtitiendas (id_producto, nombre, precio, imagen_url, tamano) VALUES
('P000', 'Leche', 4500, 'imagenes/leche.jpg', '1 Litro'),
('P001', 'Yogurt', 2500, 'imagenes/yogurt.webp', '140gr'),
('P002', 'Activia', 2500, 'imagenes/activia.webp', '150gr'),
('P003', 'M-M', 1000, 'imagenes/M-M.webp', '100gr'),
('P004', 'Avena', 2500, 'imagenes/avena.jpg', '180gr'),
('P005', 'Jugo Tangelo', 5000, 'imagenes/tangelo.webp', '2 Litros'),
('P006', 'ChocoLeche', 5000, 'imagenes/chocoleche.jpg', '200gr'),
('P007', 'Arequipe', 5000, 'imagenes/arequipe.webp', '50gr');


INSERT INTO Producto_alqueria (id_producto_alqueria, nombre, precio) VALUES
('A000', 'Leche', 4500.00),
('A001', 'Yogurt', 2500.00),
('A002', 'Activia', 2500.00),
('A003', 'M-M', 1000.00),
('A004', 'Avena', 2500.00),
('A005', 'Jugo Tangelo', 5000.00),
('A006', 'ChocoLeche', 5000.00),
('A007', 'Arequipe', 5000.00);



select * from Producto_surtitiendas;
describe Producto_surtitiendas;
show tables;


