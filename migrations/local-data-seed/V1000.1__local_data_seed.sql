INSERT INTO public.users (id, username, password, enabled) VALUES (1, 'test_user_1', 'pass1', true);
INSERT INTO public.users (id, username, password, enabled) VALUES (2, 'test_user_2', 'pass2', true);
INSERT INTO public.users (id, username, password, enabled) VALUES (3, 'test_user_3', 'pass3', false);

INSERT INTO public.games (id, title) VALUES (1, 'Far Cry 6');
INSERT INTO public.games (id, title) VALUES (2, 'Assassin''s Creed Odyssey');
INSERT INTO public.games (id, title) VALUES (3, 'Fifa 23');
INSERT INTO public.games (id, title) VALUES (4, 'Gran Turismo 7');
INSERT INTO public.games (id, title) VALUES (5, 'The Last of Us Part 2');

INSERT INTO public.reviews (id, review_text) VALUES (1, 'Loved it!');

INSERT INTO public.games_genres (game_id, genre_id) VALUES (1, 5);
INSERT INTO public.games_genres (game_id, genre_id) VALUES (1, 8);
INSERT INTO public.games_genres (game_id, genre_id) VALUES (2, 1);
INSERT INTO public.games_genres (game_id, genre_id) VALUES (2, 8);
INSERT INTO public.games_genres (game_id, genre_id) VALUES (3, 3);
INSERT INTO public.games_genres (game_id, genre_id) VALUES (4, 2);
INSERT INTO public.games_genres (game_id, genre_id) VALUES (5, 10);
INSERT INTO public.games_genres (game_id, genre_id) VALUES (5, 11);

INSERT INTO public.games_platforms (game_id, platform_id) VALUES (1, 6);
INSERT INTO public.games_platforms (game_id, platform_id) VALUES (2, 5);
INSERT INTO public.games_platforms (game_id, platform_id) VALUES (3, 6);
INSERT INTO public.games_platforms (game_id, platform_id) VALUES (4, 4);
INSERT INTO public.games_platforms (game_id, platform_id) VALUES (5, 3);

INSERT INTO public.games_status (game_id, status_id) VALUES (1, 2);
INSERT INTO public.games_status (game_id, status_id) VALUES (2, 1);
INSERT INTO public.games_status (game_id, status_id) VALUES (3, 1);
INSERT INTO public.games_status (game_id, status_id) VALUES (4, 2);
INSERT INTO public.games_status (game_id, status_id) VALUES (5, 3);

INSERT INTO public.users_games (user_id, game_id) VALUES (1, 1);
INSERT INTO public.users_games (user_id, game_id) VALUES (1, 2);
INSERT INTO public.users_games (user_id, game_id) VALUES (1, 3);
INSERT INTO public.users_games (user_id, game_id) VALUES (2, 4);
INSERT INTO public.users_games (user_id, game_id) VALUES (2, 5);

INSERT INTO public.users_games_ratings (id, user_id, game_id, rating_id) VALUES (1, 2, 5, 9);

INSERT INTO public.users_games_reviews (id, user_id, game_id, review_id) VALUES (1, 2, 5, 1);
