---PROYECTO FINAL / GRUPO 4---

--------------------------------------------CREACION DE TABLAS--------------------------------------------
---TABLA DE ESTADOS
CREATE TABLE FIDE_ESTADOS_TB (
    FIDE_ESTADOS_TB_ID_ESTADOS_PK VARCHAR2(200) PRIMARY KEY,
    DESCRIPCION VARCHAR(255),
    CREADO_POR VARCHAR2(100),
    FECHA_CREACION TIMESTAMP,
    MODIFICADO_POR VARCHAR2(100),
    FECHA_MODIFICACION TIMESTAMP,
    ESTADO VARCHAR2(10),
    ACCION VARCHAR2(100)
);

---TABLA DE PAIS
CREATE TABLE FIDE_PAIS_TB (
    FIDE_PAIS_TB_ID_PAIS_PK VARCHAR2(200) PRIMARY KEY,
    ID_ESTADOS VARCHAR2(200),
    NOMBRE VARCHAR(255),
    CREADO_POR VARCHAR2(100),
    FECHA_CREACION TIMESTAMP,
    MODIFICADO_POR VARCHAR2(100),
    FECHA_MODIFICACION TIMESTAMP,
    ESTADO VARCHAR2(10),
    ACCION VARCHAR2(100),
    FOREIGN KEY (ID_ESTADOS) REFERENCES FIDE_ESTADOS_TB(FIDE_ESTADOS_TB_ID_ESTADOS_PK)
);

---TABLA DE PROVINCIA
CREATE TABLE FIDE_PROVINCIA_TB (
    FIDE_PROVINCIA_TB_ID_PROVINCIA_PK VARCHAR2(200) PRIMARY KEY,
    ID_ESTADOS VARCHAR2(200),
    NOMBRE VARCHAR(255),
    CREADO_POR VARCHAR2(100),
    FECHA_CREACION TIMESTAMP,
    MODIFICADO_POR VARCHAR2(100),
    FECHA_MODIFICACION TIMESTAMP,
    ESTADO VARCHAR2(10),
    ACCION VARCHAR2(100),
    FOREIGN KEY (ID_ESTADOS) REFERENCES FIDE_ESTADOS_TB(FIDE_ESTADOS_TB_ID_ESTADOS_PK)
);

---TABLA DE CANTON
CREATE TABLE FIDE_CANTON_TB (
    FIDE_CANTON_TB_ID_CANTON_PK VARCHAR2(200) PRIMARY KEY,
    ID_ESTADOS VARCHAR2(200),
    NOMBRE VARCHAR(255),
    CREADO_POR VARCHAR2(100),
    FECHA_CREACION TIMESTAMP,
    MODIFICADO_POR VARCHAR2(100),
    FECHA_MODIFICACION TIMESTAMP,
    ESTADO VARCHAR2(10),
    ACCION VARCHAR2(100),
    FOREIGN KEY (ID_ESTADOS) REFERENCES FIDE_ESTADOS_TB(FIDE_ESTADOS_TB_ID_ESTADOS_PK)
);

---TABLA DE DISTRITO
CREATE TABLE FIDE_DISTRITO_TB (
    FIDE_DISTRITO_TB_ID_DISTRITO_PK VARCHAR2(200) PRIMARY KEY,
    ID_ESTADOS VARCHAR2(200),
    NOMBRE VARCHAR(255),
    CREADO_POR VARCHAR2(100),
    FECHA_CREACION TIMESTAMP,
    MODIFICADO_POR VARCHAR2(100),
    FECHA_MODIFICACION TIMESTAMP,
    ESTADO VARCHAR2(10),
    ACCION VARCHAR2(100),
    FOREIGN KEY (ID_ESTADOS) REFERENCES FIDE_ESTADOS_TB(FIDE_ESTADOS_TB_ID_ESTADOS_PK)
);

---TABLA DE PROVEEDORES
CREATE TABLE FIDE_PROVEEDORES_TB (
    FIDE_PROVEEDORES_TB_ID_PROVEEDORES_PK VARCHAR2(200) PRIMARY KEY,
    ID_ESTADOS VARCHAR2(200),
    ID_PAIS VARCHAR2(200),
    ID_PROVINCIA VARCHAR2(200),
    ID_CANTON VARCHAR2(200),
    ID_DISTRITO VARCHAR2(200),
    DIRECCION VARCHAR(255),
    NOMBRE_PROVEEDOR VARCHAR(255),
    TELEFONO VARCHAR(20),
    CORREO VARCHAR(255),
    CREADO_POR VARCHAR2(100),
    FECHA_CREACION TIMESTAMP,
    MODIFICADO_POR VARCHAR2(100),
    FECHA_MODIFICACION TIMESTAMP,
    ESTADO VARCHAR2(10),
    ACCION VARCHAR2(100),
    FOREIGN KEY (ID_ESTADOS) REFERENCES FIDE_ESTADOS_TB(FIDE_ESTADOS_TB_ID_ESTADOS_PK),
    FOREIGN KEY (ID_PAIS) REFERENCES FIDE_PAIS_TB(FIDE_PAIS_TB_ID_PAIS_PK),
    FOREIGN KEY (ID_PROVINCIA) REFERENCES FIDE_PROVINCIA_TB(FIDE_PROVINCIA_TB_ID_PROVINCIA_PK),
    FOREIGN KEY (ID_CANTON) REFERENCES FIDE_CANTON_TB(FIDE_CANTON_TB_ID_CANTON_PK),
    FOREIGN KEY (ID_DISTRITO) REFERENCES FIDE_DISTRITO_TB(FIDE_DISTRITO_TB_ID_DISTRITO_PK)
);

