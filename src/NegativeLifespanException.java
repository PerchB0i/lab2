public class NegativeLifespanException extends Exception {
    public NegativeLifespanException(Person person) {
        super(person.name + " ma niepoprawną datę śmierci względem daty urodzenia!");
    }
}
