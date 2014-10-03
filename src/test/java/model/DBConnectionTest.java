package model;

import dao.DBRepository;
import dao.DBUserRepository;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

/**
 * Created by vladimir on 03.10.14.
 */
public class DBConnectionTest extends Assert {

    @Test
    public void connectionTest() {
        try {
            DBRepository dbRepository = new DBUserRepository();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insertUserTest() throws Exception {
        DBUserRepository dbUserRepository = new DBUserRepository();
        assertEquals(3, dbUserRepository.insert(new User("TestUser","test2@mail.com","pP1234567",Sex.MAN)));
    }

    @Test
    public void selectUserTest() throws Exception {
        DBUserRepository dbUserRepository = new DBUserRepository();
        User user = dbUserRepository.get(3);
        assertEquals(3, user.getId());
        System.out.println(user);
    }
}
