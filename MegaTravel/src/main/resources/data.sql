insert into user(user_name, password, role) values ('admin', 'admin', 'Administrator');

insert into user(user_name, password, role) values ('London', '123456', 'Employee');
insert into user(user_name, password, role) values ('Boston', '123456', 'Employee');
insert into user(user_name, password, role) values ('Hong Kong', '123456', 'Employee');

insert into user(user_name, password, role) values ('office1', '123456', 'Employee');
insert into user(user_name, password, role) values ('office2', '123456', 'Employee');
insert into user(user_name, password, role) values ('office3', '123456', 'Employee');

insert into user(user_name, password, role) values ('client', '123456', 'Client');

insert into employee(user_id,employee_role) values (2, 'Branch');
insert into employee(user_id,employee_role) values (3, 'Branch');
insert into employee(user_id,employee_role) values (4, 'Branch');
insert into employee(user_id,employee_role) values (5, 'Office');
insert into employee(user_id,employee_role) values (6, 'Office');
insert into employee(user_id,employee_role) values (7, 'Office');

insert into role(role_name) values ('adminRole');
insert into role(role_name) values ('branchRole');
insert into role(role_name) values ('officeRole');
insert into role(role_name) values ('clientR');

insert into privilege(privilege_name) values ('preuzmiZaposlenog');
insert into privilege(privilege_name) values ('preuzmiKlijenta');

insert into roles_privileges(role_id, privilege_id) values (1, 1);
insert into roles_privileges(role_id, privilege_id) values (2, 1);
insert into roles_privileges(role_id, privilege_id) values (3, 1);
insert into roles_privileges(role_id, privilege_id) values (2, 2);

insert into user_roles(user_id, role_id) values (1, 1);

insert into user_roles(user_id, role_id) values (2, 2);
insert into user_roles(user_id, role_id) values (3, 2);
insert into user_roles(user_id, role_id) values (4, 2);

insert into user_roles(user_id, role_id) values (5, 3);
insert into user_roles(user_id, role_id) values (6, 3);
insert into user_roles(user_id, role_id) values (7, 3);

insert into user_roles(user_id, role_id) values (8, 4);


