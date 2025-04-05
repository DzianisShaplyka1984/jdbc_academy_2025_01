alter table warehouse add column status varchar(255);

update warehouse set status = 'NEW';