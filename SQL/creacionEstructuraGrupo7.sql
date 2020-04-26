drop schema `grupo-7-bdd-oo2-2020`;
CREATE SCHEMA `grupo-7-bdd-oo2-2020`;
use `grupo-7-bdd-oo2-2020`;

CREATE TABLE `persona` (
`idPersona` INT NOT NULL,
`nombre` VARCHAR(30) NOT NULL,
`apellido` VARCHAR(20) NOT NULL,
`fechaNacimiento` DATE NOT NULL,
`dni` INT ZEROFILL NOT NULL,
PRIMARY KEY (`idPersona`),
UNIQUE INDEX `dni_UNIQUE` (`dni` ASC));

CREATE TABLE `tipoempleado` (
`idTipoEmpleado` INT NOT NULL,
`nombre` VARCHAR(45) NOT NULL,
`descripcion` VARCHAR(45) NULL,
`sueldoBasico` FLOAT ZEROFILL NOT NULL,
PRIMARY KEY (`idTipoEmpleado`),
UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC));

CREATE TABLE `empleado` (
  `idEmpleado` INT NOT NULL,
  `horaIngreso` DATE NOT NULL,
  `horasXJornada` TIME NOT NULL,
  `idTipoEmpleado` INT NOT NULL,
  `baja` BOOLEAN,
  PRIMARY KEY (`idEmpleado`),
  CONSTRAINT `TipoEmpleado_fk`
FOREIGN KEY (`idTipoEmpleado`) REFERENCES `tipoempleado` (`idTipoEmpleado`),
FOREIGN KEY (`idEmpleado`) REFERENCES `persona` (`idPersona`)
);

CREATE TABLE `gerente` (
  `idGerente` INT NOT NULL,  
  PRIMARY KEY (`idGerente`),
  CONSTRAINT `heredaEmpleado_fk`
FOREIGN KEY (`idGerente`) REFERENCES `empleado` (`idEmpleado`)
);



CREATE TABLE `producto` (
`idProducto` INT NOT NULL ,
`nombre` VARCHAR(30) NULL,
`descripcion` VARCHAR(50) NULL,
`precioUnitario` FLOAT ZEROFILL NULL,
PRIMARY KEY (`idProducto`),
UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC));

CREATE TABLE `estadoventa` (
`idEstadoVenta` INT NOT NULL ,
`nombre` VARCHAR(30) NOT NULL,
`descripcion` VARCHAR(20) NULL,
PRIMARY KEY (`idEstadoVenta`),
UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC));


CREATE TABLE `sucursal` (
  `idSucursal` INT NOT NULL, 
  `idGerente` INT NOT NULL,
  `telefono` LONG NOT NULL,
  `localidad` VARCHAR(30) NOT NULL,
  `direccion` VARCHAR(50) NOT NULL,
  `latitud` DOUBLE NOT NULL,
  `longitud` DOUBLE NOT NULL,
  PRIMARY KEY (`idSucursal`),  
  CONSTRAINT `gerente_fk`
FOREIGN KEY (`idGerente`) REFERENCES `gerente` (`idGerente`)
);

CREATE TABLE `vendedor` (
  `idVendedor` INT NOT NULL, 
  `idSucursal` INT NOT NULL,  
  PRIMARY KEY (`idVendedor`),  
  CONSTRAINT `heredaEmpleado2_fk` FOREIGN KEY (`idVendedor`) REFERENCES `empleado` (`idEmpleado`),  
  CONSTRAINT `sucursalvendedor_fk` FOREIGN KEY (`idSucursal`) REFERENCES `sucursal` (`idSucursal`)
  );

CREATE TABLE `venta` (
  `idVenta` INT NOT NULL, 
  `idSucursal` INT NOT NULL,
  `idVendedor` INT NOT NULL,
  `idPersona` INT NOT NULL,
  `idEstadoVenta` INT NOT NULL,
  PRIMARY KEY (`idVenta`),  
  CONSTRAINT `sucVenta_fk` FOREIGN KEY (`idSucursal`) REFERENCES `sucursal` (`idSucursal`),
  CONSTRAINT `sucVendedor_fk` FOREIGN KEY (`idVendedor`) REFERENCES `vendedor` (`idVendedor`),
  CONSTRAINT `sucPersona_fk` FOREIGN KEY (`idPersona`) REFERENCES `persona` (`idPersona`),
  CONSTRAINT `sucEstadoVenta_fk` FOREIGN KEY (`idEstadoVenta`) REFERENCES `estadoVenta` (`idEstadoVenta`)
);

CREATE TABLE `item` (
`idItem` INT NOT NULL,
`idVenta` INT NOT NULL,
`idProducto` INT NOT NULL,
`cantidad` DOUBLE ZEROFILL NOT NULL,
PRIMARY KEY (`idItem`), 
CONSTRAINT `itemVenta_fk` FOREIGN KEY (`idVenta`) REFERENCES `venta` (`idVenta`),
CONSTRAINT `itemProducto_fk` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`)
);


CREATE TABLE `lote` (
  `idLote` INT NOT NULL, 
  `idProducto` INT NOT NULL,
  `cantidad` DOUBLE NOT NULL,
  `idSucursal` INT NOT NULL,
  `fechaIngreso` DATE NOT NULL,
  PRIMARY KEY (`idLote`),  
  CONSTRAINT `productolote_fk` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`),
  CONSTRAINT `sucursallote_fk` FOREIGN KEY (`idSucursal`) REFERENCES `sucursal` (`idSucursal`)
);







