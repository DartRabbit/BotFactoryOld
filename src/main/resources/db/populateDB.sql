-- DELETE FROM quotes;
-- DELETE FROM user_bots;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;
ALTER SEQUENCE quotes_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password');

INSERT INTO users (name, email, password)
VALUES ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO bots (name, user_id, type) VALUES
  ('ShrekTheSecondBot', 100000,'Telegram'),
  ('SomeTestBot', 100001,'Telegram');

INSERT INTO telegram_bots (bot_id, token) VALUES
  (100002,'347037495:AAGtX8QqLKNIdi8hqPTDj40nCdHDNZ_Le7w'),
  (100003,'pioejhtr098y4cn9u8doivjhosv8ne4n28y398y5934875y');

