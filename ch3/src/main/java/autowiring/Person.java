package autowiring;

import wiring.Parrot;

public class Person {
    private String name;
    private wiring.Parrot parrot;

    public wiring.Parrot getParrot() {
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