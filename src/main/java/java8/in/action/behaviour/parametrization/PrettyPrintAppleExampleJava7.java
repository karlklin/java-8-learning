package java8.in.action.behaviour.parametrization;

import java.util.Arrays;
import java.util.List;



public class PrettyPrintAppleExampleJava7 {

	private static class SimpleAppleFormatter extends AppleFormatter {
		@Override
		String accept(Apple apple) {
			return "Apple with color " + apple.getColor() + " and weight of " + apple.getWeight();
		}
	}

	private static class WeightAppleFormatter extends AppleFormatter {

		@Override
		String accept(Apple apple) {
			return  apple.getWeight() > 150 ? "Big apple" : "Small apple" + " of color " + apple.getColor();
		}
	}

	public static void prettyPrintApples(List<Apple> inventory, AppleFormatter printer) {
		for (Apple apple : inventory) {
			System.out.println(printer.accept(apple));
		}
	}

	public static void main(String[] args) {
		List<Apple> inventory = Arrays.asList(new Apple(160, "Red"), new Apple(120, "Green"));

		System.out.println("SimplePrinter:");
		prettyPrintApples(inventory, new SimpleAppleFormatter());
		
		System.out.println("\nWeightPrinter:");
		prettyPrintApples(inventory, new WeightAppleFormatter());

	}

}
