CREATE TABLE public.users (
	id serial4 NOT NULL,
	username varchar(50) NOT NULL,
	"password" varchar(50) NOT NULL,
	enabled bool NOT NULL,
	CONSTRAINT users_pk PRIMARY KEY (id)
);

CREATE TABLE public.titles (
	id serial4 NOT NULL,
	description varchar NOT NULL,
	CONSTRAINT titles_pk PRIMARY KEY (id)
);

CREATE TABLE public.platforms (
	id serial4 NOT NULL,
	description varchar NOT NULL,
	CONSTRAINT platforms_pk PRIMARY KEY (id)
);

CREATE TABLE public.status (
	id serial4 NOT NULL,
	description varchar NOT NULL,
	CONSTRAINT status_pk PRIMARY KEY (id)
);

CREATE TABLE public.genres (
	id serial4 NOT NULL,
	description varchar NOT NULL,
	CONSTRAINT genres_pk PRIMARY KEY (id)
);

CREATE TABLE public.games (
	id serial4 NOT NULL,
	platform_id int4 NOT NULL,
	title_id int4 NULL,
	genre_id int4 NULL,
	CONSTRAINT games_pk PRIMARY KEY (id)
);

ALTER TABLE public.games ADD CONSTRAINT games_genres_id_fk FOREIGN KEY (genre_id) REFERENCES public.genres(id);
ALTER TABLE public.games ADD CONSTRAINT games_platforms_id_fk FOREIGN KEY (platform_id) REFERENCES public.platforms(id);
ALTER TABLE public.games ADD CONSTRAINT games_titles_id_fk FOREIGN KEY (title_id) REFERENCES public.titles(id);

CREATE TABLE public.users_games (
	user_id int4 NOT NULL,
	game_id int4 NOT NULL,
	status_id int4 NULL,
	CONSTRAINT users_games_pk UNIQUE (game_id, user_id)
);

ALTER TABLE public.users_games ADD CONSTRAINT users_games_game_id_fk FOREIGN KEY (game_id) REFERENCES public.games(id);
ALTER TABLE public.users_games ADD CONSTRAINT users_games_status_id_fk FOREIGN KEY (status_id) REFERENCES public.status(id);
ALTER TABLE public.users_games ADD CONSTRAINT users_games_users_id_fk FOREIGN KEY (user_id) REFERENCES public.users(id);
