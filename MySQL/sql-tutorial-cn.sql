drop database if exists randolflu;
create database if not exists randolflu;
show databases;
use randolflu;

drop table if exists regions;
CREATE TABLE if not exists regions
(
    region_id   INT(11) AUTO_INCREMENT PRIMARY KEY,
    region_name VARCHAR(25) DEFAULT NULL
);

drop table if exists countries;
CREATE TABLE if not exists countries
(
    country_id   CHAR(2) PRIMARY KEY,
    country_name VARCHAR(40) DEFAULT NULL,
    region_id    INT(11) NOT NULL,
    FOREIGN KEY (region_id) REFERENCES regions (region_id) ON DELETE CASCADE ON UPDATE CASCADE
);

drop table if exists locations;
CREATE TABLE if not exists locations
(
    location_id    INT(11) AUTO_INCREMENT PRIMARY KEY,
    street_address VARCHAR(40) DEFAULT NULL,
    postal_code    VARCHAR(12) DEFAULT NULL,
    city           VARCHAR(30) NOT NULL,
    state_province VARCHAR(25) DEFAULT NULL,
    country_id     CHAR(2)     NOT NULL,
    FOREIGN KEY (country_id) REFERENCES countries (country_id) ON DELETE CASCADE ON UPDATE CASCADE
);
drop table if exists jobs;
CREATE TABLE if not exists jobs
(
    job_id     INT(11) AUTO_INCREMENT PRIMARY KEY,
    job_title  VARCHAR(35) NOT NULL,
    min_salary DECIMAL(8, 2) DEFAULT NULL,
    max_salary DECIMAL(8, 2) DEFAULT NULL
);
drop table if exists departments;
CREATE TABLE if not exists departments
(
    department_id   INT(11) AUTO_INCREMENT PRIMARY KEY,
    department_name VARCHAR(30) NOT NULL,
    location_id     INT(11) DEFAULT NULL,
    FOREIGN KEY (location_id) REFERENCES locations (location_id) ON DELETE CASCADE ON UPDATE CASCADE
);

