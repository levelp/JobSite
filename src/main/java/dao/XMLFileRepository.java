package dao;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Хранение в XML файле
 */
public class XMLFileRepository<T extends Entity> extends MemoryRepository<T> {
    private final String fileName;

    public XMLFileRepository(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Запись объекта в XML-файл
     *
     * @param obj      Объект
     * @param filename XML-файл
     * @throws Exception
     */
    private static void write(Object obj, String filename) throws Exception {
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
    private static Object read(String filename) throws Exception {
        XMLDecoder decoder =
                new XMLDecoder(new BufferedInputStream(
                        new FileInputStream(filename)));
        Object o = decoder.readObject();
        decoder.close();
        return o;
    }

    /**
     * Сохраняем таблицу объектов в файл
     *
     * @throws Exception
     */
    public void save() throws Exception {
        write(table, fileName);
    }

    /**
     * Загружаем из файла
     *
     * @throws Exception
     */
    public void load() throws Exception {
        table = (java.util.HashMap<Integer, T>) read(fileName);
    }
}
