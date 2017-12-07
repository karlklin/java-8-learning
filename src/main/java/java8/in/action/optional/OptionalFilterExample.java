package java8.in.action.optional;

import java.util.Optional;

public class OptionalFilterExample {

    public static void main(String[] args) {
        Optional<Person> person = Optional.empty();

        String insuranceName = person.filter(p -> p.getAge() > 18)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName).orElse("no insurance");
        System.out.println(insuranceName);
    }
}
