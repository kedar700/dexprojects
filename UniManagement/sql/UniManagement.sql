	


CREATE TABLE IF NOT EXISTS departments
(dept_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
dept_name VARCHAR(50));

CREATE TABLE IF NOT EXISTS semesters
(semester_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
semester_type varchar(50),
semester_year varchar(25),
semester_status tinyint(1));


CREATE TABLE IF NOT EXISTS users
(user_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
cwid varchar(25),
	first_name VARCHAR(30),
	last_name VARCHAR(30),
	email VARCHAR(40) UNIQUE,
	password VARCHAR(30),
	phone VARCHAR(11),
	dept_id INT,
	user_type ENUM('Admin', 'Student','Faculty'),
	DOB DATE,
	FOREIGN KEY(dept_id) REFERENCES departments(dept_id)  ON DELETE CASCADE);


CREATE TABLE IF NOT EXISTS courses
(course_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
course_name VARCHAR(50),
capacity INT,
startdate DATE,
enddate DATE,
faculty_id INT,
dept_id INT,
semester_id INT,
FOREIGN KEY (faculty_id) REFERENCES users(user_id) ON DELETE CASCADE,
FOREIGN KEY (semester_id) REFERENCES semesters(semester_id)  ON DELETE CASCADE,
FOREIGN KEY (dept_id) REFERENCES departments(dept_id)  ON DELETE CASCADE
);



CREATE TABLE IF NOT EXISTS enrollments
(enrollment_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
startdate DATE,
enddate DATE,
course_id INT,
course_name VARCHAR(50),
grade DECIMAL(5,2),
student_id INT,
semester_id INT,
FOREIGN KEY (student_id) REFERENCES users(user_id)  ON DELETE CASCADE,
FOREIGN KEY (course_id) REFERENCES  courses(course_id)  ON DELETE CASCADE,
FOREIGN KEY (semester_id) REFERENCES semesters(semester_id)  ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS addresses
	(address_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	address_line1 VARCHAR(40),
	address_line2 VARCHAR(40),
	city VARCHAR(40),
	state VARCHAR(4),
	zip_code VARCHAR(10),
	phone VARCHAR(15),
	user_id INT,
	FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
	);



insert into departments (dept_name)
values('ITM');
	
insert into users (first_name,email,password,dept_id,user_type)
values('admin','admin@example.com','password',1,'Admin');

insert into users (first_name,email,password,dept_id,user_type)
values('student','student@example.com','password',1,'Student');

insert into users (first_name,email,password,dept_id,user_type)
values('faculty','faculty@example.com','password',1,'Faculty');


insert into semesters (semester_type,semester_year,semester_status) values('Spring','2017',1);
insert into semesters (semester_type,semester_year,semester_status) values('Fall','2017',1);
insert into semesters (semester_type,semester_year,semester_status) values('Spring','2018',1);
insert into semesters (semester_type,semester_year,semester_status) values('Fall','2018',1);
insert into semesters (semester_type,semester_year,semester_status) values('Spring','2019',1);
insert into semesters (semester_type,semester_year,semester_status) values('Fall','2019',1);
insert into semesters (semester_type,semester_year,semester_status) values('Spring','2020',0);
insert into semesters (semester_type,semester_year,semester_status) values('Fall','2020',0);
insert into semesters (semester_type,semester_year,semester_status) values('Spring','2021',0);
insert into semesters (semester_type,semester_year,semester_status) values('Fall','2021',0);
insert into semesters (semester_type,semester_year,semester_status) values('Spring','2022',0);
insert into semesters (semester_type,semester_year,semester_status) values('Fall','2022',0);

