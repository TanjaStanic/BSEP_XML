insert into user (user_id, first_name, last_name, email,password,certificated) values (1, 'admin', 'admin', 'admin@gmail.com', '$2a$10$B5q5PKtYYwtHSLd7lekgGu4ve5Iaa1IoAsZZZJkX74ervZjCAKdUe',true);
insert into role (id, name) values (1, 'ADMIN');
insert into user_roles (user_id,role_id) values (1,1);
