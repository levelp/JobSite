package dao;

import model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by vladimir on 03.10.14.
 */
public class DBUserRepository extends DBRepository<User> implements Repository<User> {

    public DBUserRepository() throws SQLException, ClassNotFoundException {
        super();
    }

    @Override
    public int insert(User newUser) throws Exception {
        String newUserQuery = "INSERT INTO user (name, email, password, sex) " +
                "VALUES ('" + newUser.getUsername() + "','" + newUser.getEmail() + "','" + newUser.getNewPassword() +
                "','" + newUser.getSex() + "')";
        System.out.println(newUserQuery);
        statement.execute(newUserQuery);

        String selectIdQuery = "SELECT id FROM user WHERE email='" + newUser.getEmail() + "'";
        ResultSet rs = statement.executeQuery(selectIdQuery);
        rs.next();
        newUser.setId(rs.getInt("id"));
        return newUser.getId();
    }

    @Override
    public User get(int id) throws Exception {
        String query = "SELECT * FROM user WHERE id=" + id;
        ResultSet rs = statement.executeQuery(query);
        rs.next();

        User user = new User();
        user.setId(rs.getInt("id"));
        user.setEmail(rs.getString("email"));
        user.setNewPassword(rs.getString("password"));
        user.setUsername(rs.getString("name"));
        user.setSex(rs.getString("sex"));

        return user;
    }
}