drop table if exists employees;
CREATE TABLE if not exists employees
(
    employee_id   INT(11) AUTO_INCREMENT PRIMARY KEY,
    first_name    VARCHAR(20) DEFAULT NULL,
    last_name     VARCHAR(25)   NOT NULL,
    email         VARCHAR(100)  NOT NULL,
    phone_number  VARCHAR(20) DEFAULT NULL,
    hire_date     DATE          NOT NULL,
    job_id        INT(11)       NOT NULL,
    salary        DECIMAL(8, 2) NOT NULL,
    manager_id    INT(11)     DEFAULT NULL,
    department_id INT(11)     DEFAULT NULL,
    FOREIGN KEY (job_id) REFERENCES jobs (job_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (department_id) REFERENCES departments (department_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (manager_id) REFERENCES employees (employee_id)
);

drop table if exists dependents;
CREATE TABLE if not exists dependents
(
    dependent_id INT(11) AUTO_INCREMENT PRIMARY KEY,
    first_name   VARCHAR(50) NOT NULL,
    last_name    VARCHAR(50) NOT NULL,
    relationship VARCHAR(25) NOT NULL,
    employee_id  INT(11)     NOT NULL,
    FOREIGN KEY (employee_id) REFERENCES employees (employee_id) ON DELETE CASCADE ON UPDATE CASCADE
);

/*Data for the table regions */

INSERT INTO regions(region_id, region_name)
VALUES (1, 'Europe');
INSERT INTO regions(region_id, region_name)
VALUES (2, 'Americas');
INSERT INTO regions(region_id, region_name)
VALUES (3, 'Asia');
INSERT INTO regions(region_id, region_name)
VALUES (4, 'Middle East and Africa');


/*Data for the table countries */
INSERT INTO countries(country_id, country_name, region_id)
VALUES ('AR', 'Argentina', 2);
INSERT INTO countries(country_id, country_name, region_id)
VALUES ('AU', 'Australia', 3);
INSERT INTO countries(country_id, country_name, region_id)
VALUES ('BE', 'Belgium', 1);
INSERT INTO countries(country_id, country_name, region_id)
VALUES ('BR', 'Brazil', 2);
INSERT INTO countries(country_id, country_name, region_id)
VALUES ('CA', 'Canada', 2);
INSERT INTO countries(country_id, country_name, region_id)
VALUES ('CH', 'Switzerland', 1);
INSERT INTO countries(country_id, country_name, region_id)
VALUES ('CN', 'China', 3);
INSERT INTO countries(country_id, country_name, region_id)
VALUES ('DE', 'Germany', 1);
INSERT INTO countries(country_id, country_name, region_id)
VALUES ('DK', 'Denmark', 1);
INSERT INTO countries(country_id, country_name, region_id)
VALUES ('EG', 'Egypt', 4);
INSERT INTO countries(country_id, country_name, region_id)
VALUES ('FR', 'France', 1);
INSERT INTO countries(country_id, country_name, region_id)
VALUES ('HK', 'HongKong', 3);
INSERT INTO countries(country_id, country_name, region_id)
VALUES ('IL', 'Israel', 4);
INSERT INTO countries(country_id, country_name, region_id)
VALUES ('IN', 'India', 3);
INSERT INTO countries(country_id, country_name, region_id)
VALUES ('IT', 'Italy', 1);
INSERT INTO countries(country_id, country_name, region_id)
VALUES ('JP', 'Japan', 3);
INSERT INTO countries(country_id, country_name, region_id)
VALUES ('KW', 'Kuwait', 4);
INSERT INTO countries(country_id, country_name, region_id)
VALUES ('MX', 'Mexico', 2);
INSERT INTO countries(country_id, country_name, region_id)
VALUES ('NG', 'Nigeria', 4);
INSERT INTO countries(country_id, country_name, region_id)
VALUES ('NL', 'Netherlands', 1);
INSERT INTO countries(country_id, country_name, region_id)
VALUES ('SG', 'Singapore', 3);
INSERT INTO countries(country_id, country_name, region_id)
VALUES ('UK', 'United Kingdom', 1);
INSERT INTO countries(country_id, country_name, region_id)
VALUES ('US', 'United States of America', 2);
INSERT INTO countries(country_id, country_name, region_id)
VALUES ('ZM', 'Zambia', 4);
INSERT INTO countries(country_id, country_name, region_id)
VALUES ('ZW', 'Zimbabwe', 4);

/*Data for the table locations */
INSERT INTO locations(location_id, street_address, postal_code, city, state_province, country_id)
VALUES (1400, '2014 Jabberwocky Rd', '26192', 'Southlake', 'Texas', 'US');
INSERT INTO locations(location_id, street_address, postal_code, city, state_province, country_id)
VALUES (1500, '2011 Interiors Blvd', '99236', 'South San Francisco', 'California', 'US');
INSERT INTO locations(location_id, street_address, postal_code, city, state_province, country_id)
VALUES (1700, '2004 Charade Rd', '98199', 'Seattle', 'Washington', 'US');
INSERT INTO locations(location_id, street_address, postal_code, city, state_province, country_id)
VALUES (1800, '147 Spadina Ave', 'M5V 2L7', 'Toronto', 'Ontario', 'CA');
INSERT INTO locations(location_id, street_address, postal_code, city, state_province, country_id)
VALUES (2400, '8204 Arthur St', NULL, 'London', NULL, 'UK');
INSERT INTO locations(location_id, street_address, postal_code, city, state_province, country_id)
VALUES (2500, 'Magdalen Centre, The Oxford Science Park', 'OX9 9ZB', 'Oxford', 'Oxford', 'UK');
INSERT INTO locations(location_id, street_address, postal_code, city, state_province, country_id)
VALUES (2700, 'Schwanthalerstr. 7031', '80925', 'Munich', 'Bavaria', 'DE');


/*Data for the table jobs */

INSERT INTO jobs(job_id, job_title, min_salary, max_salary)
VALUES (1, 'Public Accountant', 4200.00, 9000.00);
INSERT INTO jobs(job_id, job_title, min_salary, max_salary)
VALUES (2, 'Accounting Manager', 8200.00, 16000.00);
INSERT INTO jobs(job_id, job_title, min_salary, max_salary)
VALUES (3, 'Administration Assistant', 3000.00, 6000.00);
INSERT INTO jobs(job_id, job_title, min_salary, max_salary)
VALUES (4, 'President', 20000.00, 40000.00);
INSERT INTO jobs(job_id, job_title, min_salary, max_salary)
VALUES (5, 'Administration Vice President', 15000.00, 30000.00);
INSERT INTO jobs(job_id, job_title, min_salary, max_salary)
VALUES (6, 'Accountant', 4200.00, 9000.00);
INSERT INTO jobs(job_id, job_title, min_salary, max_salary)
VALUES (7, 'Finance Manager', 8200.00, 16000.00);
INSERT INTO jobs(job_id, job_title, min_salary, max_salary)
VALUES (8, 'Human Resources Representative', 4000.00, 9000.00);
INSERT INTO jobs(job_id, job_title, min_salary, max_salary)
VALUES (9, 'Programmer', 4000.00, 10000.00);
INSERT INTO jobs(job_id, job_title, min_salary, max_salary)
VALUES (10, 'Marketing Manager', 9000.00, 15000.00);
INSERT INTO jobs(job_id, job_title, min_salary, max_salary)
VALUES (11, 'Marketing Representative', 4000.00, 9000.00);
INSERT INTO jobs(job_id, job_title, min_salary, max_salary)
VALUES (12, 'Public Relations Representative', 4500.00, 10500.00);
INSERT INTO jobs(job_id, job_title, min_salary, max_salary)
VALUES (13, 'Purchasing Clerk', 2500.00, 5500.00);
INSERT INTO jobs(job_id, job_title, min_salary, max_salary)
VALUES (14, 'Purchasing Manager', 8000.00, 15000.00);
INSERT INTO jobs(job_id, job_title, min_salary, max_salary)
VALUES (15, 'Sales Manager', 10000.00, 20000.00);
INSERT INTO jobs(job_id, job_title, min_salary, max_salary)
VALUES (16, 'Sales Representative', 6000.00, 12000.00);
INSERT INTO jobs(job_id, job_title, min_salary, max_salary)
VALUES (17, 'Shipping Clerk', 2500.00, 5500.00);
INSERT INTO jobs(job_id, job_title, min_salary, max_salary)
VALUES (18, 'Stock Clerk', 2000.00, 5000.00);
INSERT INTO jobs(job_id, job_title, min_salary, max_salary)
VALUES (19, 'Stock Manager', 5500.00, 8500.00);


/*Data for the table departments */

INSERT INTO departments(department_id, department_name, location_id)
VALUES (1, 'Administration', 1700);
INSERT INTO departments(department_id, department_name, location_id)
VALUES (2, 'Marketing', 1800);
INSERT INTO departments(department_id, department_name, location_id)
VALUES (3, 'Purchasing', 1700);
INSERT INTO departments(department_id, department_name, location_id)
VALUES (4, 'Human Resources', 2400);
INSERT INTO departments(department_id, department_name, location_id)
VALUES (5, 'Shipping', 1500);
INSERT INTO departments(department_id, department_name, location_id)
VALUES (6, 'IT', 1400);
INSERT INTO departments(department_id, department_name, location_id)
VALUES (7, 'Public Relations', 2700);
INSERT INTO departments(department_id, department_name, location_id)
VALUES (8, 'Sales', 2500);
INSERT INTO departments(department_id, department_name, location_id)
VALUES (9, 'Executive', 1700);
INSERT INTO departments(department_id, department_name, location_id)
VALUES (10, 'Finance', 1700);
INSERT INTO departments(department_id, department_name, location_id)
VALUES (11, 'Accounting', 1700);


/*Data for the table employees */

INSERT INTO employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id,
                      department_id)
VALUES (100, 'Steven', 'King', 'steven.king@sqltutorial.org', '515.123.4567', '1987-06-17', 4, 24000.00, NULL, 9);
INSERT INTO employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id,
                      department_id)
