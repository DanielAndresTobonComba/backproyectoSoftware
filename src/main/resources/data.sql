INSERT INTO producto_surtitiendas 
(id_producto, nombre, precio, imagen_url, tamano) VALUES
('P000', 'Leche', 4500, 'imagenes/leche.jpg', '1 Litro'),
('P001', 'Yogurt', 2500, 'imagenes/yogurt.webp', '140gr'),
('P002', 'Activia', 2500, 'imagenes/activia.webp', '150gr'),
('P003', 'M-M', 1000, 'imagenes/M-M.webp', '100gr'),
('P004', 'Avena', 2500, 'imagenes/avena.jpg', '180gr'),
('P005', 'Jugo Tangelo', 5000, 'imagenes/tangelo.webp', '2 Litros'),
('P006', 'ChocoLeche', 5000, 'imagenes/chocoleche.jpg', '200gr'),
('P007', 'Arequipe', 5000, 'imagenes/arequipe.webp', '50gr');


INSERT INTO producto_alqueria 
(id_producto_alqueria, nombre, precio) VALUES
('A000', 'Leche', 4500.00),
('A001', 'Yogurt', 2500.00),
('A002', 'Activia', 2500.00),
('A003', 'M-M', 1000.00),
('A004', 'Avena', 2500.00),
('A005', 'Jugo Tangelo', 5000.00),
('A006', 'ChocoLeche', 5000.00),
('A007', 'Arequipe', 5000.00);


INSERT INTO usuario (nombre, contrasena, correo, telefono) VALUES
('daniel', '123456', 'daniel@mail.com', '3001112233'),
('laura', '123456', 'laura@mail.com', '3004445566');

INSERT INTO factura_surtitiendas (total, id, fecha)
VALUES
  (9500.00, 1, '2025-12-14'),
  (7800.00, 2, '2025-12-14');

INSERT INTO factura_alqueria (total, id_usuario, fecha) VALUES
(7600.00, 1, '2025-12-14'),
(5100.00, 2, '2025-12-14');

INSERT INTO producto_factura_alqueria
(id_factura, id_producto_alqueria, cantidad, precio_base, subtotal)
VALUES
(1, 'A001', 2, 2500, 5000),
(1, 'A002', 1, 2600, 2600);

INSERT INTO producto_surtitiendas_factura
(id_producto, id_factura, precio_base, cantidad, subtotal) VALUES
('P001', 1, 4500.00, 1, 4500.00),
('P002', 1, 2500.00, 2, 5000.00),
('P003', 2, 1000.00, 1, 1000.00),
('P005', 2, 5000.00, 1, 5000.00);


