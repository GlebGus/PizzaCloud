create table if not exists Ingredient (
                                          id varchar(4) not null,
                                          name varchar(25) not null,
                                          type varchar(10) not null
);
create table if not exists Pizza_Order (
                                           id INTEGER PRIMARY KEY ,
                                           delivery_Name varchar(50) not null,
                                           delivery_Street varchar(50) not null,
                                           house varchar(50) not null,
                                           flat varchar(50),
                                           entrance varchar(25),
                                           floor varchar(25),
                                           doorPhone varchar(99),
                                           cc_number varchar(16) not null,
                                           cc_expiration varchar(5) not null,
                                           cc_cvv varchar(3) not null,
                                           placed_at timestamp not null
);
create table if not exists Pizza (
                                     id INTEGER PRIMARY KEY ,
                                     name varchar(50) not null,
                                     pizza_order bigint not null,
                                     pizza_order_key bigint not null,
                                     created_at timestamp not null
);
create table if not exists Ingredient_Ref (
                                              ingredient varchar(4) not null,
                                              pizza bigint not null,
                                              pizza_key bigint not null
);
alter table Pizza
    add foreign key (pizza_order) references Pizza_Order(id);
alter table Ingredient add primary key (id);
alter table Ingredient_Ref
    add foreign key (ingredient) references Ingredient(id);