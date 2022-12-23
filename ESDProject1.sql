create table alumni (alumni_id integer not null auto_increment, contact_number varchar(255) not null, email varchar(255) not null, password varchar(255) not null, student_id integer, primary key (alumni_id));

create table alumni_education (id integer not null auto_increment, address varchar(255) not null, college_name varchar(255), degree varchar(255) not null, joining_year integer not null, passing_year integer not null, alumni_id integer, primary key (id));

create table alumni_organisation (id integer not null auto_increment, joining_date datetime(6) not null, leaving_date datetime(6) not null, position varchar(255) not null, alumni_id integer, org_id integer, primary key (id));

create table organisation (org_id integer not null auto_increment, address varchar(255), name varchar(255) not null, primary key (org_id));

create table students (student_id integer not null auto_increment, cgpa float default 0.0 not null, email varchar(255) not null, first_name varchar(255) not null, graduation_year float(23) not null, last_name varchar(255), photograph_path varchar(255), roll_number integer not null, total_credits float(23) not null, primary key (student_id));

alter table alumni add constraint unique (contact_number);

alter table alumni add constraint unique (email);

alter table students add constraint unique (email);

alter table students add constraint unique (roll_number);

alter table alumni add constraint foreign key (student_id) references students (student_id);

alter table alumni add constraint unique (student_id);

alter table alumni_education add constraint foreign key (alumni_id) references alumni (alumni_id);

alter table alumni_organisation add constraint foreign key (alumni_id) references alumni (alumni_id);

alter table alumni_organisation add constraint foreign key (org_id) references organisation (org_id);

insert into students(student_id,roll_number,first_name,last_name,email,photograph_path,cgpa,total_credits,graduation_year) VALUES
(511, 20221511,'Nishit', 'Chechani', 'nishit@iiitb.ac.in','./',4.00,16,2024),
(53, 2022053,'Lax','Shree','Lax@iiitb.ac.in', './',3.70,16,2024),
(52, 2022052,'Jay','Parekh','jay@iiitb.ac.in', './',3.60,16,2024),
(54, 2022054,'Jayant','Mukundam','jayant@iiitb.ac.in', './',3.60,16,2024),
(1, 2022001,'Gaurang','Agarwal','gaurang@iiitb.ac.in', './',4.00,16,2024),
(125, 2022125,'Tushar','Nagpal','tushar@iiitb.ac.in', './',3.60,125,2024);

insert into organisation(address, name) VALUES
('Bangalore','Adobe'),
('Noida','Qualcomm'),
('Bangalore','MathWorks'),
('Bangalore','ThoughtSpot'),
('Bangalore','Siemens India'),
('Bangalore','Uber'),
('Bangalore','Google'),
('Bangalore','Cisco');


insert into alumni(alumni_id, contact_number, email, password, student_id) VALUES
(19, "9", "KjkkA", "hggj", 1);
