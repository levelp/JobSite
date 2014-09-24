package examples.xml;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

/**
 * Тестируем сохранение и загрузку
 */
public class MyClassXMLTest extends Assert {

    public static final String FILENAME = "test.xml";

    @Test
    public void testSaveLoad() throws Exception {
        MyClass myClass = new MyClass();
        myClass.setName("Петя");
        MyClassHelper.write(myClass, FILENAME);

        File f = new File(FILENAME);
        assertTrue(f.exists());
        assertFalse(f.isDirectory());
        assertTrue(new File(FILENAME).isFile());

        // Считываем обратно
        MyClass f2 = MyClassHelper.read(FILENAME);
        System.out.println("Прочитали: " + f2.getName());
    }


}