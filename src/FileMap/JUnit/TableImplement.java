package ru.fizteh.fivt.students.AndrewTimokhin.FileMap.JUnit;

/**
 * ����� TableImplement �������� ������ ������ ������� ���� ������. 
 * � ��� �������������� ��� ������, ������� �������� � ���������� Table
 * 
 * @author Timokhin Andrew
 */

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TableImplement implements Table {

    public String name; // �������� ��� �������
    public String path; // ���� � �������
    public Map<String, String> map; // real-time ������ �����
    public Map<String, String> backup; // ���������� ������ ���� ������

   public TableImplement(String name, String path) {
        this.path = path; // ������������� ���� � ���� ������
        this.name = name; // ������������� ��� ���� ������
        map = new HashMap<String, String>(); // ��������� ����� ��� real-time
                                             // �����
        backup = new HashMap<String, String>(); // ��������� ����� ���
                                                // backup-�����

    }

    @Override
    public String getName() { // ���������� ��� ���� ������
        return name;
    }

    @Override
    public int size() { // ������� ����� ������, �������� � ���� ������.
                        // ���������� �� ���������������.
        int summ = 0; // ����������� ������ ���� ������ �������� ������ 0.
        if (map != null) {
            summ += map.size();// ��������� �������� ����� �������, �������� �
                               // ���� ������.
        }
        return summ;
    }

    @Override
    public String get(String key) throws IllegalArgumentException { // ����������
                                                                    // ��������
                                                                    // ��
                                                                    // ����������
                                                                    // �����
        if (key == null)
            throw new IllegalArgumentException(
                    "Error in get-meth. Key is wrong!"); // ���� ���� null,
                                                         // ����� ������������
                                                         // ����������
        if (map != null)
            if (map.containsKey(key))
                return (String) map.get(key);
        return null;

    }

    @Override
    public String put(String key, String value) throws IllegalArgumentException { // �����
                                                                                  // ������
                                                                                  // ���
                                                                                  // ������
                                                                                  // �����
                                                                                  // �
                                                                                  // ��������
                                                                                  // �
                                                                                  // ����
                                                                                  // ������
        String time = null;
        if (key == null || value == null)
            throw new IllegalArgumentException(
                    "Error in put-meth. Key or (and) value is wrong."); // ����
                                                                        // �������
                                                                        // ������
                                                                        // ���������
        // ���������� ����������
        if (map != null) // ������, ���� ���� ������ ���� �������
            if (map.containsKey(key))
                time = (String) map.get(key);
        map.put(key, value);
        return time; // ��������� �������� ����� ��������������� � ������ ������
        // null- ���� �� ���� ����� ������� ����������
    }

    @Override
    public String remove(String key) throws IllegalArgumentException // �������
                                                                     // ��������
                                                                     // ���������������
                                                                     // �
                                                                     // ������,
                                                                     // ����������
                                                                     // �
                                                                     // ����������
    {
        String time = null;
        if (key == null)
            throw new IllegalArgumentException(
                    "Error in remove-meth. Key is wrong.");
        if (map != null)
            if (map.containsKey(key)) {
                time = (String) map.get(key);
                map.remove(key);
            }
        return time;

    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public List<String> list() { // ������� ������, ����������� ����� ����
                                 // ������
        Set<String> time;
        if (map != null) {
            time = map.keySet(); // ��������� ������, �������� � ���� ������ �
                                 // ������ ������
            List<?> list = new ArrayList(time);
            return (List<String>) list;
        }
        return (List<String>) (new ArrayList());
    }

    @Override
    public int commit() {
        int counter = 0;
        if (backup == null && map == null)
            return 0; // ��������� ���, �� ����� ���������
        if (backup != null && map == null)
            counter= backup.size(); // ������� ��������� ���� ������ �����, �
                                  // ������ ���� ������, ������������ ����������
        if (backup == null && map != null)
            counter = map.size(); // ����������
         if (backup != null && map != null) {
        Set<String> time = backup.keySet();
        for (String time1 : time) {

            if (backup.get(time1).equals(map.get(time1)) == false)
                counter++; // ���� ������ � ���� �� ����� ������������� ������
                           // ��������
            // �� ����� �������, ��� ����� ��������
            else if (backup.containsKey(time1)
                    && map.containsKey(time1) == false)
                counter++;
        }
        time = map.keySet();
        for (String time1 : time) {

            if ((backup.containsKey(time1) && map.containsKey(time1)) == false) {
                // ����������, ������, ���� ���� ���� ��� ������, � ������ ���
                // ��������, �� ���������� ��� ���� ����������� 2 ���������
                counter++;
            }
        }}
        System.out.println("in this method counter is ==> " + counter);
        if (counter != 0) // ���� ���� ��������� ���������� ��������� ������ ��
                          // ������� ����
            try {

                this.writeToDisk();
            } catch (IOException e) {
                // do nothing
            }

        return counter; // ������������� ����� ������� ����� ���������
    }

    public void writeToDisk() throws IOException { // �����, �������
                                                   // ������������ ���������
                                                   // ��������� �� ����
        int flag = 0;
        Reader rd = new Reader();
        TableProviderImplements tpi = new TableProviderImplements(path);
        rd.read(tpi); // ���������, ��������� �� �����
        Writer writer = new Writer();
        if (tpi.t != null) {
            for (int i = 0; i < tpi.t.length; i++) {
                if (tpi.t[i].getName().equals(this.getName())) {

                    {
                        Map<String, String> tmp = new HashMap<String, String>();
                        @SuppressWarnings("unchecked")
                        Set<String> copy = tpi.t[i].map.keySet();
                        for (String time : copy) {

                            tmp.put(new String(time),
                                    new String(tpi.t[i].map.get(time)));
                        }
                        this.backup = new HashMap<String, String>(tmp);
                        ;

                    }

                    tpi.t[i] = this;
                    flag = 1;
                }

            }

        }
        if (flag == 0) {
            tpi.createTable(this.name);
            this.backup = null;
        }
        for (int i = 0; i < tpi.t.length; i++) {
            if (tpi.t[i].getName().equals(this.getName()))
                tpi.t[i] = this;

        }

        writer.write(tpi);
        if (this.map == null) {
            this.commit();

        }

    }

    @Override
    public int rollback() { // �������� �� ����� � ����������� ��������� (�
                            // ������ ���������� �������)
        Map<String, String> time = new HashMap<String, String>(this.map);
        this.map = new HashMap<String, String>(this.backup);
        this.backup = time;
        this.commit();

        return 0;
    }
}