---TABLA DE CLIENTES
CREATE TABLE FIDE_CLIENTES_TB (
    FIDE_CLIENTES_TB_ID_CLIENTE_PK VARCHAR2(200) PRIMARY KEY,
    ID_PAIS VARCHAR2(200),
    ID_PROVINCIA VARCHAR2(200),
    ID_CANTON VARCHAR2(200),
    ID_DISTRITO VARCHAR2(200),
    ID_ESTADOS VARCHAR2(200),
    NOMBRE VARCHAR(255),
    CORREO VARCHAR(255),
    CONTRASENA VARCHAR2(50),
    DIRECCION VARCHAR(255),
    TELEFONO VARCHAR(20),
    CREADO_POR VARCHAR2(100),
    FECHA_CREACION TIMESTAMP,
    MODIFICADO_POR VARCHAR2(100),
    FECHA_MODIFICACION TIMESTAMP,
    ESTADO VARCHAR2(10),
    ACCION VARCHAR2(100),
    FOREIGN KEY (ID_PAIS) REFERENCES FIDE_PAIS_TB(FIDE_PAIS_TB_ID_PAIS_PK),
    FOREIGN KEY (ID_PROVINCIA) REFERENCES FIDE_PROVINCIA_TB(FIDE_PROVINCIA_TB_ID_PROVINCIA_PK),
    FOREIGN KEY (ID_CANTON) REFERENCES FIDE_CANTON_TB(FIDE_CANTON_TB_ID_CANTON_PK),
    FOREIGN KEY (ID_DISTRITO) REFERENCES FIDE_DISTRITO_TB(FIDE_DISTRITO_TB_ID_DISTRITO_PK),
    FOREIGN KEY (ID_ESTADOS) REFERENCES FIDE_ESTADOS_TB(FIDE_ESTADOS_TB_ID_ESTADOS_PK)
);

---TABLA DE INVENTARIO
CREATE TABLE FIDE_INVENTARIO_TB (
    FIDE_INVENTARIO_TB_ID_INVENTARIO_PK VARCHAR2(200) PRIMARY KEY,
    ID_PALLET VARCHAR2(200),
    ID_ESTADOS VARCHAR2(200),
    NOMBRE VARCHAR(255),
    CANTIDAD INT,
    PRECIO DECIMAL(10, 2),
    CREADO_POR VARCHAR2(100),
    FECHA_CREACION TIMESTAMP,
    MODIFICADO_POR VARCHAR2(100),
    FECHA_MODIFICACION TIMESTAMP,
    ESTADO VARCHAR2(10),
    ACCION VARCHAR2(100),
    FOREIGN KEY (ID_PALLET) REFERENCES FIDE_PALLETS_TB(FIDE_PALLETS_TB_ID_PALLET_PK),
    FOREIGN KEY (ID_ESTADOS) REFERENCES FIDE_ESTADOS_TB(FIDE_ESTADOS_TB_ID_ESTADOS_PK)
);

---TABLA DE PALLETS
CREATE TABLE FIDE_PALLETS_TB (
    FIDE_PALLETS_TB_ID_PALLET_PK VARCHAR2(200) PRIMARY KEY,
    ID_PROVEEDORES VARCHAR2(200),
    ID_ESTADOS VARCHAR2(200),
    DESCRIPCION VARCHAR(255),
    CREADO_POR VARCHAR2(100),
    FECHA_CREACION TIMESTAMP,
    MODIFICADO_POR VARCHAR2(100),
    FECHA_MODIFICACION TIMESTAMP,
    ESTADO VARCHAR2(10),
    ACCION VARCHAR2(100),
    FOREIGN KEY (ID_PROVEEDORES) REFERENCES FIDE_PROVEEDORES_TB(FIDE_PROVEEDORES_TB_ID_PROVEEDORES_PK),
    FOREIGN KEY (ID_ESTADOS) REFERENCES FIDE_ESTADOS_TB(FIDE_ESTADOS_TB_ID_ESTADOS_PK)
);

---TABLA DE DESCUENTO
CREATE TABLE FIDE_DESCUENTO_TB (
    FIDE_DESCUENTO_TB_ID_DESCUENTO_PK VARCHAR2(200) PRIMARY KEY,
    ID_ESTADOS VARCHAR2(200),
    ID_TIPO_DESCUENTO VARCHAR2(200),
    VALOR DECIMAL(10, 2),
    CREADO_POR VARCHAR2(100),
    FECHA_CREACION TIMESTAMP,
    MODIFICADO_POR VARCHAR2(100),
    FECHA_MODIFICACION TIMESTAMP,
    ESTADO VARCHAR2(10),
    ACCION VARCHAR2(100),
    FOREIGN KEY (ID_ESTADOS) REFERENCES FIDE_ESTADOS_TB(FIDE_ESTADOS_TB_ID_ESTADOS_PK),
    FOREIGN KEY (ID_TIPO_DESCUENTO) REFERENCES FIDE_TIPO_DESCUENTO_TB(FIDE_TIPO_DESCUENTO_TB_ID_TIPO_DESCUENTO_PK)
);

