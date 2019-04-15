delete from user_authority;
delete from authority;
delete from user;



insert into user (user_id, first_name, last_name, email,password) values ('1', 'admin', 'admin', 'admin@gmail.com', '$2b$10$B5q5PKtYYwtHSLd7lekgGu4ve5Iaa1IoAsZZZJkX74ervZjCAKdUe');
insert into authority (id, name) values (1, 'ADMIN');
