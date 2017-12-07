package java8.in.action.optional;

import java.util.Optional;

public class Person {

    private int age;

    private Optional<Car> car;

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

}
