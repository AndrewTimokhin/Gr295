package ru.fizteh.fivt.students.AndrewTimokhin.MultiDataBase;

import java.io.*;
import java.util.*;

public class MainClass {

    public static void main(String[] args) {
        @SuppressWarnings("unchecked")
        Map<String, Object>[] map = (Map<String, Object>[]) new Map[16];
        for (int i = 0; i < 16; i++) {
            map[i] = new HashMap<String, Object>();
        }

        Reader rd = new Reader("C:/Users/Андрей/Videos/DataBase");
        map = rd.read();
        Write wr = new Write("C:/Users/Андрей/Videos/DataBase");
        Functional fn = new Functional(map);
        ModeWork mw = new ModeWork(map, "C:/Users/Андрей/Videos/DataBase");
        mw.usermode(fn);
         
         
        try {
            wr.write(map);

        } catch (IOException e) {
            System.out.println(e.toString());
        }

    }
}