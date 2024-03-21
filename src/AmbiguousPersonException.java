public class AmbiguousPersonException extends Exception{
    public AmbiguousPersonException(Person person) {
        super(person.name + " is Ambiguous");
    }
}
