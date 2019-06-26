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

insert into accommodation (accommodation_id,name, cancelation_days,rating,category,description,acc_location,acc_address,acc_agent)
 values (3,"Metropol palace", 3, 4.6, "5", "Hotel Metropol Palace, A Luxury Collection Hotel features 2 restaurants and elegantly decorated accommodation with free WiFi, and is just 400 metres from the heart of Belgrade.", 3,7,3);

insert into accommodation (accommodation_id,name, cancelation_days,rating,category,description,acc_location,acc_address,acc_agent)
 values (4,"Hyatt Regency Hotel", 5, 4.8, "5", "The elegant rooms are decorated in soft pastel shades and overlook the centre of Belgrade or the park.", 4,8,3);

insert into accommodation (accommodation_id,name, cancelation_days,rating,category,description,acc_location,acc_address,acc_agent)
 values (5,"Crowne Plaza", 7, 4.3, "5", "The luxurious Crowne Plaza Belgrade is ideally located in the central business district of New Belgrade. The city centre can be reached in a 5-minute drive, while 2 shopping centres are just a few steps away. ", 5,9,3);

insert into accommodation (accommodation_id,name, cancelation_days,rating,category,description,acc_location,acc_address,acc_agent)
 values (6,"88 Rooms", 4, 3.7, "4", "Featuring a rooftop restaurant, 88 Rooms Hotel is located 1.2 km from the centre of Belgrade. Built in 2014, it offers elegant rooms with free high speed WiFi access, as well as a 24/7 fitness room.", 6,10,3);

insert into accommodation (accommodation_id,name, cancelation_days,rating,category,description,acc_location,acc_address,acc_agent)
 values (7,"Garny Hotel Crystal", 15, 3.9, "4", "Hotel Crystal is situated in an exclusive residential area in central Belgrade close to the St. Sava Temple. It offers luxuriously equipped hotel with free broadband and free Wi-Fi. A beauty salon is right next to the hotel.", 7,11,3);

insert into accommodation (accommodation_id,name, cancelation_days,rating,category,description,acc_location,acc_address,acc_agent)
 values (8,"Mama Shelter", 11, 3.5, "4", "All units are fitted with a desk, a flat-screen cable TV and a minibar. Every room has air-conditioning while some come with a furnished terrace as well. The private bathroom is equipped with a walk in shower and a hairdryer.", 8,12,3);

insert into accommodation (accommodation_id,name, cancelation_days,rating,category,description,acc_location,acc_address,acc_agent)
 values (9,"Hotel Majestic", 6, 3.8, "4", "Located in the very heart of Belgrade, Hotel Majestic is a traditional-style hotel offering elegant rooms with modern amenities, free WiFi, a restaurant and an on-site garage parking. The famous shopping Knez Mihailova Street is just 200 m away.", 9,13,3);

insert into accommodation (accommodation_id,name, cancelation_days,rating,category,description,acc_location,acc_address,acc_agent)
 values (10,"Prezident Hotel", 14, 4.3, "5", "Ideally located close to the centre of Novi Sad, the luxurious Prezident Hotel is a 5-minute walk to Novi Sad's Fair, offering a secure parking lot and a transfer service.",10,14,3);
 
insert into accommodation (accommodation_id,name, cancelation_days,rating,category,description,acc_location,acc_address,acc_agent)
 values (11,"Sheraton Hotel", 10, 4.3, "5", "Located in Novi Sad, 2.7 km from Promenada Shopping Mall, Sheraton Novi Sad provides accommodation with a fitness centre, private parking, a bar and a shared lounge.",11,15,3);

insert into accommodation (accommodation_id,name, cancelation_days,rating,category,description,acc_location,acc_address,acc_agent)
 values (12,"Garni Hotel Leopold 1", 10, 4.3, "5", "Located in Novi Sad, on the right bank of the Danube River and on top of 17th centruy Petrovaradin Fortress.",12,16,3);

 
 --dodatni servisi
insert into additional_services (additional_id,name,price_of_add) values (1,'All inclusive',100.1);
insert into additional_services (additional_id,name,price_of_add) values (2,'Full Board',50.1);
insert into additional_services (additional_id,name,price_of_add) values (3,'Half Board',25.1);
insert into additional_services (additional_id,name,price_of_add) values (4,'WiFi',0.0);
insert into additional_services (additional_id,name,price_of_add) values (5,'Pet friendly',20.1);

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
--dodati slike za hotele..
--insert into image (image_id,title,uri,accommodation_pic) values (1,'Aleksandar1','../assets/images/aleksandar.jpg',1);
--insert into image (image_id,title,uri,accommodation_pic) values (2,'Aleksandar2','../assets/images/aleksandar2.jpg',1);
--insert into image (image_id,title,uri,accommodation_pic) values (3,'NoviSad1','../assets/images/novisad.jpg',2);
--insert into image (image_id,title,uri,accommodation_pic) values (4,'NoviSad2','../assets/images/novisad2.jpg',2);