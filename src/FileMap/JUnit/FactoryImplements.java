package ru.fizteh.fivt.students.AndrewTimokhin.FileMap.JUnit;

import java.io.IOException;

/**
 * ����� @class FactoryImplements �������� �� ������� �� �������� ������.
 * ������������� ��������� TableProviderFactory, �������������� ����� ��
 * �������� ���������� ���� ������.
 *
 * @author Timokhin Andrew
 */

public class FactoryImplements implements TableProviderFactory {

    @Override
    public TableProvider create(String dir) {
        if (dir == null)
            throw new IllegalArgumentException("Error in create-meth.");
        // then, generate exception
        try {
            return new TableProviderImplements(dir);
        } catch (IOException e) {
            // do nothing
        }
        return null;
    }
}