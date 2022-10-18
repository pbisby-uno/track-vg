INSERT INTO public.users (id, username, password, enabled) VALUES (1, 'test_user_1', 'pass1', true);
INSERT INTO public.users (id, username, password, enabled) VALUES (2, 'test_user_2', 'pass2', true);
INSERT INTO public.users (id, username, password, enabled) VALUES (3, 'test_user_3', 'pass3', false);

INSERT INTO public.titles (id, description) VALUES (1, 'Far Cry 6');
INSERT INTO public.titles (id, description) VALUES (2, 'Assassin''s Creed Odyssey');
INSERT INTO public.titles (id, description) VALUES (3, 'Fifa 23');
INSERT INTO public.titles (id, description) VALUES (4, 'Gran Turismo 7');
INSERT INTO public.titles (id, description) VALUES (5, 'The Last of Us Part 2');

INSERT INTO public.games (id, platform_id, title_id, genre_id) VALUES(1, 6, 1, 5);
INSERT INTO public.games (id, platform_id, title_id, genre_id) VALUES(2, 5, 2, 1);
INSERT INTO public.games (id, platform_id, title_id, genre_id) VALUES(3, 6, 3, 3);
INSERT INTO public.games (id, platform_id, title_id, genre_id) VALUES(4, 4, 4, 2);
INSERT INTO public.games (id, platform_id, title_id, genre_id) VALUES(5, 3, 5, 10);

INSERT INTO public.users_games (user_id, game_id, status_id) VALUES(1, 1, 2);
INSERT INTO public.users_games (user_id, game_id, status_id) VALUES(1, 2, 4);
INSERT INTO public.users_games (user_id, game_id, status_id) VALUES(1, 3, 1);
INSERT INTO public.users_games (user_id, game_id, status_id) VALUES(2, 4, 2);
INSERT INTO public.users_games (user_id, game_id, status_id) VALUES(2, 5, 3);
