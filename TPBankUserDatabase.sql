
create database TPBankDatabase
go

use TPBankDatabase
go

create table TPBankUser(
   id varchar(10) primary key,
   accountNumber varchar(10),
   passwordU  varchar(31),
   capcha varchar(6)
)
go

insert into TPBankUser
 values
 ('TP0001','9922456709','quanghau1122','HK37C9'),
 ('TP0002','9922450001','cuShin55','MH35B0'),
 ('TP0003','9922458516','beMit09','KK11F8'),
 ('TP0004','9922455543','vuivui334','JG67H1')

 select * from TPBankUser
