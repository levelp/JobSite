CREATE SEQUENCE user_id;

CREATE TABLE "user" (
  id       INTEGER PRIMARY KEY NOT NULL DEFAULT nextval('user_id'),
  name     CHARACTER VARYING   NOT NULL,
  email    CHARACTER VARYING   NOT NULL,
  password CHARACTER VARYING   NOT NULL,
  sex      CHARACTER VARYING   NOT NULL
);
CREATE UNIQUE INDEX unique_email ON "user" USING BTREE (email);

INSERT INTO "user" (name, email, password, sex)
VALUES ('Иванов Иван Иванович', 'test@mail.ru', '111', 'MALE');

CREATE TABLE resume (
  user_id INT                NOT NULL,
  phone   VARCHAR            NOT NULL,
  text    VARCHAR DEFAULT '' NOT NULL
);