VALUES (101, 'Neena', 'Kochhar', 'neena.kochhar@sqltutorial.org', '515.123.4568', '1989-09-21', 5, 17000.00, 100, 9);
INSERT INTO employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id,
                      department_id)
VALUES (102, 'Lex', 'De Haan', 'lex.de haan@sqltutorial.org', '515.123.4569', '1993-01-13', 5, 17000.00, 100, 9);
INSERT INTO employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id,
                      department_id)
VALUES (103, 'Alexander', 'Hunold', 'alexander.hunold@sqltutorial.org', '590.423.4567', '1990-01-03', 9, 9000.00, 102,
        6);
INSERT INTO employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id,
                      department_id)
VALUES (104, 'Bruce', 'Ernst', 'bruce.ernst@sqltutorial.org', '590.423.4568', '1991-05-21', 9, 6000.00, 103, 6);
INSERT INTO employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id,
                      department_id)
VALUES (105, 'David', 'Austin', 'david.austin@sqltutorial.org', '590.423.4569', '1997-06-25', 9, 4800.00, 103, 6);
INSERT INTO employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id,
                      department_id)
VALUES (106, 'Valli', 'Pataballa', 'valli.pataballa@sqltutorial.org', '590.423.4560', '1998-02-05', 9, 4800.00, 103, 6);
INSERT INTO employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id,
                      department_id)
VALUES (107, 'Diana', 'Lorentz', 'diana.lorentz@sqltutorial.org', '590.423.5567', '1999-02-07', 9, 4200.00, 103, 6);
INSERT INTO employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id,
                      department_id)
VALUES (108, 'Nancy', 'Greenberg', 'nancy.greenberg@sqltutorial.org', '515.124.4569', '1994-08-17', 7, 12000.00, 101,
        10);
INSERT INTO employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id,
                      department_id)
VALUES (109, 'Daniel', 'Faviet', 'daniel.faviet@sqltutorial.org', '515.124.4169', '1994-08-16', 6, 9000.00, 108, 10);
INSERT INTO employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id,
                      department_id)
VALUES (110, 'John', 'Chen', 'john.chen@sqltutorial.org', '515.124.4269', '1997-09-28', 6, 8200.00, 108, 10);
INSERT INTO employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id,
                      department_id)
VALUES (111, 'Ismael', 'Sciarra', 'ismael.sciarra@sqltutorial.org', '515.124.4369', '1997-09-30', 6, 7700.00, 108, 10);
INSERT INTO employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id,
                      department_id)
VALUES (112, 'Jose Manuel', 'Urman', 'jose manuel.urman@sqltutorial.org', '515.124.4469', '1998-03-07', 6, 7800.00, 108,
        10);
INSERT INTO employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id,
                      department_id)
VALUES (113, 'Luis', 'Popp', 'luis.popp@sqltutorial.org', '515.124.4567', '1999-12-07', 6, 6900.00, 108, 10);
INSERT INTO employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id,
                      department_id)
VALUES (114, 'Den', 'Raphaely', 'den.raphaely@sqltutorial.org', '515.127.4561', '1994-12-07', 14, 11000.00, 100, 3);
INSERT INTO employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id,
                      department_id)
VALUES (115, 'Alexander', 'Khoo', 'alexander.khoo@sqltutorial.org', '515.127.4562', '1995-05-18', 13, 3100.00, 114, 3);
INSERT INTO employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id,
                      department_id)
VALUES (116, 'Shelli', 'Baida', 'shelli.baida@sqltutorial.org', '515.127.4563', '1997-12-24', 13, 2900.00, 114, 3);
INSERT INTO employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id,
                      department_id)
VALUES (117, 'Sigal', 'Tobias', 'sigal.tobias@sqltutorial.org', '515.127.4564', '1997-07-24', 13, 2800.00, 114, 3);
INSERT INTO employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id,
                      department_id)
VALUES (118, 'Guy', 'Himuro', 'guy.himuro@sqltutorial.org', '515.127.4565', '1998-11-15', 13, 2600.00, 114, 3);
INSERT INTO employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id,
                      department_id)
VALUES (119, 'Karen', 'Colmenares', 'karen.colmenares@sqltutorial.org', '515.127.4566', '1999-08-10', 13, 2500.00, 114,
        3);
INSERT INTO employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id,
                      department_id)
VALUES (120, 'Matthew', 'Weiss', 'matthew.weiss@sqltutorial.org', '650.123.1234', '1996-07-18', 19, 8000.00, 100, 5);
INSERT INTO employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id,
                      department_id)
VALUES (121, 'Adam', 'Fripp', 'adam.fripp@sqltutorial.org', '650.123.2234', '1997-04-10', 19, 8200.00, 100, 5);
INSERT INTO employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id,
                      department_id)
VALUES (122, 'Payam', 'Kaufling', 'payam.kaufling@sqltutorial.org', '650.123.3234', '1995-05-01', 19, 7900.00, 100, 5);
INSERT INTO employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id,
                      department_id)
VALUES (123, 'Shanta', 'Vollman', 'shanta.vollman@sqltutorial.org', '650.123.4234', '1997-10-10', 19, 6500.00, 100, 5);
INSERT INTO employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id,
                      department_id)
