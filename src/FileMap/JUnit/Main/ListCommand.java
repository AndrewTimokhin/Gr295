/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.fizteh.fivt.students.AndrewTimokhin.FileMap.JUnit.Main;

import ru.fizteh.fivt.students.AndrewTimokhin.FileMap.JUnit.Interpretator.Commands;
import java.util.ArrayList;
import ru.fizteh.fivt.students.AndrewTimokhin.FileMap.DataBase.KeyNullAndNotFound;
import ru.fizteh.fivt.students.AndrewTimokhin.FileMap.DataBase.TableProviderImplements;

/**
 *
 * @author Андрей
 */
public class ListCommand extends Commands {

    public ListCommand() {
        super(1);
    }

    @Override
    public boolean execute(String[] commands, TableProviderImplements tableProvider) {
        if (currentTable == null) {
            System.out.println("No table");
            return true;
        } else {
            ArrayList<String> set;
            set = (ArrayList<String>) currentTable.list();
            for (String key : set) {
                try {
                    System.out.println(key + " " + currentTable.get(key));
                } catch (KeyNullAndNotFound ex) {
                    System.out.println("Null key is wrong!");
                }
            }
        }
        return true;
    }

}