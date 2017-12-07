package java8.in.action.behaviour.parametrization;

import java.util.Arrays;
import java.util.List;

public class Example2PrettyPrintApple2 {

	public static <T> void prettyPrintApples(List<T> inventory, Formatter<T> printer) {
		for (T t : inventory) {
			System.out.println(printer.accept(t));
		}
	}

	public static void main(String[] args) {
		List<Apple> inventory = Arrays.asList(new Apple(160, "Red"), new Apple(120, "Green"));

		System.out.println("SimplePrinter:");
		prettyPrintApples(inventory,
				(Apple apple) -> "Apple with color " + apple.getColor() + " and weight of " + apple.getWeight());

		System.out.println("\nWeightPrinter:");
		prettyPrintApples(inventory, (Apple apple) -> apple.getWeight() > 150 ? "Big apple"
				: "Small apple" + " of color " + apple.getColor());

	}

}
