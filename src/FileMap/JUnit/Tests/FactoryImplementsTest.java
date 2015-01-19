/*
 * �������� ������ ��� ������ FactoryImplements
 * ������ ����� � ������ ������ ��������� ����������������
 * ���������������� ������, ������� ��������� ������
 */
package ru.fizteh.fivt.students.AndrewTimokhin.FileMap.JUnit;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ������
 */
public class FactoryImplementsTest {
 private final Map agregaret = new HashMap(); 
     
    /**
     * ���� �������� �� �������� ��������� ���������� IllegalArgumentException
     * ��� ������� ������� ���������� ���� ������ � ������ �������� �����������.
     * ����� ������������ �������� ���������� ���� ������ � ���������� �����������.
     * @throws java.io.IOException
     */

    @Test 
    public void testCreate() throws IOException {
        TableProviderImplements resultOne = (TableProviderImplements) new FactoryImplements().create("C:\\DataBase");
        assertEquals("C:\\DataBase",resultOne.dir );}
    
    @Test(expected = IllegalArgumentException.class) 
    public void testCreateCorrect() 
    {
        String dir = null;
        TableProvider result = new FactoryImplements().create(dir);
    }
    
        
}
