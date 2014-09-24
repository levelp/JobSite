package model;

import dao.MemoryRepository;
import dao.Repository;
import org.junit.Assert;
import org.junit.Test;

/**
 * Базовые операции с пользователями
 */
public class UserTest extends Assert {
    /**
     * Создание нового пользователя
     */
    @Test
    public void createNewUser() {
        // 1. Создаём объект
        User user = new User();

        assertEquals(1, user.id);
    }

    /**
     * Регистрация пользователя: успешная
     */
    @Test
    public void regNewUser() throws Exception {
        // 1. Создаём объект
        User user = new User();
        // 2. Заполнение полей объекта
        // Показываем страницу для заполнения
        user.setEmail("test@mail.ru");

        // 3. Проверка корректности
        assertTrue(user.validate());

        // 4. Сохранение в постоянное хранилище объектов
        Repository<User> userTable = new MemoryRepository();
        int newId = userTable.insert(user);
        assertEquals(1, newId);
    }

    @Test
    public void validateEmail() {
        User user = new User();
        user.setEmail("test@mail.ru");
        assertTrue(user.validate());

        user.setEmail("test@mail.com.ru");
        assertTrue(user.validate());

        user.setEmail("test212@mail1.com2.com");
        assertTrue(user.validate());

        user.setEmail("john.smith@mail.com.com");
        assertTrue(user.validate());

        user.setEmail("testmail.ru");
        assertFalse(user.validate());

        user.setEmail("test@@mail.ru");
        assertFalse(user.validate());
    }
}
