package webapp.dao;

import webapp.model.User;
import webapp.model.exceptions.EmailExistsException;

import java.util.HashSet;
import java.util.Set;

/**
 * Специальное хранилище для пользователей
 */
public class UserMemoryRepository extends MemoryRepository<User> {

    Set<String> allEmails = new HashSet<String>();

    @Override
    public int insert(User obj) throws Exception {
        // Проверяем, что пользователя с таким email ещё нет
        String email = obj.getEmail();
        if (allEmails.contains(email))
            throw new EmailExistsException("Пользователь с " + email + " уже есть в БД");
        allEmails.add(email);

        return super.insert(obj);
    }
}
