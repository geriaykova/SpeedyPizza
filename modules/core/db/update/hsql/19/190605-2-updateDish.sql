update SPEEDYPIZZA2_DISH set PRICE = 0 where PRICE is null ;
alter table SPEEDYPIZZA2_DISH alter column PRICE set not null ;
