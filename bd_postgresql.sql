create table profile(
	profile_id int not null,
	name varchar(500),
	constraint profile_pk primary key(profile_id)
);

create table gender (
	gender_id int not null,
	name varchar(500) not null,
	constraint gender_pk primary key(gender_id)
);

create table movie (
	movie_id serial not null,
	name varchar(500) not null,
	description TEXT,
	image varchar(500) not null,
	created_at TIMESTAMP not null,
	release_date date,
	actors varchar(500),
	gender_id int not null,
	rating int,
	constraint movie_pk primary key(movie_id),
	constraint movie_category_fk foreign key(gender_id) references gender(gender_id)
);

create table users(
	user_id SERIAL not null,
	name varchar(500) not null,
	email varchar(100) not null,
	password varchar(500) not null,
	created_at TIMESTAMP not null,
	profile_id int not null,
	constraint user_pk primary key(user_id),
	constraint user_profile_fk foreign key(profile_id) references profile(profile_id),
	constraint email_uq UNIQUE (email)
);


-- INSERTS
-- Generos
insert into gender(gender_id, name) values (1, 'Acción');
insert into gender(gender_id, name) values (2, 'Aventura');
insert into gender(gender_id, name) values (3, 'Comedia');
insert into gender(gender_id, name) values (4, 'Animación');
insert into gender(gender_id, name) values (5, 'Misterio');
insert into gender(gender_id, name) values (6, 'Terror');

-- Perfiles
insert into profile(profile_id, name) values (1, 'Administrador');
insert into profile(profile_id, name) values (2, 'Cliente');

-- User
insert into `user` (user_id, name, email, created_at, password, profile_id) 
values (1, 'Adrián López', 'adrian.lopez@pascualbravo.edu.co', now(), '123456', 1);

insert into `user` (user_id, name, email, created_at, password, profile_id) 
values (2, 'Elena Guzman', 'elena.guzman@pascualbravo.edu.co', now(), '123456', 2);


