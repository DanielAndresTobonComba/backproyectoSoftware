
-- -----------------------------------------------------
-- Crear la base de datos
-- -----------------------------------------------------
DROP DATABASE IF EXISTS mydb;
CREATE DATABASE IF NOT EXISTS mydb DEFAULT CHARACTER SET utf8;
USE mydb;

-- -----------------------------------------------------
-- Tabla: Usuario
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS usuario (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(45) NOT NULL UNIQUE,
  contrasena VARCHAR(100) NOT NULL,
  correo VARCHAR(100) NOT NULL UNIQUE,
  telefono VARCHAR(25),
  PRIMARY KEY (id)
);

-- -----------------------------------------------------
-- Tabla: Producto_surtitiendas
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS producto_surtitiendas (
  id_producto VARCHAR(45) NOT NULL,
  nombre VARCHAR(45) NOT NULL UNIQUE,
  precio DECIMAL(10,2) NOT NULL,
  imagen_url VARCHAR(255),
  tamano VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_producto)
);

-- -----------------------------------------------------
-- Tabla: Factura_surtitiendas
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS factura_surtitiendas (
  id_factura INT NOT NULL AUTO_INCREMENT,
  total DECIMAL(10,2),
  id_usuario INT NOT NULL,
  fecha varchar (16),
  PRIMARY KEY (id_factura),
  FOREIGN KEY (id_usuario)
    REFERENCES usuario (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);


-- -----------------------------------------------------
-- Tabla PUENTE: Productos_surtitiendas_factura
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS producto_surtitiendas_factura (
  id_producto VARCHAR(45) NOT NULL,
  id_factura INT NOT NULL,
  cantidad INT NOT NULL,
  subtotal DOUBLE NOT NULL,
  precio_base DOUBLE NOT NULL,
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


-- -----------------------------------------------------
-- Tabla: Producto_alqueria
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS producto_alqueria (
  id_producto_alqueria VARCHAR(45) NOT NULL,
  nombre VARCHAR(45) NOT NULL UNIQUE,
  precio DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (id_producto_alqueria)
);

-- -----------------------------------------------------
-- Tabla: Factura_alqueria
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS factura_alqueria (
  id_factura INT NOT NULL AUTO_INCREMENT,
  total DECIMAL(10,2),
  id_usuario INT NOT NULL,
  fecha varchar (16),
  PRIMARY KEY (id_factura),
  FOREIGN KEY (id_usuario)
    REFERENCES usuario (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);
-- -----------------------------------------------------
-- Tabla: Producto_factura_alqueria
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS producto_factura_alqueria (
  id_factura INT NOT NULL,
  id_producto_alqueria VARCHAR(45) NOT NULL,
  cantidad INT NOT NULL,
  precio_base DECIMAL(10,2) NOT NULL,
  subtotal DECIMAL(10,2) NOT NULL,
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

CREATE TABLE IF NOT EXISTS resena (
  id_resena INT NOT NULL AUTO_INCREMENT,
  comentario TEXT,
  usuario TEXT,
  PRIMARY KEY (id_resena)
);

CREATE TABLE IF NOT EXISTS contacto (
  id_contacto INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(45),
  apellidos VARCHAR(45),
  correo VARCHAR(45),
  direccion VARCHAR(45),
  telefono VARCHAR(45),
  tipo_facturacion VARCHAR(45),
  comentarios TEXT,
  PRIMARY KEY (id_contacto)
);

-- ===============================
-- INSERTS USUARIO
-- ===============================
INSERT INTO usuario (nombre, contrasena, correo, telefono) VALUES
('daniel', '123456', 'daniel@mail.com', '3001112233'),
('laura', '123456', 'laura@mail.com', '3004445566'),
('carlos', '123456', 'carlos@mail.com', '3007778899');

-- ===============================
-- INSERTS PRODUCTO SURTITIENDA
-- ===============================
INSERT INTO producto_surtitiendas (id_producto, nombre, precio, imagen_url, tamano) VALUES
('P001', 'Leche Entera', 4500.00, 'imagenes/leche.jpg', '1 Litro'),
('P002', 'Yogurt Fresa', 2500.00, 'imagenes/yogurt.webp', '140gr'),
('P003', 'Avena', 2800.00, 'imagenes/avena.jpg', '180gr'),
('P004', 'Chocoleche', 5000.00, 'imagenes/chocoleche.jpg', '200gr');

-- ===============================
-- INSERTS FACTURA SURTITIENDA
-- ===============================
INSERT INTO factura_surtitiendas (total, id_usuario) VALUES
(7000.00, 1),
(7800.00, 2);

-- ===============================
-- INSERTS PRODUCTO_SURTITIENDA_FACTURA
-- ===============================
INSERT INTO producto_surtitiendas_factura 
(id_producto, id_factura, cantidad, precio_base, subtotal) VALUES
('P001', 1, 1, 5000.00, 5000.00),
('P002', 1, 1, 2000.00, 2000.00),
('P003', 2, 2, 3000.00, 6000.00),
('P004', 2, 1, 1800.00, 1800.00);


-- ===============================
-- INSERTS PRODUCTO ALQUERIA
-- ===============================
INSERT INTO producto_alqueria (id_producto_alqueria, nombre, precio) VALUES
('A001', 'Leche Alquería', 4600.00),
('A002', 'Yogurt Natural', 2600.00),
('A003', 'Avena Alquería', 3000.00);

-- ===============================
-- INSERTS FACTURA ALQUERIA
-- ===============================
INSERT INTO factura_alqueria (total, id_usuario) VALUES
(7600.00, 1),
(5100.00, 3);

-- ===============================
-- INSERTS PRODUCTO_FACTURA_ALQUERIA
-- ===============================
INSERT INTO producto_factura_alqueria
(id_factura, id_producto_alqueria, cantidad, precio_base, subtotal)
VALUES
(1, 'A001', 1, 4600.00, 4600.00),
(1, 'A002', 1, 2600.00, 2600.00),
(2, 'A003', 2, 3000.00, 6000.00);

-- ===============================
-- INSERTS RESEÑA
-- ===============================
INSERT INTO resena (comentario, usuario) VALUES
('Excelente servicio y productos frescos', 'daniel'),
('Muy buena atención y rapidez', 'laura');

-- ===============================
-- INSERTS CONTACTO
-- ===============================
INSERT INTO contacto (nombre, apellidos, correo, direccion, telefono, tipo_facturacion, comentarios) VALUES
('Daniel', 'Tobón', 'daniel@mail.com', 'Calle 10 #20-30', '3001112233', 'Electronica', 'Todo excelente'),
('Laura', 'Gómez', 'laura@mail.com', 'Carrera 15 #40-20', '3004445566', 'Fisica', 'Buen servicio');






show tables;

select * from usuario;
select * from contacto;
select * from producto_alqueria;
select * from factura_alqueria;
select * from producto_factura_alqueria;
select * from producto_surtitiendas_factura;

select * from producto_surtitiendas;