VALUES (126, 'Irene', 'Mikkilineni', 'irene.mikkilineni@sqltutorial.org', '650.124.1224', '1998-09-28', 18, 2700.00,
        120, 5);
INSERT INTO employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id,
                      department_id)
VALUES (145, 'John', 'Russell', 'john.russell@sqltutorial.org', NULL, '1996-10-01', 15, 14000.00, 100, 8);
INSERT INTO employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id,
                      department_id)
VALUES (146, 'Karen', 'Partners', 'karen.partners@sqltutorial.org', NULL, '1997-01-05', 15, 13500.00, 100, 8);
INSERT INTO employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id,
                      department_id)
VALUES (176, 'Jonathon', 'Taylor', 'jonathon.taylor@sqltutorial.org', NULL, '1998-03-24', 16, 8600.00, 100, 8);
INSERT INTO employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id,
                      department_id)
VALUES (177, 'Jack', 'Livingston', 'jack.livingston@sqltutorial.org', NULL, '1998-04-23', 16, 8400.00, 100, 8);
INSERT INTO employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id,
                      department_id)
VALUES (178, 'Kimberely', 'Grant', 'kimberely.grant@sqltutorial.org', NULL, '1999-05-24', 16, 7000.00, 100, 8);
INSERT INTO employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id,
                      department_id)
VALUES (179, 'Charles', 'Johnson', 'charles.johnson@sqltutorial.org', NULL, '2000-01-04', 16, 6200.00, 100, 8);
INSERT INTO employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id,
                      department_id)
VALUES (192, 'Sarah', 'Bell', 'sarah.bell@sqltutorial.org', '650.501.1876', '1996-02-04', 17, 4000.00, 123, 5);
INSERT INTO employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id,
                      department_id)
VALUES (193, 'Britney', 'Everett', 'britney.everett@sqltutorial.org', '650.501.2876', '1997-03-03', 17, 3900.00, 123,
        5);
INSERT INTO employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id,
                      department_id)
VALUES (200, 'Jennifer', 'Whalen', 'jennifer.whalen@sqltutorial.org', '515.123.4444', '1987-09-17', 3, 4400.00, 101, 1);
INSERT INTO employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id,
                      department_id)
VALUES (201, 'Michael', 'Hartstein', 'michael.hartstein@sqltutorial.org', '515.123.5555', '1996-02-17', 10, 13000.00,
        100, 2);
INSERT INTO employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id,
                      department_id)
VALUES (202, 'Pat', 'Fay', 'pat.fay@sqltutorial.org', '603.123.6666', '1997-08-17', 11, 6000.00, 201, 2);
INSERT INTO employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id,
                      department_id)
VALUES (203, 'Susan', 'Mavris', 'susan.mavris@sqltutorial.org', '515.123.7777', '1994-06-07', 8, 6500.00, 101, 4);
INSERT INTO employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id,
                      department_id)
VALUES (204, 'Hermann', 'Baer', 'hermann.baer@sqltutorial.org', '515.123.8888', '1994-06-07', 12, 10000.00, 101, 7);
INSERT INTO employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id,
                      department_id)
VALUES (205, 'Shelley', 'Higgins', 'shelley.higgins@sqltutorial.org', '515.123.8080', '1994-06-07', 2, 12000.00, 101,
        11);
INSERT INTO employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id,
                      department_id)
VALUES (206, 'William', 'Gietz', 'william.gietz@sqltutorial.org', '515.123.8181', '1994-06-07', 1, 8300.00, 205, 11);


/*Data for the table dependents */

