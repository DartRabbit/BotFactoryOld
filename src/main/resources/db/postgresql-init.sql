DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS type_of_bot;
DROP TABLE IF EXISTS quotes;
DROP TABLE IF EXISTS bots;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS global_seq;
DROP SEQUENCE IF EXISTS quotes_seq;

CREATE SEQUENCE global_seq START 100000;
CREATE SEQUENCE quotes_seq START 100000;

CREATE TABLE users
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name       VARCHAR(255)             NOT NULL,
  email      VARCHAR(255)             NOT NULL,
  password   VARCHAR(255)             NOT NULL,
  registered TIMESTAMP DEFAULT now()  NOT NULL,
  enabled    BOOLEAN DEFAULT FALSE    NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx
  ON USERS (email);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR(255),
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES USERS (id) ON DELETE CASCADE
);

CREATE TABLE type_of_bot
(
  id          INTEGER,
  name        VARCHAR(255),
  description VARCHAR(255),
  pict_file   VARCHAR(255)
);

CREATE TABLE bots
(
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name        VARCHAR(255)             NOT NULL,
  token       VARCHAR                  NOT NULL,
  description VARCHAR(255)             NOT NULL,
  registered  TIMESTAMP DEFAULT now()  NOT NULL,
  enabled     BOOLEAN DEFAULT FALSE    NOT NULL,
  type        INTEGER                  NOT NULL,
  user_id     INTEGER                  NOT NULL,
  FOREIGN KEY (user_id) REFERENCES USERS (id) ON DELETE CASCADE
);

CREATE UNIQUE INDEX bots_unique_user_name_idx
  ON bots (user_id, name);

CREATE TABLE quotes
(
  id     INTEGER PRIMARY KEY DEFAULT nextval('quotes_seq'),
  text   VARCHAR NOT NULL,
  author VARCHAR(255),
  bot_id INTEGER NOT NULL,
  FOREIGN KEY (bot_id) REFERENCES bots (id) ON DELETE CASCADE
);

CREATE UNIQUE INDEX quotes_bot_id_text_author
  ON quotes (bot_id, text, author);