---TABLA DE TIPO DESCUENTO
CREATE TABLE FIDE_TIPO_DESCUENTO_TB (
    FIDE_TIPO_DESCUENTO_TB_ID_TIPO_DESCUENTO_PK VARCHAR2(200) PRIMARY KEY,
    ID_ESTADOS VARCHAR2(200),
    NOMBRE VARCHAR(255),
    DESCRIPCION VARCHAR(255),
    CREADO_POR VARCHAR2(100),
    FECHA_CREACION TIMESTAMP,
    MODIFICADO_POR VARCHAR2(100),
    FECHA_MODIFICACION TIMESTAMP,
    ESTADO VARCHAR2(10),
    ACCION VARCHAR2(100),
    FOREIGN KEY (ID_ESTADOS) REFERENCES FIDE_ESTADOS_TB(FIDE_ESTADOS_TB_ID_ESTADOS_PK)
);

---TABLA DE PROMOCIONES
CREATE TABLE FIDE_PROMOCIONES_TB (
    FIDE_PROMOCIONES_TB_ID_PROMOCION_PK VARCHAR2(200) PRIMARY KEY,
    ID_FACTURAS VARCHAR2(200),
    ID_ESTADOS VARCHAR2(200),
    NOMBRE_PROMOCION VARCHAR2(255),
    FECHA_INICIO DATE,
    FECHA_FIN DATE,
    DESCRIPCION VARCHAR2(255),
    CREADO_POR VARCHAR2(100),
    FECHA_CREACION TIMESTAMP,
    MODIFICADO_POR VARCHAR2(100),
    FECHA_MODIFICACION TIMESTAMP,
    ESTADO VARCHAR2(10),
    ACCION VARCHAR2(100),
    FOREIGN KEY (ID_ESTADOS) REFERENCES FIDE_ESTADOS_TB(FIDE_ESTADOS_TB_ID_ESTADOS_PK)
);

---TABLA DE FACTURAS
CREATE TABLE FIDE_FACTURAS_TB (
    FIDE_FACTURAS_TB_ID_FACTURAS_PK VARCHAR2(200) PRIMARY KEY,
    ID_INVENTARIO VARCHAR2(200),
    ID_DESCUENTO VARCHAR2(200),
    ID_ESTADOS VARCHAR2(200),
    ID_CLIENTE VARCHAR2(200),
    ID_PROMOCION VARCHAR2(200),
    FECHA_VENTA DATE,
    TOTAL_VENTA DECIMAL(10, 2),
    SUBTOTAL DECIMAL(10, 2),
    IMPUESTOS DECIMAL(10, 2),
    CREADO_POR VARCHAR2(100),
    FECHA_CREACION TIMESTAMP,
    MODIFICADO_POR VARCHAR2(100),
    FECHA_MODIFICACION TIMESTAMP,
    ESTADO VARCHAR2(10),
    ACCION VARCHAR2(100),
    FOREIGN KEY (ID_INVENTARIO) REFERENCES FIDE_INVENTARIO_TB(FIDE_INVENTARIO_TB_ID_INVENTARIO_PK),
    FOREIGN KEY (ID_DESCUENTO) REFERENCES FIDE_DESCUENTO_TB(FIDE_DESCUENTO_TB_ID_DESCUENTO_PK),
    FOREIGN KEY (ID_ESTADOS) REFERENCES FIDE_ESTADOS_TB(FIDE_ESTADOS_TB_ID_ESTADOS_PK),
    FOREIGN KEY (ID_CLIENTE) REFERENCES FIDE_CLIENTES_TB(FIDE_CLIENTES_TB_ID_CLIENTE_PK),
    FOREIGN KEY (ID_PROMOCION) REFERENCES FIDE_PROMOCIONES_TB(FIDE_PROMOCIONES_TB_ID_PROMOCION_PK)
);

---TABLA DE DETALLES FACTURAS
CREATE TABLE FIDE_DETALLES_FACTURAS_TB (
    FIDE_DETALLES_FACTURAS_TB_ID_DETALLE_PK VARCHAR2(200) PRIMARY KEY,
    ID_FACTURAS VARCHAR2(200),
    ID_ESTADOS VARCHAR2(200),
    ID_INVENTARIO VARCHAR2(200),
    CANTIDAD_VENDIDA INT,
    PRECIO_UNITARIO DECIMAL(10, 2),
    PRECIO_TOTAL_UNITARIO DECIMAL(10, 2),
    CREADO_POR VARCHAR2(100),
    FECHA_CREACION TIMESTAMP,
    MODIFICADO_POR VARCHAR2(100),
    FECHA_MODIFICACION TIMESTAMP,
    ESTADO VARCHAR2(10),
    ACCION VARCHAR2(100),
    FOREIGN KEY (ID_FACTURAS) REFERENCES FIDE_FACTURAS_TB(FIDE_FACTURAS_TB_ID_FACTURAS_PK),
    FOREIGN KEY (ID_ESTADOS) REFERENCES FIDE_ESTADOS_TB(FIDE_ESTADOS_TB_ID_ESTADOS_PK),
    FOREIGN KEY (ID_INVENTARIO) REFERENCES FIDE_INVENTARIO_TB(FIDE_INVENTARIO_TB_ID_INVENTARIO_PK)
);

