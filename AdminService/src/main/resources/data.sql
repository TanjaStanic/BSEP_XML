--adrese
insert into address (address_id,street,number,city,country) values (1,'Ulica Nikole Tesle',2,'Novi Sad','Srbija');
insert into address (address_id,street,number,city,country) values (2,'1. Maja',2,'Novi Sad','Srbija');
insert into address (address_id,street,number,city,country) values (3,'Bulevar Oslobođenja',22,'Novi Sad','Srbija');
insert into address (address_id,street,number,city,country) values (4,'Bulevar Evrope',23,'Novi Sad','Srbija');
--za smjestaj
insert into address (address_id,street,number,city,country) values (5,'Bulevar Cara Lazara',79,'Novi Sad','Srbija');
insert into address (address_id,street,number,city,country) values (6,'Bulevar Jase Tomica',23,'Novi Sad','Srbija');
insert into address (address_id,street,number,city,country) values (7,'Bulevar Aleksandra',69,'Beograd','Srbija');
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
insert into user (user_id, first_name, last_name, email,password,certificated,active,blocked) values (1, 'admin', 'admin', 'admin@gmail.com', '$2a$10$B5q5PKtYYwtHSLd7lekgGu4ve5Iaa1IoAsZZZJkX74ervZjCAKdUe',1,true,false);

--agenti ima pib
insert into user (user_id, first_name, last_name, email,password,certificated,pib,active,blocked) values (2, 'agent', 'agent', 'agent@gmail.com', '$2a$12$l5RRveYgubpdAK5h42f2xu8qpVf6619DtbY90JneL/NXVsBeIzL1e',1,'123456',true,false);
insert into user (user_id, first_name, last_name, email,password,certificated,pib,active,blocked) values (3, 'agent2', 'agent2', 'agent2@gmail.com', '$2a$12$l5RRveYgubpdAK5h42f2xu8qpVf6619DtbY90JneL/NXVsBeIzL1e',1,'1234567',true,false);
insert into user (user_id, first_name, last_name, email,password,certificated,pib,active,blocked) values (4, 'agent3', 'agent3', 'agent3@gmail.com', '$2a$12$l5RRveYgubpdAK5h42f2xu8qpVf6619DtbY90JneL/NXVsBeIzL1e',1,'1234568',true,false);


--client ima adresu 
insert into user (user_id, first_name, last_name, email,password,certificated,user_address,active,blocked) values (5, 'client', 'client', 'client@gmail.com', '$2a$12$6ftbtcYQQuf1bRpuxOB2oehiLSjYVMJYiC1soNh726NKYMZwTYQ1m',1,1,true,false);
insert into user (user_id, first_name, last_name, email,password,certificated,user_address,active,blocked) values (6, 'tanja', 'tanja', 't@gmail.com', '$2a$10$B5q5PKtYYwtHSLd7lekgGu4ve5Iaa1IoAsZZZJkX74ervZjCAKdUe',1,2,false,false);
insert into user (user_id, first_name, last_name, email,password,certificated,user_address,active,blocked) values (7, 'client1', 'client1', 'client1@gmail.com', '$2a$12$6ftbtcYQQuf1bRpuxOB2oehiLSjYVMJYiC1soNh726NKYMZwTYQ1m',0,1,1,0);
insert into user (user_id, first_name, last_name, email,password,certificated,user_address,active,blocked) values (8, 'tanja1', 'tanj1a', 't1@gmail.com', '$2a$10$B5q5PKtYYwtHSLd7lekgGu4ve5Iaa1IoAsZZZJkX74ervZjCAKdUe',0,2,1,0);
--uloga
insert into role (id, name) values (1, 'ROLE_ADMIN');
insert into role (id, name) values (2, 'ROLE_AGENT');
insert into role (id, name) values (3, 'ROLE_USER');


--privilegije
--privilegije
insert into privilege (id,name) values (1,'registrationAgent');
insert into privilege (id,name) values (2,'login');
insert into privilege (id,name) values (3,'loginAdmin');
insert into privilege (id,name) values (4,'loginUser');
insert into privilege (id,name) values (5,'getAll');
insert into privilege (id,name) values (6,'getAcc');
insert into privilege (id,name) values (7,'activateUser');
insert into privilege (id,name) values (8,'deleteUser');
insert into privilege (id,name) values (9,'getUsersWithCetrtificate');
insert into privilege (id,name) values (10,'getAllAgents');

insert into privilege (id,name) values (11,'getAllAcc');
insert into privilege (id,name) values (12,'getAllAdditional');
insert into privilege (id,name) values (13,'addAccLocation');
insert into privilege (id,name) values (14,'changeAccLocation');
insert into privilege (id,name) values (15,'addAccAddress');
insert into privilege (id,name) values (16,'changeAccAddress');
insert into privilege (id,name) values (17,'addAcc');
insert into privilege (id,name) values (18,'changeAcc');
insert into privilege (id,name) values (19,'getAllPictures');
insert into privilege (id,name) values (20,'getAdditionalServices');
insert into privilege (id,name) values (21,'getAccommodation');
insert into privilege (id,name) values (22,'getAllComments');
insert into privilege (id,name) values (23,'aprove');
insert into privilege (id,name) values (24,'generateCertificate');
insert into privilege (id,name) values (25,'getValidCertificates');
insert into privilege (id,name) values (26,'getUsersWithCetrtificate');
insert into privilege (id,name) values (27,'getCert');
insert into privilege (id,name) values (28,'generateCRSCertificate');
insert into privilege (id,name) values (29,'allUsersWithCertificates');
insert into privilege (id,name) values (30,'allCertificatesIssuer');
insert into privilege (id,name) values (31,'revoke');
insert into privilege (id,name) values (32,'deleteCertificate');
insert into privilege (id,name) values (33,'allocate');
insert into privilege (id,name) values (34,'getCertificate');
insert into privilege (id,name) values (35,'statusCertificate');















