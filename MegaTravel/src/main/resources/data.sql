insert into user (user_id, first_name, last_name, email,password,certificated) values (3, 'admin', 'admin', 'admin@gmail.com', '$2a$10$B5q5PKtYYwtHSLd7lekgGu4ve5Iaa1IoAsZZZJkX74ervZjCAKdUe',1);
insert into user (user_id, first_name, last_name, email,password,certificated) values (2, 'tanja', 'tanja', 't@gmail.com', '$2a$10$B5q5PKtYYwtHSLd7lekgGu4ve5Iaa1IoAsZZZJkX74ervZjCAKdUe',1);


insert into role (id, name) values (1, 'ROLE_ADMIN');
insert into role (id, name) values (2, 'ROLE_USER');

insert into user_roles (user_id,role_id) values (1,1);
insert into user_roles (user_id,role_id) values (2,2);

insert into location (location_id,geo_length,geo_width) values (1,55.5,56.6);
insert into address (address_id,street,number,city,country) values (1,'ulica',45,'ns','srbija');

