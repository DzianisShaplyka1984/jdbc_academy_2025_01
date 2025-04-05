create table address (
                         id int primary key auto_increment,
                         city varchar(255),
                         street varchar(255),
                         bulding varchar(255)
);

create table test (
                      id int primary key auto_increment
);

alter table address add column appartment varchar(255);