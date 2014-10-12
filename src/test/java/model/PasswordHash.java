package model;

import org.junit.Assert;
import org.junit.Test;
import util.HashUtil;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Хеширование паролей
 */
public class PasswordHash extends Assert {

    /**
     * Встроенные функции для хеширования данных
     * https://ru.wikipedia.org/wiki/MD5
     */
    @Test
    public void hashFunctions() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        // TODO: посмотреть стандартные функции
        String newPassword = "test";
        assertEquals("1bc29b36f623ba82aaf6724fd3b16718", HashUtil.md5("md5"));
    }


    /**
     * Проверка правильности хеширования пароля
     */
    @Test
    public void checkPassword() {

        // Ставим новый пароль
        // Сохраняем пользователя в БД

        // Загружаем пользователя из БД обратно
        // Проверяем, что пароль подходит,
        // а другой (отличающийся) - нет (негативная проверка)
    }

}
