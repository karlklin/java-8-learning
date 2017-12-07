package java8.in.action.behaviour.parametrization;

import java.util.Arrays;
import java.util.List;

public class PrettyPrintAppleExampleJava8 {

	public static void main(String[] args) {
		List<Apple> inventory = Arrays.asList(new Apple(160, "Red"), new Apple(120, "Green"));

		inventory.stream().map(apple -> "Apple with color " + apple.getColor() + " and weight of " + apple.getWeight()).forEach(System.out::println);
		inventory.stream().map(apple -> apple.getWeight() > 150 ? "Big apple"
				: "Small apple" + " of color " + apple.getColor()).forEach(System.out::println);
	}

}
