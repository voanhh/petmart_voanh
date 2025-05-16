create database petmart;
use petmart;

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP		
);

CREATE TABLE user_detail (
    user_id INT UNIQUE NOT NULL,		
    full_name VARCHAR(100),
    email VARCHAR(100),
    phone VARCHAR(20),
    status BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE roles(
	id INT primary key auto_increment,
    role_name varchar(255)
);

alter table users add column role_id int;
alter table users add constraint FK_ROLE_USER foreign key(role_id) references roles(id);
alter table user_detail
add primary key (user_id);
 
create table category(
	category_id int primary key auto_increment,
    category_name varchar(100) not null
);

create table product (
	product_id int primary key auto_increment,
    product_name varchar(50),
    category_id int,
    price decimal(10,2) not null,
    quantity int not null,
    release_date timestamp default current_timestamp,
    foreign key (category_id) references category(category_id)
);

create table product_detail(
	product_id int primary key,
    description text,
    image_url text,
    foreign key (product_id) references product (product_id)
);

CREATE TABLE bill (
    bill_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total_amount DECIMAL(12,2),
    payment_method VARCHAR(50), -- COD, online,...
    status VARCHAR(50), -- pending, paid, shipped, canceled
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE bill_detail (
    bill_id INT,
    product_id INT,
    quantity INT NOT NULL,
    unit_price DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (bill_id, product_id),
    FOREIGN KEY (bill_id) REFERENCES bill(bill_id),
    FOREIGN KEY (product_id) REFERENCES product(product_id)
);


insert into roles(role_name) values ("admin");
insert into roles(role_name) values ("user");

insert into users(username, password, role_id) values ("voanhproslayer","123456","1");

insert into product(product_name, category_id, price, quantity) values("Carrier 2 in 1", "3","24.05","5");
insert into product(product_name, category_id, price, quantity) values("Chew Toy", "4","8.5","15");
insert into product(product_name, category_id, price, quantity) values("Dog Winter Coat", "3","20.45","7");
insert into product(product_name, category_id, price, quantity) values("Dog Coat", "4","17.05","3");

insert into category(category_name) values("Pet Food");
insert into category(category_name) values("Pet Hygiene & Grooming");
insert into category(category_name) values("Pet Accessories");
insert into category(category_name) values("Pet Toys");
insert into category(category_name) values("Pet Housing");
insert into category(category_name) values("Pet Health & Supplements");