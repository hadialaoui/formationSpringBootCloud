
/*insert into user values(1,sysdate(),'Sara1');
insert into user values(2,sysdate(),'Sara2');
insert into user values(3,sysdate(),'Sara3');

insert into post values(10,'Happy birthday world 1',1);
insert into post values(20,'Happy birthday world 2',1);
insert into post values(30,'Happy birthday world 3',2);
insert into post values(40,'Happy birthday world 4',2);*/

/*data for default schema*/
/*insert into users (username, password, enabled) values('admin3','passadmin',true);
insert into users (username, password, enabled) values('hadialaoui3','passhadialaoui',true);

insert into authorities (username, authority) values('admin3','ROLE_ADMIN');
insert into authorities (username, authority) values('hadialaoui3','ROLE_USER');*/

/*data for custom schema*/
insert into myusers (username, password, enabled) values('admin3','passadmin',true);
insert into myusers (username, password, enabled) values('hadialaoui3','passhadialaoui',true);

insert into myauthorities (username, authority) values('admin3','ROLE_ADMIN');
insert into myauthorities (username, authority) values('hadialaoui3','ROLE_USER');
