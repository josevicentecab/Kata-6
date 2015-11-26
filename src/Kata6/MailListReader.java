/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kata6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author josevicentecabanas
 */
public class MailListReader {
    public static ArrayList<Person> read (String name) throws IOException {
        ArrayList <Person> mailList= new ArrayList<>();
        
        BufferedReader fileRead = new BufferedReader(new FileReader(new File(name)));
        String mail;
        Integer id = 0;
        while ((mail = fileRead.readLine()) != null) {
            if (!mail.contains("@")) continue;
            //mailList.add(mail);
            mailList.add(new Person(id++, mail));
        }
        return mailList;
                
    }
    
}
