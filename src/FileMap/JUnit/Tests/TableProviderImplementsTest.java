/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.fizteh.fivt.students.AndrewTimokhin.FileMap.JUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

/**
 *
 * @author ������
 */
public class TableProviderImplementsTest {
    @Rule 
    public TemporaryFolder tmp = new TemporaryFolder();
    public TableProvider tp;
  
 
    @Before
    public void setUp() {
       TableProviderFactory tpv = new   FactoryImplements ();
       tp = tpv.create(tmp.newFolder("time").getAbsolutePath());
    }
     /**
     * ��������� ����� ��������� ��������� ���������� ����������
     */
    
    /**
     * ����� getTable ������
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetTable() {
        tp.getTable(null);
    }
    
    @Test 
    public void testGetTableNormal() {
        tp.createTable("test");
        assertNotNull(tp.getTable("test"));
    }

     @Test 
    public void testGetTableIfDnExist() {
        tp.createTable("test");
        assertNull(tp.getTable("blablabla"));
    }
    /**
     * �����  createTable ������
     */
    
    @Test(expected = IllegalArgumentException.class)
    public void testCreateTable() {
        tp.createTable(null);
    }
    
    @Test //� ������ ����� ������� ���������� ��� �����
    public void testCreateTableIfExist() {
        assertNotNull(tp.createTable("test"));
         assertNull(tp.createTable("test"));
    }
    

    /**
     * ����� removeTable ������
     */
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveTable() {
         tp.removeTable(null);
         
         
    }
    
    @Test(expected = IllegalStateException.class)
    public void testRemoveTableDnExist() {
        
         tp.removeTable("test");
                
    }
    
    @Test 
    public void testRemoveTableIfExist() {
        tp.createTable("test");
         tp.removeTable("test");
        assertNull( tp.getTable("test"));
                
    }
    
}
