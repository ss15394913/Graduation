--ì¸óÕÅ@írìc

CREATE TABLE product(
  product_id NUMBER(8) primary key,
  product_name VARCHAR2(200) not null,
  product_price NUMBER(6) not null,
  product_description VARCHAR2(4000),
  category_id NUMBER(2),
  sub_category_id NUMBER(2),
  product_size VARCHAR2(20),
  product_color VARCHAR2(40),
  product_release_date DATE not null
);


CREATE TABLE product_stock(
  product_id NUMBER(8) primary key,
  product_stock_count NUMBER(3) not null
);

CREATE TABLE category(
  category_id NUMBER(2) primary key,
  category_name VARCHAR2(20) unique not null
);

CREATE TABLE sub_category(
  sub_category_id NUMBER(2) primary key,
  sub_category_name VARCHAR2(30) unique not null,
  category_id NUMBER(2) REFERENCES category(category_id)
);

ALTER TABLE product
ADD CONSTRAINT fk_product_category_id
FOREIGN KEY(category_id) REFERENCES category(category_id)
;

ALTER TABLE product
ADD CONSTRAINT fk_product_sub_category_id
FOREIGN KEY(sub_category_id) REFERENCES sub_category(sub_category_id)
;

CREATE TABLE product_image(
  product_image_id NUMBER(8) primary key,
  product_image_path VARCHAR2(515) not null,
  product_id NUMBER(8) REFERENCES product(product_id)
);

CREATE TABLE purchase_order(
  purchase_order_id NUMBER(10) primary key,
  purchase_order_date DATE not null,
  purchase_order_delivery_status VARCHAR2(20) null,
  member_id NUMBER(10)
);

CREATE TABLE purchase_order_detail(
  purchase_order_detail_id NUMBER(10) primary key,
  purchase_order_id NUMBER(10) REFERENCES purchase_order(purchase_order_id),
  product_id NUMBER(8) REFERENCES product(product_id),
  purchase_count NUMBER(3) not null
);

--Ç±Ç±Ç©ÇÁåEìcÇ≥ÇÒ

CREATE TABLE tag(
tag_id number(3) primary key,
tag_name varchar2(40) not null,
product_id number(8) REFERENCES product(product_id)
);

CREATE TABLE favorite(
member_id number(10),
product_id number(8) REFERENCES product(product_id)
);

CREATE TABLE member_status(
 member_status_id number(1) primary key,
 member_status_name varchar2(20) unique not null
);

CREATE TABLE member(
 member_id number(10) primary key,
 member_name varchar2(100) not null,
 member_kana varchar2(100) not null,
 member_zip_code varchar2(7) not null,
 member_address varchar2(400) not null,
 member_phone_number varchar2(11) not null,
 member_birthday date,
 member_email varchar(256) not null,
 member_password varchar2(32),
 member_status_id number(1) REFERENCES member_status(member_status_id)
);

--Ç±Ç±Ç©ÇÁírìc

ALTER TABLE favorite
ADD CONSTRAINT favorite_member_id
FOREIGN KEY(member_id) REFERENCES member(member_id)
;

ALTER TABLE purchase_order
ADD CONSTRAINT fk_purchase_order_member_id
FOREIGN KEY(member_id) REFERENCES member(member_id)
;

ALTER TABLE favorite
ADD CONSTRAINT pk_favorite_both_id
PRIMARY KEY(member_id,product_id)
;
