DELETE FROM quotes;
DELETE FROM bots;
DELETE FROM type_of_bot;
DELETE FROM user_roles;
DELETE FROM users;

ALTER SEQUENCE global_seq RESTART WITH 100000;
ALTER SEQUENCE quotes_seq RESTART WITH 100000;

INSERT INTO users(name, email, password, enabled)
    VALUES ('Admin','admin@gmail.com','admin',TRUE );

INSERT INTO users(name, email, password, enabled)
    VALUES ('User', 'user@mail.ru', 'password', TRUE );

INSERT INTO user_roles(role, user_id) VALUES
  ('ROLE_ADMIN',100000),
  ('ROLE_USER',100001);

INSERT INTO type_of_bot(id,name,description) VALUES
  (1,'Telegram', 'Telegram bot');

INSERT INTO bots(name, token, description, type, user_id) VALUES
  ('ShrekTheSecondBot','347037495:AAGtX8QqLKNIdi8hqPTDj40nCdHDNZ_Le7w','Шрэк Второй',1,100001);