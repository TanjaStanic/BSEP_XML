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

--insert into additional_services (additional_id,name,price_of_add,accommodation_unit) values (6,'Parking',20.1,1);
--insert into additional_services (additional_id,name,price_of_add,accommodation_unit) values (7,'Kitchen',20.1,1);
--insert into additional_services (additional_id,name,price_of_add,accommodation_unit) values (8,'Wifi',20.1,1);
--insert into additional_services (additional_id,name,price_of_add,accommodation_unit) values (9,'Pet Friendly',20.1,1);

insert into accommodation_unit (accommodation_unit_id,capacity,number_of_room,floor,size,default_price,type, acc,agent_units)
	values (1,3,22,2,40,50,"room",1,2);
insert into accommodation_unit (accommodation_unit_id,capacity,number_of_room,floor,size,default_price,type, acc,agent_units)
	values (2,2,33,3,35,51,"apartman",1,2);
insert into accommodation_unit (accommodation_unit_id,capacity,number_of_room,floor,size,default_price,type, acc,agent_units)
	values (3,5,123,12,50,59,"bed&breakfast",2,2);


--povezivanje cjenovnika

insert into pricing(pricing_id,price,date_from,date_to,acc_unit_price) 
	values (1,100,'2019-06-01','2019-07-01',1);
insert into pricing (pricing_id,price,date_from,date_to,acc_unit_price) 
	values (2,100,'2019-07-01','2019-08-01',1);
insert into pricing (pricing_id,price,date_from,date_to,acc_unit_price) 
	values (3,100,'2019-08-01','2019-09-01',1);	
insert into pricing (pricing_id,price,date_from,date_to,acc_unit_price) 
	values (4,100,'2019-09-01','2019-10-01',1);
insert into pricing (pricing_id,price,date_from,date_to,acc_unit_price) 
	values (5,100,'2019-10-01','2019-11-01',1);
	
insert into reservation (reservation_id,start_date,end_date,total_price,reservation_status,reservation_rating,reservation_user,acc_unit_reservation)	
	values (1,'2018-04-15','2018-04-25',350.5,'arrived',5,5,1);
insert into reservation (reservation_id,start_date,end_date,total_price,reservation_status,reservation_rating,reservation_user,acc_unit_reservation)	
	values (2,'2018-04-01','2018-04-13',666.5,'arrived',2,5,1);
insert into reservation (reservation_id,start_date,end_date,total_price,reservation_status,reservation_rating,reservation_user,acc_unit_reservation)	
	values (3,'2018-05-01','2018-05-13',666.5,'confirmed',null,5,1);
insert into reservation (reservation_id,start_date,end_date,total_price,reservation_status,reservation_rating,reservation_user,acc_unit_reservation)	
	values (4,'2018-04-01','2018-04-13',666.5,'arrived',null,5,1);
insert into reservation (reservation_id,start_date,end_date,total_price,reservation_status,reservation_rating,reservation_user,acc_unit_reservation)	
	values (5,'2018-05-01','2018-05-13',666.5,'confirmed',null,5,1);

	
	
	--dodati slike za hotele..
insert into image (image_id,title,uri,accommodation_pic) values (1,'Aleksandar1','../assets/images/aleksandar.jpg',1);
insert into image (image_id,title,uri,accommodation_pic) values (2,'Aleksandar2','../assets/images/aleksandar2.jpg',1);
insert into image (image_id,title,uri,accommodation_pic) values (3,'NoviSad1','../assets/images/novisad.jpg',2);
insert into image (image_id,title,uri,accommodation_pic) values (4,'NoviSad2','../assets/images/novisad2.jpg',2);

--dodavanje poruke
insert into messages(message_id,title,content,user_sent_id,user_received_id,date) 
	values (1,'Title1', 'Postovani, ovo je u smijeru agent  poslao klijentu, puno poozzz',2,5,'2018-05-13');
insert into messages(message_id,title,content,user_sent_id,user_received_id,date) 
	values (2,'Title2', 'Postovani, ovo je u smijeru agent  poslao klijentu',2,5,'2018-05-13');

insert into messages(message_id,title,content,user_sent_id,user_received_id,date) 
	values (3,'Title1', 'Postovani, ovo je u smijeru klijent  poslao agentu, puno poozzz',5,2,'2018-05-13');
insert into messages(message_id,title,content,user_sent_id,user_received_id,date) 
	values (4,'Title2', 'Postovani, ovo je u smijeru klijent  poslao agentu',5,2,'2018-05-13');

insert into comment (comment_id,text,visible,client_comment,acc_commment) 
	values (1,'Super zurka. jeeeeeeej',1,5,1);
insert into comment (comment_id,text,visible,client_comment,acc_commment) 
	values (2,'Lose posve, palac dole',1,5,1);
insert into comment (comment_id,text,visible,client_comment,acc_commment) 
	values (3,'Moze procii, al pih',1,5,1);
insert into comment (comment_id,text,visible,client_comment,acc_commment) 
	values (4,'Hejt!!!!!!!!!!!!!',0,5,1);




			
