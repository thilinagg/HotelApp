CREATE DATABASE incubate;

USE incubate;

CREATE TABLE users (

user_id INT AUTO_INCREMENT PRIMARY KEY,
fname VARCHAR(50),
lname VARCHAR(50),
user_name VARCHAR(100),
password VARCHAR(40)
);

CREATE TABLE hotel (

hotel_id INT AUTO_INCREMENT PRIMARY KEY,
hotel_name VARCHAR(100),
address VARCHAR(255),
city VARCHAR(100)

);

INSERT INTO users (fname, lname, username, password) VALUES ('Thilina', 'Rangana', 'thilina', sha1('abc123'));
