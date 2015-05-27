-- DROP TABLE "user";
-- DROP SEQUENCE user_id;
-- DROP TABLE resume;

-- Создаём последовательность user_id
CREATE SEQUENCE user_id;

-- Создаём таблицу user
CREATE TABLE "user" (
  id       INTEGER PRIMARY KEY NOT NULL DEFAULT nextval('user_id'),
  name     CHARACTER VARYING   NOT NULL,
  email    CHARACTER VARYING   NOT NULL,
  password CHARACTER VARYING   NOT NULL,
  sex      CHARACTER VARYING   NOT NULL
);
-- e-mail в БД уникальный
CREATE UNIQUE INDEX unique_email ON "user" USING BTREE (email);

-- Добавляем тестовые данные
INSERT INTO "user" (name, email, password, sex)
VALUES ('Иванов Иван Иванович', 'test@mail.ru', '111', 'MALE');
INSERT INTO "user" (name, email, password, sex)
VALUES ('Петров Пётр Петрович', 'petrov@mail.ru', '444', 'MALE');
INSERT INTO "user" (name, email, password, sex)
VALUES ('Петров Иван', 'pivan@mail.ru', '11', 'MALE');
INSERT INTO "user" (email, name, password, sex)
VALUES ('dfd@gmail.com', 'Иванов Пётр', '32', 'MALE');
INSERT INTO "user" (name, email, password, sex)
VALUES ('Чубайс Пётр Иванович', 'mail2@gmail.com', '32', 'MALE');
INSERT INTO "user" (name, email, password, sex)
VALUES ('Иванов Пётр Иванович', 'mail3@gmail.com', '32', 'MALE');
INSERT INTO "user" (name, email, password, sex)
VALUES ('Путин Пётр Иванович', 'putin@gmail.com', '32', 'MALE');


-- Создаём таблицу resume
CREATE TABLE resume (
  user_id INT                NOT NULL,
  phone   VARCHAR            NOT NULL,
  text    VARCHAR DEFAULT '' NOT NULL
);

INSERT INTO resume (user_id, phone, text) VALUES (1, '+79117123122', 'Текст резюме ');