--------------------------------------------INSERTS A LAS TABLAS--------------------------------------------
---INSERTS TABLA ESTADOS
INSERT INTO FIDE_ESTADOS_TB (FIDE_ESTADOS_TB_ID_ESTADOS_PK, DESCRIPCION) VALUES ('1', 'Activo');
INSERT INTO FIDE_ESTADOS_TB (FIDE_ESTADOS_TB_ID_ESTADOS_PK, DESCRIPCION) VALUES ('2', 'Inactivo');
COMMIT;

---INSERTS TABLA PAIS
INSERT INTO FIDE_PAIS_TB (FIDE_PAIS_TB_ID_PAIS_PK, ID_ESTADOS, NOMBRE) VALUES ('CR', '1', 'Costa Rica');
COMMIT;

---INSERTS TABLA PROVINCIA
INSERT INTO FIDE_PROVINCIA_TB (FIDE_PROVINCIA_TB_ID_PROVINCIA_PK, ID_ESTADOS, NOMBRE) VALUES ('SJ', '1', 'San José');
INSERT INTO FIDE_PROVINCIA_TB (FIDE_PROVINCIA_TB_ID_PROVINCIA_PK, ID_ESTADOS, NOMBRE) VALUES ('AL', '1', 'Alajuela');
INSERT INTO FIDE_PROVINCIA_TB (FIDE_PROVINCIA_TB_ID_PROVINCIA_PK, ID_ESTADOS, NOMBRE) VALUES ('CA', '1', 'Cartago');
INSERT INTO FIDE_PROVINCIA_TB (FIDE_PROVINCIA_TB_ID_PROVINCIA_PK, ID_ESTADOS, NOMBRE) VALUES ('HE', '1', 'Heredia');
COMMIT;


---INSERTS TABLA CANTON
INSERT INTO FIDE_CANTON_TB (FIDE_CANTON_TB_ID_CANTON_PK, ID_ESTADOS, NOMBRE) VALUES ('ES', '1', 'Escazú');
INSERT INTO FIDE_CANTON_TB (FIDE_CANTON_TB_ID_CANTON_PK, ID_ESTADOS, NOMBRE) VALUES ('AT', '1', 'Atenas');
INSERT INTO FIDE_CANTON_TB (FIDE_CANTON_TB_ID_CANTON_PK, ID_ESTADOS, NOMBRE) VALUES ('PA', '1', 'Paraiso');
INSERT INTO FIDE_CANTON_TB (FIDE_CANTON_TB_ID_CANTON_PK, ID_ESTADOS, NOMBRE) VALUES ('BE', '1', 'Belen');
COMMIT;

---INSERTS TABLA DISTRITO
INSERT INTO FIDE_DISTRITO_TB (FIDE_DISTRITO_TB_ID_DISTRITO_PK, ID_ESTADOS, NOMBRE) VALUES ('SAN', '1', 'San Antonio');
INSERT INTO FIDE_DISTRITO_TB (FIDE_DISTRITO_TB_ID_DISTRITO_PK, ID_ESTADOS, NOMBRE) VALUES ('ME', '1', 'Mercedes');
INSERT INTO FIDE_DISTRITO_TB (FIDE_DISTRITO_TB_ID_DISTRITO_PK, ID_ESTADOS, NOMBRE) VALUES ('OR', '1', 'Orosi');
INSERT INTO FIDE_DISTRITO_TB (FIDE_DISTRITO_TB_ID_DISTRITO_PK, ID_ESTADOS, NOMBRE) VALUES ('LA', '1', 'La Ribera');
COMMIT;

---INSERTS TABLA PROVEEDORES
INSERT INTO FIDE_PROVEEDORES_TB (FIDE_PROVEEDORES_TB_ID_PROVEEDORES_PK, ID_ESTADOS, ID_PAIS, ID_PROVINCIA, ID_CANTON, ID_DISTRITO, DIRECCION, NOMBRE_PROVEEDOR, TELEFONO, CORREO) 
VALUES ('1', '1', 'CR', 'SJ', 'ES', 'SAN', 'Calle 123', 'Proveedor 1', '1234567890', 'proveedor1@example.com');
INSERT INTO FIDE_PROVEEDORES_TB (FIDE_PROVEEDORES_TB_ID_PROVEEDORES_PK, ID_ESTADOS, ID_PAIS, ID_PROVINCIA, ID_CANTON, ID_DISTRITO, DIRECCION, NOMBRE_PROVEEDOR, TELEFONO, CORREO) 
VALUES ('2', '1', 'CR', 'AL', 'AT', 'ME', 'Avenida 456', 'Proveedor 2', '0987654321', 'proveedor2@example.com');
INSERT INTO FIDE_PROVEEDORES_TB (FIDE_PROVEEDORES_TB_ID_PROVEEDORES_PK, ID_ESTADOS, ID_PAIS, ID_PROVINCIA, ID_CANTON, ID_DISTRITO, DIRECCION, NOMBRE_PROVEEDOR, TELEFONO, CORREO) 
VALUES ('3', '1', 'CR', 'CA', 'PA', 'OR', 'Boulevard 789', 'Proveedor 3', '1122334455', 'proveedor3@example.com');
COMMIT;

