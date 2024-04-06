-- Insertar una Ciudad asociada a una Sede
INSERT INTO CIUDAD (NOMBRE) VALUES ('Ciudad 1');

-- Insertar una Sede con un director (Persona) asociado
INSERT INTO sede (direccion, director_id, ciudad_id) VALUES ('Calle Principal', null,1);

-- Insertar una Persona
INSERT INTO persona (nombre_completo, fecha_nacimiento, direccion_vivienda, correo_electronico, numero, sede_id,es_socio) VALUES ('Juan Perez', '1990-05-15', 'Calle 123', 'juan@example.com', 123456789,1,TRUE);

UPDATE sede SET director_id = 1 WHERE id = 1;

-- Insertar un TipoCuota asociado a una Cuota
INSERT INTO tipo_Cuota (nombre) VALUES ('minima');

-- Insertar una Cuota asociada a un Socio
INSERT INTO cuota (cuenta_bancaria, valor, fecha_pago, persona_id,tipo_cuota_id) VALUES ('123456789', 10000, '2024-04-06', 1,1);