INSERT INTO dependents(dependent_id, first_name, last_name, relationship, employee_id)
VALUES (1, 'Penelope', 'Gietz', 'Child', 206);
INSERT INTO dependents(dependent_id, first_name, last_name, relationship, employee_id)
VALUES (2, 'Nick', 'Higgins', 'Child', 205);
INSERT INTO dependents(dependent_id, first_name, last_name, relationship, employee_id)
VALUES (3, 'Ed', 'Whalen', 'Child', 200);
INSERT INTO dependents(dependent_id, first_name, last_name, relationship, employee_id)
VALUES (4, 'Jennifer', 'King', 'Child', 100);
INSERT INTO dependents(dependent_id, first_name, last_name, relationship, employee_id)
VALUES (5, 'Johnny', 'Kochhar', 'Child', 101);
INSERT INTO dependents(dependent_id, first_name, last_name, relationship, employee_id)
VALUES (6, 'Bette', 'De Haan', 'Child', 102);
INSERT INTO dependents(dependent_id, first_name, last_name, relationship, employee_id)
VALUES (7, 'Grace', 'Faviet', 'Child', 109);
INSERT INTO dependents(dependent_id, first_name, last_name, relationship, employee_id)
VALUES (8, 'Matthew', 'Chen', 'Child', 110);
INSERT INTO dependents(dependent_id, first_name, last_name, relationship, employee_id)
VALUES (9, 'Joe', 'Sciarra', 'Child', 111);
INSERT INTO dependents(dependent_id, first_name, last_name, relationship, employee_id)
VALUES (10, 'Christian', 'Urman', 'Child', 112);
INSERT INTO dependents(dependent_id, first_name, last_name, relationship, employee_id)
VALUES (11, 'Zero', 'Popp', 'Child', 113);
INSERT INTO dependents(dependent_id, first_name, last_name, relationship, employee_id)
VALUES (12, 'Karl', 'Greenberg', 'Child', 108);
INSERT INTO dependents(dependent_id, first_name, last_name, relationship, employee_id)
VALUES (13, 'Uma', 'Mavris', 'Child', 203);
INSERT INTO dependents(dependent_id, first_name, last_name, relationship, employee_id)
VALUES (14, 'Vivien', 'Hunold', 'Child', 103);
INSERT INTO dependents(dependent_id, first_name, last_name, relationship, employee_id)
VALUES (15, 'Cuba', 'Ernst', 'Child', 104);
INSERT INTO dependents(dependent_id, first_name, last_name, relationship, employee_id)
VALUES (16, 'Fred', 'Austin', 'Child', 105);
INSERT INTO dependents(dependent_id, first_name, last_name, relationship, employee_id)
VALUES (17, 'Helen', 'Pataballa', 'Child', 106);
INSERT INTO dependents(dependent_id, first_name, last_name, relationship, employee_id)
VALUES (18, 'Dan', 'Lorentz', 'Child', 107);
INSERT INTO dependents(dependent_id, first_name, last_name, relationship, employee_id)
VALUES (19, 'Bob', 'Hartstein', 'Child', 201);
INSERT INTO dependents(dependent_id, first_name, last_name, relationship, employee_id)
VALUES (20, 'Lucille', 'Fay', 'Child', 202);
INSERT INTO dependents(dependent_id, first_name, last_name, relationship, employee_id)
VALUES (21, 'Kirsten', 'Baer', 'Child', 204);
INSERT INTO dependents(dependent_id, first_name, last_name, relationship, employee_id)
VALUES (22, 'Elvis', 'Khoo', 'Child', 115);
INSERT INTO dependents(dependent_id, first_name, last_name, relationship, employee_id)
VALUES (23, 'Sandra', 'Baida', 'Child', 116);
INSERT INTO dependents(dependent_id, first_name, last_name, relationship, employee_id)
VALUES (24, 'Cameron', 'Tobias', 'Child', 117);
INSERT INTO dependents(dependent_id, first_name, last_name, relationship, employee_id)
VALUES (25, 'Kevin', 'Himuro', 'Child', 118);
INSERT INTO dependents(dependent_id, first_name, last_name, relationship, employee_id)
VALUES (26, 'Rip', 'Colmenares', 'Child', 119);
INSERT INTO dependents(dependent_id, first_name, last_name, relationship, employee_id)
VALUES (27, 'Julia', 'Raphaely', 'Child', 114);
INSERT INTO dependents(dependent_id, first_name, last_name, relationship, employee_id)
VALUES (28, 'Woody', 'Russell', 'Child', 145);
INSERT INTO dependents(dependent_id, first_name, last_name, relationship, employee_id)
VALUES (29, 'Alec', 'Partners', 'Child', 146);
INSERT INTO dependents(dependent_id, first_name, last_name, relationship, employee_id)
VALUES (30, 'Sandra', 'Taylor', 'Child', 176);

show tables;
describe employees;
select *
from employees;
select e.employee_id                                        as '员工ID',
       e.first_name                                         as '名字',
       e.last_name                                          as '姓氏',
       concat(e.first_name, '·', e.last_name)               as '姓名',
       e.hire_date                                          as '入职日期',
       concat(round(e.salary * 0.001, 1), 'k')              as '薪水',
       concat(round(e.salary * (1 + 0.05) * 0.001, 1), 'k') as '涨薪'
from employees e
order by month(e.hire_date) desc, e.salary desc;
update employees e
set e.hire_date = date_add(e.hire_date, interval 25 year)
where e.employee_id > 0;
select e.employee_id, e.first_name, e.last_name
from employees e
order by e.first_name asc, e.last_name desc;
select e.employee_id, e.first_name, e.last_name, e.salary
from employees e
order by e.salary desc, e.last_name asc;
select e.first_name, e.last_name, e.hire_date
from employees e
order by hire_date desc;
select distinct e.manager_id
from employees e
order by e.manager_id; -- NULLS LAST ; MySQL不支持

select count(1)
from (select e.job_id, e.salary
      from employees e) as jis;

select count(distinct jis.job_id, jis.salary)
from (select e.job_id, e.salary from employees e) as jis;

select e.job_id, e.salary
from employees e;

select e.salary
from employees e;
select distinct e.salary
from employees e
order by e.salary desc;
select e.job_id,
       e.salary,
       count(1) as total,
       case
           when count(1) >= 2
               then '√√√是√√√'
           else '否'
           end  as '是否重复'
from employees e
group by e.job_id, e.salary;

select null is null, null != null, null = null;
select distinct e.phone_number
from employees e;
select e.phone_number, count(e.phone_number)
from employees e
group by e.phone_number;

select *
from employees e
limit 0,5; -- OFFSET, LIMIT

select *
from employees e
order by e.salary desc
limit 5 offset 0; -- LIMIT limit OFFSET offset

select *
from employees e
order by e.first_name
limit 5 offset 10;

select e.employee_id, e.first_name, e.last_name, e.salary
from employees e
order by e.salary desc
limit 5 offset 0;

select e.employee_id, e.first_name, e.last_name, e.salary
from employees e
order by e.salary asc
limit 0,5;

select e.first_name, e.last_name, e.salary
from employees e
order by e.salary desc
limit 1 offset 1;

select *
from employees e
where e.salary = (select e2.salary
                  from employees e2
                  order by e2.salary desc
                  limit 1,1);
-- FETCH , MySQL 不支持
SELECT first_name,
       salary
FROM employees
ORDER BY salary DESC FETCH FIRST 5 ROWS ONLY;

select concat(e.first_name, ' ', e.last_name) as 'Name'
     , e.salary                               as 'salary'
from employees e
order by e.salary desc
limit 0,5;

select concat(e.first_name, ' ', e.last_name) as 'Name'
     , e.hire_date
from employees e
order by e.hire_date desc
limit 5 offset 0;

select year(e.hire_date)                      as 'Year',
       month(e.hire_date)                     as 'Month',
       e.hire_date,
       concat(e.first_name, ' ', e.last_name) as 'Name'
