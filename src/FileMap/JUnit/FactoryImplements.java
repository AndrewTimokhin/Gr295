package ru.fizteh.fivt.students.AndrewTimokhin.FileMap.JUnit;

import java.io.IOException;

/**
 *  ласс @class FactoryImplements отвечает за фабрику по созданию таблиц.
 * »мплиментиру€ интерфейс TableProviderFactory, переопредел€ет метод по
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
        // генерируетс€ исключение
        try {
            return new TableProviderImplements(dir); // иначе, предпринимаетьс€
                                                     // попытка по созданию
            // провайдера базы данных
        } catch (IOException e) {
            // do nothing
        }
        return null;
    }
}
