-- begin SPEEDYPIZZA2_DISH
alter table SPEEDYPIZZA2_DISH add constraint FK_SPEEDYPIZZA2_DISH_ON_TYPE foreign key (TYPE_ID) references SPEEDYPIZZA2_TYPE(ID)^
create index IDX_SPEEDYPIZZA2_DISH_ON_TYPE on SPEEDYPIZZA2_DISH (TYPE_ID)^
-- end SPEEDYPIZZA2_DISH
-- begin SPEEDYPIZZA2_ORDER
alter table SPEEDYPIZZA2_ORDER add constraint FK_SPEEDYPIZZA2_ORDER_ON_CUSTOMER foreign key (CUSTOMER_ID) references SPEEDYPIZZA2_CUSTOMER(ID)^
create index IDX_SPEEDYPIZZA2_ORDER_ON_CUSTOMER on SPEEDYPIZZA2_ORDER (CUSTOMER_ID)^
-- end SPEEDYPIZZA2_ORDER
-- begin SPEEDYPIZZA2_ORDER_DISH_LINK
alter table SPEEDYPIZZA2_ORDER_DISH_LINK add constraint FK_ORDDIS_ON_ORDER foreign key (ORDER_ID) references SPEEDYPIZZA2_ORDER(ID)^
alter table SPEEDYPIZZA2_ORDER_DISH_LINK add constraint FK_ORDDIS_ON_DISH foreign key (DISH_ID) references SPEEDYPIZZA2_DISH(ID)^
-- end SPEEDYPIZZA2_ORDER_DISH_LINK
