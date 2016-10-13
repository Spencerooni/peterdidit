DROP DATABASE IF EXISTS kainos; 

CREATE DATABASE kainos; 
USE kainos; 

CREATE TABLE employee (employee_id int(6)  AUTO_INCREMENT, first_name VARCHAR(20) NOT NULL, last_name VARCHAR(20) NOT NULL, address_1 VARCHAR(30) NOT NULL, address_2 VARCHAR(30), city VARCHAR(30) NOT NULL, postcode VARCHAR(8) NOT NULL, bank_account VARCHAR(34) NOT NULL, salary decimal(11,2) NOT NULL,PRIMARY KEY(employee_id));

CREATE TABLE bu (bu_id int(6) AUTO_INCREMENT, name VARCHAR(30) NOT NULL, directorid int(6) NOT NULL,PRIMARY KEY(bu_id), FOREIGN KEY (directorid) REFERENCES employee(employee_id));

CREATE TABLE emp_bu(emp_id int(6), bu_id int(6) NOT NULL, PRIMARY KEY(emp_id), FOREIGN KEY (emp_id) REFERENCES employee(employee_id), FOREIGN KEY (bu_id) REFERENCES bu(bu_id));




