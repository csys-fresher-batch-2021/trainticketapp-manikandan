create database trainticketapp_db;

//Create Users Table
create table users ( id serial primary key, firstname varchar(40) NOT NULL,
			 lastname varchar(40) NOT NULL,email varchar(40) NOT NULL,
			 mobilenumber bigint NOT NULL ,
			 username varchar(40) NOT NULL,newpasword varchar(40) NOT NULL,unique(email),unique(mobilenumber), unique(username)
			);
			
select * from users;
insert into users (firstname,lastname,email,mobilenumber,username,newpassword) 
values ('Manikandan','S','smani06022000@gmail.com',9514915914,'Mani375','pass@1234');


//Create Trains Table
create table trains (  id serial primary key, trainnumber int NOT NULL,trainname varchar(50) NOT NULL,
				train_source varchar(40) NOT NULL,train_destination varchar(40) NOT NULL,
			 source_time time NOT NULL,destination_time time NOT NULL,
			 class_type varchar(40) NOT NULL,fare int NOT NULL,availability int NOT NULL,
			  unique(trainnumber), unique(trainname),check(fare>0)
			);
select * from trains;
insert into trains(trainnumber,trainname,train_source,train_destination,source_time,destination_time,class_type,fare,availability)
values (21653,'TEJASEXPRESS','MADURAI','CHENNAI','07:00:00','13:35:00','FirstClass',1240,200);


//Create Employees Table
create table employees(id serial primary key,admin_name varchar(50) not null,admin_password varchar(50) not null,unique(admin_password), unique(admin_name));
select * from employees;
insert into employees (admin_name,admin_password) values ('admin','admin6789');

//Create Booking_details Table
create table booking_details(
 	id  serial NOT NULL  PRIMARY KEY,
    user_id integer NOT NULL,
    train_id integer NOT NULL,
	pnr_no int NOT NULL,
    journey_date date NOT NULL,
	journey_time time NOT NULL,
    booking_date timestamp without time zone NOT NULL,
	tickets integer NOT NULL,
    passengers character varying(500),
	total_price int NOT NULL,
	status character varying(100) DEFAULT 'BOOKED',
	UNIQUE(pnr_no),
    CONSTRAINT booking_details_train_id_fkey FOREIGN KEY (train_id)
        REFERENCES trains (id),
    CONSTRAINT booking_details_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES users (id),check(tickets>0),check(total_price>0)
);
select * from booking_details;

//To get Booking Details
select b.id, u.username as user_name, t.trainnumber as train_number, t.trainname as train_name, b.pnr_no as pnr_number ,b.booking_date, b.journey_date ,b.journey_time , t.class_type, b.tickets,b.passengers,b.total_price, b.status
			from users u, trains t , booking_details b where b.user_id = u.id and b.train_id = t.id;
			select * from trains;
			select * from booking_details;