---INSERTS TABLA CLIENTES
INSERT INTO FIDE_CLIENTES_TB (FIDE_CLIENTES_TB_ID_CLIENTE_PK, ID_PAIS, ID_PROVINCIA, ID_CANTON, ID_DISTRITO, ID_ESTADOS, NOMBRE, CORREO, DIRECCION, TELEFONO, CONTRASE�A) 
VALUES ('1', 'CR', 'SJ', 'ES', 'SAN', '1', 'Cesar', 'Cesar@example.com', 'Calle 123', '87026789', '12345');
INSERT INTO FIDE_CLIENTES_TB (FIDE_CLIENTES_TB_ID_CLIENTE_PK, ID_PAIS, ID_PROVINCIA, ID_CANTON, ID_DISTRITO, ID_ESTADOS, NOMBRE, CORREO, DIRECCION, TELEFONO, CONTRASE�A)  
VALUES ('2', 'CR', 'AL', 'AT', 'ME', '1', 'Esteban', 'Esteban@example.com', 'Avenida 456', '85643567', '12345');
INSERT INTO FIDE_CLIENTES_TB (FIDE_CLIENTES_TB_ID_CLIENTE_PK, ID_PAIS, ID_PROVINCIA, ID_CANTON, ID_DISTRITO, ID_ESTADOS, NOMBRE, CORREO, DIRECCION, TELEFONO, CONTRASE�A)  
VALUES ('3', 'CR', 'CA', 'PA', 'OR', '1', 'Alexandra', 'Alexandra@example.com', 'Calle 789', '88456789', '12345');
COMMIT;

---INSERTS TABLA INVENTARIO
INSERT INTO FIDE_INVENTARIO_TB (FIDE_INVENTARIO_TB_ID_INVENTARIO_PK, ID_PALLET, ID_ESTADOS, NOMBRE, CANTIDAD, PRECIO) 
VALUES ('1', '1', '1', 'Maleta', 3, 25.00);
INSERT INTO FIDE_INVENTARIO_TB (FIDE_INVENTARIO_TB_ID_INVENTARIO_PK, ID_PALLET, ID_ESTADOS, NOMBRE, CANTIDAD, PRECIO) 
VALUES ('2', '2', '1', 'Silla', 2, 20.75);
INSERT INTO FIDE_INVENTARIO_TB (FIDE_INVENTARIO_TB_ID_INVENTARIO_PK, ID_PALLET, ID_ESTADOS, NOMBRE, CANTIDAD, PRECIO) 
VALUES ('3', '3', '1', 'Armario', 4, 30.00);
COMMIT;

---INSERTS TABLA PALLETS
INSERT INTO FIDE_PALLETS_TB (FIDE_PALLETS_TB_ID_PALLET_PK, ID_PROVEEDORES, ID_ESTADOS, DESCRIPCION) 
VALUES ('1', '1', '1', 'Pallet 1');
INSERT INTO FIDE_PALLETS_TB (FIDE_PALLETS_TB_ID_PALLET_PK, ID_PROVEEDORES, ID_ESTADOS, DESCRIPCION) 
VALUES ('2', '2', '1', 'Pallet 2');
INSERT INTO FIDE_PALLETS_TB (FIDE_PALLETS_TB_ID_PALLET_PK, ID_PROVEEDORES, ID_ESTADOS, DESCRIPCION) 
VALUES ('3', '3', '1', 'Pallet 3');
COMMIT;


---INSERTS TABLA TIPO DESCUENTO
INSERT INTO FIDE_TIPO_DESCUENTO_TB (FIDE_TIPO_DESCUENTO_TB_ID_TIPO_DESCUENTO_PK, ID_ESTADOS, NOMBRE, DESCRIPCION) 
VALUES ('1', '1', 'Descuento por tiempo', 'Descuento aplicado por ofertas en tiempo limitado');
INSERT INTO FIDE_TIPO_DESCUENTO_TB (FIDE_TIPO_DESCUENTO_TB_ID_TIPO_DESCUENTO_PK, ID_ESTADOS, NOMBRE, DESCRIPCION) 
VALUES ('2', '1', 'Descuento por Temporada', 'Descuento aplicado durante temporadas específicas');
INSERT INTO FIDE_TIPO_DESCUENTO_TB (FIDE_TIPO_DESCUENTO_TB_ID_TIPO_DESCUENTO_PK, ID_ESTADOS, NOMBRE, DESCRIPCION) 
VALUES ('3', '1', 'Descuento Promocional', 'Descuento aplicado durante promociones especiales');
COMMIT;

