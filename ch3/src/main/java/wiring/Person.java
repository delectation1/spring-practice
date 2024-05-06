package wiring;

public class Person {
    private String name;
    private Parrot parrot;

    public Parrot getParrot() {
        return parrot;
    }

    public void setParrot(Parrot parrot) {
        this.parrot = parrot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ch2.Person{" +
                "name='" + name + '\'' +
                ", parrot=" + parrot +
                '}';
    }
}