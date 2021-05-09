package person;

@Component
public class Person {

    private String name = "조이";

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println(name);
    }
}
