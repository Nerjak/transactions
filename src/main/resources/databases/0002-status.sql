create table status
(
    id    smallserial primary key,
    value text not null unique
);