/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.fizteh.fivt.students.AndrewTimokhin.FileMap.JUnit.Interpretator;

import java.util.HashMap;
import java.util.Map;
import ru.fizteh.fivt.students.AndrewTimokhin.FileMap.DataBase.TableImplement;
import ru.fizteh.fivt.students.AndrewTimokhin.FileMap.DataBase.TableProviderImplements;
import ru.fizteh.fivt.students.AndrewTimokhin.FileMap.JUnit.Main.CommitCommand;
import ru.fizteh.fivt.students.AndrewTimokhin.FileMap.JUnit.Main.CreateCommand;
import ru.fizteh.fivt.students.AndrewTimokhin.FileMap.JUnit.Main.DropCommand;
import ru.fizteh.fivt.students.AndrewTimokhin.FileMap.JUnit.Main.ExitCommand;
import ru.fizteh.fivt.students.AndrewTimokhin.FileMap.JUnit.Main.GetCommand;
import ru.fizteh.fivt.students.AndrewTimokhin.FileMap.JUnit.Main.ListCommand;
import ru.fizteh.fivt.students.AndrewTimokhin.FileMap.JUnit.Main.PutCommand;
import ru.fizteh.fivt.students.AndrewTimokhin.FileMap.JUnit.Main.RemoveCommand;
import ru.fizteh.fivt.students.AndrewTimokhin.FileMap.JUnit.Main.RollbackCommand;
import ru.fizteh.fivt.students.AndrewTimokhin.FileMap.JUnit.Main.SizeCommand;
import ru.fizteh.fivt.students.AndrewTimokhin.FileMap.JUnit.Main.UseCommand;

/**
 *
 * @author Андрей
 */
public class Commands {

    private Map<String, Commands> TotalCommands;

    int digital;
    public static TableImplement currentTable;

    public Commands(int digital) {
        this.digital = digital;

    }

    public Commands() {
    }

    public Map<String, Commands> getAllCommand() {
        TotalCommands = new HashMap<>();
        TotalCommands.put("create", new CreateCommand());
        TotalCommands.put("put", new PutCommand());
        TotalCommands.put("get", new GetCommand());
        TotalCommands.put("remove", new RemoveCommand());
        TotalCommands.put("drop", new DropCommand());
        TotalCommands.put("commit", new CommitCommand());
        TotalCommands.put("rollback", new RollbackCommand());
        TotalCommands.put("use", new UseCommand());
        TotalCommands.put("size", new SizeCommand());
        TotalCommands.put("list", new ListCommand());
        TotalCommands.put("exit", new ExitCommand());
        return TotalCommands;
    }

    public boolean checkAndRun(String[] command, TableProviderImplements table) {
        if (this.invitationToRepeat(command, digital)) {
            return true;
        }
        return this.execute(command, table);

    }

    public boolean execute(String[] command, TableProviderImplements table) {
        return true; 
    }

    public boolean invitationToRepeat(String[] args, int checkValue) {

        if (args.length != checkValue) {
            System.out
                    .println("Current command was not recognized or not complete. Please, try again");
            return true;
        }
        return false;
    }

}
