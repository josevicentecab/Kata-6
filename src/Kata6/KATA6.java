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
        ArrayList<Person1> person = PersonLoader.read();
        //Histogram <String> histogram = MailHistogramBuilder.buil(mailArray);

        HistogramBuilder<Person> builder = new HistogramBuilder<>(mailArray);
        HistogramBuilder<Person1> builder1 = new HistogramBuilder<>(person);
        
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
        
        Histogram<String> domains1 = builder1.build(new Attribute<Person1, String>() {

            @Override
            public String get(Person1 item) {
                return item.getMail().split("@")[1];
            }
        });
                
        Histogram <Float> pesos = builder1.build(new Attribute<Person1, Float>() {

            @Override
            public Float get(Person1 item) {
                return item.getPeso();
            }
        });
        
        Histogram <Character> genero = builder1.build(new Attribute<Person1, Character>() {

            @Override
            public Character get(Person1 item) {
                return item.getGenero().charAt(0);
            }
        });
        new HistogramDisplay(domains, "Dominios").execute();
        new HistogramDisplay(letters, "Caracter").execute();
        new HistogramDisplay(domains1, "Dominios").execute();
        new HistogramDisplay(letters, "Caracter").execute();        
        new HistogramDisplay(pesos, "Peso").execute();
        new HistogramDisplay(genero, "Género").execute();
        
        System.out.println("Fin");
    }
    
}
