package ru.fizteh.fivt.students.AndrewTimokhin.FileMap.JUnit;

import java.io.IOException;

/**
 * ����� @class TableProviderImplements �������� ������ �� ������ ����������
 * ���� ������. � ��� �������������� ��� ������, ���������� � ����������
 * TableProvider
 * 
 * @author Timokhin Andrew
 */

public class TableProviderImplements implements TableProvider {

    public TableImplement[] t;
    public final String dir;

    TableProviderImplements(String dir) throws IOException {
        this.dir = dir;
        t = null;
        Reader rd = new Reader();
        rd.read(this);
    }

    public void writer() throws IOException {
        Writer writer = new Writer();
        writer.write(this);
    }

    @Override
    public Table getTable(String name) throws IllegalArgumentException { // ���������
                                                                         // �������
                                                                         // ��
                                                                         // ��
                                                                         // �����
        if (name == null)
            throw new IllegalArgumentException("Error in getTable-meth"); // ������������
                                                                          // ����������,
                                                                          // ����
                                                                          // ���
                                                                          // �������
                                                                          // ������
                                                                          // �����������
        if (t != null) {
            for (int i = 0; i < t.length; i++) {
                if (t[i].getName().equals(name))
                    return t[i]; // ������� �������, ���� ����� ����������

            }
        }
        return null; // ������� null � ������, ���� ������� � ���������
                     // ��������� ���������� �����
    }

    @Override
    public Table createTable(String name) throws IllegalArgumentException { // �������
                                                                            // �������
                                                                            // �
                                                                            // ���������
                                                                            // ������
        if (name == null)
            throw new IllegalArgumentException("Error in createTable-meth"); // ������������
                                                                             // ����������,
                                                                             // ����
                                                                             // ���
                                                                             // �������
                                                                             // ������
                                                                             // �����������
        if (t != null) {
            for (int i = 0; i < t.length; i++) {
                if (name.equals(t[i].getName())) {
                    return null; // ���� ������� � ��������� ������ �����������
                                 // � ��������, ����� ������� null
                }
            }
            {
                TableImplement[] temp = new TableImplement[t.length + 1];
                for (int k = 0; k < t.length; k++) {
                    temp[k] = t[k];
                }

                temp[t.length] = new TableImplement(name, dir);
                t = temp;
                return t[t.length - 1];
            }
        }

        if (t == null) { // �� ������ ������� ��������, ����� ������� �������
                         // (��� ����������� � ��������� ���������)
            t = new TableImplement[1];
            t[0] = new TableImplement(name, dir);
            return t[0];
        }
        return null;
    }

    @Override
    public void removeTable(String name) throws IllegalArgumentException,
            IllegalStateException { // �������� ������� � ��������� ������,
                                    // ��������
        // ��������� ���� ����� ����������
        if (name == null)
            throw new IllegalArgumentException("Error in removeTable-meth"); // ����
                                                                             // ��������
                                                                             // �������
                                                                             // �������,
                                                                             // �����
                                                                             // ����������
                                                                             // ����������
        if (t != null) {
            for (int i = 0; i < t.length; i++) { // ���������� ��������
                                                 // ����������� � ����������
                if (t[i].getName().equals(name)) {
                    t[i].backup = null;
                    t[i].map = null;
                    t[i].name = null;
                    TableImplement[] temp = new TableImplement[t.length - 1];
                    for (int j = 0; j < i; j++) {
                        temp[j] = t[j];
                    }

                    for (int j = i + 1; j < t.length; j++) {
                        temp[j - 1] = t[j];
                    }
                    t = temp;
                    return;
                }
            }
            throw new IllegalStateException("Error in removeTable-meth"); // ����
                                                                          // �������,
                                                                          // ���������������
                                                                          // ���������
                                                                          // name
                                                                          // ��
                                                                          // ������������
            // �� ��������� ���������� ��������� ���������
        }

    }

}
