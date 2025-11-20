package webapp.dao;

import org.junit.Assert;
import org.junit.Test;
import webapp.model.User;
import webapp.model.exceptions.EmailExistsException;

/**
 * Tests for UserMemoryRepository
 */
public class UserMemoryRepositoryTest extends Assert {

    @Test
    public void testInsertUserWithUniqueEmail() throws Exception {
        UserMemoryRepository repository = new UserMemoryRepository();
        User user = new User("testUser");
        user.setEmail("test@example.com");

        int id = repository.insert(user);

        assertEquals(1, id);
        assertEquals(user, repository.get(id));
    }

    @Test
    public void testInsertMultipleUsersWithDifferentEmails() throws Exception {
        UserMemoryRepository repository = new UserMemoryRepository();
        User user1 = new User("user1");
        user1.setEmail("user1@example.com");
        User user2 = new User("user2");
        user2.setEmail("user2@example.com");

        int id1 = repository.insert(user1);
        int id2 = repository.insert(user2);

        assertEquals(1, id1);
        assertEquals(2, id2);
    }

    @Test
    public void testInsertUserWithDuplicateEmail() throws Exception {
        UserMemoryRepository repository = new UserMemoryRepository();
        User user1 = new User("user1");
        user1.setEmail("test@example.com");
        repository.insert(user1);

        User user2 = new User("user2");
        user2.setEmail("test@example.com");

        try {
            repository.insert(user2);
            fail("Expected EmailExistsException");
        } catch (EmailExistsException e) {
            assertEquals("Пользователь с test@example.com уже есть в БД", e.getMessage());
        }
    }

    @Test
    public void testGetUserById() throws Exception {
        UserMemoryRepository repository = new UserMemoryRepository();
        User user = new User("testUser");
        user.setEmail("test@example.com");
        int id = repository.insert(user);

        User retrieved = repository.get(id);

        assertNotNull(retrieved);
        assertEquals(user, retrieved);
    }
}
