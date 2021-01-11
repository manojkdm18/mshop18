			
create table countrymaster(
COUNTRYRFNUM int NOT NULL AUTO_INCREMENT,
COUNTRYNAME  varchar(20),
COUNTRYCODE  varchar(20),
CREATEDATE timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
MODIFIDATE timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
CREATEDBY tinyint(1) NOT NULL DEFAULT '0',
MODIFIEDBY tinyint(1) NOT NULL DEFAULT '0',
ISACTIVE tinyint(1) NOT NULL DEFAULT '1',
PRIMARY KEY ( COUNTRYRFNUM )
);

create table statemaster(
STATERFNUM int NOT NULL AUTO_INCREMENT,
STATENAME  varchar(20),
STATECODE  varchar(20),
COUNTRYRFNUM bigint(10),
CREATEDATE timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
MODIFIDATE timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
CREATEDBY tinyint(1) NOT NULL DEFAULT '0',
MODIFIEDBY tinyint(1) NOT NULL DEFAULT '0',
ISACTIVE tinyint(1) NOT NULL DEFAULT '1',
PRIMARY KEY ( STATERFNUM )
);

create table citymaster(
CITYRFNUM int NOT NULL AUTO_INCREMENT,
CITYNAME  varchar(20),
CITYCODE  varchar(20),
PINCODE   bigint(20),
COUNTRYRFNUM int(10),
STATERFNUM int(10),
CREATEDATE timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
MODIFIDATE timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
CREATEDBY tinyint(1) NOT NULL DEFAULT '0',
MODIFIEDBY tinyint(1) NOT NULL DEFAULT '0',
ISACTIVE tinyint(1) NOT NULL DEFAULT '1',
PRIMARY KEY ( CITYRFNUM )
);

alter table user add CONSTRAINT FK_staterfnum FOREIGN KEY (STATERFNUM)
    REFERENCES statemaster(STATERFNUM);
alter table statemaster add CONSTRAINT FK_countryrfnum FOREIGN KEY (COUNTRYRFNUM)
    REFERENCES countrymaster(COUNTRYRFNUM);
    alter table user add CONSTRAINT FK_cityrfnum FOREIGN KEY (CITYRFNUM)
    REFERENCES citymaster(CITYRFNUM);
    

create table user(
USERRFNUM int NOT NULL AUTO_INCREMENT,
FIRSTNAME  varchar(20),
LASTNAME  varchar(20),
MOBILE  varchar(20),
EMAIL  varchar(25),
PASSWORD   varchar(20),
USERTYPE  varchar(2),
COUNTRYRFNUM int(10),
STATERFNUM int(10),
CITYRFNUM int (10),
CREATEDATE timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
MODIFIDATE timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
CREATEDBY tinyint(1) NOT NULL DEFAULT '0',
MODIFIEDBY tinyint(1) NOT NULL DEFAULT '0',
ISACTIVE tinyint(1) NOT NULL DEFAULT '1',
PRIMARY KEY ( USERRFNUM )
);

alter table statemaster add column COUNTRY int(10)
ALTER TABLE statemaster RENAME COLUMN COUNTRY TO COUNTRYRFNUM;


ALTER TABLE statemaster
DROP COLUMN COUNTRYRFNUM;

 insert into statemaster values(null,'MAHARASHTRA','MH',NOW(),NOW(),0,0,1,1);
 mysql> insert into statemaster values(null,'GOA','GA',NOW(),NOW(),0,0,1,1);
 
 insert into citymaster values(null,'PUNE','PN',400002,now(),now(),0,0,1,1,1);
  insert into citymaster values(null,'MUMBAI','MI',400001,now(),now(),0,0,1,1,1);
   insert into citymaster values(null,'CHIPLUN','CH',415605,now(),now(),0,0,1,1,1);

create table category(
CATRFNUM bigint(20) NOT NULL AUTO_INCREMENT,
CATNAME  varchar(30),
CATDESC  varchar(200),
CREATEDATE timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
MODIFIDATE timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
CREATEDBY tinyint(1) NOT NULL DEFAULT '0',
MODIFIEDBY tinyint(1) NOT NULL DEFAULT '0',
ISACTIVE varchar(1) NOT NULL DEFAULT 'Y',
PRIMARY KEY ( CATRFNUM )
);


