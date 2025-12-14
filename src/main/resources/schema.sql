
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
CREATE TABLE IF NOT EXISTS producto_surtitiendas  (
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
CREATE TABLE IF NOT EXISTS producto_alqueria (
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




