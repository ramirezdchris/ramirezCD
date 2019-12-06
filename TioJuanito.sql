-- DROP DATABASE TioJuanito;

CREATE DATABASE TioJuanito CHARACTER SET 'UTF8' COLLATE 'utf8_general_ci';
USE TioJuanito;

CREATE TABLE Buses
(
	idBuses INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	placa VARCHAR(8) NOT NULL,  -- INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    marca VARCHAR(100) NOT NULL,
    modelo VARCHAR(100) NOT NULL,
    asientos INT NOT NULL   
);

CREATE TABLE Chofer
(
	idChofer INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    dui VARCHAR(10) NOT NULL,
    nombreChofer VARCHAR(50) NOT NULL,
    apellidoChofer VARCHAR(50) NOT NULL,
    licencia VARCHAR(20) NOT NULL
);

CREATE TABLE Asistente
(
	idAsistente INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    dui VARCHAR(10) NOT NULL,
    nombreAsistente VARCHAR(50) NOT NULL,
    apellidoAsistente VARCHAR(50) NOT NULL
);

CREATE TABLE BusesChofer
(
	idBusesChofer INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    idBuses INT NOT NULL,
    idChofer INT NOT NULL,
	idAsistente INT NOT NULL
);


-- Relacion de las tablas Buses, Asistente
ALTER TABLE BusesChofer ADD CONSTRAINT FOREIGN KEY(idBuses) REFERENCES Buses(idBuses) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE BusesChofer ADD CONSTRAINT FOREIGN KEY(idChofer) REFERENCES Chofer(idChofer) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE BusesChofer ADD CONSTRAINT FOREIGN KEY(idAsistente) REFERENCES Asistente(idAsistente) ON DELETE CASCADE ON UPDATE CASCADE;


CREATE TABLE Colegio
(
	idColegio INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nombreColegio VARCHAR(50) NOT NULL,
    direccionColegio VARCHAR(50) NOT NULL
);

CREATE TABLE Apoderado
(
	idApoderado INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nombreApoderado VARCHAR(50) NOT NULL,
    apellidoApoderado VARCHAR(50) NOT NULL,
    direccionApoderado VARCHAR(500) NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    correo VARCHAR(30) NOT NULL,
    dui VARCHAR(20) NOT NULL
);

CREATE TABLE Nino
(
	idNino INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nombreNino VARCHAR(50) NOT NULL,
    apellidoNino VARCHAR(50) NOT NULL,
    idApoderado INT NOT NULL
    -- idColegio INT NOT NULL
);

-- Relacionar el colegio del niño o escula
ALTER TABLE Nino ADD CONSTRAINT FOREIGN KEY(idApoderado) REFERENCES Apoderado(idApoderado) ON DELETE CASCADE ON UPDATE CASCADE;
-- ALTER TABLE Nino ADD CONSTRAINT FOREIGN KEY(idColegio) REFERENCES Colegio(idColegio) ON DELETE CASCADE ON UPDATE CASCADE;




CREATE TABLE Modalidad
(
	idModalidad INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    modalidad VARCHAR(100) NOT NULL,
    recoger TIME NOT NULL,
    dejar TIME NOT NULL
);

CREATE TABLE Barrio
(
	idBarrio INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    barrio VARCHAR(200) NOT NULL
);

CREATE TABLE Recorrido
(
	idRecorrido INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    idModalidad INT NOT NULL,
    idBarrio INT NOT NULL,
    idColegio INT NOT NULL,
    idBusesChofer INT NOT NULL
);


-- Relacion de Barrio, Modalidad, Colefio
ALTER TABLE Recorrido ADD CONSTRAINT FOREIGN KEY(idModalidad) REFERENCES Modalidad(idModalidad) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Recorrido ADD CONSTRAINT FOREIGN KEY(idBarrio) REFERENCES Barrio(idBarrio) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Recorrido ADD CONSTRAINT FOREIGN KEY(idColegio) REFERENCES Colegio(idColegio) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Recorrido ADD CONSTRAINT FOREIGN KEY(idBusesChofer) REFERENCES BusesChofer(idBusesChofer) ON DELETE CASCADE ON UPDATE CASCADE;


CREATE TABLE RecorridoNino
(
	-- idRecorridoNino INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    idRecorrido INT NOT NULL,
    idNino INT NOT NULL
    
	-- descripcion VARCHAR(1000)
);

-- Relacion de los recorridos con los viajes que se haran 
ALTER TABLE RecorridoNino ADD CONSTRAINT FOREIGN KEY(idRecorrido) REFERENCES Recorrido(idRecorrido) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE RecorridoNino ADD CONSTRAINT FOREIGN KEY(idNino) REFERENCES Nino(idNino) ON DELETE CASCADE ON UPDATE CASCADE;

CREATE TABLE Viajes
(
	idViaje INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    llegadaColegio TIME NOT NULL,
    retornoCochera TIME NOT NULL,
    kmInicio INT NOT NULL,
    kmFin INT NOT NULL,
    descripcion VARCHAR(1000),
    Fecha DATE,
    idRecorrido INT NOT NULL    
);
-- Relacion de Recorridonino con cada viaje del dia
ALTER TABLE Viajes ADD CONSTRAINT FOREIGN KEY(idRecorrido) REFERENCES Recorrido(idRecorrido);