insert into roles_privileges(role_id,privilege_id) values (1,1);
insert into roles_privileges(role_id,privilege_id) values (1,2);
insert into roles_privileges(role_id,privilege_id) values (1,3);
insert into roles_privileges(role_id,privilege_id) values (3,4);
insert into roles_privileges(role_id,privilege_id) values (1,5);
insert into roles_privileges(role_id,privilege_id) values (1,6);
insert into roles_privileges(role_id,privilege_id) values (1,7);
insert into roles_privileges(role_id,privilege_id) values (1,8);
insert into roles_privileges(role_id,privilege_id) values (1,9);
insert into roles_privileges(role_id,privilege_id) values (1,10);
insert into roles_privileges(role_id,privilege_id) values (1,11);
insert into roles_privileges(role_id,privilege_id) values (1,12);
insert into roles_privileges(role_id,privilege_id) values (1,13);
insert into roles_privileges(role_id,privilege_id) values (1,14);
insert into roles_privileges(role_id,privilege_id) values (1,15);
insert into roles_privileges(role_id,privilege_id) values (1,16);
insert into roles_privileges(role_id,privilege_id) values (1,17);
insert into roles_privileges(role_id,privilege_id) values (1,18);
insert into roles_privileges(role_id,privilege_id) values (1,19);
insert into roles_privileges(role_id,privilege_id) values (1,20);
insert into roles_privileges(role_id,privilege_id) values (1,21);
insert into roles_privileges(role_id,privilege_id) values (1,22);
insert into roles_privileges(role_id,privilege_id) values (1,23);
insert into roles_privileges(role_id,privilege_id) values (1,24);
insert into roles_privileges(role_id,privilege_id) values (1,25);
insert into roles_privileges(role_id,privilege_id) values (1,26);
insert into roles_privileges(role_id,privilege_id) values (1,27);
insert into roles_privileges(role_id,privilege_id) values (1,28);
insert into roles_privileges(role_id,privilege_id) values (1,29);
insert into roles_privileges(role_id,privilege_id) values (1,30);
insert into roles_privileges(role_id,privilege_id) values (1,31);
insert into roles_privileges(role_id,privilege_id) values (1,32);
insert into roles_privileges(role_id,privilege_id) values (1,33);
insert into roles_privileges(role_id,privilege_id) values (1,34);
insert into roles_privileges(role_id,privilege_id) values (1,35);









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
insert into additional_services (additional_id,name,price_of_add,accommodation) values (1,'All inclusive',100.1,1);
insert into additional_services (additional_id,name,price_of_add,accommodation) values (2,'Full Board',50.1,1);
insert into additional_services (additional_id,name,price_of_add,accommodation) values (3,'Half Board',25.1,1);
insert into additional_services (additional_id,name,price_of_add,accommodation) values (4,'WiFi',0.0,1);
insert into additional_services (additional_id,name,price_of_add,accommodation) values (5,'Pet friendly',20.1,1);

--povezivanje smjestaja i additional servica
--insert into accommodation_additional_services (accommodation_id,additional_id) values (1,1);
--insert into accommodation_additional_services (accommodation_id,additional_id) values (1,2);
--insert into accommodation_additional_services (accommodation_id,additional_id) values (2,3);
--insert into accommodation_additional_services (accommodation_id,additional_id) values (2,4);
--insert into accommodation_additional_services (accommodation_id,additional_id) values (2,5);

--dodati slike za hotele..
insert into image (image_id,title,uri,accommodation_pic) values (1,'Aleksandar1','../assets/images/aleksandar.jpg',1);
insert into image (image_id,title,uri,accommodation_pic) values (2,'Aleksandar2','../assets/images/aleksandar2.jpg',1);
insert into image (image_id,title,uri,accommodation_pic) values (3,'NoviSad1','../assets/images/novisad.jpg',2);
insert into image (image_id,title,uri,accommodation_pic) values (4,'NoviSad2','../assets/images/novisad2.jpg',2);


insert into comment (comment_id,text,visible,client_comment,acc_commment) 
	values (1,'Super zurka. jeeeeeeej',1,5,1);
insert into comment (comment_id,text,visible,client_comment,acc_commment) 
	values (2,'Lose posve, palac dole',1,5,1);
insert into comment (comment_id,text,visible,client_comment,acc_commment) 
	values (3,'Moze procii, al pih',1,5,1);
insert into comment (comment_id,text,visible,client_comment,acc_commment) 
	values (4,'Hejt!!!!!!!!!!!!!',0,5,1);



