package java8.in.action.optional;

import java.util.Optional;

public class Person {

    private final String name;
    private int age;

    private Optional<Car> car;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Optional<Car> getCar() {
        return car;
    }

    public Car getCar2() {
        return getCar().get();
    }

    public void setCar(Optional<Car> car) {
        this.car = car;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

}
