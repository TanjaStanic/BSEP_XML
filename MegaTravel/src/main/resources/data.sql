delete from user_roles;


--adrese
insert into address (address_id,street,number,city,country) values (1,'Ulica Nikole Tesle',2,'Novi Sad','Srbija');
insert into address (address_id,street,number,city,country) values (2,'1. Maja',2,'Novi Sad','Srbija');
insert into address (address_id,street,number,city,country) values (3,'Bulevar Oslobodjenja',22,'Novi Sad','Srbija');
insert into address (address_id,street,number,city,country) values (4,'Bulevar Evrope',23,'Novi Sad','Srbija');
--za smjestaj
insert into address (address_id,street,number,city,country) values (5,'Bulevar Cara Lazara',79,'Novi Sad','Srbija');
insert into address (address_id,street,number,city,country) values (6,'Bulevar Jase Tomica',23,'Novi Sad','Srbija');
insert into address (address_id,street,number,city,country) values (7,'Bulevar Kralja Aleksandra',69,'Beograd','Srbija');
insert into address (address_id,street,number,city,country) values (8,'Milentija Popovica',5,'Novi Beograd','Srbija');
insert into address (address_id,street,number,city,country) values (9,'Vladimira Popovica',10,'Novi Beograd','Srbija');
insert into address (address_id,street,number,city,country) values (10,'Takovska',49,'Beograd','Srbija');
insert into address (address_id,street,number,city,country) values (11,'Internacionalnih Brigada',9,'Beograd','Srbija');
insert into address (address_id,street,number,city,country) values (12,'Kneza Mihaila',54,'Beograd','Srbija');
insert into address (address_id,street,number,city,country) values (13,'Obilicev Venac',28,'Beograd','Srbija');
insert into address (address_id,street,number,city,country) values (14,'Futoska',109,'Novi Sad','Srbija');
insert into address (address_id,street,number,city,country) values (15,'Polgar Andrasa',1,'Novi Sad','Srbija');
insert into address (address_id,street,number,city,country) values (16,'Petrovaradinska tvrdjava bb',1,'Novi Sad','Srbija');


--admin 
insert into user (user_id, first_name, last_name, email,password,certificated,active,blocked) values (1, 'admin', 'admin', 'admin@gmail.com', '$2a$10$B5q5PKtYYwtHSLd7lekgGu4ve5Iaa1IoAsZZZJkX74ervZjCAKdUe',1,1,0);

--agenti ima pib
insert into user (user_id, first_name, last_name, email,password,certificated,pib,active,blocked) values (2, 'agent', 'agent', 'agent@gmail.com', '$2a$12$l5RRveYgubpdAK5h42f2xu8qpVf6619DtbY90JneL/NXVsBeIzL1e',1,'123456',1,0);
insert into user (user_id, first_name, last_name, email,password,certificated,pib,active,blocked) values (3, 'agent2', 'agent2', 'agent2@gmail.com', '$2a$12$l5RRveYgubpdAK5h42f2xu8qpVf6619DtbY90JneL/NXVsBeIzL1e',1,'1234567',1,0);
insert into user (user_id, first_name, last_name, email,password,certificated,pib,active,blocked) values (4, 'agent3', 'agent3', 'agent3@gmail.com', '$2a$12$l5RRveYgubpdAK5h42f2xu8qpVf6619DtbY90JneL/NXVsBeIzL1e',1,'1234568',1,0);


--client ima adresu 
insert into user (user_id, first_name, last_name, email,password,certificated,user_address,active,blocked) values (5, 'client', 'client', 'client@gmail.com', '$2a$12$6ftbtcYQQuf1bRpuxOB2oehiLSjYVMJYiC1soNh726NKYMZwTYQ1m',1,1,1,0);
insert into user (user_id, first_name, last_name, email,password,certificated,user_address,active,blocked) values (6, 'tanja', 'tanja', 't@gmail.com', '$2a$10$B5q5PKtYYwtHSLd7lekgGu4ve5Iaa1IoAsZZZJkX74ervZjCAKdUe',1,2,1,0);


insert into user (user_id, first_name, last_name, email,password,certificated,user_address,active,blocked) values (7, 'client1', 'client1', 'client1@gmail.com', '$2a$12$6ftbtcYQQuf1bRpuxOB2oehiLSjYVMJYiC1soNh726NKYMZwTYQ1m',0,1,1,0);
insert into user (user_id, first_name, last_name, email,password,certificated,user_address,active,blocked) values (8, 'tanja1', 'tanj1a', 't1@gmail.com', '$2a$10$B5q5PKtYYwtHSLd7lekgGu4ve5Iaa1IoAsZZZJkX74ervZjCAKdUe',0,2,1,0);

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
insert into privilege (id,name) values (5,'loginAgent');
insert into privilege (id,name) values (6,'myProfile');

