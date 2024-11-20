---PROYECTO FINAL / GRUPO 4---

---CREACION DE TABLAS---
---TABLA DE ESTADOS
CREATE TABLE FIDE_ESTADOS_TB (
    ID_ESTADOS VARCHAR2(200) PRIMARY KEY,
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
    ID_PAIS VARCHAR2(200) PRIMARY KEY,
    ID_ESTADOS VARCHAR2(200),
    NOMBRE VARCHAR(255),
    CREADO_POR VARCHAR2(100),
    FECHA_CREACION TIMESTAMP,
    MODIFICADO_POR VARCHAR2(100),
    FECHA_MODIFICACION TIMESTAMP,
    ESTADO VARCHAR2(10),
    ACCION VARCHAR2(100),
    FOREIGN KEY (ID_ESTADOS) REFERENCES FIDE_ESTADOS_TB(ID_ESTADOS)
);

---TABLA DE PROVINCIA
CREATE TABLE FIDE_PROVINCIA_TB (
    ID_PROVINCIA VARCHAR2(200) PRIMARY KEY,
    ID_ESTADOS VARCHAR2(200),
    NOMBRE VARCHAR(255),
    CREADO_POR VARCHAR2(100),
    FECHA_CREACION TIMESTAMP,
    MODIFICADO_POR VARCHAR2(100),
    FECHA_MODIFICACION TIMESTAMP,
    ESTADO VARCHAR2(10),
    ACCION VARCHAR2(100),
    FOREIGN KEY (ID_ESTADOS) REFERENCES FIDE_ESTADOS_TB(ID_ESTADOS)
);

---TABLA DE CANTON
CREATE TABLE FIDE_CANTON_TB (
    ID_CANTON VARCHAR2(200) PRIMARY KEY,
    ID_ESTADOS VARCHAR2(200),
    NOMBRE VARCHAR(255),
    CREADO_POR VARCHAR2(100),
    FECHA_CREACION TIMESTAMP,
    MODIFICADO_POR VARCHAR2(100),
    FECHA_MODIFICACION TIMESTAMP,
    ESTADO VARCHAR2(10),
    ACCION VARCHAR2(100),
    FOREIGN KEY (ID_ESTADOS) REFERENCES FIDE_ESTADOS_TB(ID_ESTADOS)
);

---TABLA DE DISTRITO
CREATE TABLE FIDE_DISTRITO_TB (
    ID_DISTRITO VARCHAR2(200) PRIMARY KEY,
    ID_ESTADOS VARCHAR2(200),
    NOMBRE VARCHAR(255),
    CREADO_POR VARCHAR2(100),
    FECHA_CREACION TIMESTAMP,
    MODIFICADO_POR VARCHAR2(100),
    FECHA_MODIFICACION TIMESTAMP,
    ESTADO VARCHAR2(10),
    ACCION VARCHAR2(100),
    FOREIGN KEY (ID_ESTADOS) REFERENCES FIDE_ESTADOS_TB(ID_ESTADOS)
);

---TABLA DE PROVEEDORES
CREATE TABLE FIDE_PROVEEDORES_TB (
    ID_PROVEEDORES VARCHAR2(200) PRIMARY KEY,
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
    FOREIGN KEY (ID_ESTADOS) REFERENCES FIDE_ESTADOS_TB(ID_ESTADOS),
    FOREIGN KEY (ID_PAIS) REFERENCES FIDE_PAIS_TB(ID_PAIS),
    FOREIGN KEY (ID_PROVINCIA) REFERENCES FIDE_PROVINCIA_TB(ID_PROVINCIA),
    FOREIGN KEY (ID_CANTON) REFERENCES FIDE_CANTON_TB(ID_CANTON),
    FOREIGN KEY (ID_DISTRITO) REFERENCES FIDE_DISTRITO_TB(ID_DISTRITO)
);

---TABLA DE CLIENTES
CREATE TABLE FIDE_CLIENTES_TB (
    ID_CLIENTE VARCHAR2(200) PRIMARY KEY,
    ID_PAIS VARCHAR2(200),
    ID_PROVINCIA VARCHAR2(200),
    ID_CANTON VARCHAR2(200),
    ID_DISTRITO VARCHAR2(200),
    ID_ESTADOS VARCHAR2(200),
    NOMBRE VARCHAR(255),
    CORREO VARCHAR(255),
    DIRECCION VARCHAR(255),
    TELEFONO VARCHAR(20),
    CREADO_POR VARCHAR2(100),
    FECHA_CREACION TIMESTAMP,
    MODIFICADO_POR VARCHAR2(100),
    FECHA_MODIFICACION TIMESTAMP,
    ESTADO VARCHAR2(10),
    ACCION VARCHAR2(100),
    FOREIGN KEY (ID_PAIS) REFERENCES FIDE_PAIS_TB(ID_PAIS),
    FOREIGN KEY (ID_PROVINCIA) REFERENCES FIDE_PROVINCIA_TB(ID_PROVINCIA),
    FOREIGN KEY (ID_CANTON) REFERENCES FIDE_CANTON_TB(ID_CANTON),
    FOREIGN KEY (ID_DISTRITO) REFERENCES FIDE_DISTRITO_TB(ID_DISTRITO),
    FOREIGN KEY (ID_ESTADOS) REFERENCES FIDE_ESTADOS_TB(ID_ESTADOS)
);