from employees e
group by year(e.hire_date), month(e.hire_date), employee_id
order by Year desc;

-- fetch 语句mysql不支持
/*  */
SELECT first_name, last_name
FROM employees
ORDER BY first_name, last_name OFFSET 5 ROWS
FETCH NEXT 5 ROWS ONLY;

select *
from employees e
where e.salary = 17000;

select *
from employees e
where e.salary != 17000;

select *
from employees e
where e.salary <= 20000
  and e.salary >= 12000
order by e.salary desc;

select *
from employees e
where e.last_name = 'Chen';

select *
from employees e
where e.last_name = 'chen';

select *
from employees e
where e.hire_date > '2024-01-01'
order by e.hire_date desc;

-- 查找2023年入职的员工
select *
from employees e
where e.hire_date >= '2023-01-01'
  and e.hire_date <= '2023-12-31'
order by e.hire_date desc;

select *
from employees e
where year(e.hire_date) = 2023
order by e.hire_date desc;

select *
from employees e
where extract(year from e.hire_date) = 2023
order by e.hire_date desc;

select *
from employees e
where e.hire_date between '2023-01-01' and '2023-12-31'
order by e.hire_date desc;

select true and false;
select true and true; -- 1
select true and null; -- <null>

select false and false;
select false and true;
select false and null; -- 0

select null and null; -- <null>

select *
from employees e
where e.job_id = 9
  and e.salary >= 5000
order by e.salary desc;

select *
from employees e
where year(e.hire_date) between 2021 and 2022
order by e.hire_date;

-- 短路求值
select 1 = 0 and 1 = 1 as 'result';
select 1 = 1 and 1 = 0 as result;
select 1 = 0 and 1 / 0;
select 1 = 1 and 1 / 0 = 1;
select 1 / 0; -- <null>

select true or true;
select true or false;
select false or false;
select false or true;
select true or null; -- 1
select false or null; -- <null>
select null or null; -- <null>

select *
from employees e
where extract(year from e.hire_date) in (2024, 2025)
order by e.hire_date desc;

select *
from employees e
where extract(year from e.hire_date) = 2024
   or extract(year from e.hire_date) = 2025
order by e.hire_date desc;

-- 数据库 and 优先级高于 or
select *
from employees e
where (year(e.hire_date) = 2024 or year(e.hire_date) = 2025)
  and e.job_id = 16
order by e.hire_date desc;

-- or 可以用in来替代
select *
from employees e
where extract(year from e.hire_date) = 2025
   or extract(year from e.hire_date) = 2024
   or extract(year from e.hire_date) = 2023
order by e.hire_date desc;

select *
from employees e
where extract(year from e.hire_date) in (2023, 2024, 2025)
order by e.hire_date;

select e.salary
from employees e
group by e.salary
order by e.salary desc;

select *
from employees e
where e.salary /* not */ between 13000 and 17000
order by e.salary desc;

select *
from employees e
where e.salary >= 13000
  and e.salary <= 17000
order by e.salary desc;

select *
from employees e
where e.salary not between 2500 and 2900
order by e.salary;

select *
from employees e
where e.hire_date between '2023-05-01' and '2024-06-01'
order by e.hire_date desc;

select *
from employees e
where e.hire_date >= '2023-05-01'
  and e.hire_date <= '2024-06-01'
order by e.hire_date desc;

select e.first_name, year(e.hire_date)
from employees e
where extract(year from e.hire_date) between 2023 and 2024
order by e.hire_date desc;

select *
from employees e
where e.job_id /* not */ in (8, 9, 10)
order by e.job_id desc;

select *
from employees e
where e.first_name not in ('Lex', 'Daniel', 'Sarah');

select *
from employees e
where e.hire_date not in ('2024-12-07')
  and year(e.hire_date) = 2024
order by e.hire_date desc;

select *
from employees e
where month(e.hire_date) <= 6
  and day(e.hire_date) > 15
  and extract(year from e.hire_date) = 2024
order by e.hire_date desc;

select e.first_name as '姓名', concat(month(e.hire_date), '月') as '月份'
from employees e
where extract(month from e.hire_date) in (1, 2, 3)
order by month(e.hire_date) desc;

select 'abc' like 'ab%';
select 'abc' like '_b_';
select 'abc' not like '_b__';
select e.first_name
from employees e
where e.first_name like '%an_'
order by e.first_name;

select *
from employees e
where e.first_name not like 'Jo%' -- 对结果取反, 而不是对like后面的正则表达式取反!!!
order by e.first_name;

select '10%' like '%10!%%' escape '!';

select *
from employees e
where e.first_name like 'Da%'
order by e.first_name;

select *
from employees e
where e.first_name like '%er'
order by e.first_name;

select *
from employees e
where e.first_name like '%an%'
order by e.first_name;

select *
from employees e
where e.first_name like 'Jo__'
order by e.first_name;

select *
from employees e
where e.first_name like '%are_'
order by e.first_name;

select *
from employees e
where e.first_name like 'S%'
  and e.first_name not like 'Sh%'
order by e.first_name;

select not null; -- <null>
select null;-- <null>
select 5 = null;-- <null>
select null = null;-- <null>
select null != null;-- <null>
select null is null; -- 1
select not null is not null; -- 1
select null is not null; -- 0
select not null is null; -- 0

select e.first_name, e.phone_number;
select count(e.employee_id)
from employees e
where e.phone_number is null;

select e.first_name, e.phone_number
from employees e
where e.phone_number is not null;

select not 1;
select not 0;
select not true;
select not false;
select not null;

select e.first_name, e.salary
from employees e
where not e.salary >= 3000;

select e.first_name, e.department_id
from employees e
where e.department_id not in (10, 20)
order by e.department_id;

select e.first_name, e.department_id
from employees e
where not (e.department_id = 10 or e.department_id = 20)
order by e.department_id;

