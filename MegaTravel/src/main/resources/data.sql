insert into user(user_name, password) values ('user11', '123456');
insert into user(user_name, password, role) values ('user1', '123456', 'Employee');
insert into user(user_name, password, role) values ('user2', '123456', 'Employee');
insert into user(user_name, password, role) values ('klijent', '123456', 'Client');
insert into privilege(name) values ('promenaLozinke');
insert into role(name) values ('adminRole');
insert into roles_privileges(role_id, privilege_id) values (1, 1);

