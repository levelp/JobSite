package model;

import dao.MemoryRepository;
import dao.Repository;
import model.exceptions.EmailExistsException;
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
        Repository<User> userTable = new MemoryRepository<User>();
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

    /**
     * Проверка, что email-дублируется
     */
    @Test//(expected = EmailExistsException)
    public void duplicateEmail() throws Exception {
        Repository<User> repository = new MemoryRepository<User>();
        User user1 = new User("user1");
        user1.setEmail("test@mail.ru");
        repository.insert(user1);

        User user2 = new User("user2");
        user2.setEmail("test@mail.ru");
        try {
            repository.insert(user2);
            fail("Должно быть исключение, т.к. email уже есть в БД");
        } catch (EmailExistsException ex) {
            assertEquals("Пользователь с test@mail.ru уже есть в БД", ex.getMessage());
        }
    }
}
