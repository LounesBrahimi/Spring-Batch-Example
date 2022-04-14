DROP TABLE IF EXISTS person;

CREATE TABLE person (
	person_id INT auto_increment NOT NULL PRIMARY KEY,
	first_name VARCHAR(30),
	last_name VARCHAR(30),
	email VARCHAR(50)
	age INT
);