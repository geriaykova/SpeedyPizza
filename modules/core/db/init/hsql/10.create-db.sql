-- begin SPEEDYPIZZA2_DISH
create table SPEEDYPIZZA2_DISH (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    TYPE_ID varchar(36) not null,
    INGREDIENTS varchar(255),
    PRICE decimal(19, 2) not null,
    QUANTITY decimal(19, 2),
    --
    primary key (ID)
)^
-- end SPEEDYPIZZA2_DISH
-- begin SPEEDYPIZZA2_TYPE
create table SPEEDYPIZZA2_TYPE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    --
    primary key (ID)
)^
-- end SPEEDYPIZZA2_TYPE
-- begin SPEEDYPIZZA2_CUSTOMER
create table SPEEDYPIZZA2_CUSTOMER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    PHONE_NUMBER varchar(255) not null,
    DELIVERY_ADDRESS varchar(255) not null,
    USER_ID varchar(36),
    --
    primary key (ID)
)^
-- end SPEEDYPIZZA2_CUSTOMER
-- begin SPEEDYPIZZA2_ORDER
create table SPEEDYPIZZA2_ORDER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    ORDER_TIME timestamp not null,
    CUSTOMER_ID varchar(36),
    CLIENT_NAME varchar(255),
    PHONE_NUMBER varchar(255),
    DELIVERY_ADDRESS varchar(255),
    INSTRUCTIONS varchar(255),
    DELIVERY_TIME timestamp,
    DISCOUNT decimal(19, 2),
    TOTAL_AMOUNT decimal(19, 2),
    --
    primary key (ID)
)^
-- end SPEEDYPIZZA2_ORDER
-- begin SPEEDYPIZZA2_ORDER_DISH_LINK
create table SPEEDYPIZZA2_ORDER_DISH_LINK (
    ORDER_ID varchar(36) not null,
    DISH_ID varchar(36) not null,
    primary key (ORDER_ID, DISH_ID)
)^
-- end SPEEDYPIZZA2_ORDER_DISH_LINK
