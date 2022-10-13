create table if not exists platforms
(
    id   serial
    constraint platforms_pk
    primary key,
    name varchar not null
);

alter table platforms
    owner to "user";

create table if not exists status
(
    id    serial
    constraint status_pk
    primary key,
    value varchar not null
);

alter table status
    owner to "user";

create table if not exists ratings
(
    id    serial
    constraint ratings_pk
    primary key,
    value integer not null
);

alter table ratings
    owner to "user";

create table if not exists genres
(
    id    serial
    constraint genres_id_uindex
    primary key,
    value varchar not null
);

alter table genres
    owner to "user";

create table if not exists games
(
    id    serial
    constraint games_pk
    primary key,
    title varchar not null
);

alter table games
    owner to "user";

create table if not exists games_genres
(
    game_id  integer not null
    constraint games_genres_games_id_fk
    references games,
    genre_id integer not null
    constraint games_genres_genres_id_fk
    references genres,
    constraint games_genres_pk
    unique (game_id, genre_id)
    );

alter table games_genres
    owner to "user";

create table if not exists users
(
    id       serial
    constraint users_pk
    primary key,
    username varchar(50) not null,
    password varchar(50) not null,
    enabled  boolean     not null
    );

alter table users
    owner to "user";

create table if not exists users_games
(
    user_id integer not null
    constraint users_games_users_id_fk
    references users,
    game_id integer not null
    constraint users_games_games_id_fk
    references games,
    constraint users_games_pk
    unique (game_id, user_id)
    );

alter table users_games
    owner to "user";

create table if not exists games_platforms
(
    game_id     integer not null
    constraint games_platforms_games_id_fk
    references games,
    platform_id integer not null
    constraint games_platforms_platforms_id_fk
    references platforms,
    constraint games_platforms_pk
    unique (game_id, platform_id)
    );

alter table games_platforms
    owner to "user";

create table if not exists games_status
(
    game_id   integer not null
    constraint games_status_games_id_fk
    references games,
    status_id integer not null
    constraint games_status_status_id_fk
    references status,
    constraint games_status_pk
    unique (game_id, status_id)
    );

alter table games_status
    owner to "user";

create table if not exists users_games_ratings
(
    id        serial
    constraint users_games_ratings_pk
    primary key,
    user_id   integer not null
    constraint users_games_ratings_users_id_fk
    references users,
    game_id   integer not null
    constraint users_games_ratings_games_id_fk
    references games,
    rating_id integer not null
    constraint users_games_ratings_ratings_id_fk
    references ratings,
    constraint users_games_ratings_uniq
    unique (user_id, game_id, rating_id)
    );

alter table users_games_ratings
    owner to "user";

create table if not exists reviews
(
    id          serial
    constraint reviews_pk
    primary key,
    review_text text not null
);

alter table reviews
    owner to "user";

create table if not exists users_games_reviews
(
    id        serial
    constraint users_games_reviews_pk
    primary key,
    user_id   integer not null
    constraint users_games_reviews_users_id_fk
    references users,
    game_id   integer not null
    constraint users_games_reviews_games_id_fk
    references games,
    review_id integer not null
    constraint users_games_reviews_reviews_id_fk
    references reviews,
    constraint users_games_reviews_uniq
    unique (user_id, game_id, review_id)
    );

alter table users_games_reviews
    owner to "user";
