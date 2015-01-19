package ru.fizteh.fivt.students.AndrewTimokhin.FileMap.JUnit;

import java.io.IOException;

/**
 * Класс @class FactoryImplements отвечает за фабрику по созданию таблиц.
 * Имплиментируя интерфейс TableProviderFactory, переопределяет метод по
 * созданию провайдера базы данных.
 *
 * @author Timokhin Andrew
 */

public class FactoryImplements implements TableProviderFactory {

    @Override
    public TableProvider create(String dir) {
        if (dir == null)
            throw new IllegalArgumentException("Error in create-meth."); // если
                                                                         // в
                                                                         // параметрах
                                                                         // указана
        // неверный путь к директории,
        // генерируется исключение
        try {
            return new TableProviderImplements(dir); // иначе, предпринимаеться
                                                     // попытка по созданию
            // провайдера базы данных
        } catch (IOException e) {
            // do nothing
        }
        return null;
    }
}