package examples.xml;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Вспомогательный класс, который умеет сохранять и загружать наш объект
 */
public class XMLHelper {
    /**
     * Запись объекта в XML-файл
     *
     * @param obj      Объект
     * @param filename XML-файл
     * @throws Exception
     */
    public static void write(Object obj, String filename) throws Exception {
        XMLEncoder encoder =
                new XMLEncoder(
                        new BufferedOutputStream(
                                new FileOutputStream(filename)));
        encoder.writeObject(obj);
        encoder.close();
    }

    /**
     * Чтение из XML-файла
     *
     * @param filename Имя файла
     * @return Объект
     * @throws Exception
     */
    public static Object read(String filename) throws Exception {
        XMLDecoder decoder =
                new XMLDecoder(new BufferedInputStream(
                        new FileInputStream(filename)));
        Object o = decoder.readObject();
        decoder.close();
        return o;
    }
}