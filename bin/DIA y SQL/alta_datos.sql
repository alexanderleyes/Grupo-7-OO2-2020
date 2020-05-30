CREATE SCHEMA  `grupo-7-bdd-oo2-2020`;



/***PROMERO EJECUTAR SPRING PARA QUE SE CREEN LAS TABLAS*****//////
INSERT INTO `grupo-7-bdd-oo2-2020`.`persona` (`apellido`, `dni`, `fecha_nacimiento`, `nombre`) VALUES ('Perez', '32555666', '1990-05-05', 'Brisa');
INSERT INTO `grupo-7-bdd-oo2-2020`.`persona` (`apellido`, `dni`, `fecha_nacimiento`, `nombre`) VALUES ('Benitez', '22333666', '1992-01-20', 'Pablo');
INSERT INTO `grupo-7-bdd-oo2-2020`.`persona` (`id_persona`, `apellido`, `dni`, `fecha_nacimiento`, `nombre`) VALUES ('3', 'Avalos', '30555999', '2000-03-28', 'Juan');



INSERT INTO `grupo-7-bdd-oo2-2020`.`empleado` (`baja`, `hora_ingreso`, `horas_xjornada`, `password`, `plus_sueldo`, `usuario`, `id_empleado`) VALUES (0, '08:00:00', '06:00:00', '123', '5000', 'pablo', '2');
INSERT INTO `grupo-7-bdd-oo2-2020`.`empleado` (`baja`, `hora_ingreso`, `horas_xjornada`, `password`, `plus_sueldo`, `usuario`, `id_empleado`) VALUES (0, '08:00:00', '08:00:00', '123', '2000', 'juan', '3');

INSERT INTO `grupo-7-bdd-oo2-2020`.`cliente` (`id_cliente`) VALUES ('1');

INSERT INTO `grupo-7-bdd-oo2-2020`.`gerente` (`fecha_ascenso`, `id_gerente`) VALUES ('2020-05-10', '2');

INSERT INTO `grupo-7-bdd-oo2-2020`.`sucursal` (`direccion`, `latitud`, `localidad`, `longitud`, `telefono`) VALUES ('Laprida 777', '1.1111', 'Lomas', '1.212121', '45556987');
INSERT INTO `grupo-7-bdd-oo2-2020`.`sucursal` (`direccion`, `latitud`, `localidad`, `longitud`, `telefono`) VALUES ('Calle 123', '1.1111', 'Lanus', '1.212121', '41113333');


INSERT INTO `grupo-7-bdd-oo2-2020`.`vendedor` (`id_vendedor`, `sucursal_id_sucursal`) VALUES ('3', '1');