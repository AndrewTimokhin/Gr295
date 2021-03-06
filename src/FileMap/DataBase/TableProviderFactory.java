package ru.fizteh.fivt.students.AndrewTimokhin.FileMap.DataBase;

public interface TableProviderFactory {

    /**
     * Возвращает объект для работы с базой данных.
     *
     * @param dir Директория с файлами базы данных.
     * @return Объект для работы с базой данных.
     * @throws IllegalArgumentException Если значение директории null или имеет
     * недопустимое значение.
     */
    TableProvider create(String dir);
}