---INSERTS TABLA DESCUENTO
INSERT INTO FIDE_DESCUENTO_TB (FIDE_DESCUENTO_TB_ID_DESCUENTO_PK, ID_ESTADOS, ID_TIPO_DESCUENTO, VALOR) 
VALUES ('1', '1', '1', 5.00);
INSERT INTO FIDE_DESCUENTO_TB (FIDE_DESCUENTO_TB_ID_DESCUENTO_PK, ID_ESTADOS, ID_TIPO_DESCUENTO, VALOR) 
VALUES ('2', '1', '2', 4.00);
INSERT INTO FIDE_DESCUENTO_TB (FIDE_DESCUENTO_TB_ID_DESCUENTO_PK, ID_ESTADOS, ID_TIPO_DESCUENTO, VALOR) 
VALUES ('3', '1', '3', 2.00);
COMMIT;

---INSERTS TABLA PROMOCIONES
INSERT INTO FIDE_PROMOCIONES_TB (FIDE_PROMOCIONES_TB_ID_PROMOCION_PK, ID_FACTURAS, ID_ESTADOS, NOMBRE_PROMOCION, FECHA_INICIO, FECHA_FIN, DESCRIPCION) 
VALUES ('1', '1', '1', 'Promoción de Verano', TO_DATE('2024-06-01', 'YYYY-MM-DD'), TO_DATE('2024-08-31', 'YYYY-MM-DD'), 'Descuento especial de verano');
INSERT INTO FIDE_PROMOCIONES_TB (FIDE_PROMOCIONES_TB_ID_PROMOCION_PK, ID_FACTURAS, ID_ESTADOS, NOMBRE_PROMOCION, FECHA_INICIO, FECHA_FIN, DESCRIPCION) 
VALUES ('2', '2', '1', 'Promoción de Invierno', TO_DATE('2024-12-01', 'YYYY-MM-DD'), TO_DATE('2025-02-28', 'YYYY-MM-DD'), 'Descuento especial de invierno');
INSERT INTO FIDE_PROMOCIONES_TB (FIDE_PROMOCIONES_TB_ID_PROMOCION_PK, ID_FACTURAS, ID_ESTADOS, NOMBRE_PROMOCION, FECHA_INICIO, FECHA_FIN, DESCRIPCION) 
VALUES ('3', '3', '1', 'Promoción de Primavera', TO_DATE('2024-03-01', 'YYYY-MM-DD'), TO_DATE('2024-05-31', 'YYYY-MM-DD'), 'Descuento especial de primavera');
COMMIT;

---INSERTS TABLA FACTURAS
INSERT INTO FIDE_FACTURAS_TB (FIDE_FACTURAS_TB_ID_FACTURAS_PK, ID_INVENTARIO, ID_DESCUENTO, ID_ESTADOS, ID_CLIENTE, ID_PROMOCION, FECHA_VENTA, TOTAL_VENTA, SUBTOTAL, IMPUESTOS) 
VALUES ('1', '1', '1', '1', '1', '1', TO_DATE('2024-06-15', 'YYYY-MM-DD'), 100.00, 90.00, 10.00);
INSERT INTO FIDE_FACTURAS_TB (FIDE_FACTURAS_TB_ID_FACTURAS_PK, ID_INVENTARIO, ID_DESCUENTO, ID_ESTADOS, ID_CLIENTE, ID_PROMOCION, FECHA_VENTA, TOTAL_VENTA, SUBTOTAL, IMPUESTOS) 
VALUES ('2', '2', '2', '1', '2', '2', TO_DATE('2024-12-20', 'YYYY-MM-DD'), 200.00, 170.00, 30.00);
INSERT INTO FIDE_FACTURAS_TB (FIDE_FACTURAS_TB_ID_FACTURAS_PK, ID_INVENTARIO, ID_DESCUENTO, ID_ESTADOS, ID_CLIENTE, ID_PROMOCION, FECHA_VENTA, TOTAL_VENTA, SUBTOTAL, IMPUESTOS) 
VALUES ('3', '3', '3', '1', '3', '3', TO_DATE('2024-03-10', 'YYYY-MM-DD'), 300.00, 240.00, 60.00);
COMMIT;

---INSERTS TABLA DETALLES FACTURAS
INSERT INTO FIDE_DETALLES_FACTURAS_TB (FIDE_DETALLES_FACTURAS_TB_ID_DETALLE_PK, ID_FACTURAS, ID_ESTADOS, ID_INVENTARIO, CANTIDAD_VENDIDA, PRECIO_UNITARIO, PRECIO_TOTAL_UNITARIO) 
VALUES ('1', '1', '1', '1', 10, 9.00, 90.00);
INSERT INTO FIDE_DETALLES_FACTURAS_TB (FIDE_DETALLES_FACTURAS_TB_ID_DETALLE_PK, ID_FACTURAS, ID_ESTADOS, ID_INVENTARIO, CANTIDAD_VENDIDA, PRECIO_UNITARIO, PRECIO_TOTAL_UNITARIO) 
VALUES ('2', '2', '1', '2', 20, 8.50, 170.00);
INSERT INTO FIDE_DETALLES_FACTURAS_TB (FIDE_DETALLES_FACTURAS_TB_ID_DETALLE_PK, ID_FACTURAS, ID_ESTADOS, ID_INVENTARIO, CANTIDAD_VENDIDA, PRECIO_UNITARIO, PRECIO_TOTAL_UNITARIO) 
VALUES ('3', '3', '1', '3', 30, 8.00, 240.00);
COMMIT;


