create table transactions
(
    id           serial primary key,
    request_id   uuid           not null,
    account_from integer        not null,
    account_to   integer        not null,
    amount       numeric(10, 2) not null,
    initiator    text,
    status       smallint       not null,
    constraint fk_status foreign key (status) references status (id),
    constraint fk_account_from foreign key (account_from) references accounts (id),
    constraint fk_account_to foreign key (account_to) references accounts (id)
);