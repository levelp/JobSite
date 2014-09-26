package model;

import dao.MemoryRepository;
import dao.Repository;
import model.exceptions.NotCorrectEmailException;
import model.exceptions.NotCorrectPasswordException;
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
        user.setUsername("testUser");
        user.setPassword("Ud45345435-_");

        // 3. Проверка корректности
        assertTrue(user.validate());

        // 4. Сохранение в постоянное хранилище объектов
        Repository<User> userTable = new MemoryRepository<User>();
        int newId = userTable.insert(user);
        assertEquals(1, newId);
    }

    @Test
    public void validateEmail() {
        User user = new User("usertest", "password");
        user.setEmail("test@mail.ru");

        try {
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
        } catch (NotCorrectEmailException e) {
            System.err.println("Email не корректный");
        } catch (NotCorrectPasswordException e) {
            System.err.println("Пароль должен содержать не менее 8 символов, буквы латинского алфавита, цифры, знаки дефиса или подчеркивания");
        }
    }

    @Test
    public void validatePassword() {
        User user = new User("test@mail.com", "Username", "");

        try {
            user.setPassword("Aa1234567_-");
            assertTrue(user.validate());

            user.setPassword("1Af-_");
            assertFalse(user.validate());

            user.setPassword("@#$sdfsFDFS3414");
            assertFalse(user.validate());
        } catch (NotCorrectEmailException e) {
            System.err.println("Email не корректный");
        } catch (NotCorrectPasswordException e) {
            System.err.println("Пароль должен содержать не менее 8 символов, буквы латинского алфавита, цифры, знаки дефиса или подчеркивания");
        }
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
        } catch (NotCorrectEmailException ex) {
            assertEquals("Пользователь с test@mail.ru уже есть в БД", ex.getMessage());
        }
    }
}
