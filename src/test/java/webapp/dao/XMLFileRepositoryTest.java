package webapp.dao;

import org.junit.Assert;
import org.junit.Test;
import webapp.model.User;

import java.io.File;

/**
 * Tests for XMLFileRepository
 */
public class XMLFileRepositoryTest extends Assert {

    @Test
    public void testConstructor() {
        XMLFileRepository<User> repository = new XMLFileRepository<>("test.xml");
        assertNotNull(repository);
    }

    @Test
    public void testInsertAndSave() throws Exception {
        String fileName = "test_users.xml";
        File file = new File(fileName);

        try {
            XMLFileRepository<User> repository = new XMLFileRepository<>(fileName);
            User user = new User("testUser");
            user.setEmail("test@example.com");

            int id = repository.insert(user);
            assertEquals(1, id);

            // Save to file
            repository.save();

            // Verify file was created
            assertTrue(file.exists());
        } finally {
            // Cleanup
            if (file.exists()) {
                file.delete();
            }
        }
    }

    @Test
    public void testSaveAndLoad() throws Exception {
        String fileName = "test_save_load.xml";
        File file = new File(fileName);

        try {
            // Create repository and add users
            XMLFileRepository<User> repository1 = new XMLFileRepository<>(fileName);
            User user1 = new User("user1");
            user1.setEmail("user1@example.com");
            User user2 = new User("user2");
            user2.setEmail("user2@example.com");

            repository1.insert(user1);
            repository1.insert(user2);
            repository1.save();

            // Create new repository and load
            XMLFileRepository<User> repository2 = new XMLFileRepository<>(fileName);
            repository2.load();

            // Verify data was loaded
            User loaded1 = repository2.get(1);
            User loaded2 = repository2.get(2);

            assertNotNull(loaded1);
            assertNotNull(loaded2);
            assertEquals("user1", loaded1.getUsername());
            assertEquals("user2", loaded2.getUsername());
        } finally {
            // Cleanup
            if (file.exists()) {
                file.delete();
            }
        }
    }

    @Test
    public void testGet() throws Exception {
        XMLFileRepository<User> repository = new XMLFileRepository<>("test.xml");
        User user = new User("testUser");
        user.setEmail("test@example.com");

        int id = repository.insert(user);
        User retrieved = repository.get(id);

        assertNotNull(retrieved);
        assertEquals(user, retrieved);
    }
}
