JobSite - сайт поиска работы
============================

Совместный проект участников курса Java Junior Developer 

Используемая БД: PostgreSQL

``` java
int x = 1;
System.out.println(x);
```

Книга про Git: http://git-scm.com/book/ru

Подготовка и запуск проекта
---------------------------
* Устанавливаем apache tomcat
* Устанавливаем apache maven
* Устанавливаем и настраиваем БД PostgeSQL
* Создаём схему и загружаем тестовые данные в БД
* Запускаем проект

Настройка проекта
-----------------
* Сервис: postgresql-x64-9.3
* Конфигурация: C:\Program Files\PostgreSQL\9.3\data\postgresql.conf
* PgAdmin III:  логин: postgres, пароль: admin (или тот, который вы задали при установке)
* Создаю БД jobsite
* Подключаюсь из Intellij Idea: View -> Tool windows -> Database.

Пользователь и его резюме
``` sql 
SELECT * FROM "user" LEFT JOIN resume ON "user".id = resume.user_id 
```

``` sql
SELECT * FROM "user" INNER JOIN resume ON "user".id = resume.user_id 
SELECT * FROM "user" JOIN resume ON "user".id = resume.user_id 
```

Все строки
``` sql 
SELECT * FROM "user" FULL OUTER JOIN resume ON "user".id = resume.user_id 
```

``` sql
SELECT * FROM "user" RIGHT JOIN resume ON "user".id = resume.user_id 
```

``` sql
SELECT phone, text, (SELECT name FROM "user" WHERE id = user_id) AS user_name FROM resume
```