-- INNER JOIN
drop table if exists tb_x;
drop table if exists tb_y;
create table if not exists tb_x
(
    id bigint primary key auto_increment,
    x  varchar(10)
);
create table if not exists tb_y
(
    id bigint primary key auto_increment,
    y  varchar(10)
);
insert into tb_x(x)
values ('x1'),
       ('x2'),
       ('x3');
insert into tb_y(y)
values ('y1'),
       ('y2'),
       ('y3');
select *
from tb_x;
select *
from tb_y;

select *
from tb_x x
         inner join tb_y y on x.id = y.id;

select e.employee_id, e.first_name, d.department_name, d.department_id
from employees e
         inner join departments d on e.department_id = d.department_id;

select concat(e.first_name, ' ', e.last_name) as 'Name', e.email, d.department_name
from employees e
         inner join departments d
                    on e.department_id = d.department_id
order by first_name, last_name;

select concat(e.first_name, ' ', e.last_name) as 'Name',
       d.department_name                      as deptName,
       j.job_title                            as title
from employees e
         inner join departments d on e.department_id = d.department_id
         inner join jobs j on e.job_id = j.job_id
order by e.first_name, e.last_name, d.department_name, j.job_title;

select *
from tb_x x
         left join tb_y y on x.id = y.id;

select e.employee_id,
       concat(e.first_name, ' ', e.last_name) as Name,
       d.*
from employees e
         left join departments d on e.department_id = d.department_id;

update employees e
set e.department_id = null
where e.employee_id = 206;

select e.employee_id, e.first_name, d.department_id, d.department_name
from employees e
         left join departments d on e.department_id = d.department_id
where e.department_id is null;

select *
from countries c
         left join locations l on c.country_id = l.country_id;

select c.country_name, l.city, l.street_address
from countries c
         left join locations l on c.country_id = l.country_id
where c.country_name in ('China', 'United Kingdom', 'United States of America')
order by l.city;

-- 查找没有位置的国家
select c.country_name as '国家', l.city as 'city', l.street_address as 'addr'
from countries c
         left join locations l on c.country_id = l.country_id
where l.location_id is null;

select r.region_name    as '洲',
       c.country_name   as '国家',
       l.city           as '城市',
       l.street_address as '街道'
from regions r
         left join countries c on r.region_id = c.region_id
         left join locations l on l.country_id = c.country_id;

select *
from tb_x x
         right join tb_y y on x.id = y.id;

select d.department_name as deptName, e.employee_id as empId, e.first_name
from departments d
         right join employees e on d.department_id = e.department_id;

select e.first_name, d.department_name as deptName
from departments d
         right join employees e on d.department_id = e.department_id
where e.department_id is null;

select c.country_name as country, l.city as city
from countries c
         right join locations l on c.country_id = l.country_id;

select l.city, c.country_name
from locations l
         right join countries c on l.country_id = c.country_id;

select l.city, c.country_name, r.region_name
from locations l
         right join countries c on l.country_id = c.country_id
         right join regions r on c.region_id = r.region_id;

select *
from tb_x x
         left join tb_y y on x.id = y.id
union
select *
from tb_x x
         right join tb_y y on x.id = y.id;

select e.*, d.*
from employees e
         left join departments d on e.department_id = d.department_id
union
select e.*, d.*
from employees e
         right join departments d on e.department_id = d.department_id;

select *
from locations;
insert into departments(department_id, department_name, location_id)
values (99, 'testDept', 2400);

select e.employee_id, e.first_name, d.department_name
from employees e
         left join departments d on e.department_id = d.department_id
union
select e.employee_id, e.first_name, d.department_name
from employees e
         right join departments d on e.department_id = d.department_id;

select *
from tb_x,
     tb_y
order by tb_x.id;
select *
from tb_x
         cross join tb_y
order by tb_x.id;

select e1.first_name '员工', e2.first_name '领导'
from employees e1
         join employees e2 on e1.manager_id = e2.employee_id
where e2.first_name = 'Steven'
;

select e1.first_name '员工',
       case
           when e2.manager_id is null then 'CEO'
           else e2.first_name
           end as    '领导'
from employees e1
         left join employees e2 on e1.manager_id = e2.employee_id;

select *
from employees e
where e.manager_id is null;

select e.department_id
from employees e
group by e.department_id;

select distinct e.department_id
from employees e;

select e.department_id, count(e.department_id) as deptCount
from employees e
group by e.department_id
order by deptCount desc;

select d.department_name, count(e.department_id) as deptCount
from employees e
         inner join departments d on e.department_id = d.department_id
group by e.department_id
order by deptCount desc;

select d.department_name, count(e.department_id) as deptCount
from employees e
         inner join departments d on e.department_id = d.department_id
group by e.department_id
having deptCount >= 5
order by deptCount desc;

select d.department_name       as 'deptName',
       min(e.salary)           as 'minSalary',
       max(e.salary)           as 'maxSalary',
       round(avg(e.salary), 2) as 'avgSalary',
       sum(e.salary)           as 'sumSalary'
from employees e
         inner join departments d on e.department_id = d.department_id
group by e.department_id
order by e.department_id;

select d.department_name as deptName, s.job_title as title, count(e.job_id) as '人数'
from employees e
         inner join departments d on e.department_id = d.department_id
         inner join jobs s on e.job_id = s.job_id
group by d.department_name, s.job_title
having 人数 >= 2
order by d.department_name, s.job_title
limit 0,100;

select concat(m.first_name, ' ', m.last_name) as Manager,
       count(e.employee_id)                   as '下属数量'
from employees e
         inner join employees m on e.manager_id = m.employee_id
where e.manager_id is not null
group by m.employee_id
having 下属数量 >= 3
order by Manager
limit 0,100;


select d.department_name as '部门', sum(e.salary) as '支出'
from employees e
         inner join departments d on e.department_id = d.department_id