CREATE TABLE Usuarios
(
	username VARCHAR(50) NOT NULL,
    clave VARCHAR(15) NOT NULL,
    rol VARCHAR(20) NOT NULL,
	idApoderado INT
);

-- Relacionar los usuarios para ingresar al sistema como Admisnitrador o como Padre
ALTER TABLE Usuarios ADD CONSTRAINT FOREIGN KEY(idApoderado) REFERENCES Apoderado(idApoderado) ON DELETE CASCADE ON UPDATE CASCADE;

-- Ususario Super Administrador
INSERT INTO Usuarios(username,clave,rol) VALUES('sa','sa','Super Administrador');

-- Trigger para crear usuario automaticamente cuando se registe en la tabla apoderado
DELIMITER //
CREATE TRIGGER insertarApoderado
AFTER INSERT ON Apoderado FOR EACH ROW
BEGIN
	INSERT INTO Usuarios VALUES(NEW.correo,NEW.dui,'Apoderado',NEW.idApoderado);
END //
DELIMITER ;

/*
SELECT * FROM Apoderado;
SELECT * FROM Usuarios;
INSERT INTO Apoderado VALUES(0,'Christian Denilson','Ramirez Sarmiento','Colonia USAM, km 10','2257-7777','cr@gmail.com','0000000-0');


SELECT a.idBusesChofer, b.placa AS PlacadeAutoBus,CONCAT(c.nombreChofer,' ', c.apellidoChofer) AS NombreChofer , CONCAT(d.nombreAsistente,' ', d.apellidoAsistente) AS NombreAsistente FROM buseschofer a
INNER JOIN buses b ON b.idBuses = a.idBuses
INNER JOIN chofer c ON c.idChofer = a.idChofer
INNER JOIN asistente d ON d.idAsistente = a.idAsistente;


-- Consulta de recorrido
SELECT a.idRecorrido, b.modalidad, c.barrio, d.nombreColegio,f.placa, f.asientos, g.nombreChofer, h.nombreAsistente FROM recorrido a
INNER JOIN modalidad b ON b.idModalidad = a.idModalidad
INNER JOIN barrio c ON c.idBarrio = a.idBarrio
INNER JOIN colegio d ON d.idColegio = a.idColegio
INNER JOIN buseschofer e ON e.idBusesChofer = a.idBusesChofer
INNER JOIN buses f ON f.idBuses = f.idBuses
INNER JOIN chofer g ON g.idChofer = g.idChofer
INNER JOIN asistente h ON h.idAsistente = h.idAsistente;


SET FOREIGN_KEY_CHECKS = 0;
SET FOREIGN_KEY_CHECKS = 1;
TRUNCATE buses;
TRUNCATE chofer;
TRUNCATE asistente;
TRUNCATE colegio;
TRUNCATE barrio;
TRUNCATE modalidad;
TRUNCATE recorrido;

INSERT INTO buses VALUES(0,'A62-458', 'BlueBird', 'BlueBired',10),
(0,'A98-558', 'BlueBird', 'BlueBired',10),
(0,'A100-458', 'BlueBird', 'BlueBired',10),
(0,'A92-458', 'BlueBird', 'BlueBired',10),
(0,'A62-458', 'BlueBird', 'BlueBired',10),
(0,'A58-458', 'BlueBird', 'BlueBired',10),
(0,'A89-458', 'BlueBird', 'BlueBired',10),
(0,'A22-458', 'BlueBird', 'BlueBired',10),
(0,'A12-458', 'BlueBird', 'BlueBired',10),
(0,'A01-458', 'BlueBird', 'BlueBired',10);

INSERT INTO asistente VALUES(0,'05547813-5','Fernando','Ruíz'),
(0,'03541213-7','Juan Pablo','Baires'),
(0,'09456652-9','Christian','Cruz');

INSERT INTO Chofer VALUES(0,'05547813-4','Christian Denilson','Ramírez','00000'),
(0,'05547813-4','Juan Carlos','Nativí','00000');


SELECT a.idRecorrido, b.modalidad, c.barrio, d.nombreColegio,f.placa, f.asientos, g.nombreChofer, h.nombreAsistente FROM recorrido a
                INNER JOIN modalidad b ON b.idModalidad = a.idModalidad
                INNER JOIN barrio c ON c.idBarrio = a.idBarrio
                INNER JOIN colegio d ON d.idColegio = a.idColegio
                INNER JOIN buseschofer e ON e.idBusesChofer = a.idBusesChofer
                INNER JOIN buses f ON f.idBuses = e.idBuses
                INNER JOIN chofer g ON g.idChofer = e.idChofer
                INNER JOIN asistente h ON h.idAsistente = e.idAsistente order by a.idRecorrido ASC;

-- sp_MostrarClientesDELIMITADOR;

SELECT * FROM recorrido;*/

SELECT * FROM Apoderado;

SELECT rol, nombreApoderado FROM usuarios a
LEFT JOIN Apoderado b ON b.idApoderado = a.idApoderado WHERE username = 'sa' AND clave = 'sa';

SELECT rol, nombreApoderado,username,clave FROM usuarios a
LEFT JOIN Apoderado b ON b.idApoderado = a.idApoderado;

