select * from users;
--select * from users WHERE username='user';
--SELECT * FROM pg_catalog.pg_tables;
--SELECT * FROM DOOR;
--SELECT * frOM sensor_status;
SELECT * FROM houses;
--SELECT * FROM house_types;

INSERT INTO house_types(description, name) VALUES('IT IS BIG HOUSER', 'BIG_HOUSE');
INSERT INTO house_types(description, name) VALUES('IT IS FLAT', 'FLAT');
INSERT INTO house_types(description, name) VALUES('IT IS OFFICE', 'OFFICE');

SELECT * FROM floors;
select * from sensors;
select * from sensor_mode;
SELECT * from sensor_status;
SELECT * from status_code;
--SELECT * FROM information_schema.COLUMNS WHERE table_name = 'sensors';

INSERT INTO status_code (code, description, name) values (1123, 'it is very good', 'all good');
INSERT INTO status_code (code, description, name) values (1223, 'it is very good', 'all bad');
INSERT INTO sensor_status (description, name, codeid) VALUES ('good', 'house do not fire', 1);
INSERT INTO sensor_status (description, name, codeid) VALUES ('all very bad', 'house fire', 2);
INSERT INTO sensor_mode (description, name, statusid) values ('YEAH, my sensor work', 'Work', 1);
INSERT INTO sensor_mode (description, name, statusid) values ('Noooooooo :-(', 'NOT WORKING', 2);


INSERT INTO sensors (code_sensor, name, type, modeid) VALUES (12323, 'xiaomi', 0, 1);
INSERT INTO sensors (code_sensor, name, type, modeid) VALUES (13343, 'ajax', 2, 2);
--INSERT INTO sensors (code_sensor, name, type, modeid) VALUES (13223, 'ajax', 2, 3);
--INSERT INTO sensors (code_sensor, name, type, modeid) VALUES (13213, 'ajax', 2, 4);
--INSERT INTO sensors (code_sensor, name, type, modeid) VALUES (12223, 'ajax', 1, 2);
--INSERT INTO sensors (code_sensor, name, type, modeid) VALUES (15213, 'ajax', 0, 1);