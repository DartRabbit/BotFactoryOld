DROP TABLE IF EXISTS quotes;
DROP TABLE IF EXISTS telegram_bots;
DROP TABLE IF EXISTS bots;

DROP TABLE IF EXISTS users;

DROP SEQUENCE IF EXISTS global_seq;
DROP SEQUENCE IF EXISTS quotes_seq;

CREATE SEQUENCE global_seq START 100000;
CREATE SEQUENCE quotes_seq START 100000;

CREATE TABLE users
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name       VARCHAR NOT NULL,
  email      VARCHAR NOT NULL,
  password   VARCHAR NOT NULL,
  registered TIMESTAMP           DEFAULT now()
);
CREATE UNIQUE INDEX users_unique_email_idx
  ON users (email);

CREATE TABLE bots
(
  id             INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  user_id        INTEGER NOT NULL,
  name           VARCHAR NOT NULL,
  type           VARCHAR NOT NULL,
  must_be_runned BOOLEAN DEFAULT FALSE,
  CONSTRAINT bots_idx UNIQUE (id, user_id),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE telegram_bots
(
  id     INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  bot_id INTEGER NOT NULL,
  token  VARCHAR NOT NULL,
  CONSTRAINT telegram_bots_idx UNIQUE (id, bot_id),
  FOREIGN KEY (bot_id) REFERENCES bots (id) ON DELETE CASCADE
);

CREATE TABLE quotes
(
  id       INTEGER PRIMARY KEY DEFAULT nextval('quotes_seq'),
  bot_id   INTEGER NOT NULL,
  author   VARCHAR,
  text     VARCHAR,
  datetime TIMESTAMP           DEFAULT now(),
  CONSTRAINT quotes_idx UNIQUE (bot_id, datetime),
  FOREIGN KEY (bot_id) REFERENCES bots (id) ON DELETE CASCADE
);
