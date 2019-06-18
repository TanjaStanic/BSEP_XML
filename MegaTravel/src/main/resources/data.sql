--svi useri
insert into user (user_id, first_name, last_name, email,password,certificated) values (1, 'admin', 'admin', 'adminMAMA@gmail.com', '$2a$10$B5q5PKtYYwtHSLd7lekgGu4ve5Iaa1IoAsZZZJkX74ervZjCAKdUe',1);
-- agenti za provjeru sertifikata
insert into user (user_id, first_name, last_name, email,password,certificated,pib) values (2, 'agent', 'agent', 'agent@gmail.com', '$2a$12$l5RRveYgubpdAK5h42f2xu8qpVf6619DtbY90JneL/NXVsBeIzL1e',1,'123456');
insert into user (user_id, first_name, last_name, email,password,certificated,pib) values (3, 'agent2', 'agent2', 'agent2@gmail.com', '$2a$12$l5RRveYgubpdAK5h42f2xu8qpVf6619DtbY90JneL/NXVsBeIzL1e',1,'1234567');
insert into user (user_id, first_name, last_name, email,password,certificated,pib) values (4, 'agent3', 'agent3', 'agent3@gmail.com', '$2a$12$l5RRveYgubpdAK5h42f2xu8qpVf6619DtbY90JneL/NXVsBeIzL1e',1,'1234568');
--
insert into user (user_id, first_name, last_name, email,password,certificated) values (5, 'tanja', 'tanja', 't@gmail.com', '$2a$10$B5q5PKtYYwtHSLd7lekgGu4ve5Iaa1IoAsZZZJkX74ervZjCAKdUe',1);

--certifikati
insert into certificate (id, ca, end_date, id_issuer, id_subject, reason_for_revokation, revoked, start_date) values (1, 1, '2021-04-15 22:00:00.000000', 1, 1, '', 0, '2019-04-15 22:00:00.000000');
insert into certificate (id, ca, end_date, id_issuer, id_subject, reason_for_revokation, revoked, start_date) values (2, 1, '2021-04-15 22:00:00.000000', 1, 2, '', 0, '2019-04-15 22:00:00.000000');
insert into certificate (id, ca, end_date, id_issuer, id_subject, reason_for_revokation, revoked, start_date) values (3, 1, '2021-04-15 22:00:00.000000', 1, 3, '', 0, '2019-04-15 22:00:00.000000');
insert into certificate (id, ca, end_date, id_issuer, id_subject, reason_for_revokation, revoked, start_date) values (4, 1, '2021-04-15 22:00:00.000000', 1, 4, '', 0, '2019-04-15 22:00:00.000000');

insert into role (id, name) values (1, 'ROLE_ADMIN');
insert into role (id, name) values (3, 'ROLE_USER');
insert into role (id, name) values (2, 'ROLE_AGENT');


insert into user_roles (user_id,role_id) values (1,1);
insert into user_roles (user_id,role_id) values (2,3);

insert into location (location_id,geo_length,geo_width) values (1,55.5,56.6);
insert into address (address_id,street,number,city,country) values (1,'ulica',45,'ns','srbija');