insert into roles_privileges(role_id,privilege_id) values (2,5);

insert into roles_privileges(role_id,privilege_id) values (1,1);
insert into roles_privileges(role_id,privilege_id) values (1,2);
insert into roles_privileges(role_id,privilege_id) values (1,3);
insert into roles_privileges(role_id,privilege_id) values (3,4);
insert into roles_privileges(role_id,privilege_id) values (3,6);



--lokacija za smjestaj
insert into location (location_id,geo_length,geo_width) values (1,44.8,20.35);
insert into location (location_id,geo_length,geo_width) values (2,45.8,23.35);
insert into location (location_id,geo_length,geo_width) values (3,45.8,23.35);
insert into location (location_id,geo_length,geo_width) values (4,45.8,23.35);
insert into location (location_id,geo_length,geo_width) values (5,35.8,23.35);
insert into location (location_id,geo_length,geo_width) values (6,45.8,23.35);
insert into location (location_id,geo_length,geo_width) values (7,45.8,23.35);
insert into location (location_id,geo_length,geo_width) values (8,45.8,23.35);
insert into location (location_id,geo_length,geo_width) values (9,45.8,23.35);
insert into location (location_id,geo_length,geo_width) values (10,45.8,23.35);
insert into location (location_id,geo_length,geo_width) values (11,45.8,23.35);
insert into location (location_id,geo_length,geo_width) values (12,45.8,23.35);

--dodavanje smjestaja
--dodjeljen prvom agentu
insert into accommodation (accommodation_id,name, cancelation_days,rating,category,description,acc_location,acc_address,acc_agent)
 values (1,"Hotel Aleksandar", 2, 4.1, "4", "Sve full", 1,5,2);
 --dodjeljen drugom agentu
insert into accommodation (accommodation_id,name, cancelation_days,rating,category,description,acc_location,acc_address,acc_agent)
 values (2,"Hotel Novi Sad", 3, 3.9, "4", "Sve ok", 2,6,3);


 
 --dodatni servisi
insert into additional_services (additional_id,name,price_of_add,accommodation) values (1,'All inclusive',100.1,1);
insert into additional_services (additional_id,name,price_of_add,accommodation) values (2,'Full Board',50.1,1);
insert into additional_services (additional_id,name,price_of_add,accommodation) values (3,'Half Board',25.1,1);
insert into additional_services (additional_id,name,price_of_add,accommodation) values (4,'WiFi',0.0,1);
insert into additional_services (additional_id,name,price_of_add,accommodation) values (5,'Pet friendly',20.1,1);


insert into certificate (id, idissuer, idsubject, valid_from, valid_to,revoked,ca,reasonforrevokation,serial_number) 
				values (1,1,1,'2019-06-26','2020-06-26',0,1,'',1561574973635);
insert into certificate (id, idissuer, idsubject, valid_from, valid_to,revoked,ca,reasonforrevokation,serial_number) 
				values (2,1,2,'2019-06-26','2020-06-26',0,1,'',	1561575194191);
insert into certificate (id, idissuer, idsubject, valid_from, valid_to,revoked,ca,reasonforrevokation,serial_number) 
				values (3,1,3,'2019-06-26','2020-06-26',0,1,'',	1561575340619);
insert into certificate (id, idissuer, idsubject, valid_from, valid_to,revoked,ca,reasonforrevokation,serial_number) 
				values (4,1,4,'2019-06-26','2020-06-26',0,1,'',	1561575397061);
insert into certificate (id, idissuer, idsubject, valid_from, valid_to,revoked,ca,reasonforrevokation,serial_number) 
				values (5,2,5,'2019-06-26','2020-06-26',0,1,'',	1561575457468);
insert into certificate (id, idissuer, idsubject, valid_from, valid_to,revoked,ca,reasonforrevokation,serial_number) 
				values (6,2,null,'2019-06-26','2020-06-26',0,1,'',	1561575457469);				

		
--insert into accommodation_additional_services (accommodation_id,additional_id) values (1,1);
--insert into accommodation_additional_services (accommodation_id,additional_id) values (1,2);
--insert into accommodation_additional_services (accommodation_id,additional_id) values (2,5);

insert into accommodation_unit (accommodation_unit_id,capacity,number_of_room,floor,size,type, acc,agent_units)
	values (1,3,22,2,40,"room",1,2);
insert into accommodation_unit (accommodation_unit_id,capacity,number_of_room,floor,size,type, acc,agent_units)
	values (2,2,33,3,35,"apartman",1,2);
insert into accommodation_unit (accommodation_unit_id,capacity,number_of_room,floor,size,type, acc,agent_units)
	values (3,5,123,12,50,"bed&breakfast",2,2);

