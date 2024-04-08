-- Insertar un usuario

INSERT INTO usuario (cedula, email, pwd, fecha) VALUES (1005372613, 'account@debuggeandoieas.com', 'to_be_encoded', '2015-12-01');
INSERT INTO usuario (cedula, email, pwd, fecha) VALUES (1005372614, 'account2@debuggeandoieas.com', 'to_be_encoded_auxiliar', '2015-12-01');
INSERT INTO usuario (cedula, email, pwd, fecha) VALUES (1005372615, 'account3@debuggeandoieas.com', 'to_be_encoded_director', '2015-12-01');

-- Insertar un role

INSERT INTO roles (role_name, description) VALUES ('ROLE_ADMIN', 'cant view account endpoint'); 
INSERT INTO roles (role_name, description) VALUES ('ROLE_AUXILIAR', 'cant view account endpoint'); 
INSERT INTO roles (role_name, description) VALUES ('ROLE_DIRECTOR', 'cant view account endpoint'); 

-- Insertar usuarioRoles

INSERT INTO usuario_roles (roles_id, usuario_id) VALUES (1, 1); 
INSERT INTO usuario_roles (roles_id, usuario_id) VALUES (2, 2); 
INSERT INTO usuario_roles (roles_id, usuario_id) VALUES (3, 3); 


-- Insertar una ciudad
INSERT INTO ciudad (nombre) VALUES ('Cali');
INSERT INTO ciudad (nombre) VALUES ('Barranquilla');
INSERT INTO ciudad (nombre) VALUES ('Cartagena');

-- Insertar una sede
INSERT INTO sede (direccion, ciudad_id, director) VALUES ('Direccion 1', 1, 'uno'),('Direccion 2', 2, 'DOS'),('Direccion 3', 3, 'tres');

-- Insertar una Persona
INSERT INTO persona (nombre_completo, fecha_nacimiento, sede_id, numero_telefono, correo_electronico, direccion_vivienda) VALUES ('Juan Perez', '1990-01-01', 1, '123456789', 'juan@example.com', 'Calle 123');
INSERT INTO persona (nombre_completo, fecha_nacimiento, sede_id, numero_telefono, correo_electronico, direccion_vivienda) VALUES('María Lopez', '1985-05-05', 2, '987654321', 'maria@example.com', 'Avenida Principal');
INSERT INTO persona (nombre_completo, fecha_nacimiento, sede_id, numero_telefono, correo_electronico, direccion_vivienda) VALUES('Pedro Ramirez', '1995-10-10', 1, '456789123', 'pedro@example.com', 'Carrera 456');

-- Insertar un tipo de cuota

INSERT INTO tipo_cuota (nombre, valor) VALUES ('minima', 10);
INSERT INTO tipo_cuota (nombre, valor) VALUES ('media', 20);
INSERT INTO tipo_cuota (nombre, valor) VALUES ('maxima', 30);

-- Insertar socios

INSERT INTO socio (persona_id, tipo_cuota_id, cuenta_bancaria) VALUES (1, 1, '1234567890'),  -- Juan Perez, tipo cuota minima
INSERT INTO socio (persona_id, tipo_cuota_id, cuenta_bancaria) VALUES (2, 2, '9876543210');
INSERT INTO socio (persona_id, tipo_cuota_id, cuenta_bancaria) VALUES (3, 3, '4567891230'); 

-- Insertar un Voluntario
INSERT INTO voluntario (tipo, disponibilidad, numero_trabajos, profesion, persona_id) VALUES (1, true, 5, 'profesion1', 1);

INSERT INTO voluntario (tipo, disponibilidad, numero_trabajos, profesion, persona_id) VALUES (1, false, 3, 'profesion2', 2);

INSERT INTO voluntario (tipo, disponibilidad, numero_trabajos, profesion, persona_id) VALUES (1, true, 7, 'profesion3', 3);


-- Insertar materiales
INSERT INTO material (tipo, nombre) VALUES (0, 'Arroz');
INSERT INTO material (tipo, nombre) VALUES (0, 'Frijoles');
INSERT INTO material (tipo, nombre) VALUES (0, 'Aceite');
INSERT INTO material (tipo, nombre) VALUES (1, 'Paracetamol');
INSERT INTO material (tipo, nombre) VALUES (1, 'Ibuprofeno');
INSERT INTO material (tipo, nombre) VALUES (1, 'Amoxicilina');
