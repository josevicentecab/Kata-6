package Kata6;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class KATA6 {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
        
        String nameFile ="/Users/josevicentecabanas/Documents/Proyectos Netbeans/KATA4/Data/emailsfilev1.txt";
        //ArrayList<String> mailArray = MailListReader.read(nameFile);
        ArrayList<Person> mailArray = MailListReader.read(nameFile);
        
        //Histogram <String> histogram = MailHistogramBuilder.buil(mailArray);

        HistogramBuilder<Person> builder = new HistogramBuilder<>(mailArray);
        Histogram<String> domains = builder.build(new Attribute<Person, String>() {

            @Override
            public String get(Person item) {
                return item.getMail().split("@")[1];
            }
        });
        Histogram <Character> letters = builder.build(new Attribute<Person, Character>() {

            @Override
            public Character get(Person item) {
                return item.getMail().charAt(0);
            }
        });
        new HistogramDisplay(domains, "Dominios").execute();
        new HistogramDisplay(letters, "Caracter").execute();
        System.out.println("Fin");
    }
    
}
