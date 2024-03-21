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
        if (!splited[2].isEmpty()) {
            person.dateOfDeath = LocalDate.parse(splited[2], formatter);
        }

        return person;
    }

    public static ArrayList<Person> fromCSV(String filePath) throws IOException {

        ArrayList<Person> arrList = new ArrayList<>();
        FileReader fileReader = new FileReader(filePath);
        BufferedReader reader = new BufferedReader(fileReader);

        String line = reader.readLine();
        line = reader.readLine();

        while (line != null) {

            Person person = Person.fromCSVLine(line);

            try {
                person.CheckLifespan();
                person.CheckAmbiguousPerson(arrList);
                arrList.add(person);
            } catch (NegativeLifespanException | AmbiguousPersonException e) {
                System.out.println(e.getMessage());
            }

            line = reader.readLine();
        }

        return arrList;
    }

    public void CheckLifespan() throws NegativeLifespanException {
        if (this.dateOfDeath != null && this.dateOfDeath.isBefore(dateOfBirth))
            throw new NegativeLifespanException(this);
    }

    public void CheckAmbiguousPerson(ArrayList<Person> personList) throws AmbiguousPersonException {
        for (Person p:
             personList) {
            if (this.name.equals(p.name)) {
                throw new AmbiguousPersonException(this);
            }
        }
    }
}