create table subcategory(
SUBCATRFNUM bigint(20) NOT NULL AUTO_INCREMENT,
SUBCATNAME  varchar(20),
SUBCATDESC  varchar(20),
CATRFNUM bigint(10),
CREATEDATE timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
MODIFIDATE timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
CREATEDBY tinyint(1) NOT NULL DEFAULT '0',
MODIFIEDBY tinyint(1) NOT NULL DEFAULT '0',
ISACTIVE varchar(1) NOT NULL DEFAULT 'Y',
PRIMARY KEY ( SUBCATRFNUM )
);

alter table subcategory add CONSTRAINT FK_catrfnum FOREIGN KEY (CATRFNUM)
    REFERENCES category(CATRFNUM);


create table mshop_cnd(
CNDRFNUM bigint(20) NOT NULL AUTO_INCREMENT,
CNDNAME  varchar(25),
CNDCODE  varchar(25),
CNDGROUP VARCHAR(25),
CREATEDATE timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
MODIFIDATE timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
CREATEDBY tinyint(1) NOT NULL DEFAULT '0',
MODIFIEDBY tinyint(1) NOT NULL DEFAULT '0',
ISACTIVE varchar(1) NOT NULL DEFAULT 'Y',
PRIMARY KEY ( CNDRFNUM )
);

create table mshop_banner(
BRFNUM bigint(20) NOT NULL AUTO_INCREMENT,
TITLE  varchar(25),
TYPE  varchar(25),
SEQUENCE  VARCHAR(10),
THEME VARCHAR(25),
CREATEDATE timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
MODIFIDATE timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
CREATEDBY tinyint(1) NOT NULL DEFAULT '0',
MODIFIEDBY tinyint(1) NOT NULL DEFAULT '0',
ISACTIVE varchar(1) NOT NULL DEFAULT 'Y',
PRIMARY KEY ( BRFNUM )
);

alter table mshop_banner add CONSTRAINT FK_mshop_cnd FOREIGN KEY (TYPE)
    REFERENCES mshop_cnd(CNDRFNUM);

insert into countrymaster values(null,'INDIA','IND',now(),now(),0,0,1);

insert into user values(null,'superadmin','superadmin','8554906835','superadmin@gmail.com','123456','A',now(),now(),0,0,'Y',
      

create table product(
PRFNUM int NOT NULL AUTO_INCREMENT,
PRODUCT_SKU  varchar(25),
PRODUCT_NAME  varchar(25),
PRODUCT_DESC  varchar(200),
COLOUR  varchar(25),
BRAND   varchar(25),
PRICE bigint (10),
DISCOUNT bigint (10),
FINALPAY bigint (10),
QUANTITY bigint (10),
PRO_IMG1  varchar(100),
PRO_IMG2  varchar(100),
PRO_IMG3  varchar(100),
PRO_IMG4  varchar(100),
SUBCATRFNUM int (10),
COLOUR bigint (10),
BRAND bigint (10),
CNDENTITY bigint (10),
CREATEDATE timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
MODIFIDATE timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
CREATEDBY tinyint(1) NOT NULL DEFAULT '0',
MODIFIEDBY tinyint(1) NOT NULL DEFAULT '0',
ISACTIVE varchar(1) NOT NULL DEFAULT 'Y',
PRIMARY KEY ( PRFNUM )
);

  
alter table product add CONSTRAINT FK_subcategory FOREIGN KEY (SUBCATRFNUM)
    REFERENCES subcategory(SUBCATRFNUM);
    
 alter table product add CONSTRAINT FK_cnd1 FOREIGN KEY (COLOUR)
    REFERENCES subcategory(CNDRFNUM);
    alter table product add CONSTRAINT FK_cnd2 FOREIGN KEY (BRAND)
    REFERENCES subcategory(CNDRFNUM);
    alter table product add CONSTRAINT FK_cnd3 FOREIGN KEY (CNDENTITY)
    REFERENCES subcategory(CNDRFNUM);


create table CartItems(
cartRfnum bigint(20) NOT NULL AUTO_INCREMENT,
productRfnum  bigint(20),
productSku  varchar(200),
userRfnum  bigint(20),
quantity   int(20),
CREATEDATE timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
MODIFIDATE timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
CREATEDBY tinyint(1) NOT NULL DEFAULT '0',
MODIFIEDBY tinyint(1) NOT NULL DEFAULT '0',
ISACTIVE varchar(1) NOT NULL DEFAULT 'Y',
PRIMARY KEY ( cartRfnum )
);