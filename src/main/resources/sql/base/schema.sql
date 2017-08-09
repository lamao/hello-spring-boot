create table users (
    username varchar(50) not null primary key,
    password varchar(255) not null,
    enabled boolean not null
);

create table authorities (
    username varchar(50) not null,
    authority varchar(50) not null,
    foreign key (username) references users (username),
    unique (username, authority)
);

create table property_definition (
    id uuid not null primary key,
    code varchar(50) unique
);

create table entity_type (
    id uuid not null primary key,
    code varchar(50) unique
);

create table entity (
    id uuid not null primary key,
    type_id uuid not null,
    foreign key (type_id) references entity_type(id)
);