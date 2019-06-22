delete from user_roles;


--adrese
insert into address (address_id,street,number,city,country) values (1,'Ulica Nikole Tesle',2,'Novi Sad','Srbija');
insert into address (address_id,street,number,city,country) values (2,'1. Maja',2,'Novi Sad','Srbija');
insert into address (address_id,street,number,city,country) values (3,'Bulevar Oslobodjenja',22,'Novi Sad','Srbija');
insert into address (address_id,street,number,city,country) values (4,'Bulevar Evrope',23,'Novi Sad','Srbija');
--za smjestaj
insert into address (address_id,street,number,city,country) values (5,'Bulevar Cara Lazara',79,'Novi Sad','Srbija');
insert into address (address_id,street,number,city,country) values (6,'Bulevar Jase Tomica',23,'Novi Sad','Srbija');


--admin 
insert into user (user_id, first_name, last_name, email,password,certificated,active,blocked) values (1, 'admin', 'admin', 'admin@gmail.com', '$2a$10$B5q5PKtYYwtHSLd7lekgGu4ve5Iaa1IoAsZZZJkX74ervZjCAKdUe',1,1,0);

--agenti ima pib
insert into user (user_id, first_name, last_name, email,password,certificated,pib,active,blocked) values (2, 'agent', 'agent', 'agent@gmail.com', '$2a$12$l5RRveYgubpdAK5h42f2xu8qpVf6619DtbY90JneL/NXVsBeIzL1e',1,'123456',1,0);
insert into user (user_id, first_name, last_name, email,password,certificated,pib,active,blocked) values (3, 'agent2', 'agent2', 'agent2@gmail.com', '$2a$12$l5RRveYgubpdAK5h42f2xu8qpVf6619DtbY90JneL/NXVsBeIzL1e',1,'1234567',1,0);
insert into user (user_id, first_name, last_name, email,password,certificated,pib,active,blocked) values (4, 'agent3', 'agent3', 'agent3@gmail.com', '$2a$12$l5RRveYgubpdAK5h42f2xu8qpVf6619DtbY90JneL/NXVsBeIzL1e',1,'1234568',1,0);


--client ima adresu 
insert into user (user_id, first_name, last_name, email,password,certificated,user_address,active,blocked) values (5, 'client', 'client', 'client@gmail.com', '$2a$12$6ftbtcYQQuf1bRpuxOB2oehiLSjYVMJYiC1soNh726NKYMZwTYQ1m',1,1,1,0);
insert into user (user_id, first_name, last_name, email,password,certificated,user_address,active,blocked) values (6, 'tanja', 'tanja', 't@gmail.com', '$2a$10$B5q5PKtYYwtHSLd7lekgGu4ve5Iaa1IoAsZZZJkX74ervZjCAKdUe',1,2,1,0);

--uloga
insert into role (id, name) values (1, 'ROLE_ADMIN');
insert into role (id, name) values (2, 'ROLE_AGENT');
insert into role (id, name) values (3, 'ROLE_USER');

--povezivanje usera i uloga
--admin
insert into user_roles (user_id,role_id) values (1,1);
--agenti
insert into user_roles (user_id,role_id) values (2,2);
insert into user_roles (user_id,role_id) values (3,2);
insert into user_roles (user_id,role_id) values (4,2);
--client
insert into user_roles (user_id,role_id) values (5,3);
insert into user_roles (user_id,role_id) values (6,3);

--privilegije
insert into privilege (id,name) values (1,'registrationAgent');
insert into privilege (id,name) values (2,'login');
insert into privilege (id,name) values (3,'loginAdmin');
insert into privilege (id,name) values (4,'loginUser');


insert into roles_privileges(role_id,privilege_id) values (1,1);
insert into roles_privileges(role_id,privilege_id) values (1,2);
insert into roles_privileges(role_id,privilege_id) values (1,3);
insert into roles_privileges(role_id,privilege_id) values (3,4);



--lokacija za smjestaj
insert into location (location_id,geo_length,geo_width) values (1,44.8,20.35);
insert into location (location_id,geo_length,geo_width) values (2,45.8,23.35);

--dodavanje smjestaja
--dodjeljen prvom agentu
insert into accommodation (accommodation_id,name, cancelation_days,rating,category,description,acc_location,acc_address,acc_agent)
 values (1,"Hotel Aleksandar", 2, 4.1, "4", "Sve full", 1,5,2);
 --dodjeljen drugom agentu
insert into accommodation (accommodation_id,name, cancelation_days,rating,category,description,acc_location,acc_address,acc_agent)
 values (2,"Hotel Novi Sad", 3, 3.9, "4", "Sve ok", 2,6,3);
 
 --dodatni servisi
insert into additional_services (additional_id,name,price_of_add) values (1,'All inclusive',100.1);
insert into additional_services (additional_id,name,price_of_add) values (2,'Full Board',50.1);
insert into additional_services (additional_id,name,price_of_add) values (3,'Half Board',25.1);
insert into additional_services (additional_id,name,price_of_add) values (4,'WiFi',0.0);
insert into additional_services (additional_id,name,price_of_add) values (5,'Pet friendly',20.1);

--povezivanje smjestaja i additional servica
--insert into accommodation_additional_services (accommodation_id,additional_id) values (1,1);
--insert into accommodation_additional_services (accommodation_id,additional_id) values (1,2);
--insert into accommodation_additional_services (accommodation_id,additional_id) values (2,3);
--insert into accommodation_additional_services (accommodation_id,additional_id) values (2,4);
--insert into accommodation_additional_services (accommodation_id,additional_id) values (2,5);

insert into accommodation_unit (accommodation_unit_id,capacity,number_of_room,floor,size,type, acc,agent_units)
	values (1,3,22,2,40,"room",1,2);
insert into accommodation_unit (accommodation_unit_id,capacity,number_of_room,floor,size,type, acc,agent_units)
	values (2,2,33,3,35,"apartman",1,2);
insert into accommodation_unit (accommodation_unit_id,capacity,number_of_room,floor,size,type, acc,agent_units)
	values (3,5,123,12,50,"bed&breakfast",2,2);
--dodati slike za hotele..
--insert into image (image_id,title,uri,accommodation_pic) values (1,'Aleksandar1','../assets/images/aleksandar.jpg',1);
--insert into image (image_id,title,uri,accommodation_pic) values (2,'Aleksandar2','../assets/images/aleksandar2.jpg',1);
--insert into image (image_id,title,uri,accommodation_pic) values (3,'NoviSad1','../assets/images/novisad.jpg',2);
--insert into image (image_id,title,uri,accommodation_pic) values (4,'NoviSad2','../assets/images/novisad2.jpg',2);