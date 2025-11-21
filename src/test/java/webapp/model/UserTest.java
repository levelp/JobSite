package webapp.model;

import org.junit.Assert;
import org.junit.Test;
import webapp.dao.MemoryRepository;
import webapp.dao.Repository;
import webapp.dao.UserMemoryRepository;
import webapp.model.exceptions.EmailExistsException;
import webapp.model.exceptions.NotCorrectEmailException;
import webapp.model.exceptions.NotCorrectPasswordException;

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
        user.setNewPassword("Ud45345435-_");

        // 3. Проверка корректности
        assertTrue(user.validate());

        // 4. Сохранение в постоянное хранилище объектов
        Repository<User> userTable = new MemoryRepository<User>();
        int newId = userTable.insert(user);
        assertEquals(1, newId);
    }

    @Test
    public void validateEmail() throws NotCorrectEmailException, NotCorrectPasswordException {
        User user = new User();
        user.setEmail("test@mail.ru");
        assertTrue(user.validateEmail());

        user.setEmail("test@mail.com.ru");
        assertTrue(user.validateEmail());

        user.setEmail("test212@mail1.com2.com");
        assertTrue(user.validateEmail());

        user.setEmail("john.smith@mail.com.com");
        assertTrue(user.validateEmail());

        user.setEmail("testmail.ru");
        assertFalse(user.validateEmail());

        user.setEmail("test@@mail.ru");
        assertFalse(user.validateEmail());
    }

    @Test
    public void validatePassword() throws NotCorrectEmailException, NotCorrectPasswordException {
        User user = new User("test@mail.com", "Username", "");

        //  try {
        user.setNewPassword("Aa1234567_-");
        assertTrue(user.validate());

        try {
            user.setNewPassword("1Af-_");
            assertFalse(user.validate());
            fail("Пароль слишком короткий, поэтому должно быть исключение");
        } catch (NotCorrectPasswordException ex) {
            assertEquals(User.PASSWORD_TOO_SHORT, ex.getMessage());
        }

        try {
            user.setNewPassword("@#$sdfsFDFS3414");
            assertFalse(user.validate());
            fail("Должно быть исключение NotCorrectPasswordException");
        } catch (NotCorrectPasswordException ex) {
            assertEquals(User.PASSWORD_NOT_MATCH_PATTERN, ex.getMessage());
        }
        // } catch (NotCorrectEmailException e) {
        //     System.err.println("Email не корректный");
        // } catch (NotCorrectPasswordException e) {
        //    System.err.println("Пароль должен содержать не менее 8 символов, буквы латинского алфавита, цифры, знаки дефиса или подчеркивания");
        // }
    }

    /**
     * Проверка, что email-дублируется
     */
    @Test//(expected = EmailExistsException)
    public void duplicateEmail() throws Exception {
        Repository<User> repository = new UserMemoryRepository();
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

    @Test
    public void testCreateFemale() {
        User user = new User();
        User female = user.createFemale("testUser", "test@mail.com", "Test123");
        assertEquals("testUser", female.getUsername());
        assertEquals("test@mail.com", female.getEmail());
        assertEquals("Test123", female.getPassword());
        assertEquals(Sex.WOMAN, female.getSex());
    }

    @Test
    public void testConstructorWithUsernameAndPassword() {
        User user = new User("testUser", "testPassword");
        assertEquals("testUser", user.getUsername());
        assertEquals("testPassword", user.getPassword());
    }

    @Test
    public void testConstructorWithAllParameters() {
        User user = new User("testUser", "test@mail.com", "Test123", Sex.MAN);
        assertEquals("testUser", user.getUsername());
        assertEquals("test@mail.com", user.getEmail());
        assertEquals("Test123", user.getPassword());
        assertEquals(Sex.MAN, user.getSex());
    }

    @Test
    public void testCheckPasswordComplexityNoLowerCaseAndDigits() {
        User user = new User();
        user.setNewPassword("AAAAAAAA");
        String error = user.checkPasswordComplexity();
        assertEquals("Пароль не содержит строчных букв и цифр", error);
    }

    @Test
    public void testCheckPasswordComplexityOnlyDigits() {
        User user = new User();
        user.setNewPassword("12345678");
        String error = user.checkPasswordComplexity();
        assertEquals("Пароль состоит только из цифр", error);
    }

    @Test
    public void testCheckPasswordComplexityNoDigits() {
        User user = new User();
        user.setNewPassword("AaAaAaAa");
        String error = user.checkPasswordComplexity();
        assertEquals("Пароль не содержит цифр", error);
    }

    @Test
    public void testCheckPasswordComplexityValid() {
        User user = new User();
        user.setNewPassword("Aa123456");
        String error = user.checkPasswordComplexity();
        assertNull(error);
    }

    @Test
    public void testGetId() {
        User user = new User();
        assertEquals(1, user.getId());
    }

    @Test
    public void testSetId() {
        User user = new User();
        user.setId(100);
        assertEquals(100, user.getId());
    }

    @Test
    public void testGetNewPassword() {
        User user = new User();
        user.setNewPassword("TestPassword123");
        assertEquals("TestPassword123", user.getNewPassword());
    }

    @Test
    public void testGetSex() {
        User user = new User();
        user.setSex(Sex.MAN);
        assertEquals(Sex.MAN, user.getSex());
    }
}
