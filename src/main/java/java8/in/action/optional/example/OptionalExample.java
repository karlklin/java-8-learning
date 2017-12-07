package java8.in.action.optional.example;

import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {
        Optional<Person> emptyCar = Optional.empty();

        boolean present = emptyCar.isPresent();
        System.out.println(present);

        System.out.println(getCarInsuranceName(emptyCar));
        System.out.println(getCarInsuranceName(emptyCar, 18));
    }

    public static String getCarInsuranceName(Optional<Person> person) {
        return person.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("no insurance _1");
    }

    public static String getCarInsuranceName(Optional<Person> person, int minAge) {
        return person.filter(p -> p.getAge() > minAge)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName).orElse("no insurance");
    }



}
