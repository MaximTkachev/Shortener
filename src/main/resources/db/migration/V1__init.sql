create table public.link
(
    id bigserial primary key,
    creation_date date,
    last_use_date date,
    original_link varchar(255),
    short_link varchar(255) constraint short_link_unique unique,
    uses_count integer not null
);

alter table public.link owner to shortener;
