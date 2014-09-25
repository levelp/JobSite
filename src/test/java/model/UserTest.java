package model;

import dao.MemoryRepository;
import dao.Repository;
import model.exceptions.EqualityException;
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
    @Test
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
        } catch (EqualityException ex) {
            assertEquals("Пользователь с test@mail.ru уже есть в БД", ex.getSuppressed()[0].getMessage());
        }
    }

    /**
     * Проверка, что имя дублируется
     */
    @Test
    public void duplicateName() throws Exception {
        Repository<User> repository = new MemoryRepository<User>();
        User user1 = new User("user1");
        User user2 = new User("user1");

        repository.insert(user1);

        try {
            repository.insert(user2);
            fail("Должно быть исключение, т.к. такой имя уже есть в БД");
        } catch (EqualityException ex) {
            assertEquals("Пользователь с именеме user1 уже есть в БД", ex.getSuppressed()[0].getMessage());
        }
    }

    /**
     * Проверка что имя не null, не пробел, содержит только буквы, цифры и тире
     */
    @Test
    public void validateName() {
        User user = new User();

        // обычное имя
        user.setUsername("Name Name");
        assertTrue(user.validate());
        // составные имена
        user.setUsername("FirstName-SecondName Name");
        assertTrue(user.validate());
        user.setUsername("FirstName-SecondName-ThirdName");
        assertTrue(user.validate());
        // содержит цифры
        user.setUsername("1user3");
        assertTrue(user.validate());

        // имя == null
        user.setUsername(null);
        assertFalse(user.validate());
        // пустое имя
        user.setUsername("");
        assertFalse(user.validate());
        // имя == пробел(ы)
        user.setUsername(" ");
        assertFalse(user.validate());
        user.setUsername("  ");
        assertFalse(user.validate());
        user.setUsername("      ");
        assertFalse(user.validate());
        // содержит два тире подряд
        user.setUsername("FirstName--SecondName");
        assertFalse(user.validate());
        // содержит прочие символы
        user.setUsername("!Name@#");
        assertFalse(user.validate());
    }

    /**
     * Сохранение и восстановление нескольких разных пользователей в репозиторий в памяти
     */
    @Test
    public void insertAndGetUsers() throws Exception {
        Repository<User> users = new MemoryRepository<User>();
        User user1 = new User("User1");
        User user2 = new User("User2");
        User user3 = new User("User3");
        User user4 = new User("User4");

        assertEquals(1, users.insert(user1));
        assertEquals(2, users.insert(user2));
        assertEquals(3, users.insert(user3));
        assertEquals(4, users.insert(user4));

        assertEquals(user1, users.get(1));
        assertEquals(user2, users.get(2));
        assertEquals(user3, users.get(3));
        assertEquals(user4, users.get(4));

        assertNotEquals(user1, users.get(2));
    }


}