group by e.department_id
having 支出 between 20000 and 30000
order by e.department_id desc;

select e.department_id, d.department_name, min(e.salary)
from employees e
         inner join departments d on e.department_id = d.department_id
group by e.department_id
having min(e.salary) > 10000
order by min(e.salary)
limit 0,100;

select e.department_id, d.department_name, round(avg(e.salary), 2)
from employees e
         inner join departments d on e.department_id = d.department_id
group by e.department_id
having avg(e.salary) between 5000 and 7000
order by avg(e.salary) desc
limit 0,100;

select e.department_id, d.department_name, round(avg(e.salary), 2) as avgSalary
from employees e
         inner join departments d on e.department_id = d.department_id
group by e.department_id
having avgSalary between 5000 and 7000
order by avgSalary desc
limit 0,100;

DROP TABLE IF EXISTS salary_reports;

CREATE TABLE salary_reports
(
    state  varchar(255) NOT NULL,
    job    varchar(255) NOT NULL,
    salary DEC(11, 2)
);

INSERT INTO salary_reports (state, job, salary)
VALUES ('California', 'IT', 150000),
       ('California', 'Marketing', 130000),
       ('California', 'Shopping', 140000),
       ('Texas', 'IT', 100000),
       ('Texas', 'Marketing', 80000),
       ('Texas', 'HR', 60000);

SELECT *
FROM salary_reports;

select sr.state, sr.job, sum(sr.salary) as total
from salary_reports sr
group by sr.state, sr.job;

select sr.state, sum(sr.salary) as total
from salary_reports sr
group by sr.state;

select sr.job, sum(sr.salary) as total
from salary_reports sr
group by sr.job;

-- grouping sets , MySQL不支持
select sr.state, sr.job, sum(sr.salary) as total
from salary_reports sr
group by grouping sets (
                 (sr.state, sr.job),
                 (sr.state),
                 (sr.job),
                 (())
         );

select *
from employees e
group by rollup(); -- MySQL不支持
select *
from employees e
group by cube(); -- MySQL不支持

select x.id, x.x
from tb_x x
union
select y.id, y.y
from tb_y y;

select concat(e.first_name, ' ', e.last_name) as Name, '员工' as Type
from employees e
union
select concat(d.first_name, ' ', d.last_name) as Name, '家属' as Type
from dependents d
order by Name desc;

drop table if exists tb_a;
drop table if exists tb_b;
create table if not exists tb_a
(
    id bigint
);
create table if not exists tb_b
(
    id bigint
);
insert into tb_a
values (1),
       (2),
       (3);
insert into tb_b
values (4),
       (2),
       (3);

select *
from tb_a
union all
select *
from tb_b;
select a.id
from tb_a a
intersect
select b.id
from tb_b b;

CREATE TABLE candidates
(
    candidate_id INT PRIMARY KEY,
    first_name   VARCHAR(255) NOT NULL,
    last_name    VARCHAR(255) NOT NULL
);

INSERT INTO candidates (candidate_id, first_name, last_name)
VALUES (1, 'Neena', 'Kochhar'),
       (2, 'Alexander', 'Hunold'),
       (3, 'Peter', 'Thiel');

select e.first_name, e.last_name
from employees e
intersect
select c.first_name, c.last_name
from candidates c;

select a.id
from tb_a a
except
-- 等同于minus, 但MySQL不支持minus关键字
select b.id
from tb_b b;


select concat(e.first_name, ' ', e.last_name) as 员工
from employees e
except
select concat(e.first_name, ' ', e.last_name) as 员工
from employees e
         inner join dependents ds on e.employee_id = ds.employee_id;

select concat(e.first_name, ' ', e.last_name) as '没有家属的员工'
from employees e
where e.employee_id in (select e.employee_id
                        from employees e
                        except
                        select ds.employee_id
                        from dependents ds);
select e.employee_id
from employees e;
insert into dependents
values (null, '三', '张', 'friend', 101),
       (null, '四', '李', 'friend', 102),
       (null, '五', '王', 'friend', 103);

select *
from dependents;

insert into dependents(first_name, last_name, relationship, employee_id)
    value ('六', '赵', 'friend', 104);

select concat(e.first_name, ' ', e.last_name) as Name,
       concat(ds.first_name, ds.last_name)    as Friend
from employees e
         inner join dependents ds on e.employee_id = ds.employee_id;

INSERT INTO dependents (first_name, last_name, relationship, employee_id)
VALUES ('Cameron', 'Bell', 'Child', 192),
       ('Michelle', 'Bell', 'Child', 192);

update employees e
set e.last_name = 'Lopez'
where e.employee_id = 192;

select *
from employees e
where e.employee_id = 192;

update employees e
set e.last_name = 'Lopez'
where e.first_name = 'Sarah';

select e.employee_id, e.first_name, ds.last_name
from employees e
         left join dependents ds on e.employee_id = ds.employee_id
where e.first_name = 'Nancy';

select *
from dependents ds
where ds.employee_id = 192;

update dependents ds
set ds.last_name = 'Lopez'
where ds.employee_id = 192;

select e.last_name as '员工姓氏', ds.last_name as '孩子姓氏', ds.relationship
from employees e
         inner join dependents ds on e.employee_id = ds.employee_id
where ds.relationship = 'Child'
  and e.last_name != ds.last_name
order by e.last_name;

update dependents ds
set ds.last_name = (select e.last_name
                    from employees e
                    where e.employee_id = ds.employee_id)
where 1;

describe test_db.tb_test1;
describe test_db.tb_test2;
drop table if exists test_db.tb_test1;
drop table if exists test_db.tb_test2;

delete
from tb_x x
where x.id > 0;
select *
from tb_x;

delete
from tb_y y
where y.id % 2 != 0;
select *
from tb_y;