---TABLA DE INVENTARIO
CREATE TABLE FIDE_INVENTARIO_TB (
    ID_INVENTARIO VARCHAR2(200) PRIMARY KEY,
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
    FOREIGN KEY (ID_PALLET) REFERENCES FIDE_PALLETS_TB(ID_PALLET),
    FOREIGN KEY (ID_ESTADOS) REFERENCES FIDE_ESTADOS_TB(ID_ESTADOS)
);

---TABLA DE PALLETS
CREATE TABLE FIDE_PALLETS_TB (
    ID_PALLET VARCHAR2(200) PRIMARY KEY,
    ID_PROVEEDORES VARCHAR2(200),
    ID_ESTADOS VARCHAR2(200),
    DESCRIPCION VARCHAR(255),
    CREADO_POR VARCHAR2(100),
    FECHA_CREACION TIMESTAMP,
    MODIFICADO_POR VARCHAR2(100),
    FECHA_MODIFICACION TIMESTAMP,
    ESTADO VARCHAR2(10),
    ACCION VARCHAR2(100),
    FOREIGN KEY (ID_PROVEEDORES) REFERENCES FIDE_PROVEEDORES_TB(ID_PROVEEDORES),
    FOREIGN KEY (ID_ESTADOS) REFERENCES FIDE_ESTADOS_TB(ID_ESTADOS)
);

---TABLA DE DESCUENTO
CREATE TABLE FIDE_DESCUENTO_TB (
    ID_DESCUENTO VARCHAR2(200) PRIMARY KEY,
    ID_ESTADOS VARCHAR2(200),
    ID_TIPO_DESCUENTO VARCHAR2(200),
    VALOR DECIMAL(10, 2),
    CREADO_POR VARCHAR2(100),
    FECHA_CREACION TIMESTAMP,
    MODIFICADO_POR VARCHAR2(100),
    FECHA_MODIFICACION TIMESTAMP,
    ESTADO VARCHAR2(10),
    ACCION VARCHAR2(100),
    FOREIGN KEY (ID_ESTADOS) REFERENCES FIDE_ESTADOS_TB(ID_ESTADOS),
    FOREIGN KEY (ID_TIPO_DESCUENTO) REFERENCES FIDE_TIPO_DESCUENTO_TB(ID_TIPO_DESCUENTO)
);

---TABLA DE TIPO DESCUENTO
CREATE TABLE FIDE_TIPO_DESCUENTO_TB (
    ID_TIPO_DESCUENTO VARCHAR2(200) PRIMARY KEY,
    ID_ESTADOS VARCHAR2(200),
    NOMBRE VARCHAR(255),
    DESCRIPCION VARCHAR(255),
    CREADO_POR VARCHAR2(100),
    FECHA_CREACION TIMESTAMP,
    MODIFICADO_POR VARCHAR2(100),
    FECHA_MODIFICACION TIMESTAMP,
    ESTADO VARCHAR2(10),
    ACCION VARCHAR2(100),
    FOREIGN KEY (ID_ESTADOS) REFERENCES FIDE_ESTADOS_TB(ID_ESTADOS)
);

---TABLA DE PROMOCIONES
CREATE TABLE FIDE_PROMOCIONES_TB (
    ID_PROMOCION VARCHAR2(200) PRIMARY KEY,
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
    FOREIGN KEY (ID_FACTURAS) REFERENCES FIDE_FACTURAS_TB(ID_FACTURAS),
    FOREIGN KEY (ID_ESTADOS) REFERENCES FIDE_ESTADOS_TB(ID_ESTADOS)
);


---TABLA DE FACTURAS
CREATE TABLE FIDE_FACTURAS_TB (
    ID_FACTURAS VARCHAR2(200) PRIMARY KEY,
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
    FOREIGN KEY (ID_INVENTARIO) REFERENCES FIDE_INVENTARIO_TB(ID_INVENTARIO),
    FOREIGN KEY (ID_DESCUENTO) REFERENCES FIDE_DESCUENTO_TB(ID_DESCUENTO),
    FOREIGN KEY (ID_ESTADOS) REFERENCES FIDE_ESTADOS_TB(ID_ESTADOS),
    FOREIGN KEY (ID_CLIENTE) REFERENCES FIDE_CLIENTES_TB(ID_CLIENTE),
    FOREIGN KEY (ID_PROMOCION) REFERENCES FIDE_PROMOCIONES_TB(ID_PROMOCION)
);

---TABLA DE DETALLES FACTURAS
CREATE TABLE FIDE_DETALLES_FACTURAS_TB (
    ID_DETALLE VARCHAR2(200) PRIMARY KEY,
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
    FOREIGN KEY (ID_FACTURAS) REFERENCES FIDE_FACTURAS_TB(ID_FACTURAS),
    FOREIGN KEY (ID_ESTADOS) REFERENCES FIDE_ESTADOS_TB(ID_ESTADOS),
    FOREIGN KEY (ID_INVENTARIO) REFERENCES FIDE_INVENTARIO_TB(ID_INVENTARIO)
);


CREATE TABLE FIDE_USUARIOS_TB (
    USUARIO VARCHAR2(50) PRIMARY KEY,
    CONTRASEÑA VARCHAR2(50)
);

INSERT INTO FIDE_USUARIOS_TB (USUARIO, CONTRASEÑA)
VALUES ('admin', '123456');
COMMIT;



