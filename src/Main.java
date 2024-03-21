import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //stringi
        /*
        String s = "aa,bb,cc";
        String[] splited = s.split(",");
        for (String str : splited) {
            System.out.print(str + ' ');
        }

         */
//listy
/*
        ArrayList<String> list = new ArrayList<String>();
        list.add("test");
        for (String str : list) {
            System.out.print(str + ' ');
        }
        */
//data
        /*
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String dateString = "10.10.2010";
        LocalDate date = LocalDate.parse(dateString, formatter);
        */
        //pliczki
        /*
        try {
            FileReader fileReader = new FileReader("C:\\Users\\student\\Desktop\\oop\\lab2\\family.csv");
            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();
            while(line != null) {
                //...line
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
        List<Person> persons;
        try {
            persons = Person.fromCSV("family.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (Person p:
             persons) {
            System.out.print(p.name + '\n');
        }
    }
}