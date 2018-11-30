	CREATE SEQUENCE books_sequence start 1000 increment 1;
	CREATE SEQUENCE user_sequence start 1000 increment 1;
	CREATE SEQUENCE rent_sequence start 1000 increment 1;
	CREATE SEQUENCE shop_sequence start 1000 increment 1;

	create table usertable
(
	userid int default nextval('user_sequence'::regclass)
		constraint usertable_pk
			primary key,
	pseudo varchar(200) not null,
	password varchar(300) not null,
	gender boolean not null,
	mail varchar(200) not null,
	role integer,
	salt varchar(250),
	delete boolean default true not null
)
;

create table book
(
	bookid int default nextval('books_sequence'::regclass)
		constraint book_pk
			primary key,
	bookname varchar(200) not null,
	author varchar(100) not null,
	editeurs varchar(100) not null,
	nbpage integer,
	dispo integer default 3
)
;

create table rentbook
(
	rentid int default nextval('rent_sequence'::regclass),
	user_id integer not null
		constraint usertable_rentbook_fk
			references usertable,
	book_id integer not null
		constraint book_rentbook_fk
			references book,
	reload boolean not null,
	returnbook boolean not null,
	create_at date,
	end_at date,
	constraint rentbook_pk
		primary key (rentid, user_id, book_id)
)
;

create table shoppinglist
(
	id int default nextval('shop_sequence'::regclass)
		constraint "ShoppingList_pkey"
			primary key,
	idusershop integer not null
		constraint shoppinglist_usertable_userid_fk
			references usertable,
	dispo boolean,
	create_at timestamp,
	end_at timestamp,
	idbookshop integer
		constraint shoppinglist_book_bookid_fk
			references book,
	idpannier varchar(50)
)
;

COMMENT ON SCHEMA public
    IS 'standard public schema';

GRANT ALL ON SCHEMA public TO postgres;

GRANT ALL ON SCHEMA public TO PUBLIC;