--------------------------------------------PROCEDIMIENTOS CRUD--------------------------------------------






--------------------------------------------FUNCIONES------------------------------------------------------------------------------

---------------------------Funcion 1 que hace filtrar los datos de un cliente conforme al nombre----------------------
CREATE OR REPLACE FUNCTION FIDE_CLIENTES_TB_FILTRAR_CLIENTES_FN(
    P_NOMBRE IN VARCHAR2
) RETURN VARCHAR2 IS
    V_RESULTADO VARCHAR2(4000);
BEGIN
    V_RESULTADO := '';

    FOR C IN (
        SELECT FIDE_CLIENTES_TB_ID_CLIENTE_PK, ID_PAIS, ID_PROVINCIA, ID_CANTON, ID_DISTRITO, 
               ID_ESTADOS, NOMBRE, CORREO, CONTRASE�A, DIRECCION, TELEFONO, ESTADO, ACCION
        FROM FIDE_CLIENTES_TB
        WHERE UPPER(NOMBRE) = UPPER(P_NOMBRE)
        ORDER BY NOMBRE
    ) LOOP
        V_RESULTADO := V_RESULTADO || 
                       'ID Cliente: ' || C.FIDE_CLIENTES_TB_ID_CLIENTE_PK || ', ' || 'Pa�s: ' || C.ID_PAIS || ', ' ||
                       'Provincia: ' || C.ID_PROVINCIA || ', ' || 'Cant�n: ' || C.ID_CANTON || ', ' ||
                       'Distrito: ' || C.ID_DISTRITO || ', ' || 'Estado: ' || C.ID_ESTADOS || ', ' ||
                       'Nombre: ' || C.NOMBRE || ', ' || 'Correo: ' || C.CORREO || ', ' ||
                       'Contrase�a: ' || C.CONTRASE�A || ', ' || 'Direcci�n: ' || C.DIRECCION || ', ' ||
                       'Tel�fono: ' || C.TELEFONO || ', ' || 'Estado del Cliente: ' || C.ESTADO || ', ' ||
                       'Acci�n: ' || C.ACCION || ' | '; 
    END LOOP;

    IF V_RESULTADO = '' THEN
        RETURN 'No se encontraron clientes con el nombre proporcionado.';
    ELSE
        RETURN V_RESULTADO;
    END IF;

EXCEPTION
    WHEN OTHERS THEN
        RETURN 'Ocurri� un error: ' || SQLERRM;
END FIDE_CLIENTES_TB_FILTRAR_CLIENTES_FN;
/

SELECT FIDE_CLIENTES_TB_FILTRAR_CLIENTES_FN('Esteban') FROM DUAL;
/
---------------Funcion 2 que con el id del pallet se vea el proveedor -------------

CREATE OR REPLACE FUNCTION FIDE_PALLETS_TB_OBTENER_PROVEEDOR_FN (
    P_ID_PALLET IN VARCHAR2
) RETURN VARCHAR2 IS
    v_nombre_proveedor VARCHAR2(255);
BEGIN
    SELECT FIDE_PROVEEDORES_TB.NOMBRE_PROVEEDOR
    INTO v_nombre_proveedor
    FROM FIDE_PALLETS_TB
    JOIN FIDE_PROVEEDORES_TB ON FIDE_PALLETS_TB.ID_PROVEEDORES = FIDE_PROVEEDORES_TB.FIDE_PROVEEDORES_TB_ID_PROVEEDORES_PK
    WHERE FIDE_PALLETS_TB.FIDE_PALLETS_TB_ID_PALLET_PK = P_ID_PALLET;

    RETURN v_nombre_proveedor;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 'Proveedor no encontrado'; 
    WHEN OTHERS THEN
        RETURN 'Error al obtener el proveedor'; 
END FIDE_PALLETS_TB_OBTENER_PROVEEDOR_FN;
/
SELECT FIDE_PALLETS_TB_OBTENER_PROVEEDOR_FN('1') FROM DUAL;
/

----------------Funcion 3  Filtrar el nombre del descuento con el id de descuento--------------------------------------

CREATE OR REPLACE FUNCTION FIDE_TIPO_DESCUENTO_TB_NOMBRE_DESCUENTO_FN(
    P_ID_TIPO_DESCUENTO IN VARCHAR2
) RETURN VARCHAR2 IS
    V_NOMBRE VARCHAR2(255);
