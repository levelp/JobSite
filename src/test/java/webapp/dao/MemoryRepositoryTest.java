package webapp.dao;

import org.junit.Assert;
import org.junit.Test;
import webapp.model.User;

/**
 * Tests for MemoryRepository
 */
public class MemoryRepositoryTest extends Assert {

    @Test
    public void testInsert() throws Exception {
        MemoryRepository<User> repository = new MemoryRepository<>();
        User user = new User("testUser");

        int id = repository.insert(user);

        assertEquals(1, id);
        assertEquals(1, user.getId());
    }

    @Test
    public void testInsertMultiple() throws Exception {
        MemoryRepository<User> repository = new MemoryRepository<>();
        User user1 = new User("user1");
        User user2 = new User("user2");
        User user3 = new User("user3");

        int id1 = repository.insert(user1);
        int id2 = repository.insert(user2);
        int id3 = repository.insert(user3);

        assertEquals(1, id1);
        assertEquals(2, id2);
        assertEquals(3, id3);
    }

    @Test
    public void testGet() throws Exception {
        MemoryRepository<User> repository = new MemoryRepository<>();
        User user = new User("testUser");
        int id = repository.insert(user);

        User retrieved = repository.get(id);

        assertNotNull(retrieved);
        assertEquals(user, retrieved);
        assertEquals("testUser", retrieved.getUsername());
    }

    @Test
    public void testGetNonExistent() {
        MemoryRepository<User> repository = new MemoryRepository<>();
        User retrieved = repository.get(999);

        assertNull(retrieved);
    }

    @Test
    public void testGetAfterMultipleInserts() throws Exception {
        MemoryRepository<User> repository = new MemoryRepository<>();
        User user1 = new User("user1");
        User user2 = new User("user2");
        User user3 = new User("user3");

        repository.insert(user1);
        repository.insert(user2);
        repository.insert(user3);

        assertEquals(user1, repository.get(1));
        assertEquals(user2, repository.get(2));
        assertEquals(user3, repository.get(3));
    }
}
