package examples.xml;

import dao.Repository;
import dao.XMLFileRepository;
import model.User;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Тестируем сохранение и загрузку
 */
public class MyClassXMLTest extends Assert {

    public static final String FILENAME = "test.xml";

    @Test
    public void testSaveLoad() throws Exception {
        MyClass myClass = new MyClass();
        myClass.setName("Петя");
        myClass.setAge(22);
        XMLHelper.write(myClass, FILENAME);

        File f = new File(FILENAME);
        assertTrue(f.exists());
        assertFalse(f.isDirectory());
        assertTrue(new File(FILENAME).isFile());

        // Считываем обратно
        MyClass f2 = (MyClass) XMLHelper.read(FILENAME);
        System.out.println("Прочитали: " + f2.getName());
    }

    @Test
    public void testSaveLoadArrayOfObjects() throws Exception {
        List<User> list = new ArrayList<User>();
        list.add(new User("User1"));
        list.add(new User("User2"));
        list.add(new User("User3"));

        XMLHelper.write(list, "list.xml");

        List<User> newList = (ArrayList<User>) XMLHelper.read("list.xml");

        assertEquals("User1", newList.get(0).getUsername());
        assertEquals("User2", newList.get(1).getUsername());
        assertEquals("User3", newList.get(2).getUsername());
    }

    @Test
    public void testSaveLoadRepositoryObjects() throws Exception {
        XMLFileRepository xmlFileRepository =
                new XMLFileRepository("users.xml");

        Repository<User> repository = xmlFileRepository;
        repository.insert(new User("User1"));
        repository.insert(new User("User2"));
        repository.insert(new User("User3"));

        xmlFileRepository.save();

        XMLFileRepository newXmlFileRepository = new XMLFileRepository("users.xml");
        newXmlFileRepository.load();

        Repository<User> rep = newXmlFileRepository;

        assertEquals("User1", rep.get(0).getUsername());
        assertEquals("User2", rep.get(0).getUsername());
        assertEquals("User2", rep.get(0).getUsername());
    }


}