import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Person {
    public String name;
    public LocalDate dateOfBirth;
    public LocalDate dateOfDeath;

    public static Person fromCSVLine(String line) {
        String[] splited = line.split(",");
        Person person = new Person();
        person.name = splited[0];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        person.dateOfBirth = LocalDate.parse(splited[1], formatter);
        if (splited[2] != null) {
            person.dateOfDeath = LocalDate.parse(splited[2], formatter);
        } else {
            person.dateOfDeath = null;
        }

        return person;
    }

    public static Person[] fromCSV(String filePath) {

        ArrayList<Person> arrList = new ArrayList<>();
        int counter = 0;

        try {
            FileReader fileReader = new FileReader("family.csv");
            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();
            while (line != null) {
                if(counter != 0)
                    arrList.add(Person.fromCSVLine(line));
                counter++;
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Person[] persons = new Person[counter];
        int i = 0;
        for (Person p:
             arrList) {
            persons[i] = p;
        }

        return persons;
    }
}