BEGIN
    SELECT NOMBRE
    INTO V_NOMBRE
    FROM FIDE_TIPO_DESCUENTO_TB
    WHERE FIDE_TIPO_DESCUENTO_TB_ID_TIPO_DESCUENTO_PK = P_ID_TIPO_DESCUENTO;

    RETURN V_NOMBRE;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 'No se encontr� el descuento';
    WHEN OTHERS THEN
        RETURN 'Error en la consulta';
END FIDE_TIPO_DESCUENTO_TB_NOMBRE_DESCUENTO_FN;
/
SELECT FIDE_TIPO_DESCUENTO_TB_NOMBRE_DESCUENTO_FN('3') FROM dual;
/

------------------------Funcion 4 con el nombre del producto se filtra la cantidad que hay-------------------------------
CREATE OR REPLACE FUNCTION FIDE_INVENTARIO_TB_CANTIDAD_POR_NOMBRE_FN(
    P_NOMBRE IN VARCHAR2
) RETURN INT IS
    V_CANTIDAD INT;
BEGIN
    SELECT CANTIDAD
    INTO V_CANTIDAD
    FROM FIDE_INVENTARIO_TB
    WHERE NOMBRE = P_NOMBRE;

    RETURN V_CANTIDAD;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 0;
    WHEN OTHERS THEN
        RETURN NULL;
END FIDE_INVENTARIO_TB_CANTIDAD_POR_NOMBRE_FN;
/
SELECT FIDE_INVENTARIO_TB_CANTIDAD_POR_NOMBRE_FN('Armario') FROM dual;
------------------Funcion 5 que con su id se filtre los datos de la factura del id --------------------------------

CREATE OR REPLACE FUNCTION FIDE_FACTURAS_TB_DATOS_FACTURA_FN(
    P_ID_FACTURA  IN VARCHAR2
) RETURN VARCHAR2 IS
    V_FACTURA FIDE_FACTURAS_TB%ROWTYPE;  
BEGIN
    SELECT * INTO V_FACTURA
    FROM FIDE_FACTURAS_TB
    WHERE FIDE_FACTURAS_TB_ID_FACTURAS_PK = P_ID_FACTURA;

    RETURN 'Factura ID: ' || V_FACTURA.FIDE_FACTURAS_TB_ID_FACTURAS_PK ||
           ', Inventario ID: ' || V_FACTURA.ID_INVENTARIO ||
           ', Descuento ID: ' || V_FACTURA.ID_DESCUENTO ||
           ', Estado ID: ' || V_FACTURA.ID_ESTADOS ||
           ', Cliente ID: ' || V_FACTURA.ID_CLIENTE ||
           ', Promoci�n ID: ' || V_FACTURA.ID_PROMOCION ||
           ', Fecha de Venta: ' || V_FACTURA.FECHA_VENTA ||
           ', Total Venta: ' || V_FACTURA.TOTAL_VENTA ||
           ', Subtotal: ' || V_FACTURA.SUBTOTAL ||
           ', Impuestos: ' || V_FACTURA.IMPUESTOS ||
           ', Estado: ' || V_FACTURA.ESTADO;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 'No se encontr� la factura con ese ID';
    WHEN OTHERS THEN
        RETURN 'Error en la consulta';
END FIDE_FACTURAS_TB_DATOS_FACTURA_FN;
/
SELECT FIDE_FACTURAS_TB_DATOS_FACTURA_FN('2') FROM dual;
/
-----------------------Funcion 6 filtra el nombre con el id del canton ---------------------
CREATE OR REPLACE FUNCTION FIDE_CANTON_TB_NOMBRE_POR_ID_FN(
    P_ID_CANTO  IN VARCHAR2
) RETURN VARCHAR2 IS
    V_NOMBRE VARCHAR2(255);
BEGIN
    SELECT NOMBRE
    INTO V_NOMBRE
    FROM FIDE_CANTON_TB
    WHERE FIDE_CANTON_TB_ID_CANTON_PK = P_ID_CANTO;

    RETURN V_NOMBRE;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 'No se encontr� el cant�n con ese ID';
    WHEN OTHERS THEN
        RETURN 'Error en la consulta';
END FIDE_CANTON_TB_NOMBRE_POR_ID_FN;
/
SELECT FIDE_CANTON_TB_NOMBRE_POR_ID_FN('AT') FROM dual;
/
-----------------------Funcion 7  filtra el nombre del distrito con el id------------------------------------------------------
CREATE OR REPLACE FUNCTION FIDE_DISTRITO_TB_NOMBRE_POR_ID_FN(
    P_ID_DISTRITO  IN VARCHAR2
) RETURN VARCHAR2 IS
    V_NOMBRE VARCHAR2(255);
BEGIN
    SELECT NOMBRE
    INTO V_NOMBRE
    FROM FIDE_DISTRITO_TB
    WHERE FIDE_DISTRITO_TB_ID_DISTRITO_PK = P_ID_DISTRITO;

    RETURN V_NOMBRE;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 'No se encontr� el distrito con ese ID';
    WHEN OTHERS THEN
        RETURN 'Error en la consulta';
END FIDE_DISTRITO_TB_NOMBRE_POR_ID_FN;
/
SELECT FIDE_DISTRITO_TB_NOMBRE_POR_ID_FN('ME') FROM dual;
/
